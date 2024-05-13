package io.mateusrosecode.model.calendar.controllers;

import io.mateusrosecode.model.calendar.DTOs.DayDTO;
import io.mateusrosecode.model.calendar.DTOs.HalfDTO;
import io.mateusrosecode.model.calendar.converter.DayDTOtoDay;
import io.mateusrosecode.model.calendar.converter.DayDaytoDTO;
import io.mateusrosecode.model.calendar.model.Day;
import io.mateusrosecode.model.calendar.model.Half;
import io.mateusrosecode.model.calendar.repo.DayRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/day")
@RolesAllowed("admin")
public class DayResource {

    @Inject
    DayRepository dayRepo;

    @Inject
    DayDaytoDTO dayDay;
    @Inject
    DayDTOtoDay dayDTO;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DayDTO getDayById(@PathParam("id") long id) {
        return dayDay.convert(dayRepo.findById(id));
    }
    @GET
    @Path("/{year}/{month}/{day}")
    @Produces(MediaType.APPLICATION_JSON)
    public DayDTO getDayById(@PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day) {
        return dayDay.convert(dayRepo.getDayByExactDate(year, month, day));
    }
    @PUT
    @Path("/{year}/{month}/{day}/{canWork}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateDayCanWork(@PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day, @PathParam("canWork") boolean canWork) {
        Day dayObj = dayRepo.getDayByExactDate(year, month, day);
        //dayDTO.convert(dayDto,dayObj);
        dayRepo.persist(dayObj);
        return Response.ok(dayObj.isCanWork()).build();
    }

}
