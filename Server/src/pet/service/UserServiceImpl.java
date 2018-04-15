package pet.service;

import pet.dao.UserDAO;
import pet.entity.Client;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserServiceImpl implements UserService {

    @EJB
    private UserDAO userDAO;

    public Response registrate(Client client) {
        // Client clientByEmail = userDAO.findUserByEmail("zanderrak@gmail.con");
        return Response.status(200).entity(client).build();

    }

    public Response findUserByEmail() {
        // Client clientByEmail = userDAO.findUserByEmail("zanderrak@gmail.con");
        // return Response.status(200).entity(clientByEmail).build();
        return null;
    }
}
