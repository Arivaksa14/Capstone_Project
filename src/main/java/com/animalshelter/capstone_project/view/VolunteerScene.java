package com.animalshelter.capstone_project.view;

//import com.animalshelter.capstone_project.controller.Controller;
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

    //TODO: Add NAME, Covid Vaccinated?, Foster or In House?, Animal Type? Time Slots?

    private Label nameLabel = new Label("Volunteer Name");
    private TextField nameTF = new TextField();
    private Label nameErrLabel = new Label("Name is required.");

    private Label ageLabel = new Label("Volunteer Age");
    private TextField ageTF =  new TextField();
    private Label ageErrorLabel = new Label("Age required");

    private Label reasonLabel = new Label("Volunteer Reason");
    private TextField reasonTF = new TextField();
    private Label reasonErrorLabel = new Label("Reason Optional");

    private Label emailLabel = new Label("Volunteer Email");
    private TextField emailTF = new TextField();
    private Label emailErrorLabel = new Label("Email required");

    private Label volunteerTypeLabel = new Label("Volunteer Foster or In House?");
    private ComboBox<String> volunteerTypeComboBox = new ComboBox<>();
    private String volunteerTypeSelected;

    private Label animalTypeLabel = new Label("Volunteer Animal Category");
    private ComboBox<String> animalTypeCB = new ComboBox<>();
    private Label animalTypeErr = new Label("Animal Selection required");

    private String animalSelected;


    // Foster Volunteer Scene
    private Label fosterStartDateLabel = new Label("Foster Start Date");
    private TextField fosterStartTF = new TextField();
    private Label fosterStartErr = new Label("Start Dated Required");

    private Label fosterEndDateLabel = new Label("Foster End Date");
    private TextField fosterEndTF = new TextField();
    private Label fosterEndErr = new Label("End Date Required");


    // In House Volunteer Scene
    private Label volunteerLocationLabel = new Label("Location Choice");
    private TextField volunteerLocationTF = new TextField();
    private Label volunteerLocationErr = new Label("Location Required");


    private Label volunteerDateLabel = new Label("Date for volunteer");
    private TextField volunteerDateTF = new TextField();
    private Label volunteerDateErr = new Label("Date Required");

    private Label timeSlotLabel = new Label("Time Slot Chosen");
    private TextField timeSlotTF = new TextField();
    private Label timeSlotErr = new Label("Time Slot Required");





    //TODO: complete once controller is set up with rest of class
    //private HelloController controller = HelloController.getInstance();

    public VolunteerScene (){

        super(new GridPane(), WIDTH, HEIGHT);

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        volunteerImage.setImage(new Image("AnimalVolunteerPicResized.png"));
        volunteerImage.setFitWidth(WIDTH);
        pane.add(volunteerImage, 0, 0, 3, 1);


        pane.add(nameLabel, 0 ,2);
        pane.add(nameTF, 1, 2);
        pane.add(nameErrLabel, 2, 2);
        nameErrLabel.setTextFill(Color.RED);
        nameErrLabel.setVisible(false);

        pane.add(ageLabel, 0, 3);
        pane.add(ageTF, 1, 3);
        pane.add(ageErrorLabel, 2, 3);
        ageErrorLabel.setTextFill(Color.RED);
        ageErrorLabel.setVisible(false);

        pane.add(emailLabel, 0, 4);
        pane.add(emailTF, 1, 4);
        pane.add(emailErrorLabel, 2, 4);
        emailErrorLabel.setTextFill(Color.RED);
        emailErrorLabel.setVisible(false);

        pane.add(reasonLabel, 0, 5);
        pane.add(reasonTF, 1, 5);
        pane.add(reasonErrorLabel, 2, 5);

        pane.add(animalTypeLabel, 0, 6);
        animalTypeCB.getItems().addAll("Dogs", "Cats");
        animalTypeCB.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> animalSelected(newVal));
        animalTypeCB.getSelectionModel().select(0);
        pane.add(animalTypeCB, 1, 6);
        animalTypeErr.setVisible(false);
        animalTypeErr.setTextFill(Color.RED);

        pane.add(volunteerTypeLabel, 0, 7);
        volunteerTypeComboBox.getItems().addAll( "Foster", "In House Volunteer");
        volunteerTypeComboBox.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> changeVolunteerTypeTF(newVal));
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

        pane.add(resetButton, 0, 10);
        resetButton.setOnAction(e -> reset());

        this.setRoot(pane);

        //volunteerTypeComboBox.setOnAction(e -> volunteerTypeComboBox.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> selectScene(newVal)));

        //TODO: Time Slots
    }

    private void volunteerTypeSelection(String newVal) {
        volunteerTypeSelected = newVal;
    }

    private void reset() {
        nameTF.clear();
        ageTF.clear();
        emailTF.clear();
        reasonTF.clear();
        nameTF.requestFocus();
    }

    private void animalSelected(String newVal){
        animalSelected = newVal;
    }



    public void selectScene(String volunteerTypeSelected){

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

        String location = volunteerLocationTF.getText();
        volunteerLocationErr.setVisible(location.isEmpty());

        String timeslot = timeSlotTF.getText();
        timeSlotErr.setVisible(timeslot.isEmpty());

        String date = volunteerDateTF.getText();
        volunteerDateErr.setVisible(date.isEmpty());


        if(volunteerTypeSelected.equalsIgnoreCase("Foster"))
            fosterVolunteerScene();
        else
            inHouseVolunteerScene();
    }

    public void fosterVolunteerScene(){

        GridPane pane = new GridPane();
        pane.setVisible(true);
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        pane.add(fosterStartDateLabel, 0, 2);
        pane.add(fosterStartTF, 1, 2);
        pane.add(fosterStartErr, 2, 2);
        fosterStartErr.setTextFill(Color.RED);
        fosterStartErr.setVisible(false);

        pane.add(fosterEndDateLabel, 0, 3);
        pane.add(fosterEndTF, 1, 3);
        pane.add(fosterEndErr, 2, 3);
        fosterEndErr.setTextFill(Color.RED);
        fosterEndErr.setVisible(false);

        pane.add(submitButton, 4, 10);
        submitButton.setOnAction(e -> addVolunteer());


        this.setRoot(pane);

    }

    public void inHouseVolunteerScene(){

        GridPane pane = new GridPane();
        pane.setVisible(true);
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        pane.add(volunteerLocationLabel, 0, 3);
        pane.add(volunteerLocationTF, 1, 3);
        pane.add(volunteerLocationErr, 2, 3);
        volunteerLocationErr.setTextFill(Color.RED);
        volunteerLocationErr.setVisible(false);

        pane.add(volunteerDateLabel, 0, 4);
        pane.add(volunteerDateTF, 1, 4);
        pane.add(volunteerDateErr, 2, 4);
        volunteerDateErr.setTextFill(Color.RED);
        volunteerDateErr.setVisible(false);


        pane.add(submitButton, 4, 10);
        submitButton.setOnAction(e -> addVolunteer());

        this.setRoot(pane);

    }

    private void changeVolunteerTypeTF(String newVal) {
        volunteerTypeLabel.setText(newVal + " selected.");
    }

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

            volunteersList.add(0, new InHouseVolunteer(name, age, reason, animalType, location, timeslot, date));
        }
        volunteerListView.refresh();
    }


    public static final String BINARY_FILE_VOLUNTEER = "volunteer.dat";

    public static boolean volunteerBinaryHasData(){
        File volunteerBinaryFile = new File(BINARY_FILE_VOLUNTEER);
        return (volunteerBinaryFile.exists() && volunteerBinaryFile.length() >= 5L);
    }

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
