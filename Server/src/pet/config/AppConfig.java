package pet.config;

import pet.service.UserServiceImpl;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class AppConfig extends Application {
    private Set<Object> singletons = new HashSet<>();

    public AppConfig() {
        singletons.add(new UserServiceImpl());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
