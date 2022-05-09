module com.animalshelter.capstone_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.animalshelter.capstone_project to javafx.fxml;
    exports com.animalshelter.capstone_project;
}