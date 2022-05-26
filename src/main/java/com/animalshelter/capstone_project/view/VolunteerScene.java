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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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

    public static final int IMAGE_ROW = 0;
    public static final int SELECT_VOLUNTEER_ROW = 2;
    public static final int FOSTER_CHOICE_CB_ROW = 3;
    public static final int VOLUNTEER_SELECTION_ROW = 4;
    public static final int CURRENT_VOLUNTEERS_ROW = 5;
    public static final int LV_ROW = 6;
    public static final int NEXT_BUTTON_ROW = 10;
    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;

    private ImageView volunteerImage = new ImageView();

    private ObservableList<Volunteer> volunteersList;
    private ListView<Volunteer> volunteerListView = new ListView<>();
    private Controller controller = Controller.getInstance();

    private Button resetButton = new Button("Reset Choices");
    private Button addButton = new Button("Add to Schedule");
    private Button nextButton = new Button("Next");
    private Button submitButton = new Button("Submit");


    private Label selectVolunteerLabel = new Label("Please select to enter either Foster or In House Volunteer");
    private Label volunteerTypeLabel = new Label();
    private ComboBox<String> volunteerTypeComboBox = new ComboBox<>();
    private String volunteerTypeSelected = "Foster";

    private Label currentVolunteersLabel = new Label("Currently entered Volunteers:");

    private ColorPicker colorPicker = new ColorPicker();

    /**
     *
     */
    public VolunteerScene (){

        super(new GridPane(), WIDTH, HEIGHT);

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        pane.add(new Label("Choose a color for this backround :)"), 0, 10);

        //pane.add(colorPicker, 1, 10);
        //Color chosenColor = colorPicker.getValue().
        //pane.setBackground(new Background(new BackgroundFill(chosenColor, null, null)));
        //pane.setBackground(new BackgroundFill(Color.CYAN, null, null));

        volunteerImage.setImage(new Image("volunteerpic2.png"));
        volunteerImage.setFitWidth(WIDTH);
        pane.add(volunteerImage, 0, IMAGE_ROW, 3, 1);

        //pane.add(selectVolunteerLabel, 0, SELECT_VOLUNTEER_ROW);

        pane.add(volunteerTypeLabel, 0, VOLUNTEER_SELECTION_ROW);

        pane.add(currentVolunteersLabel, 0, CURRENT_VOLUNTEERS_ROW);

        HBox selectCBHbox = new HBox(selectVolunteerLabel, volunteerTypeComboBox);
        selectCBHbox.setSpacing(10);
        selectCBHbox.setAlignment(Pos.CENTER);
        pane.add(selectCBHbox, 0, FOSTER_CHOICE_CB_ROW);

        volunteerTypeComboBox.getItems().addAll( "Foster", "In House Volunteer");
        volunteerTypeComboBox.getSelectionModel().selectedItemProperty().addListener
                ((obsVal, oldVal, newVal) -> changeVolunteerTypeLabel(newVal));
        //pane.add(volunteerTypeComboBox, 1, FOSTER_CHOICE_CB_ROW);
        volunteerTypeComboBox.getSelectionModel().selectedItemProperty().addListener
                ((obsVal, oldVal, newVal) -> volunteerTypeSelection(newVal));
        volunteerTypeComboBox.getSelectionModel().select(0);

        volunteersList = controller.getAllVolunteers();
        volunteerListView.setItems(volunteersList);
        volunteerListView.setPrefWidth(WIDTH);
        pane.add(volunteerListView, 0, LV_ROW, 3, 1);

        pane.add(nextButton, 4, NEXT_BUTTON_ROW);

        nextButton.setOnAction(e -> selectScene(volunteerTypeSelected));

        this.setRoot(pane);
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