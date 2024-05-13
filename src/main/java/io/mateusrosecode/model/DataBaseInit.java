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

    void loadUsers(){
        User.deleteAll();
        User.add("admin", "admin", "admin");

    }
    @Transactional
    public void onStart(@Observes StartupEvent ev){
        loadUsers();
        if(yearRepo.countYears() == 0){
            addYear();
        }
    }
    @Transactional
    public long addYear(){
        Year year = new Year();
        year.setYear(2024 + yearRepo.countYears() );
        addMonths(year);
        yearRepo.persist(year);
        return year.getYear();
    }

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

    public void addDays(Month month){
        int year = month.getYear().getYear();
        int monthNumber = month.getMonthNumber();
        YearMonth yearMonth = YearMonth.of(year, monthNumber);
        int daysInMonth = yearMonth.lengthOfMonth();

        for(int i = 1; i <= daysInMonth/4; i++){
            Day day = new Day();
            day.setup(i);
            day.setMonth(month);
            month.getDays().add(day);
            addHalfs(day);
            dayRepo.persist(day);
        }
    }
    public void addHalfs(Day day){
        for(int i = 1; i <= 1; i++){
            Half half = new Half();
            half.setup(i);
            half.setDay(day);
            day.getHalves().add(half);
            halfRepo.persist(half);
        }
    }


}