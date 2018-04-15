package com.pet.clinic.rest;

import pet.dao.UserDAO;
import pet.entity.Client;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/user")
@RequestScoped
public class UserResourceRESTService implements UserService {

    @EJB
    private UserDAO userDAO;

    @Override
    public Response registrate(Client client) {
        Client clientByEmail = userDAO.findUserByEmail("zanderrak@gmail.con");
        return Response.status(200).entity(clientByEmail).build();

    }

    @Override
    public Response findUserByEmail() {
        Client clientByEmail = userDAO.findUserByEmail("zanderrak@gmail.con");
        return Response.status(200).entity(clientByEmail).build();
    }
}
