package my.home.webapp.entity;

import java.util.Arrays;
import java.util.Optional;

public enum Gender {
    MALE,
    FEMALE;

    public static Optional<Gender> find(String gender){

        return Arrays.stream(values())
                .filter(item -> item.name().equals(gender))
                .findFirst();
    }
}
