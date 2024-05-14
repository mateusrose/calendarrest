package io.mateusrosecode.model.calendar.converter;

import io.mateusrosecode.model.calendar.DTOs.DayDTO;
import io.mateusrosecode.model.calendar.model.Day;
import io.mateusrosecode.model.calendar.repo.DayRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * The DayDTOtoDay class is a converter class that transforms a DayDTO object into a Day entity.
 * It is annotated with @ApplicationScoped, which means that a single instance of this class is created for the entire application.
 */
@ApplicationScoped
public class DayDTOtoDay {
    // The DayRepository is injected here to access the methods of the DayRepository.
    @Inject
    DayRepository dayRepo;

    /**
     * The convert method transforms a DayDTO object into a Day entity.
     * It sets the properties of the Day entity based on the properties of the DayDTO object.
     * @param day The Day entity to convert.
     * @param canWork The new value of the canWork property.
     * @return A Day entity that represents the DayDTO object.
     */
    public Day convert(Day day, boolean canWork) {
        day.setCanWork(canWork);
        return day;
    }
}