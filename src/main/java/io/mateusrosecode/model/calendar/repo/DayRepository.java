package io.mateusrosecode.model.calendar.repo;

import io.mateusrosecode.model.calendar.model.Day;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;



/**
 * The DayRepository class provides methods to interact with the Day entities in the database.
 * It is annotated with @ApplicationScoped, which means that a single instance of this class is created for the entire application.
 * It implements the PanacheRepository interface, which provides methods for common database operations.
 */
@ApplicationScoped
public class DayRepository implements PanacheRepository<Day> {

    /**
     * The HalfRepository instance used to interact with the Half entities in the database.
     */
    @Inject
    HalfRepository halfRepo;

    /**
     * The getOccupiedSpots method returns the number of occupied half-day periods for a given day.
     * @param day The Day entity for which to count the occupied half-day periods.
     * @return The number of occupied half-day periods for the given day.
     */
    public long getOccupiedSpots(Day day){
        return halfRepo.count("day.id = ?1 and occupied = ?2", day.getId(), true);
    }

    /**
     * The getFreeSpots method returns the number of free half-day periods for a given day.
     * @param day The Day entity for which to count the free half-day periods.
     * @return The number of free half-day periods for the given day.
     */
    public long getFreeSpots(Day day){
        return halfRepo.count("day.id = ?1 and occupied = ?2", day.getId(), false);
    }

    /**
     * The getDayByExactDate method returns the Day entity for a given date.
     * @param year The year of the date.
     * @param month The month of the date.
     * @param day The day of the date.
     * @return The Day entity for the given date.
     */
    public Day getDayByExactDate(int year, int month, int day) {
        return find("month.year.year = ?1 and month.monthNumber = ?2 and monthDay = ?3", year, month, day).firstResult();
    }
}
