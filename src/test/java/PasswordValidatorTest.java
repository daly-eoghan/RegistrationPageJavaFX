import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.assignmentjavafx.PasswordValidator;

class PasswordValidatorTest {
    private PasswordValidator passwordValidator;

    /**
     * This method is used to create a new PasswordValidator object before each method marked with
     * the Test annotation is called.
     */
    @BeforeEach
    public void setUp() {
        passwordValidator = new PasswordValidator();
    }

    /**
     * This method is used to test if a sting that represents the email passes the test found
     * in the PasswordValidator class. It passes if the boolean isPasswordValid is true, this would
     * mean that the test method in the Validator class was a success.
     */
    @Test
    public void validatePassword() {
        String myPassword = "Password6!";
        boolean isPasswordValid = passwordValidator.test(myPassword);
        Assertions.assertTrue(isPasswordValid);
    }
}
