package io.mateusrosecode.model.calendar.repo;

import io.mateusrosecode.model.calendar.model.Year;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class YearRepository implements PanacheRepository<Year> {

    //
    public int countYears() {
        return listAll().size();
    }

}
