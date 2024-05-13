package io.mateusrosecode.model.calendar.converter;

import io.mateusrosecode.model.calendar.DTOs.DayDTO;
import io.mateusrosecode.model.calendar.model.Day;
import io.mateusrosecode.model.calendar.repo.DayRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DayDaytoDTO {
    DayDTO dto;
    @Inject
    DayRepository dayRepo;

    public DayDTO convert(Day day) {

        dto = new DayDTO();
        dto.setName(day.getName());
        dto.setWeekDay(day.getWeekDay());
        dto.setMonthDay(day.getMonthDay());

        dto.setReservations((int)dayRepo.getOccupiedSpots(day));
        dto.setFreeSpot((int)dayRepo.getFreeSpots(day));
        dto.setCanWork(day.isCanWork());
        dto.setMonth(day.getMonth().getMonthNumber());
        dto.setMonthName(day.getMonth().getName());
        dto.setYear(day.getMonth().getYear().getYear());

        return dto;


    }
}
