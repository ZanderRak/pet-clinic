package pet.dao;

import pet.entity.Client;

import javax.ejb.Local;


@Local
public interface UserDAO {
    Client findUserByEmail(String email);

    boolean add(Client client);

    boolean remove(Client client);

    Client update(Client client);
}
