package cn.xrb.clouduser.util;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Base64;

@Component
public  class UserUtil { private static final int ITERATIONS = 5000;
    private static final int MEMORY_COST = 65536;
    private static final int PARALLELISM = 4;
    private static final int SALT_LENGTH = 16;
    private static final int HASH_LENGTH = 32;

    private static final Argon2 ARGON2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

    public  String encode(String password) {
        byte[] salt = new byte[SALT_LENGTH];
        new SecureRandom().nextBytes(salt);
        return ARGON2.hash(ITERATIONS, MEMORY_COST, PARALLELISM, password.toCharArray());
    }

    public  boolean decode(String password, String hashedPassword) {
        return ARGON2.verify(hashedPassword, password.toCharArray());
    }}
