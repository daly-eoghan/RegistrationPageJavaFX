package com.example.assignmentjavafx;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(@NotNull String email) {

        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9]{2,6}$");
    }
}
