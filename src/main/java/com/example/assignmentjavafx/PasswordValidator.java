package com.example.assignmentjavafx;

import java.util.function.Predicate;
import org.jetbrains.annotations.NotNull;

public class PasswordValidator implements Predicate<String> {
    @Override
    public boolean test(@NotNull String password) {
        boolean testSuccess = true;

        // Added a test condition that checks if there's a digit, letter and a special character
        // within the entered password
        boolean conditions = password.matches("^(?=.*[*^&@!])(?=.*\\d)(?=.*[a-zA-Z]).{7,}$");

        if (!conditions) {
            testSuccess = false;
        }
        return testSuccess;
    }
}
