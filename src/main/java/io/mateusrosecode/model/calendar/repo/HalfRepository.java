package io.mateusrosecode.model.calendar.repo;

import io.mateusrosecode.model.calendar.model.Half;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HalfRepository implements PanacheRepository<Half> {

    public Half getHalfByExactDate(int year, int month, int day, int hour) {
        return find("day.month.year.year = ?1 and day.month.monthNumber = ?2 and day.monthDay = ?3 and hour = ?4", year, month, day, hour).firstResult();
    }
}
