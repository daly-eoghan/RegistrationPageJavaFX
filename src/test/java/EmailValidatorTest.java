import com.example.assignmentjavafx.EmailValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailValidatorTest {
    private EmailValidator emailValidator;

    @BeforeEach
    public void setUp() {
        emailValidator = new EmailValidator();
    }

    @Test
    public void validateEmail() {
        String myEmail = "Email";
        boolean isEmailValid = emailValidator.test(myEmail);
        Assertions.assertTrue(isEmailValid);
    }
}
