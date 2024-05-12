package io.mateusrosecode.controllers;

import io.mateusrosecode.model.calendar.Half;
import io.mateusrosecode.model.calendar.Day;
import io.mateusrosecode.model.calendar.Month;
import io.mateusrosecode.model.calendar.Year;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/half")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HalfResource {
    @Inject
    EntityManager em;

  /*  @POST
    @Path("/occupy/{yearNumber}/{monthNumber}/{dayNumber}/{halfNumber}")
    @Transactional
    public Response occupyHalf(@PathParam("yearNumber") int yearNumber,
                               @PathParam("monthNumber") int monthNumber,
                               @PathParam("dayNumber") int dayNumber,
                               @PathParam("halfNumber") int halfNumber) {
        Year year = Year.find("year", yearNumber).firstResult();
        Month month = Month.find("monthNumber", monthNumber).firstResult();
        Day day = Day.find("numberDay", dayNumber).firstResult();
        Half half = Half.find("halfNumber", halfNumber).firstResult();

        if (year == null || month == null || day == null || half == null) {
            throw new WebApplicationException("Year, Month, Day or Half does not exist.", 404);
        }

        if (month.year.id != year.id || day.month.id != month.id || half.day.id != day.id) {
            throw new WebApplicationException("Year, Month, Day or Half does not match.", 400);
        }

        half.occupied = true;
        return Response.ok(half).status(200).build();
    }*/

    @GET
    @Path("/{yearNumber}/{monthNumber}/{dayNumber}/{halfNumber}")
    public Response getHalf(@PathParam("yearNumber") int yearNumber,
                            @PathParam("monthNumber") int monthNumber,
                            @PathParam("dayNumber") int dayNumber,
                            @PathParam("halfNumber") int halfNumber) {
        Year year = Year.find("year", yearNumber).firstResult();
        Month month = Month.find("monthNumber", monthNumber).firstResult();
        Day day = Day.find("numberDay", dayNumber).firstResult();
        Half half = Half.find("halfNumber", halfNumber).firstResult();

        if (year == null || month == null || day == null || half == null) {
            throw new WebApplicationException("Year, Month, Day or Half does not exist.", 404);
        }

        return Response.ok(half).status(200).build();
    }
}