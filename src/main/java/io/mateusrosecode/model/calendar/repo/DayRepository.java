package io.mateusrosecode.model.calendar.repo;

import io.mateusrosecode.model.calendar.model.Day;
import io.mateusrosecode.model.calendar.model.Half;
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
    public Day getDayByExactDate(int year, int month, int day) {
        return find("month.year.year = ?1 and month.monthNumber = ?2 and monthDay = ?3", year, month, day).firstResult();
    }
}
