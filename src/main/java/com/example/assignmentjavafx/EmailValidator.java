package com.example.assignmentjavafx;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class EmailValidator implements Predicate<String> {

    /**
     * This method is used to validate the email input of the user. It checks that the email
     * is well-formed, e.g. 'example@gmail.com'. It must contain a '@' surrounded by test and
     * end with '.(something)'.
     *
     * @param  email   String object that is the email input given by the user.
     * @return         Boolean that's true is the email matches the regex statement.
     */
    @Override
    public boolean test(@NotNull String email) {

        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9]{2,6}$");
    }
}
