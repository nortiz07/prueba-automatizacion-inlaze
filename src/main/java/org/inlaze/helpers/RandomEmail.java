package org.inlaze.helpers;

import lombok.Getter;

@Getter
public class RandomEmail {

    private static RandomEmail instance;
    private final String email;

    private RandomEmail() {
        int randomNumber = (int) (Math.random() * 1000); // Número entre 0 y 999
        this.email = "oscar" + randomNumber + "@ejemplo.com";
    }

    public static RandomEmail getInstance() {
        if (instance == null) {
            instance = new RandomEmail();
        }
        return instance;
    }
}
