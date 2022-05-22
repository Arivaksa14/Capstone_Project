package com.animalshelter.capstone_project.view;
import com.animalshelter.capstone_project.controller.Controller;
import com.animalshelter.capstone_project.model.FosterVolunteer;
import com.animalshelter.capstone_project.model.InHouseVolunteer;
import com.animalshelter.capstone_project.model.Volunteer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.*;

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

    //private Controller controller = Controller.getInstance();

    private Button resetButton = new Button("Reset Choices");
    private Button addButton = new Button("Add to Schedule");
    private Button nextButton = new Button("Next");
    private Button submitButton = new Button("Submit");

    private Label volunteerTypeLabel = new Label("Volunteer Foster or In House?");
    private ComboBox<String> volunteerTypeComboBox = new ComboBox<>();
    private String volunteerTypeSelected = "Foster";

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
        //volunteersList = controller.getAllVolunteers();
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

    /**
     *
     */
    /*
    private void addVolunteer(){

        String name = nameTF.getText();
        nameErrLabel.setVisible(name.isEmpty());

        String ageErrorCheck = ageTF.getText();
        int age = Integer.parseInt(ageTF.getText());
        ageErrorLabel.setVisible(ageErrorCheck.isEmpty());

        String reason = reasonTF.getText();
        reasonErrorLabel.setVisible(reason.isEmpty());

        String animalType = animalSelected;
        animalTypeErr.setVisible(animalType.isEmpty());

        String startDate = fosterStartTF.getText();
        fosterStartErr.setVisible(startDate.isEmpty());

        String endDate = fosterEndTF.getText();
        fosterEndErr.setVisible(endDate.isEmpty());

        if(volunteerTypeSelected.equalsIgnoreCase("Foster"))
            volunteersList.add(new FosterVolunteer(name, age, reason, animalType, startDate, endDate));

        else {
            String location = volunteerLocationTF.getText();
            volunteerLocationErr.setVisible(location.isEmpty());

            String timeslot = timeSlotTF.getText();
            timeSlotErr.setVisible(timeslot.isEmpty());

            String date = volunteerDateTF.getText();
            volunteerDateErr.setVisible(date.isEmpty());

            volunteersList.add(new InHouseVolunteer(name, age, reason, animalType, location, timeslot, date));
        }
        volunteerListView.refresh();
    }

     */

    /**
     *
     */
    public static final String BINARY_FILE_VOLUNTEER = "volunteer.dat";

    /**
     *
     */
    public static boolean volunteerBinaryHasData(){
        File volunteerBinaryFile = new File(BINARY_FILE_VOLUNTEER);
        return (volunteerBinaryFile.exists() && volunteerBinaryFile.length() >= 5L);
    }



    /**
     *
     */
    public static ObservableList<Volunteer> populateListVolunteerBinaryFile() {

        ObservableList<Volunteer> volunteers = FXCollections.observableArrayList();
        try {
            ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(BINARY_FILE_VOLUNTEER));
            // read from binary file into an array
            Volunteer[] array = (Volunteer[]) fileReader.readObject();
            // loop through array and add each laureate to list
            for(Volunteer nl : array)
                volunteers.add(nl);
            fileReader.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return volunteers;
    }
    /**
     *
     */
    public static boolean writeToVolunteerBinary(ObservableList<Volunteer> volunteers){

        Volunteer[] array = new Volunteer[volunteers.size()];
        // copy all the list data into the array
        for (int i = 0; i < array.length; i++) {
            array[i] = volunteers.get(i);
        }

        // write to binary file
        try {
            ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(BINARY_FILE_VOLUNTEER));
            fileWriter.writeObject(array);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        return true;
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