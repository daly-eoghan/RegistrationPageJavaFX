package com.example.assignmentjavafx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Window;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class Registration extends Application {
    private final EmailValidator emailValidator = new EmailValidator();

    /**
     * This method creates the Stage and Scene that are used as the bottom two layers of the Registration Form.
     * A GridPane object is created through the createRegistrationFormPane method and the different controls
     * are added to this by calling the addUIControls method. The Scene is manipulated to change its width,
     * length and colour before attaching it to the Stage.
     *
     * @param  mainStage  a Stage Object that forms the foundational base of our Registration Form
     */
    @Override
    public void start(@NotNull Stage mainStage) {
        mainStage.setTitle("Registration Form");

        GridPane regPane = createRegistrationFormPane();

        addUIControls(regPane);
        Scene scene1 = new Scene(regPane, 900, 650);
        regPane.setStyle("-fx-background-color: darkred;");
        mainStage.setScene(scene1);

        mainStage.show();
    }

    /**
     * This method creates the GridPane object used in the Registration Form. It changes its alignment,
     * padding along with the column and row gaps and alignments.
     *
     * @return the GridPane object that has been altered to suit the layout of the scene.
     */
    private GridPane createRegistrationFormPane() {

        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(50, 50, 50, 50));
        grid.setHgap(15);
        grid.setVgap(15);

        ColumnConstraints columnConstraints1 = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnConstraints1.setHalignment(HPos.RIGHT);

        ColumnConstraints columnConstraints2 = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnConstraints2.setHgrow(Priority.ALWAYS);

        grid.getColumnConstraints().addAll(columnConstraints1, columnConstraints2);

        return grid;
    }

    /**
     * This method is used to add the various controls to the GridPane object that is passed in. It will
     * add the header Label, email Label, email TextField, password Label, password TextField and
     * submit button. Many properties of these controls are changed before adding them into the grid,
     * this includes the font, style, height, width and position.
     *
     * @param  grid   GridPane Object that is used to lay out the various controls of the form.
     */
    private void addUIControls(@NotNull GridPane grid) {

        // Header Controls
        Label header = new Label("Registration Form");
        header.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
        header.setStyle("-fx-text-fill: white;");
        grid.add(header, 0,0,2,1);
        GridPane.setHalignment(header, HPos.CENTER);
        GridPane.setMargin(header, new Insets(20, 0,20,0));

        // Email Controls
        Label emailLabel = new Label("Email: ");
        emailLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        emailLabel.setStyle("-fx-text-fill: white;");
        grid.add(emailLabel, 0, 1);

        TextField emailField = new TextField();
        emailField.setPrefHeight(50);
        grid.add(emailField, 1, 1);

        // Password Controls
        Label passwordLabel = new Label("Password: ");
        passwordLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        passwordLabel.setStyle("-fx-text-fill: white;");
        grid.add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(50);
        grid.add(passwordField, 1, 2);

        // Submit Controls
        Button submit = new Button("Submit");
        submit.setPrefHeight(50);
        submit.setDefaultButton(true);
        submit.setPrefWidth(100);
        submit.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        grid.add(submit, 0, 4, 2, 1);

        GridPane.setHalignment(submit, HPos.CENTER);
        GridPane.setMargin(submit, new Insets(20, 0,20,0));

        submit.setOnAction(event ->{

            if (!emailValidator.test(emailField.getText())) {
                showRegistrationResults(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Email Error!", "Please Enter a Proper Email!");
            }
            else {
                showRegistrationResults(Alert.AlertType.CONFIRMATION, grid.getScene().getWindow(), "Registration Complete!", "You have entered valid credentials");
            }

        });
    }

    /**
     * This method is used to create the alert box which will display a comment regarding the user's
     * registration. Upon clicking the submit button this alert box will appear with appropriate
     * dialogue set by the alertTitle and message1 parameters.
     *
     * @param  alertType   AlertType Object used to create the Alert box.
     * @param  owner   Window Object that highlights the owner Window for this alert box dialogue.
     * @param  alertTitle   String Object that specifies the Title for the alert.
     * @param  message1   String Object that specifies the message for the alert.
     */
    private void showRegistrationResults(@NotNull Alert.AlertType alertType, @NotNull Window owner,
                                         @NotNull String alertTitle, @NotNull String message1) {

        Alert myAlert = new Alert(alertType);
        myAlert.setTitle(alertTitle);
        myAlert.setHeaderText(null);
        myAlert.setContentText(message1);
        myAlert.initOwner(owner);
        myAlert.show();
    }

    /**
     * This method is used to run the program and to launch the JavaFx Scene.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

