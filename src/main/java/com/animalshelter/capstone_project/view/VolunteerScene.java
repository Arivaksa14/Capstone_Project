package com.animalshelter.capstone_project.view;

import com.animalshelter.capstone_project.model.Volunteer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

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

    private ListView<Volunteer> volunteerListView = new ListView<>();

    private Button resetButton = new Button("Reset Choices");
    private Button addButton = new Button("Add to Schedule");
    private Button nextButton = new Button("Next");

    //TODO: Add NAME, Covid Vaccinated?, Foster or In House?, Animal Type? Time Slots?

    private Label nameLabel = new Label("Name");
    private TextField nameTF = new TextField();
    private Label nameErrLabel = new Label("Name is required.");

    private Label ageLabel = new Label("Age");
    private TextField ageTF =  new TextField();
    private Label ageErrorLabel = new Label();

    private Label reasonLabel = new Label("Reason you are volunteering");
    private TextField reasonTF = new TextField();
    private Label reasonErrorLabel = new Label();

    private Label emailLabel = new Label("Email");
    private TextField emailTF = new TextField();
    private Label emailErrorLabel = new Label();

    private Label volunteerTypeLabel = new Label("Please select Foster or In House Volunteer?");
    private ComboBox<String> volunteerTypeComboBox = new ComboBox<>();



    private Label animalTypeLabel = new Label("Animal Category");
    private ComboBox<String> animalTypeCB = new ComboBox<>();





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
        nameErrLabel.setVisible(false);

        pane.add(ageLabel, 0, 3);
        pane.add(ageTF, 1, 3);
        pane.add(ageErrorLabel, 2, 3);

        pane.add(emailLabel, 0, 4);
        pane.add(emailTF, 1, 4);
        pane.add(emailErrorLabel, 2, 4);

        pane.add(resetButton, 0, 10);
        resetButton.setOnAction(e -> reset());


        pane.add(animalTypeLabel, 0, 5);
        animalTypeCB.getItems().addAll("Dogs", "Cats", "Small Animal"); // hamsters, bunnies, parrots
        animalTypeCB.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> changeAnimalType(newVal));
        animalTypeCB.getSelectionModel().select(0);
        pane.add(animalTypeCB, 1, 5);

        pane.add(nextButton, 4, 10);


        volunteerTypeComboBox.getItems().addAll( "Foster", "In House Volunteer");
        volunteerTypeComboBox.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> changeVolunteerTypeTF(newVal));
        pane.add(volunteerTypeComboBox, 1, 6);
        //volunteerTypeComboBox.getSelectionModel().select(0);

        pane.add(volunteerTypeLabel, 0, 6);






        this.setRoot(pane);

        volunteerTypeComboBox.setOnAction(e -> volunteerTypeComboBox.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> selectScene(newVal)));


        //TODO: Time Slots?


    }

    private void reset() {
        nameTF.clear();
        ageTF.clear();
        emailTF.clear();
        reasonTF.clear();
        nameTF.requestFocus();
    }

    private void changeAnimalType(String newVal) {

    }


    public void selectScene(String newVal){

        if(newVal.equalsIgnoreCase("Foster")) {
            fosterVolunteerScene();
        }
        else
            inHouseVolunteerScene();
    }

    public void fosterVolunteerScene(){


    }

    public void inHouseVolunteerScene(){


    }

    private void changeVolunteerTypeTF(String newVal) {
        volunteerTypeLabel.setText(newVal + " selected.");
    }

    private void addVolunteer(){

        String name = nameTF.getText();
        nameErrLabel.setVisible(name.isEmpty());
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
