package io.mateusrosecode.model.calendar.converter;

import io.mateusrosecode.model.calendar.DTOs.HalfDTO;
import io.mateusrosecode.model.calendar.model.Half;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HalfHalftoDTO {
    HalfDTO dto;

    public HalfDTO convert(Half half) {
        dto = new HalfDTO(half.getHour(), half.getHalfNumber(), half.isOccupied(), half.getDay().getName(),half.getDay().getMonth().getName(),half.getDay().getMonthDay(),half.getDay().getMonth().getMonthNumber(), half.getDay().getMonth().getYear().getYear());
        return dto;
    }
}
