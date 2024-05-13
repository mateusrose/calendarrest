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
    //add services
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



    //CHANGES VIA JSON, currently bugged
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
    @PUT
    @Path("{year}/{month}/{day}/{hour}/{barber}/{client}")
    @Transactional
    public Response updateHalfByExactDateWithClientAndBarber(@PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day, @PathParam("hour") int hour, @PathParam("barber") String barber, @PathParam("client") String client) {
        Half half = halfRepo.getHalfByExactDate(year, month, day, hour);
        DTOToHalf.convert(half, true, barber, client);
        halfRepo.persist(half);
        return Response.ok().build();
    }
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
