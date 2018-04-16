package com.pet.service;

import com.pet.dao.UserDAO;
import com.pet.entity.Client;
import com.pet.exception.ApplicationException;
import com.pet.request.RegistrationRQ;
import com.pet.response.ClientRS;
import com.pet.transformer.Client2ClientRS;
import com.pet.transformer.RegistrationRQ2Client;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.Objects;

@Stateless
public class ClientServiceImpl implements ClientService, Serializable {
    @EJB
    private UserDAO userDAO;

    @Override
    public ClientRS registration(RegistrationRQ registrationRQ) {
        String email = registrationRQ.getEmail();
        Client clientByEmail = userDAO.findUserByEmail(email);
        if (Objects.nonNull(clientByEmail)) {
            throw new ApplicationException();
        }
        Client client = new RegistrationRQ2Client().apply(registrationRQ);
        boolean isCreated = userDAO.add(client);
        if (isCreated) {
            return new Client2ClientRS().apply(userDAO.findUserByEmail(email));
        }
        throw new ApplicationException();
    }

    @Override
    public ClientRS findUserByEmail(String email) {
        return null; //userDAO.findUserByEmail(email);
    }


    @Override
    public ClientRS findUserById(String id) {
        return new Client2ClientRS().apply(userDAO.findUserById(id));
    }
}
