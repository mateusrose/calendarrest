package io.mateusrosecode.model.calendar.controllers;

import io.mateusrosecode.model.calendar.DTOs.DayDTO;
import io.mateusrosecode.model.calendar.converter.DayDaytoDTO;
import io.mateusrosecode.model.calendar.repo.DayRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/day")
@RolesAllowed("admin")
public class DayResource {

    @Inject
    DayRepository dayRepo;

    @Inject
    DayDaytoDTO dayDay;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DayDTO getDayById(@PathParam("id") long id) {
        return dayDay.convert(dayRepo.findById(id));
    }


}
