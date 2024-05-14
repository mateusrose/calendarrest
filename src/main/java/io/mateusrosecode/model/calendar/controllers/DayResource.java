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

/**
 * The DayResource class is a RESTful web service that exposes the functionality of the DayRepository.
 * It allows clients to retrieve and update Day entities.
 * This class is secured and can only be accessed by users with the "admin" role.
 */
@Path("/api/day")
@RolesAllowed("admin")
public class DayResource {
    @Inject
    DayRepository dayRepo;
    @Inject
    DayDaytoDTO dayDay;
    @Inject
    DayDTOtoDay dayDTO;

    /**
     * The getDayById method retrieves a Day entity by its id.
     * It returns a DayDTO object that represents the Day entity.
     * @param id The id of the Day entity to retrieve.
     * @return A DayDTO object that represents the Day entity.
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DayDTO getDayById(@PathParam("id") long id) {
        return dayDay.convert(dayRepo.findById(id));
    }

    /**
     * The getDayById method retrieves a Day entity by its date.
     * It returns a DayDTO object that represents the Day entity.
     * @param year The year of the Day entity to retrieve.
     * @param month The month of the Day entity to retrieve.
     * @param day The day of the Day entity to retrieve.
     * @return A DayDTO object that represents the Day entity.
     */
    @GET
    @Path("/{year}/{month}/{day}")
    @Produces(MediaType.APPLICATION_JSON)
    public DayDTO getDayById(@PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day) {
        return dayDay.convert(dayRepo.getDayByExactDate(year, month, day));
    }

    /**
     * The updateDayCanWork method updates the canWork property of a Day entity.
     * It does not return any content.
     * @param year The year of the Day entity to update.
     * @param month The month of the Day entity to update.
     * @param day The day of the Day entity to update.
     * @param canWork The new value of the canWork property.
     * @return A Response object that represents the result of the operation.
     */
    @PUT
    @Path("/{year}/{month}/{day}/{canWork}")
    @Transactional
    public Response updateDayCanWork(@PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day, @PathParam("canWork") boolean canWork) {
        Day dayObj = dayRepo.getDayByExactDate(year, month, day);
        dayDTO.convert(dayObj, canWork);
        dayRepo.persist(dayObj);
        return Response.ok().build();
    }
}