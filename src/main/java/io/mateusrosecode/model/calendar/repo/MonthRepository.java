package io.mateusrosecode.model.calendar.repo;

import io.mateusrosecode.model.calendar.model.Month;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * The MonthRepository class provides methods to interact with the Month entities in the database.
 * It is annotated with @ApplicationScoped, which means that a single instance of this class is created for the entire application.
 * It implements the PanacheRepository interface, which provides methods for common database operations.
 */
@ApplicationScoped
public class MonthRepository implements PanacheRepository<Month> {
    // Currently, no additional methods are defined in this repository.
}