package com.pet.password;

import com.pet.exception.ApplicationException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Random;

public class PasswordGenerator {

    private static final String GENERATION_STRATEGY = "PBKDF2WithHmacSHA1";
    private static final int ITERATION_COUNT = 666;
    private static final int HASH_LENGTH = 128;

    public byte[] generete(String password, byte[] salt) {
        new Random().nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATION_COUNT, HASH_LENGTH);
        try {
            SecretKeyFactory f = SecretKeyFactory.getInstance(GENERATION_STRATEGY);
            return f.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new ApplicationException();
        }
    }
}
