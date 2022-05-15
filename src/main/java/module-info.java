module com.animalshelter.capstone_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.animalshelter.capstone_project to javafx.fxml;
    exports com.animalshelter.capstone_project.View;
    opens com.animalshelter.capstone_project.View to javafx.fxml;
    exports com.animalshelter.capstone_project.Model;
    opens com.animalshelter.capstone_project.Model to javafx.fxml;
    exports com.animalshelter.capstone_project.Controller;
    opens com.animalshelter.capstone_project.Controller to javafx.fxml;
}