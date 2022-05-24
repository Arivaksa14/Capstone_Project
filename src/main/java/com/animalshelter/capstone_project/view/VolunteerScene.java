package com.animalshelter.capstone_project.view;
import com.animalshelter.capstone_project.controller.Controller;
import com.animalshelter.capstone_project.controller.VolunteerController;
import com.animalshelter.capstone_project.model.FosterVolunteer;
import com.animalshelter.capstone_project.model.InHouseVolunteer;
import com.animalshelter.capstone_project.model.Volunteer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.Scanner;

public class VolunteerScene extends Scene {
/*
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

 */
    /**
     * EASIER TO MANAGE SCENE POSITIONING
     */
    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;

    private ImageView volunteerImage = new ImageView();

    private ObservableList<Volunteer> volunteersList;
    private ListView<Volunteer> volunteerListView = new ListView<>();
    private VolunteerController controller = VolunteerController.getInstance();

    //private Controller controller = Controller.getInstance();

    private Button resetButton = new Button("Reset Choices");
    private Button addButton = new Button("Add to Schedule");
    private Button nextButton = new Button("Next");
    private Button submitButton = new Button("Submit");

    private Label volunteerTypeLabel = new Label("Volunteer Foster or In House?");
    private ComboBox<String> volunteerTypeComboBox = new ComboBox<>();
    private String volunteerTypeSelected = "Foster";

    private ColorPicker colorPicker = new ColorPicker();

    //TODO: complete once controller is set up with rest of class
    //private HelloController controller = HelloController.getInstance();
    /**
     *
     */
    public VolunteerScene (){

        super(new GridPane(), WIDTH, HEIGHT);

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));
/*
        pane.add(new Label("Choose a color for this backround :)"), 0, 10);

        pane.add(colorPicker, 1, 10);
        Color chosenColor = colorPicker.getValue().
        pane.setBackground(new Background(new BackgroundFill(chosenColor, null, null)));

 */

        volunteerImage.setImage(new Image("AnimalVolunteerPicResized.png"));
        volunteerImage.setFitWidth(WIDTH);
        pane.add(volunteerImage, 0, 0, 3, 1);

        pane.add(volunteerTypeLabel, 0, 7);
        volunteerTypeComboBox.getItems().addAll( "Foster", "In House Volunteer");
        volunteerTypeComboBox.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> changeVolunteerTypeLabel(newVal));
        pane.add(volunteerTypeComboBox, 1, 7);
        volunteerTypeComboBox.getSelectionModel().select(0);

        volunteerListView.setPrefWidth(WIDTH);
        pane.add(volunteerListView, 0, 8, 3, 1);

        //TODO: ->
        volunteersList = controller.getAllVolunteers();
        volunteerListView.setItems(volunteersList);



        pane.add(nextButton, 4, 10);
        volunteerTypeComboBox.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> volunteerTypeSelection(newVal));

        nextButton.setOnAction(e -> selectScene(volunteerTypeSelected));
        //nextButton.setOnAction(e -> volunteerTypeComboBox.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> selectScene(newVal)));

        this.setRoot(pane);
        //volunteerTypeComboBox.setOnAction(e -> volunteerTypeComboBox.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> selectScene(newVal)));
        //TODO: Time Slots
    }

    /**
     * creates String of either (Foster or In House) Volunteer
     */
    private void volunteerTypeSelection(String newVal) {
        volunteerTypeSelected = newVal;
    }

    /**
     * Creates new scene from volunteerTypeSelected
     */
    public void selectScene(String volunteerTypeSelected){
        if(volunteerTypeSelected.equalsIgnoreCase("Foster"))
            ViewNavigator.loadScene("Foster Volunteer Data Entry", new FosterVolunteerScene());
        else
            ViewNavigator.loadScene("In House Volunteer Data Entry", new InHouseVolunteerScene());
    }


    /**
     * changes volunteerTypeLabel to reflect what is selected
     */
    private void changeVolunteerTypeLabel(String newVal) {
        volunteerTypeLabel.setText(newVal + " selected.");
    }


}
/*

    private static Controller theInstance;
    private ObservableList<Volunteer> mAllVolunteers;

    private Controller(){}

    public static Controller getInstance() {

        // if instance is null, create a new obj
        if(theInstance == null) {
            theInstance = new Controller();
            // Fill the allLaureates list w/ Data from the Model class
            // if binary file has data, fill w/ binary file
            if(VolunteerScene.volunteerBinaryHasData())
                theInstance.mAllVolunteers = VolunteerScene.populateListVolunteerBinaryFile();
            else
                theInstance.mAllVolunteers.add(new Volunteer("Name", 1, "Reason", "Animal Type"));
        }
        return theInstance;
    }

    public ObservableList<Volunteer> getAllVolunteers(){
        return mAllVolunteers;
    }

    public void saveData(){
        VolunteerScene.writeToVolunteerBinary(mAllVolunteers);
    }


 */