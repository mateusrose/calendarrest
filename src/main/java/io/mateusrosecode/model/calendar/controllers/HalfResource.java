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

@Path("/api/half")
@RolesAllowed("admin")
public class HalfResource {

    @Inject
    HalfRepository halfRepo;
    @Inject
    HalfHalftoDTO halfDTO;
    @Inject
    HalfDTOtoHalf DTOToHalf;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public HalfDTO getHalfById(@PathParam("id") long id) {
        return halfDTO.convert(halfRepo.findById(id));
    }

    @GET
    @Path("{year}/{month}/{day}/{hour}")
    @Produces(MediaType.APPLICATION_JSON)
    public HalfDTO getHalfByExactDate(@PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day, @PathParam("hour") int hour) {
        return halfDTO.convert(halfRepo.getHalfByExactDate(year, month, day, hour));
    }

    //make a new one where you add a string that is the name of one of the barbers
    @PUT
    @Path("{year}/{month}/{day}/{hour}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateHalfByExactDate(@PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day, @PathParam("hour") int hour, HalfDTO dto) {
        Half half = halfRepo.getHalfByExactDate(year, month, day, hour);
        DTOToHalf.convert(dto, half);
        halfRepo.persist(half);
        return Response.ok().build();
    }


}
