package io.mateusrosecode.model.calendar.converter;

import io.mateusrosecode.model.calendar.DTOs.HalfDTO;
import io.mateusrosecode.model.calendar.model.Half;
import io.mateusrosecode.model.calendar.repo.HalfRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import io.mateusrosecode.model.calendar.DTOs.HalfDTO;
import io.mateusrosecode.model.calendar.model.Half;
import io.mateusrosecode.model.calendar.repo.HalfRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * The HalfDTOtoHalf class is a converter class that transforms a HalfDTO object into a Half entity.
 * It is annotated with @ApplicationScoped, which means that a single instance of this class is created for the entire application.
 */
@ApplicationScoped
public class HalfDTOtoHalf {
    // The HalfRepository is injected here to access the methods of the HalfRepository.
    @Inject
    HalfRepository halfRepo;

    /**
     * The convert method transforms a HalfDTO object into a Half entity.
     * It sets the properties of the Half entity based on the properties of the HalfDTO object.
     * @param dto The HalfDTO object to convert.
     * @param half The Half entity to update.
     * @return A Half entity that represents the HalfDTO object.
     */
    public Half convert(HalfDTO dto, Half half) {
        half.setOccupied(dto.isOccupied());
        half.setBarber(dto.getBarber());
        half.setClient(dto.getClient());

        //add more if needed
        return half;
    }

    /**
     * The convert method updates a Half entity with the provided parameters.
     * @param half The Half entity to update.
     * @param occupied The new value of the occupied property.
     * @param barber The new value of the barber property.
     * @param client The new value of the client property.
     * @return The updated Half entity.
     */
    public Half convert(Half half, boolean occupied, String barber, String client) {
        half.setOccupied(occupied);
        half.setBarber(barber);
        half.setClient(client);
        //add more if needed
        return half;
    }
}
