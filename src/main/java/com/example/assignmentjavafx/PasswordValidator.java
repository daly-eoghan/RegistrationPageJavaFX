package com.example.assignmentjavafx;

import java.util.function.Predicate;
import org.jetbrains.annotations.NotNull;

public class PasswordValidator implements Predicate<String> {

    /**
     * This method is used to validate the password input of the user. It checks that the password
     * is well-formed, so it contains a letter, a digit, a special character from '*^&@!' and it
     * must be at least 7 characters in length.
     *
     *
     * @param  password   String object that is the password input given by the user.
     * @return testSuccess Boolean that's true is the password matches the regex statement.
     */
    @Override
    public boolean test(@NotNull String password) {
        boolean testSuccess = true;

        // Added a test condition that checks if there's a digit, letter and a special character
        // within the entered password. Also ensures a length of at least 7 characters.
        boolean conditions = password.matches("^(?=.*[*^&@!])(?=.*\\d)(?=.*[a-zA-Z]).{7,}$");

        if (!conditions) {
            testSuccess = false;
        }
        return testSuccess;
    }
}
