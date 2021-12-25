package com.example.final_project.controller;

import com.example.final_project.entity.StudentAccount;
import com.example.final_project.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.json.bind.JsonbException;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.SQLException;
import java.util.List;

@PermitAll
@Path("/student")
public class StudentController {
    @EJB
    StudentService studentService;

    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    @Context
    HttpHeaders httpHeaders;


    @GET
    @Path("/allStudents")
    @Produces("application/json")
    @PermitAll
//    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
//    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAll() throws SQLException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(studentService.getAllStudents());
        return Response.status(Response.Status.OK).entity(json).build();

    }
    @GET
    @Path("/studentById/{id}")
    @Produces("application/json")
    @PermitAll
    public Response findById(@PathParam("id") int id) throws SQLException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(studentService.getStudentById(id));
        return Response.status(Response.Status.OK).entity(json).build();

    }
    @GET
    @Path("/studentByName/{name}")
    @Produces("application/json")
    @PermitAll
    public Response findByName(@PathParam("name") String name) throws SQLException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(studentService.getStudentByName(name));
        return Response.status(Response.Status.OK).entity(json).build();

    }
    @GET
    @Path("/studentByLastName/{lastname}")
    @Produces("application/json")
    @PermitAll
    public Response findByLastName(@PathParam("lastname") String lastname) throws SQLException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(studentService.getStudentByLastName(lastname));
        return Response.status(Response.Status.OK).entity(json).build();

    }

    @DELETE
    @Path("/deleteStudentById/{id}")
    @Produces("application/json")
    @RolesAllowed("ADMIN")
    public Response deleteById(@PathParam("id") int id) throws SQLException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(studentService.deleteStudentById(id));
        return Response.status(Response.Status.OK).entity(json).build();

    }
    @PUT
    @Path("/changeNameOfStudentById/{id}/{name}")
    @Produces("application/json")
    @PermitAll
    public Response changeNameById(@PathParam("id") int id, @PathParam("name")String name) throws SQLException, JsonProcessingException{
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(studentService.changeNameById(id, name));
        return Response.status(Response.Status.OK).entity(json).build();
    }
    @PUT
    @Path("/changeLastNameOfStudentById/{id}/{lastName}")
    @Produces("application/json")
    @PermitAll
    public Response changeLastNameById(@PathParam("id") int id, @PathParam("lastName")String lastName) throws SQLException, JsonProcessingException{
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(studentService.changeLastNameById(id,lastName));
        return Response.status(Response.Status.OK).entity(json).build();
    }

    @POST
    @Path("/addNewStudent")
    @Produces("application/json")
    @PermitAll
    public Response addNewStudent(StudentAccount student) throws SQLException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(studentService.addNewStudent(student.getId(), student.getFirstName(), student.getLastName(),student.getUserName(), student.getPassword(),student.getGpa()));
        return Response.status(Response.Status.OK).entity(json).build();
    }
}
