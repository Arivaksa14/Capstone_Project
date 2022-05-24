package com.animalshelter.capstone_project.view;
import com.animalshelter.capstone_project.controller.Controller;
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
    public static final String BINARY_FILE_VOLUNTEER = "volunteer.dat";
    public static final String CSV_VOLUNTEER_FILE = "volunteerStartToImport.csv";

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

    public static ObservableList<Volunteer> populateFromCSVFile(){

        ObservableList<Volunteer> allVolunteers = FXCollections.observableArrayList();

        String firstName;
        String lastName;
        int age;
        String phoneNumber;
        String email;
        String city;
        String reason;
        String animalType;
        String availability;
        String experience;
        String startDateORLocation;
        String endDateORDate;
        String housingORNickname;
        String transportationORwalkingString;
        boolean transportationORwalkingboolean;

        String line;
        String [] parts;

        try {
            Scanner fileScanner = new Scanner(new File(CSV_VOLUNTEER_FILE));
            // Skip the first line
            // Loop through the file
            fileScanner.nextLine(); // skip 1st line
            while(fileScanner.hasNextLine()){
                // read one line from the CSV
                line = fileScanner.nextLine();
                parts = line.split(",");
                firstName = parts[0];
                lastName = parts[1];
                age = Integer.parseInt(parts[2]);
                phoneNumber = parts[3];
                email = parts[4];
                city = parts[5];
                reason = parts[6];
                animalType = parts[7];
                availability = parts[8];
                experience = parts[9];
                startDateORLocation = parts[10];
                endDateORDate = parts[11];
                housingORNickname = parts[12];
                transportationORwalkingString = parts[13];
                if(transportationORwalkingString.equalsIgnoreCase("True"))
                    transportationORwalkingboolean = true;
                else
                    transportationORwalkingboolean = false;
                allVolunteers.add(
                        new InHouseVolunteer(firstName,lastName, age, phoneNumber, email, city, reason,
                        animalType, availability, experience, startDateORLocation, endDateORDate, housingORNickname,
                        transportationORwalkingboolean));
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return allVolunteers;
    }

    /**
     *
     */
    public static boolean writeToVolunteerBinary(ObservableList<Volunteer> allVolunteers){

        Volunteer[] array = new Volunteer[allVolunteers.size()];
        // copy all the list data into the array
        for (int i = 0; i < array.length; i++) {
            array[i] = allVolunteers.get(i);
        }
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