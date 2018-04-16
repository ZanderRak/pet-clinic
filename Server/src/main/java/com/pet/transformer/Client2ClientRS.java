package com.pet.transformer;

import com.pet.entity.Client;
import com.pet.response.ClientRS;

import java.net.URI;
import java.util.function.Function;

public class Client2ClientRS implements Function<Client, ClientRS> {

    private static final String REST_USER_URI = "rest/user/%s";

    @Override
    public ClientRS apply(Client client) {
        return ClientRS.builder()
                .birthday(client.getBirthday())
                .email(client.getEmail())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .phone(client.getPhoneNumber())
                .uri(URI.create(String.format(REST_USER_URI, client.getUserId())).toString())
                .build();
    }
}
