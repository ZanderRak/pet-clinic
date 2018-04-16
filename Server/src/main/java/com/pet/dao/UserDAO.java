package com.pet.dao;

import com.pet.entity.Client;

import javax.ejb.Local;


@Local
public interface UserDAO {
    Client findUserByEmail(String email);

    Client findUserById(String id);

    boolean add(Client client);

    boolean remove(Client client);

    Client update(Client client);
}
