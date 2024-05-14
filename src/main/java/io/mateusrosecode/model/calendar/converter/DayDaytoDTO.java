package io.mateusrosecode.model.calendar.converter;

import io.mateusrosecode.model.calendar.DTOs.DayDTO;
import io.mateusrosecode.model.calendar.model.Day;
import io.mateusrosecode.model.calendar.repo.DayRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import io.mateusrosecode.model.calendar.DTOs.DayDTO;
import io.mateusrosecode.model.calendar.model.Day;
import io.mateusrosecode.model.calendar.repo.DayRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * The DayDaytoDTO class is a converter class that transforms a Day entity into a DayDTO object.
 * It is annotated with @ApplicationScoped, which means that a single instance of this class is created for the entire application.
 */
@ApplicationScoped
public class DayDaytoDTO {
    // The DayDTO object that will be returned by the convert method.
    DayDTO dto;

    // The DayRepository is injected here to access the methods getOccupiedSpots and getFreeSpots.
    @Inject
    DayRepository dayRepo;

    /**
     * The convert method transforms a Day entity into a DayDTO object.
     * It sets the properties of the DayDTO object based on the properties of the Day entity.
     * @param day The Day entity to convert.
     * @return A DayDTO object that represents the Day entity.
     */
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
