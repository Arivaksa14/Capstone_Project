package com.animalshelter.capstone_project.view;

import com.animalshelter.capstone_project.controller.Controller;
import com.animalshelter.capstone_project.controller.VolunteerController;
import com.animalshelter.capstone_project.model.FosterVolunteer;
import com.animalshelter.capstone_project.model.Volunteer;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FosterVolunteerScene extends Scene {

    public static final int RETURN_ROW = 1;
    public static final int SAVE_ROW = 1;
    public static final int FIRST_NAME_ROW = 2;
    public static final int LAST_NAME_ROW = 3;
    public static final int AGE_ROW = 4;
    public static final int EMAIL_ROW = 5;
    public static final int CITY_ROW = 6;
    public static final int REASON_ROW = 7;
    public static final int ANIMAL_TYPE_ROW = 8;
    public static final int AVAILABILITY_ROW = 9;
    public static final int EXPERIENCE_ROW = 10;
    public static final int PHONE_ROW = 11;
    public static final int DATE_START_ROW = 12;
    public static final int DATE_END_ROW = 13;
    public static final int HOUSING_ROW = 14;
    public static final int TRANSPORTATION_ROW = 15;
    public static final int REMOVE_ROW = 16;
    public static final int RESET_SUBMIT_ROW = 16;

    public static final String [] EXPERIENCE_CHOICES = {"None", "1 year", "2 years"};
    public static final String [] TRANSPORTATION_CHOICES = {"Yes", "No"};
    public static final String [] HOUSING_CHOICES = {"House", "Apartment", "Condo", "Trailer"};


    public static final int WIDTH = 700;
    public static final int HEIGHT = 900;

    private ListView<Volunteer> volunteerLV = new ListView<>();

    private Controller controller = Controller.getInstance();
    private ObservableList<Volunteer> volunteerList;
    private Volunteer selectedVolunteer;

    private ImageView fosterVolunteerImage = new ImageView();

    // General Buttons
    private Button resetButton = new Button("Reset Choices");
    private Button addFosterButton = new Button("+ Volunteer");
    private Button removeButton = new Button("- Volunteer");
    private Button returnButton = new Button("Return to Main Page");
    private Button saveExitButton = new Button("Save & Exit");

    // General Requirements
    private Label firstNameLabel = new Label("Volunteer First Name");
    private TextField firstNameTF = new TextField();
    private Label firstNameErrLabel = new Label("First Name is required.");

    private Label lastNameLabel = new Label("Volunteer Last Name");
    private TextField lastNameTF = new TextField();
    private Label lastNameErrLabel = new Label("Last Name is required.");

    private Label ageLabel = new Label("Volunteer Age");
    private TextField ageTF =  new TextField();
    private Label ageErrorLabel = new Label("Age required");
    private Label ageVerifyErrLabel = new Label("Age must be over 18");

    private Label emailLabel = new Label("Volunteer Email");
    private TextField emailTF = new TextField();
    private Label emailErrorLabel = new Label("Email required");

    private Label cityLabel = new Label("Volunteer City");
    private TextField cityTF = new TextField();
    private Label cityErrLabel = new Label("City Required");

    private Label reasonLabel = new Label("Volunteer Reason");
    private TextField reasonTF = new TextField();
    private Label reasonErrorLabel = new Label("Reason Optional");

    private Label animalTypeLabel = new Label("Volunteer Animal Category");
    private ComboBox<String> animalTypeCB = new ComboBox<>();
    private Label animalTypeErr = new Label("Animal Selection required");
    private String animalSelected;

    private Label volunteerAvailabilityLabel = new Label("Volunteer Availability");
    private ComboBox<String> volunteerAvailabilityCB = new ComboBox<>();
    private Label volunteerAvailabilityErr = new Label("Availability required");
    private String availabilitySelected;

    private Label experienceLabel = new Label("Volunteer Experience");
    private ComboBox<String> experienceCB = new ComboBox<>();
    private Label experienceErrLabel = new Label("Experience required");
    private String experienceSelected;

    private Label phoneNumberLabel = new Label("Volunteer Phone#");
    private TextField phoneNumberTF = new TextField();
    private Label phoneErrLabel = new Label("Phone# required");

    // Foster Dedicated
    private Label fosterStartDateLabel = new Label("Foster Start Date");
    private Label fosterDateErr = new Label("Date Required");
    private DatePicker startDatePicker = new DatePicker();
    private Label fosterStartErr = new Label("Start Dated Required");
    private String startDateSelected;

    private Label fosterEndDateLabel = new Label("Foster End Date");
    private DatePicker endDatePicker = new DatePicker();
    private Label fosterEndErr = new Label("End Date Required");
    private String endDateSelected;

    private Label housingLabel = new Label("Volunteer Housing");
    private ComboBox<String> housingCB = new ComboBox<>();
    private Label housingErrLabel = new Label("Housing choice Required");
    private String housingSelected;

    private Label transportationLabel = new Label("Reliable Transportation?");
    private ComboBox<String> transportationCB = new ComboBox<>();
    private Label transportationErrLabel =  new Label("Transportation Required");
    private boolean transportationCheck;

    public FosterVolunteerScene() {

        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();
        pane.setVisible(true);
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        fosterVolunteerImage.setImage(new Image("fostervolunteerpic.png"));
        fosterVolunteerImage.setFitWidth(WIDTH);
        pane.add(fosterVolunteerImage, 0, 0, 3, 1);

        // General Requirements
        pane.add(firstNameLabel, 0 ,FIRST_NAME_ROW);
        pane.add(firstNameTF, 1, FIRST_NAME_ROW);
        pane.add(firstNameErrLabel, 2, FIRST_NAME_ROW);
        firstNameErrLabel.setTextFill(Color.RED);
        firstNameErrLabel.setVisible(false);


        pane.add(lastNameLabel, 0 ,LAST_NAME_ROW);
        pane.add(lastNameTF, 1, LAST_NAME_ROW);
        pane.add(lastNameErrLabel, 2, LAST_NAME_ROW);
        lastNameErrLabel.setTextFill(Color.RED);
        lastNameErrLabel.setVisible(false);

        pane.add(ageLabel, 0, AGE_ROW);
        pane.add(ageTF, 1, AGE_ROW);
        pane.add(ageErrorLabel, 2, AGE_ROW);
        ageErrorLabel.setTextFill(Color.RED);
        ageErrorLabel.setVisible(false);
        pane.add(ageVerifyErrLabel, 2, AGE_ROW);
        ageVerifyErrLabel.setTextFill(Color.RED);
        ageVerifyErrLabel.setVisible(false);

        pane.add(cityLabel, 0, CITY_ROW);
        pane.add(cityTF, 1, CITY_ROW);
        pane.add(cityErrLabel, 2, CITY_ROW);
        cityErrLabel.setTextFill(Color.RED);
        cityErrLabel.setVisible(false);

        pane.add(emailLabel, 0, EMAIL_ROW);
        pane.add(emailTF, 1, EMAIL_ROW);
        pane.add(emailErrorLabel, 2, EMAIL_ROW);
        emailErrorLabel.setTextFill(Color.RED);
        emailErrorLabel.setVisible(false);

        pane.add(reasonLabel, 0, REASON_ROW);
        pane.add(reasonTF, 1, REASON_ROW);
        pane.add(reasonErrorLabel, 2, REASON_ROW);
        reasonErrorLabel.setVisible(false);

        pane.add(animalTypeLabel, 0, ANIMAL_TYPE_ROW);
        animalTypeCB.getItems().addAll("Dogs", "Cats");
        animalTypeCB.getSelectionModel().selectedItemProperty().addListener
                ((obsVal, oldVal, newVal) -> animalSelected(newVal));
        animalTypeCB.getSelectionModel().select(0);
        pane.add(animalTypeCB, 1, ANIMAL_TYPE_ROW);
        animalTypeErr.setVisible(false);
        animalTypeErr.setTextFill(Color.RED);

        // Foster Dedicated
        pane.add(volunteerAvailabilityLabel, 0, AVAILABILITY_ROW);
        volunteerAvailabilityCB.getItems().addAll( "Weekdays", "Weekends", "Flexible");
        volunteerAvailabilityCB.getSelectionModel().selectedItemProperty().addListener
                ((obsVal, oldVal, newVal) -> availabilitySelect(newVal));
        pane.add(volunteerAvailabilityCB, 1, AVAILABILITY_ROW);
        volunteerAvailabilityCB.getSelectionModel().select(0);

        pane.add(volunteerAvailabilityErr, 2, AVAILABILITY_ROW);
        volunteerAvailabilityErr.setVisible(false);

        pane.add(experienceLabel, 0, EXPERIENCE_ROW);
        experienceCB.getItems().addAll(EXPERIENCE_CHOICES);
        experienceCB.getSelectionModel().selectedItemProperty().addListener
                ((obsVal, oldVal, newVal) -> experienceSelect(newVal));
        experienceCB.getSelectionModel().select(0);
        pane.add(experienceCB, 1, EXPERIENCE_ROW);
        experienceErrLabel.setVisible(false);
        experienceErrLabel.setTextFill(Color.RED);

        pane.add(phoneNumberLabel, 0, PHONE_ROW);
        pane.add(phoneNumberTF, 1, PHONE_ROW);
        pane.add(phoneErrLabel, 2, PHONE_ROW);
        phoneErrLabel.setVisible(false);

        pane.add(fosterStartDateLabel, 0, DATE_START_ROW);
        pane.add(startDatePicker, 1, DATE_START_ROW);
        pane.add(fosterStartErr, 2, DATE_START_ROW);
        fosterStartErr.setTextFill(Color.RED);
        fosterStartErr.setVisible(false);
        startDatePicker.valueProperty().addListener
                ((obsVal, oldVal, newVal) -> startDateSelect(String.valueOf(newVal)));

        pane.add(fosterEndDateLabel, 0, DATE_END_ROW);
        pane.add(endDatePicker, 1, DATE_END_ROW);
        pane.add(fosterEndErr, 2, DATE_END_ROW);
        fosterEndErr.setTextFill(Color.RED);
        fosterEndErr.setVisible(false);
        endDatePicker.valueProperty().addListener
                ((obsVal, oldVal, newVal) -> endDateSelect(String.valueOf(newVal)));

        pane.add(housingLabel, 0, HOUSING_ROW);
        housingCB.getItems().addAll(HOUSING_CHOICES);
        housingCB.getSelectionModel().selectedItemProperty().addListener
                ((obsVal, oldVal, newVal) -> housingSelect(newVal));
        housingCB.getSelectionModel().select(0);
        pane.add(housingCB, 1, HOUSING_ROW);
        pane.add(housingErrLabel, 2, HOUSING_ROW);
        housingErrLabel.setVisible(false);
        housingErrLabel.setTextFill(Color.RED);

        pane.add(transportationLabel, 0, TRANSPORTATION_ROW);
        transportationCB.getItems().addAll(TRANSPORTATION_CHOICES);
        transportationCB.getSelectionModel().selectedItemProperty().addListener
                ((obsVal, oldVal, newVal) -> transportationSelect(newVal));
        transportationCB.getSelectionModel().select(0);
        pane.add(transportationCB, 1, TRANSPORTATION_ROW);
        pane.add(transportationErrLabel, 2, TRANSPORTATION_ROW);
        transportationErrLabel.setVisible(false);
        transportationErrLabel.setTextFill(Color.RED);

        volunteerList = controller.getAllVolunteers();
        volunteerLV.setItems(volunteerList);

        volunteerLV.setPrefWidth(WIDTH);
        pane.add(volunteerLV, 0, 18, 5, 1);
        volunteerLV.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> selectVolunteer(newVal));

        pane.add(resetButton, 2, RESET_SUBMIT_ROW);
        resetButton.setOnAction(e -> reset());

        pane.add(addFosterButton, 4, RESET_SUBMIT_ROW);
        addFosterButton.setOnAction(e -> addFosterVolunteer());

        pane.add(returnButton, 0, RETURN_ROW);
        returnButton.setOnAction(e -> ViewNavigator.loadScene( "Animal Shelter Application", new MainScene()));

        pane.add(removeButton, 0, REMOVE_ROW);
        removeButton.setDisable(true);
        removeButton.setOnAction(event -> removeVolunteer());

        pane.add(saveExitButton, 4, SAVE_ROW);
        saveExitButton.setOnAction(e -> saveAndExit());

        this.setRoot(pane);
    }

    private void saveAndExit(){
        Controller.getInstance().saveData();
        System.exit(0);
    }

    private void selectVolunteer(Volunteer newVal){
        selectedVolunteer = newVal;
        removeButton.setDisable(selectedVolunteer == null);
    }

    private void reset() {
        firstNameTF.clear();
        lastNameTF.clear();
        ageTF.clear();
        emailTF.clear();
        cityTF.clear();
        reasonTF.clear();
        animalTypeCB.getSelectionModel().select(0);
        volunteerAvailabilityCB.getSelectionModel().select(0);
        phoneNumberTF.clear();
    }

    private void removeVolunteer(){

        if(selectedVolunteer == null)
            return;
        volunteerList.remove(selectedVolunteer);
        volunteerLV.refresh();
        volunteerLV.getSelectionModel().select(-1);
    }

    private void addFosterVolunteer(){

        int age = 0;
        String firstName = firstNameTF.getText();
        firstNameErrLabel.setVisible(firstName.isEmpty());

        String lastName = lastNameTF.getText();
        lastNameErrLabel.setVisible(lastName.isEmpty());
        try{
            age = Integer.parseInt(ageTF.getText());
            if(age < 18) {
                ageVerifyErrLabel.setVisible(true);
                ageErrorLabel.setVisible(false);
            }
            else
                ageVerifyErrLabel.setVisible(false);
        } catch (NumberFormatException e ) {
            ageErrorLabel.setVisible(true);
            ageVerifyErrLabel.setVisible(false);
            }

        Long phoneNumber = Long.parseLong(phoneNumberTF.getText());
        String phoneNumberFormatted = String.valueOf(phoneNumber).replaceFirst
                ("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");

        String reason = reasonTF.getText();
        reasonErrorLabel.setVisible(reason.isEmpty());

        String animalType = animalSelected;
        animalTypeErr.setVisible(animalType.isEmpty());

        String startDate = startDateSelected;
        fosterStartErr.setVisible(startDate.isEmpty());

        String endDate = endDateSelected;
        fosterEndErr.setVisible(endDate.isEmpty());

        String email = emailTF.getText();
        emailErrorLabel.setVisible(email.isEmpty());

        String city = cityTF.getText();
        cityErrLabel.setVisible(city.isEmpty());

        String availability = availabilitySelected;
        volunteerAvailabilityErr.setVisible(availability.isEmpty());

        String experience = experienceSelected;
        experienceErrLabel.setVisible(experience.isEmpty());

        String housing = housingSelected;
        housingErrLabel.setVisible(housing.isEmpty());

        boolean transportation = transportationCheck;

        if(firstNameErrLabel.isVisible() || lastNameErrLabel.isVisible() || ageErrorLabel.isVisible() ||
                phoneErrLabel.isVisible() || emailErrorLabel.isVisible() || cityErrLabel.isVisible() ||
                reasonErrorLabel.isVisible() || animalTypeErr.isVisible() || volunteerAvailabilityErr.isVisible() ||
                experienceErrLabel.isVisible() || fosterStartErr.isVisible() || fosterEndErr.isVisible() ||
                housingErrLabel.isVisible() || transportationErrLabel.isVisible()
        )
            return;
        else
        {
            ageVerifyErrLabel.setVisible(false);
            ageErrorLabel.setVisible(false);
            volunteerList.add(0, new FosterVolunteer(firstName,lastName, age, phoneNumberFormatted, email, city,
                    reason, animalType, availability, experience, startDate, endDate, housing, transportation));
            volunteerLV.refresh();
        }
    }

    private void experienceSelect(String newVal) {
        experienceSelected = newVal;
    }

    private void availabilitySelect(String newVal) {
        availabilitySelected = newVal;
    }

    private void transportationSelect(String newVal) {

        if (newVal.equalsIgnoreCase("yes")){
            transportationCheck = true;
            transportationErrLabel.setVisible(false);
        }
        else {
            transportationCheck = false;
            transportationErrLabel.setVisible(true);
        }
    }

    private void housingSelect(String newVal) {
        housingSelected = newVal;
    }

    private void startDateSelect(String newVal) {
        LocalDate dateChosen = startDatePicker.getValue();
        String dateFormatted = dateChosen.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        startDateSelected = dateFormatted;
    }

    private void endDateSelect(String newVal) {
        LocalDate dateChosen = endDatePicker.getValue();
        String dateFormatted = dateChosen.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        endDateSelected = dateFormatted;
    }

    private void animalSelected(String newVal){
        animalSelected = newVal;
    }

}
