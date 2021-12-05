import com.example.assignmentjavafx.EmailValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailValidatorTest {
    private EmailValidator emailValidator;

    /**
     * This method is used to create a new EmailValidator object before each method marked with
     * the Test annotation is called.
     */
    @BeforeEach
    public void setUp() {
        emailValidator = new EmailValidator();
    }

    /**
     * This method is used to test if a sting that represents the email passes the test found
     * in the EmailValidator class. It passes if the boolean isEmailValid is true, this would
     * mean that the test method in the Validator class was a success.
     */
    @Test
    public void validateEmail() {
        String myEmail = "email@com.com";
        boolean isEmailValid = emailValidator.test(myEmail);
        Assertions.assertTrue(isEmailValid);
    }
}