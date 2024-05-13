package io.mateusrosecode.model.calendar.repo;

import io.mateusrosecode.model.calendar.model.Half;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HalfRepository implements PanacheRepository<Half> {
}
