package com.pet.clinic.rest;

import pet.entity.Client;

import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Local
public interface UserService {
    @POST
    @Path("/sigh-in")
    @Consumes("application/json")
    Response registrate(Client client);

    @GET
    @Path("/sigh-in-test")
    Response findUserByEmail();

}
