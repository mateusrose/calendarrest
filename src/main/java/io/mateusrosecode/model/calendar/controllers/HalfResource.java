package io.mateusrosecode.model.calendar.controllers;

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
@RolesAllowed({"admin", "user"})
public class HalfResource {

    @Inject
    HalfRepository halfRepo;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Half getHalfById(@PathParam("id") long id) {
        return halfRepo.findById(id);
    }
}
