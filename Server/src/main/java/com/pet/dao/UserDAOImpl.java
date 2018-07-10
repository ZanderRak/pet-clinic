package com.pet.dao;


import com.pet.entity.Client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class UserDAOImpl implements UserDAO {

    @PersistenceContext(unitName = "PETCLINIC")
    private EntityManager entityManager;

    public Client findUserByEmail(String email) {
        return entityManager
                .createNamedQuery("Users.findByEmail", Client.class)
                .setParameter("email", email)
                .getResultList().stream().findFirst().orElse(null);
    }

    public Client findUserById(String id) {
        return entityManager
                .createNamedQuery("Users.findById", Client.class)
                .setParameter("userId", id)
                .getResultList().stream().findFirst().orElse(null);
    }

    public boolean add(Client client) {
        entityManager.persist(client);
        return true;
    }

    public boolean remove(Client client) {
        return false;
    }

    public Client update(Client client) {
        return null;
    }
}
