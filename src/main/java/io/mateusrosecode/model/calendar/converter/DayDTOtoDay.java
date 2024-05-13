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

    public Day convert(DayDTO dto, Day day) {
        day.setCanWork(dto.isCanWork());
        return day;
    }

}
