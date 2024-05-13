package io.mateusrosecode.model.calendar.converter;

import io.mateusrosecode.model.calendar.DTOs.DayDTO;
import io.mateusrosecode.model.calendar.model.Day;
import io.mateusrosecode.model.calendar.repo.DayRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DayDTOtoDay {
    @Inject
    DayRepository dayRepo;

    public Day convert(Day day, boolean canWork) {
        day.setCanWork(canWork);
        return day;
    }

}
