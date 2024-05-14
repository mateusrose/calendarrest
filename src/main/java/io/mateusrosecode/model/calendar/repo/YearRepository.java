package io.mateusrosecode.model.calendar.repo;

import io.mateusrosecode.model.calendar.model.Year;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
/**
 * The YearRepository class provides methods to interact with the Year entities in the database.
 * It is annotated with @ApplicationScoped, which means that a single instance of this class is created for the entire application.
 * It implements the PanacheRepository interface, which provides methods for common database operations.
 */
@ApplicationScoped
public class YearRepository implements PanacheRepository<Year> {

    /**
     * The countYears method returns the total number of Year entities in the database.
     * It uses the listAll method from the PanacheRepository interface to retrieve all Year entities, and then returns their size.
     * @return The total number of Year entities in the database.
     */
    public int countYears() {
        return listAll().size();
    }

}