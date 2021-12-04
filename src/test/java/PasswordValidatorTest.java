import com.example.assignmentjavafx.PasswordValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {
    private PasswordValidator passwordValidator;

    @BeforeEach
    public void setUp() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    public void validatePassword() {
        String myPassword = "Email";
        boolean isPasswordValid = passwordValidator.test(myPassword);
    }
}
