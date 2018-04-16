package com.pet.service;

import com.pet.request.RegistrationRQ;
import com.pet.response.ClientRS;

import javax.ejb.Local;

@Local
public interface ClientService {

    ClientRS findUserById(String email);

    ClientRS registration(RegistrationRQ client);

    ClientRS findUserByEmail(String email);

}
