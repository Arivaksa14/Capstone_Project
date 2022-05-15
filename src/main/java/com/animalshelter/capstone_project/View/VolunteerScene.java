package com.animalshelter.capstone_project.View;

import com.animalshelter.capstone_project.Model.Volunteer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VolunteerScene extends Scene {
/*
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

 */

    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;

    private ImageView volunteerImage = new ImageView();

    private ListView<Volunteer> volunteerListView = new ListView<>();

    private Button resetButton = new Button("Reset Choices");
    private Button addButton = new Button("Add to Schedule");

    //TODO: Add NAME, Covid Vaccinated?, Foster or In House?, Animal Type? Time Slots?

    private Label nameLabel = new Label("Name");
    private TextField nameTF = new TextField();
    private Label nameErrLabel = new Label("Name is required.");

    private Label volunteerTypeLabel = new Label("Foster or In House Volunteer?");
    private ComboBox<String> volunteerTypeComboBox = new ComboBox<>();

    private Label animalType = new Label("Animal Category");
    private ComboBox<String> animalTypeCB = new ComboBox<>();



    //TODO: complete once controller is set up with rest of class
    //private HelloController controller = HelloController.getInstance();

    public VolunteerScene (){
        super(new GridPane(), WIDTH, HEIGHT);

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        volunteerImage.setImage(new Image("AnimalVolunteerPic.png"));
        volunteerImage.setFitWidth(WIDTH);
        pane.add(volunteerImage, 0, 0, 3, 1);


        volunteerTypeComboBox.getItems().addAll("Foster", "In House Volunteer");
        volunteerTypeComboBox.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> changeVolunteerType(newVal));

        animalTypeCB.getItems().addAll("Dogs", "Cats", "Small Animal"); // hamsters, bunnies, parrots







        //TODO: Add NAME, Covid Vaccinated?, Foster or In House?, Animal Type? Time Slots?


    }

    private void changeVolunteerType(String newVal) {
        volunteerTypeLabel.setText(newVal + " selected.");
    }
}
