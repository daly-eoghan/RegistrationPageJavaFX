module com.example.assignmentjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;


    opens com.example.assignmentjavafx to javafx.fxml;
    exports com.example.assignmentjavafx;
}