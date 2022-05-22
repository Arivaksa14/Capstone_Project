package com.animalshelter.capstone_project.view;

import com.animalshelter.capstone_project.model.FosterVolunteer;
import com.animalshelter.capstone_project.model.InHouseVolunteer;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class FosterVolunteerScene extends Scene {
    /*
    pane.add(datePicker, 0, 12);
    private DatePicker datePicker = new DatePicker();
    LocalDate dateChosen = datePicker.getValue();
    String dateFormatted =dateChosen.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

     */
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

    public static final int RESET_SUBMIT_ROW = 16;


    public static final String [] EXPERIENCE_CHOICES = {"None", "1 year", "2 years"};
    public static final String [] TRANSPORTATION_CHOICES = {"Yes", "No"};
    public static final String [] HOUSING_CHOICES = {"House", "Apartment", "Condo", "Trailer"};


    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;


    // General Buttons
    private Button resetButton = new Button("Reset Choices");
    private Button addButton = new Button("Add to Schedule");
    private Button nextButton = new Button("Next");
    private Button submitButton = new Button("Submit");

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
/*
    private Label volunteerTypeLabel = new Label("Volunteer Foster or In House?");
    private ComboBox<String> volunteerTypeComboBox = new ComboBox<>();
    private String volunteerTypeSelected = "Foster";


 */
    private Label animalTypeLabel = new Label("Volunteer Animal Category");
    private ComboBox<String> animalTypeCB = new ComboBox<>();
    private Label animalTypeErr = new Label("Animal Selection required");
    private String animalSelected;

    private Label volunteerAvailabilityLabel = new Label("Volunteer Availability");
    private ComboBox<String> volunteerAvailabilityCB = new ComboBox<>();
    private Label volunteerAvailabilityErr = new Label("Availability required");
    private String volunteerAvailabilityString;

    private Label experienceLabel = new Label("Volunteer Experience");
    private ComboBox<String> experienceCB = new ComboBox<>();
    private Label experienceErrLabel = new Label("Experience required");
    private String ExperienceSelected;

    private Label phoneNumberLabel = new Label("Volunteer Phone#");
    private TextField phoneNumberTF = new TextField();
    private Label phoneErrLabel = new Label("Phone# required");
    private String phoneNumberFormatted;

    // Foster Dedicated
    private Label fosterStartDateLabel = new Label("Foster Start Date");
    private Label fosterDateErr = new Label("Date Required");
    private DatePicker startDatePicker = new DatePicker();
    private String startDateSelected;
    private Label fosterStartErr = new Label("Start Dated Required");

    private Label fosterEndDateLabel = new Label("Foster End Date");
    private DatePicker endDatePicker = new DatePicker();
    private String endDateSelected;
    private Label fosterEndErr = new Label("End Date Required");

    private Label housingLabel = new Label("Volunteer Housing");
    private ComboBox<String> housingCB = new ComboBox<>();
    private Label housingErrLabel = new Label("Housing choice Required");
    private String housingSelected;

    private Label transportationLabel = new Label("Reliable Transportation?");
    private ComboBox<String> transportationCB = new ComboBox<>();
    private Label transportationErrLabel =  new Label("Transportation Required");
    private boolean transportationCheck;

/*
    private Label fosterExperienceLabel = new Label("Previous Foster Experience?");
    private ComboBox<String> fosterExperienceCB = new ComboBox<>();
    private Label fosterExperienceErr = new Label("Experience choice required");
    private String fosterExperienceString;
 */

    public FosterVolunteerScene() {

        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();
        pane.setVisible(true);
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));
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
        //volunteerAvailabilityCB.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> changeVolunteerTypeTF(newVal));
        pane.add(volunteerAvailabilityCB, 1, AVAILABILITY_ROW);
        volunteerAvailabilityCB.getSelectionModel().select(0);

        pane.add(volunteerAvailabilityErr, 2, AVAILABILITY_ROW);
        volunteerAvailabilityErr.setVisible(false);


        pane.add(experienceLabel, 0, EXPERIENCE_ROW);
        experienceCB.getItems().addAll(EXPERIENCE_CHOICES);
        experienceCB.getSelectionModel().selectedItemProperty().addListener
                ((obsVal, oldVal, newVal) -> animalSelected(newVal));
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
        housingErrLabel.setVisible(false);
        housingErrLabel.setTextFill(Color.RED);

        pane.add(transportationLabel, 0, TRANSPORTATION_ROW);
        transportationCB.getItems().addAll(TRANSPORTATION_CHOICES);
        transportationCB.getSelectionModel().selectedItemProperty().addListener
                ((obsVal, oldVal, newVal) -> transportationSelect(newVal));
        transportationCB.getSelectionModel().select(0);
        pane.add(transportationCB, 1, TRANSPORTATION_ROW);
        transportationErrLabel.setVisible(false);
        transportationErrLabel.setTextFill(Color.RED);


        pane.add(resetButton, 0, RESET_SUBMIT_ROW);
        resetButton.setOnAction(e -> reset());

        pane.add(submitButton, 4, RESET_SUBMIT_ROW);
        submitButton.setOnAction(e -> addFosterVolunteer());

        this.setRoot(pane);
    }

    private void transportationSelect(String newVal) {

        if (newVal.equalsIgnoreCase("yes"))
            transportationCheck = true;
        else
            transportationCheck = false;
    }

    private void housingSelect(String newVal) {
        housingSelected = newVal;
    }

    private void endDateSelect(String newVal) {
        endDateSelected = newVal;
    }

    private void startDateSelect(String newVal) {
        startDateSelected = newVal;
    }

    private void animalSelected(String newVal){
        animalSelected = newVal;
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

    private void addFosterVolunteer(){

        int age = 0;
        String firstName = firstNameTF.getText();
        firstNameErrLabel.setVisible(firstName.isEmpty());

        String lastName = lastNameTF.getText();
        lastNameErrLabel.setVisible(lastName.isEmpty());
        //String ageErrorCheck = ageTF.getText();
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

        //ageErrorLabel.setVisible(ageErrorCheck.isEmpty());
        String reason = reasonTF.getText();
        reasonErrorLabel.setVisible(reason.isEmpty());
        String animalType = animalSelected;
        animalTypeErr.setVisible(animalType.isEmpty());
        String startDate = startDateSelected;
        fosterStartErr.setVisible(startDate.isEmpty());
        String endDate = endDateSelected;
        fosterEndErr.setVisible(endDate.isEmpty());
        if(firstNameErrLabel.isVisible() || lastNameErrLabel.isVisible() || ageVerifyErrLabel.isVisible() || ageErrorLabel.isVisible() ||
                reasonErrorLabel.isVisible() || animalTypeErr.isVisible() || animalTypeErr.isVisible() ||
                fosterStartErr.isVisible() || fosterEndErr.isVisible())
            return;
        else
        {
            ageVerifyErrLabel.setVisible(false);
            ageErrorLabel.setVisible(false);
        }
        //Todo: add controller to volunteer List
        //volunteersList.add(new FosterVolunteer(name, age, reason, animalType, startDate, endDate));

        //Todo: ListView from volunteer list, from controller, CREATE!!!!!!!!!!
        //volunteerListView.refresh();
    }
}
