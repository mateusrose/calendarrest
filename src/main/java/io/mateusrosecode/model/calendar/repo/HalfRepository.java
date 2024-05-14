package io.mateusrosecode.model.calendar.repo;
import io.mateusrosecode.model.calendar.model.Half;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * The HalfRepository class provides methods to interact with the Half entities in the database.
 * It is annotated with @ApplicationScoped, which means that a single instance of this class is created for the entire application.
 * It implements the PanacheRepository interface, which provides methods for common database operations.
 */
@ApplicationScoped
public class HalfRepository implements PanacheRepository<Half> {

    /**
     * The getHalfByExactDate method returns the Half entity for a given date and hour.
     * @param year The year of the date.
     * @param month The month of the date.
     * @param day The day of the date.
     * @param hour The hour of the half-day period.
     * @return The Half entity for the given date and hour.
     */
    public Half getHalfByExactDate(int year, int month, int day, int hour) {
        return find("day.month.year.year = ?1 and day.month.monthNumber = ?2 and day.monthDay = ?3 and hour = ?4", year, month, day, hour).firstResult();
    }
}