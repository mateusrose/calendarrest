package io.mateusrosecode.model.calendar.converter;

import io.mateusrosecode.model.calendar.DTOs.HalfDTO;
import io.mateusrosecode.model.calendar.model.Half;
import jakarta.enterprise.context.ApplicationScoped;

import io.mateusrosecode.model.calendar.DTOs.HalfDTO;
import io.mateusrosecode.model.calendar.model.Half;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * The HalfHalftoDTO class is a converter class that transforms a Half entity into a HalfDTO object.
 * It is annotated with @ApplicationScoped, which means that a single instance of this class is created for the entire application.
 */
@ApplicationScoped
public class HalfHalftoDTO {
    // The HalfDTO object that will be returned by the convert method.
    HalfDTO dto;

    /**
     * The convert method transforms a Half entity into a HalfDTO object.
     * It sets the properties of the HalfDTO object based on the properties of the Half entity.
     * @param half The Half entity to convert.
     * @return A HalfDTO object that represents the Half entity.
     */
    public HalfDTO convert(Half half) {
        dto = new HalfDTO(half.getHour(), half.getHalfNumber(), half.isOccupied(), half.getDay().getName(),half.getDay().getMonth().getName(),half.getDay().getMonthDay(),half.getDay().getMonth().getMonthNumber(), half.getDay().getMonth().getYear().getYear(), half.getBarber(), half.getClient());
        return dto;
    }
}