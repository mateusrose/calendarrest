package io.mateusrosecode.model.calendar.controllers;

import io.mateusrosecode.model.calendar.DTOs.HalfDTO;
import io.mateusrosecode.model.calendar.converter.HalfDTOtoHalf;
import io.mateusrosecode.model.calendar.converter.HalfHalftoDTO;
import io.mateusrosecode.model.calendar.model.Half;
import io.mateusrosecode.model.calendar.repo.HalfRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * The HalfResource class is a RESTful web service that exposes the functionality of the HalfRepository.
 * It allows clients to retrieve and update Half entities.
 * This class is secured and can only be accessed by users with the "admin" role.
 */
@Path("/api/half")
@RolesAllowed("admin")
public class HalfResource {
    // Services are injected here
    @Inject
    HalfRepository halfRepo;
    @Inject
    HalfHalftoDTO halfDTO;
    @Inject
    HalfDTOtoHalf DTOToHalf;

    /**
     * The getHalfById method retrieves a Half entity by its id.
     * It returns a HalfDTO object that represents the Half entity.
     * @param id The id of the Half entity to retrieve.
     * @return A HalfDTO object that represents the Half entity.
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public HalfDTO getHalfById(@PathParam("id") long id) {
        return halfDTO.convert(halfRepo.findById(id));
    }

    /**
     * The getHalfByExactDate method retrieves a Half entity by its exact date and hour.
     * It returns a HalfDTO object that represents the Half entity.
     * @param year The year of the Half entity to retrieve.
     * @param month The month of the Half entity to retrieve.
     * @param day The day of the Half entity to retrieve.
     * @param hour The hour of the Half entity to retrieve.
     * @return A HalfDTO object that represents the Half entity.
     */
    @GET
    @Path("{year}/{month}/{day}/{hour}")
    @Produces(MediaType.APPLICATION_JSON)
    public HalfDTO getHalfByExactDate(@PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day, @PathParam("hour") int hour) {
        return halfDTO.convert(halfRepo.getHalfByExactDate(year, month, day, hour));
    }

    /**
     * The updateHalfByExactDate method updates a Half entity by its exact date and hour.
     * It consumes a HalfDTO object and does not return any content.
     * @param year The year of the Half entity to update.
     * @param month The month of the Half entity to update.
     * @param day The day of the Half entity to update.
     * @param hour The hour of the Half entity to update.
     * @param dto The HalfDTO object that contains the new data.
     * @return A Response object that represents the result of the operation.
     */
    @PUT
    @Path("{year}/{month}/{day}/{hour}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateHalfByExactDate(@PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day, @PathParam("hour") int hour, HalfDTO dto) {
        Half half = halfRepo.getHalfByExactDate(year, month, day, hour);
        DTOToHalf.convert(dto, half);
        halfRepo.persist(half);
        return Response.ok().build();
    }

    /**
     * The updateHalfByExactDateWithClientAndBarber method updates a Half entity by its exact date and hour, and also updates the client and barber.
     * It does not return any content.
     * @param year The year of the Half entity to update.
     * @param month The month of the Half entity to update.
     * @param day The day of the Half entity to update.
     * @param hour The hour of the Half entity to update.
     * @param barber The new barber of the Half entity.
     * @param client The new client of the Half entity.
     * @return A Response object that represents the result of the operation.
     */
    @PUT
    @Path("{year}/{month}/{day}/{hour}/{barber}/{client}")
    @Transactional
    public Response updateHalfByExactDateWithClientAndBarber(@PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day, @PathParam("hour") int hour, @PathParam("barber") String barber, @PathParam("client") String client) {
        Half half = halfRepo.getHalfByExactDate(year, month, day, hour);
        DTOToHalf.convert(half, true, barber, client);
        halfRepo.persist(half);
        return Response.ok().build();
    }

    /**
     * The updateHalfReset method resets a Half entity by its exact date and hour.
     * It does not return any content.
     * @param year The year of the Half entity to reset.
     * @param month The month of the Half entity to reset.
     * @param day The day of the Half entity to reset.
     * @param hour The hour of the Half entity to reset.
     * @return A Response object that represents the result of the operation.
     */
    @PUT
    @Path("{year}/{month}/{day}/{hour}/reset")
    @Transactional
    public Response updateHalfReset(@PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day, @PathParam("hour") int hour) {
        Half half = halfRepo.getHalfByExactDate(year, month, day, hour);
        DTOToHalf.convert(half,false, "none", "none");
        halfRepo.persist(half);

        return Response.ok().build();
    }

}