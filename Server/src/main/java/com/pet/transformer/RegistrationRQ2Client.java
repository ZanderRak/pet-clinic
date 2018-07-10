package com.pet.transformer;

import com.pet.entity.Client;
import com.pet.password.PasswordGenerator;
import com.pet.request.RegistrationRQ;

import java.util.Base64;
import java.util.UUID;
import java.util.function.Function;

public class RegistrationRQ2Client implements Function<RegistrationRQ, Client> {
    @Override
    public Client apply(RegistrationRQ registrationRQ) {
        Client client = new Client();
        client.setEmail(registrationRQ.getEmail());
        client.setFirstName(registrationRQ.getFirstName());
        client.setLastName(registrationRQ.getLastName());
        client.setBirthday(registrationRQ.getBirthday());
        byte[] salt = UUID.randomUUID().toString().getBytes();
        byte[] hash = new PasswordGenerator().generete(registrationRQ.getPassword(), salt);
        Base64.Encoder enc = Base64.getEncoder();
        client.setPasswordSalt(enc.encodeToString(salt));
        client.setPasswordHash(enc.encodeToString(hash));
        return client;
    }
}
