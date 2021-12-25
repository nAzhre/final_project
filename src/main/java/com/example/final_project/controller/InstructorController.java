package com.example.final_project.controller;

import com.example.final_project.logging.Logged;
import com.example.final_project.service.InstructorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.SQLException;

@PermitAll
@Path("/instructor")
public class InstructorController {
    @EJB
    InstructorService instructorService;

    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    @Context
    HttpHeaders httpHeaders;

    @GET
    @Path("/allInstructors")
    @Logged
    @Produces("application/json")
    public Response findAll() throws SQLException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(instructorService.getAllInstructors());
        return Response.status(Response.Status.OK).entity(json).build();
    }

    @GET
    @Path("/instructorsById/{id}")
    @Logged
    @Produces("application/json")
    public Response findById(@PathParam("id") int id) throws SQLException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(instructorService.getInstructorById(id));
        return Response.status(Response.Status.OK).entity(json).build();

    }

    @GET
    @Path("/instructorByName/{firstName}")
    @Produces("application/json")
    public Response findByName(@PathParam("firstName") String firstName) throws SQLException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(instructorService.getInstructorByFirstName(firstName));
        return Response.status(Response.Status.OK).entity(json).build();

    }
    @GET
    @Path("/instructorByLastName/{lastName}")
    @Produces("application/json")
    public Response findByLastName(@PathParam("lastName") String lastName) throws SQLException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(instructorService.getInstructorByLastName(lastName));
        return Response.status(Response.Status.OK).entity(json).build();

    }
    @GET
    @Path("/instructorByEmail/{email}")
    @Produces("application/json")
    public Response findByEmail(@PathParam("email") String email) throws SQLException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(instructorService.getInstructorByEmail(email));
        return Response.status(Response.Status.OK).entity(json).build();

    }
    @DELETE
    @Path("/deleteInstructorById/{id}")
    @Produces("application/json")
    public Response deleteById(@PathParam("id") int id) throws SQLException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(instructorService.deleteInstructorById(id));
        return Response.status(Response.Status.OK).entity(json).build();

    }

}
