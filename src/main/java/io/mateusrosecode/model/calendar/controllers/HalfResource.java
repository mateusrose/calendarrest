package io.mateusrosecode.model.calendar.controllers;

import io.mateusrosecode.model.calendar.DTOs.HalfDTO;
import io.mateusrosecode.model.calendar.converter.HalfHalftoDTO;
import io.mateusrosecode.model.calendar.model.Half;
import io.mateusrosecode.model.calendar.repo.HalfRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/half")
@RolesAllowed("admin")
public class HalfResource {

    @Inject
    HalfRepository halfRepo;
    @Inject
    HalfHalftoDTO halfDTO;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public HalfDTO getHalfById(@PathParam("id") long id) {
        return halfDTO.convert(halfRepo.findById(id));
    }

    @GET
    @Path("{year}/{month}/{day}/{halfNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public HalfDTO getHalfByExactDate(@PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day, @PathParam("halfNumber") int halfNumber) {
        return halfDTO.convert(halfRepo.find("day.month.year.year = ?1 and day.month.monthNumber = ?2 and day.monthDay = ?3 and halfNumber = ?4", year, month, day, halfNumber).firstResult());
    }

}
