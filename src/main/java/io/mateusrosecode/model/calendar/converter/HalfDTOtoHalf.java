package io.mateusrosecode.model.calendar.converter;

import io.mateusrosecode.model.calendar.DTOs.HalfDTO;
import io.mateusrosecode.model.calendar.model.Half;
import io.mateusrosecode.model.calendar.repo.HalfRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class HalfDTOtoHalf {
    @Inject
    HalfRepository halfRepo;

    public Half convert(HalfDTO dto, Half half) {
        half.setOccupied(dto.isOccupied());
        //add more if needed
        return half;
    }
    public Half convert(Half half, boolean occupied, String barber, String client) {
        half.setOccupied(occupied);
        half.setBarber(barber);
        half.setClient(client);
        //add more if needed
        return half;
    }
}
