package io.mateusrosecode.model;

import io.mateusrosecode.model.auth.User;
import io.mateusrosecode.model.calendar.model.Day;
import io.mateusrosecode.model.calendar.model.Half;
import io.mateusrosecode.model.calendar.model.Month;
import io.mateusrosecode.model.calendar.model.Year;
import io.mateusrosecode.model.calendar.repo.DayRepository;
import io.mateusrosecode.model.calendar.repo.HalfRepository;
import io.mateusrosecode.model.calendar.repo.MonthRepository;
import io.mateusrosecode.model.calendar.repo.YearRepository;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.YearMonth;

/**
 * The DataBaseInit class is responsible for initializing the database at the start of the application.
 * It is annotated with @ApplicationScoped, which means that a single instance of this class is created for the entire application.
 */
@ApplicationScoped
public class DataBaseInit {
    @Inject
    YearRepository yearRepo;
    @Inject
    MonthRepository monthRepo;
    @Inject
    DayRepository dayRepo;
    @Inject
    HalfRepository halfRepo;

    /**
     * The loadUsers method deletes all existing users and adds a new user with username and password as 'admin'.
     */
    void loadUsers(){
        User.deleteAll();
        User.add("admin", "admin", "admin");

    }

    /**
     * The onStart method is called at the start of the application.
     * If there are no years in the database, it loads the users and adds a new year.
     * @param ev The StartupEvent that triggers this method.
     */
    @Transactional
    public void onStart(@Observes StartupEvent ev){
        if(yearRepo.countYears() == 0){
            loadUsers();
            addYear();
        }
    }

    /**
     * The addYear method creates a new Year entity, sets its year, adds months to it, and persists it in the database.
     */
    @Transactional
    public void addYear(){
        Year year = new Year();
        year.setYear(2024 + yearRepo.countYears() );
        addMonths(year);
        yearRepo.persist(year);

    }

    /**
     * The addMonths method creates new Month entities for a given Year, sets their names and years, adds days to them, and persists them in the database.
     * @param year The Year entity to which the months are added.
     */
    public void addMonths(Year year){
        for(int i = 1; i <= 12; i++){
            Month month = new Month();
            month.setName(i);
            month.setYear(year);
            year.getMonths().add(month);
            addDays(month);
            monthRepo.persist(month);

        }

    }

    /**
     * The addDays method creates new Day entities for a given Month, sets up their days, adds half-day periods to them, and persists them in the database.
     * @param month The Month entity to which the days are added.
     */
    public void addDays(Month month){
        int year = month.getYear().getYear();
        int monthNumber = month.getMonthNumber();
        YearMonth yearMonth = YearMonth.of(year, monthNumber);
        int daysInMonth = yearMonth.lengthOfMonth();

        for(int i = 1; i <= daysInMonth; i++){
            Day day = new Day();
            day.setup(i);
            day.setMonth(month);
            month.getDays().add(day);
            addHalfs(day);
            dayRepo.persist(day);
        }
    }

    /**
     * The addHalfs method creates new Half entities for a given Day, sets up their hours, and persists them in the database.
     * @param day The Day entity to which the half-day periods are added.
     */
    public void addHalfs(Day day){
        for(int i = 1; i <= 20 ; i++){
            Half half = new Half();
            half.setup(i);
            half.setDay(day);
            day.getHalves().add(half);
            halfRepo.persist(half);
        }
    }
}