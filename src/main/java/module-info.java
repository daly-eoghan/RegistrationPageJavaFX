module com.example.assignmentjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignmentjavafx to javafx.fxml;
    exports com.example.assignmentjavafx;
}