package com.example.assignmentjavafx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.atomic.AtomicBoolean;

public class Registration extends Application {

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

        // Adds controls to the above GridPane.
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

        final EmailValidator emailValidator = new EmailValidator();
        final PasswordValidator passwordValidator = new PasswordValidator();
        AtomicBoolean submitSuccessful = new AtomicBoolean(true);

        // Header Controls
        Label header = new Label("Registration Form");
        header.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));

        // Changes the header to white
        header.setStyle("-fx-text-fill: white;");

        header.setUnderline(true);
        grid.add(header, 0,0,2,1);
        GridPane.setHalignment(header, HPos.CENTER);
        GridPane.setMargin(header, new Insets(20, 0,20,0));

        // Email Label Control
        Label emailLabel = new Label("Email:");
        emailLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        emailLabel.setStyle("-fx-text-fill: white;");
        emailLabel.setUnderline(true);
        grid.add(emailLabel, 0, 1);

        // Password Label Control
        Label passwordLabel = new Label("Password:");
        passwordLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        passwordLabel.setStyle("-fx-text-fill: white;");
        passwordLabel.setUnderline(true);
        grid.add(passwordLabel, 0, 3);

        // Email Form Box Control
        TextField emailField = new TextField();
        emailField.setPrefHeight(50);
        grid.add(emailField, 1, 1);

        // Password Form Box Control
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(50);
        grid.add(passwordField, 1, 3);

        // Email Comment Box
        Label emailComment = new Label();
        emailComment.setPrefHeight(50);
        emailComment.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        emailComment.setStyle("-fx-text-fill: white;");
        grid.add(emailComment, 1, 2);

        // Password Comment Box
        Label passwordComment = new Label();
        passwordComment.setPrefHeight(50);
        passwordComment.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        passwordComment.setStyle("-fx-text-fill: white;");
        grid.add(passwordComment, 1, 4);

        // Submit Controls
        Button submit = new Button("Submit Credentials");
        submit.setDefaultButton(true);
        submit.setPrefWidth(100);
        submit.setPrefHeight(50);
        submit.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        grid.add(submit, 0, 5, 2, 1);

        GridPane.setHalignment(submit, HPos.CENTER);
        GridPane.setMargin(submit, new Insets(20, 0,20,0));

        // Event-Driven, once the submit button is clicked run through this code.
        submit.setOnAction(event ->{

            if (!emailValidator.test(emailField.getText())) {
               emailComment.setText("Not Quite. This must be a valid email address!");
               submitSuccessful.set(false);
            }
            else {
                emailComment.setText("About Time! This is a valid email address!");
                submitSuccessful.set(true);
            }
            if (!passwordValidator.test(passwordField.getText())) {
                passwordComment.setText("This is not a valid password. You need a minimum of 7 characters" +
                        ", it must include a digit, a letter\nand a special character from '*^&@!'.");
                submitSuccessful.set(false);
            }
            else {
                passwordComment.setText("About Time! This is a valid password!");
                if (submitSuccessful.get()) {

                    Alert myAlert = new Alert(Alert.AlertType.INFORMATION);
                    myAlert.setTitle("Registration Successful!");
                    myAlert.setHeaderText(null);
                    myAlert.setContentText("Your credentials are valid and you have finally registered!");
                    myAlert.initOwner(grid.getScene().getWindow());
                    myAlert.show();
                }
            }
        });
    }

    /**
     * This method is used to run the program and to launch the JavaFx Scene.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

