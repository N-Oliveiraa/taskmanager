module com.mycompany.taskmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    
    requires io.github.cdimascio.dotenv.java;

    opens com.mycompany.taskmanager to javafx.fxml;
    opens com.mycompany.taskmanager.controller to javafx.fxml;
    
    exports com.mycompany.taskmanager;
}
