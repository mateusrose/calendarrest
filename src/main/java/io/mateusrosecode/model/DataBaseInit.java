package io.mateusrosecode.model;

import io.mateusrosecode.model.calendar.Day;
import io.mateusrosecode.model.calendar.Month;
import io.mateusrosecode.model.calendar.Year;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.YearMonth;
import java.time.LocalDate;

@ApplicationScoped
public class DataBaseInit {
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
    }
}