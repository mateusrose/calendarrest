package io.mateusrosecode.model.calendar.repo;

import io.mateusrosecode.model.calendar.model.Day;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DayRepository implements PanacheRepository<Day> {
    @Inject
    HalfRepository halfRepo;
    //
    public long getOccupiedSpots(Day day){
        return halfRepo.count("day.id = ?1 and occupied = ?2", day.getId(), true);
    }
    public long getFreeSpots(Day day){
        return halfRepo.count("day.id = ?1 and occupied = ?2", day.getId(), false);
    }
}
