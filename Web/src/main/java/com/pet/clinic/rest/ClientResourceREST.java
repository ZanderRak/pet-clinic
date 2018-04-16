package com.pet.clinic.rest;

import com.pet.request.RegistrationRQ;
import com.pet.service.ClientService;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;

@Path("/user")
@RequestScoped
@LocalBean
public class ClientResourceREST implements Serializable {

    @EJB
    private ClientService clientService;

    @POST
    @Path("/sigh-up")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registration(RegistrationRQ registrationRQ) {
        return Response.status(200).entity(clientService.registration(registrationRQ)).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByID(@PathParam("id") String id) {
        return Response.status(200).entity(clientService.findUserById(id)).build();
    }
/*
    @GET
    @Path("{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByEmail(@PathParam("email") String email) {
        return Response.status(200).entity(clientService.findUserByEmail(email)).build();
    }*/
}
