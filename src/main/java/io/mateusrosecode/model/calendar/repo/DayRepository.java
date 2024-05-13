package io.mateusrosecode.model.calendar.repo;

import io.mateusrosecode.model.calendar.model.Day;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DayRepository implements PanacheRepository<Day> {
    //
}
