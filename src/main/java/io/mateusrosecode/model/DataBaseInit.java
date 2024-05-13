package io.mateusrosecode.model;

import io.mateusrosecode.model.calendar.model.Day;
import io.mateusrosecode.model.calendar.model.Month;
import io.mateusrosecode.model.calendar.model.Year;
import io.mateusrosecode.model.calendar.repo.DayRepository;
import io.mateusrosecode.model.calendar.repo.MonthRepository;
import io.mateusrosecode.model.calendar.repo.YearRepository;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DataBaseInit {
    @Inject
    YearRepository yearRepo;
    @Inject
    MonthRepository monthRepo;

    @Inject
    DayRepository dayRepo;


    /*
    private static final Logger LOGGER = LoggerFactory.getLogger(DataBaseInit.class);


    @PostConstruct
    @Transactional
    public void loadData(){
        int yearNumber = 2024; // Set the year you want to populate
        Year year = new Year();
        year.setYear(yearNumber);
        year.persist();
        LOGGER.info("Year {} created", yearNumber);

        for (int monthNumber = 1; monthNumber <= 12; monthNumber++) {
            Month month = new Month();
            month.setNumber(monthNumber);
            month.setYear(year);
            year.getMonths().add(month);
            month.persist();
           LOGGER.info("Month {} created for year {}", monthNumber, yearNumber);

            int numberOfDaysInMonth = YearMonth.of(yearNumber, monthNumber).lengthOfMonth();

            for (int dayNumber = 1; dayNumber <= numberOfDaysInMonth; dayNumber++) {
                Day day = new Day();
                day.setNumberDay(dayNumber);
                day.setWeekDay(LocalDate.of(yearNumber, monthNumber, dayNumber).getDayOfWeek().name());
                day.setMonth(month);
                month.getDays().add(day);
                day.persist();
                LOGGER.info("Day {} created for month {} of the year {}", dayNumber,monthNumber,yearNumber);
                for(int halfNumber = 1; halfNumber <= 20; halfNumber++){
                    io.mateusrosecode.model.calendar.Half half = new io.mateusrosecode.model.calendar.Half();
                    half.setOccupied(false);
                    half.setNumber(halfNumber);
                    half.setDay(day);
                    day.getHalfs().add(half);
                    half.persist();
                    LOGGER.info("Half {} created for day {} of month {} of the year {}", halfNumber, dayNumber, monthNumber, yearNumber);
                }
            }
        }
    }*/
    @Transactional
    public void onStart(@Observes StartupEvent ev){
        if(yearRepo.countYears() == 0){
            addYear();
            addYear();
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
        for(int i = 1; i <= 28; i++){
            Day day = new Day();
            day.setup(i);
            day.setMonth(month);
            month.getDays().add(day);
            dayRepo.persist(day);
        }
    }


}