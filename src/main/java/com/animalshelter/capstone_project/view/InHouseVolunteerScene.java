package com.animalshelter.capstone_project.view;

import com.animalshelter.capstone_project.controller.Controller;
import com.animalshelter.capstone_project.controller.VolunteerController;
import com.animalshelter.capstone_project.model.InHouseVolunteer;
import com.animalshelter.capstone_project.model.Volunteer;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class InHouseVolunteerScene extends Scene {

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
    public static final int NICKNAME_ROW = 12;
    public static final int WALKING_ROW = 13;
    public static final int LOCATION_ROW = 14;
    public static final int DATE_ROW = 15;
    public static final int RESET_SUBMIT_ROW = 16;
    public static final int RETURN_ROW = 1;
    public static final int REMOVE_ROW = 16;
    public static final int SAVE_ROW = 1;
    public static final int EXIT_ROW = 19;

    public static final int WIDTH = 700;
    public static final int HEIGHT = 900;

    public static final String [] LOCATION_CHOICES = {"Bahde Wildlife Center", "Escondido",
                                            "Oceanside", "Ramona", "San Diego"};
    public static final String [] EXPERIENCE_CHOICES = {"None", "1 year", "2 years"};
    public static final String [] WALKING_CHOICES = {"No", "Yes"};

    private ListView<Volunteer> volunteerLV = new ListView<>();

    private Controller controller = Controller.getInstance();
    private ObservableList<Volunteer> volunteerList;
    private Volunteer selectedVolunteer;

    private ImageView inHouseVolunteerImage = new ImageView();

    private Button resetButton = new Button("Reset Choices");
    private Button addInHouseVolunteerButton = new Button("+ Volunteer");
    private Button removeButton = new Button("- Volunteer");
    private Button returnButton = new Button("Return to Main Page");
    private Button saveExitButton = new Button("Save & Exit");

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
    private Label reasonErrorLabel = new Label("Reason required");

    private Label animalTypeLabel = new Label("Volunteer Animal Category");
    private ComboBox<String> animalTypeCB = new ComboBox<>();
    private Label animalTypeErrLabel = new Label("Animal Selection required");
    private String animalSelected;

    private Label volunteerAvailabilityLabel = new Label("Volunteer Availability");
    private ComboBox<String> volunteerAvailabilityCB = new ComboBox<>();
    private Label availabilityErrLabel = new Label("Availability required");
    private String availabilitySelected;

    private Label experienceLabel = new Label("Volunteer Experience");
    private ComboBox<String> experienceCB = new ComboBox<>();
    private Label experienceErrLabel = new Label("Experience required");
    private String experienceSelected;

    private Label phoneNumberLabel = new Label("Volunteer Phone#");
    private TextField phoneNumberTF = new TextField();
    private Label phoneErrLabel = new Label("Phone# required");

    private Label nickNameLabel = new Label("Volunteer Nickname");
    private TextField nickNameTF = new TextField();
    private Label nickNameErrLabel = new Label("If no nickname, please enter N/A");

    private Label walkingLabel = new Label("Volunteer able to walk long distances?");
    private ComboBox<String> walkingCB = new ComboBox<>();
    private Label walkingErrLabel = new Label("Walking Choice Required");
    private boolean walkingSelected = false;

    private Label volunteerLocationLabel = new Label("Location Choice");
    private ComboBox<String> locationComboBox = new ComboBox<>();
    private Label volunteerLocationErrLabel = new Label("Location Required");
    private String locationSelected;

    private Label volunteerDateLabel = new Label("Date for volunteer");
    //private TextField volunteerDateTF = new TextField();
    private Label volunteerDateErrLabel = new Label("Date Required");
    private DatePicker datePicker = new DatePicker();
    private String dateSelected = "01/01/1999";


    public InHouseVolunteerScene(){

        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();
        pane.setVisible(true);
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        inHouseVolunteerImage.setImage(new Image("Volunteerpic3.png"));
        inHouseVolunteerImage.setFitWidth(WIDTH);
        pane.add(inHouseVolunteerImage, 0, 0, 3, 1);

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

        pane.add(emailLabel, 0, EMAIL_ROW);
        pane.add(emailTF, 1, EMAIL_ROW);
        pane.add(emailErrorLabel, 2, EMAIL_ROW);
        emailErrorLabel.setTextFill(Color.RED);
        emailErrorLabel.setVisible(false);

        pane.add(cityLabel, 0, CITY_ROW);
        pane.add(cityTF, 1, CITY_ROW);
        pane.add(cityErrLabel, 2, CITY_ROW);
        cityErrLabel.setTextFill(Color.RED);
        cityErrLabel.setVisible(false);

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
        animalTypeErrLabel.setVisible(false);
        animalTypeErrLabel.setTextFill(Color.RED);

        pane.add(volunteerAvailabilityLabel, 0, AVAILABILITY_ROW);
        volunteerAvailabilityCB.getItems().addAll( "Weekdays", "Weekends", "Flexible");
        volunteerAvailabilityCB.getSelectionModel().selectedItemProperty().addListener
                ((obsVal, oldVal, newVal) -> availabilitySelect(newVal));
        pane.add(volunteerAvailabilityCB, 1, AVAILABILITY_ROW);
        volunteerAvailabilityCB.getSelectionModel().select(0);

        pane.add(availabilityErrLabel, 2, AVAILABILITY_ROW);
        availabilityErrLabel.setVisible(false);


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
        phoneErrLabel.setTextFill(Color.RED);
        phoneErrLabel.setVisible(false);

        pane.add(nickNameLabel, 0, NICKNAME_ROW);
        pane.add(nickNameTF, 1, NICKNAME_ROW);
        pane.add(nickNameErrLabel, 2, NICKNAME_ROW);
        nickNameErrLabel.setTextFill(Color.RED);
        nickNameErrLabel.setVisible(false);

        pane.add(walkingLabel, 0, WALKING_ROW);
        walkingCB.getItems().addAll(WALKING_CHOICES);
        walkingCB.getSelectionModel().selectedItemProperty().addListener
                ((obsVal, oldVal, newVal) -> walkingSelect(newVal));
        walkingCB.getSelectionModel().select(0);
        pane.add(walkingCB, 1, WALKING_ROW);
        pane.add(walkingErrLabel, 2, WALKING_ROW);
        walkingErrLabel.setTextFill(Color.RED);
        walkingErrLabel.setVisible(false);

        pane.add(volunteerLocationLabel, 0, LOCATION_ROW);
        pane.add(locationComboBox, 1, LOCATION_ROW);
        locationComboBox.getItems().addAll(LOCATION_CHOICES);
        locationComboBox.getSelectionModel().selectedItemProperty().addListener
                ((obsVal, oldVal, newVal) -> locationSelected(newVal));
        locationComboBox.getSelectionModel().select(0);
        pane.add(volunteerLocationErrLabel, 2, LOCATION_ROW);
        volunteerLocationErrLabel.setTextFill(Color.RED);
        volunteerLocationErrLabel.setVisible(false);

        pane.add(volunteerDateLabel, 0, DATE_ROW);
        pane.add(datePicker, 1, DATE_ROW);
        pane.add(volunteerDateErrLabel, 2, DATE_ROW);
        volunteerDateErrLabel.setTextFill(Color.RED);
        volunteerDateErrLabel.setVisible(false);
        datePicker.valueProperty().addListener
                ((obsVal, oldVal, newVal) -> DateSelected(String.valueOf(newVal)));
        // TODO: COMPLETE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        volunteerList = controller.getAllVolunteers();
        volunteerLV.setItems(volunteerList);

        volunteerLV.setPrefWidth(WIDTH);
        pane.add(volunteerLV, 0, 20, 5, 1);
        volunteerLV.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> selectVolunteer(newVal));

        pane.add(returnButton, 0, RETURN_ROW);
        returnButton.setOnAction(e -> ViewNavigator.loadScene( "Animal Shelter Application", new MainScene()));

        pane.add(resetButton, 1, RESET_SUBMIT_ROW);
        resetButton.setOnAction(e -> reset());

        pane.add(addInHouseVolunteerButton, 4, RESET_SUBMIT_ROW);
        addInHouseVolunteerButton.setOnAction(e -> addInHouseVolunteer());

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

    private void removeVolunteer(){

        if(selectedVolunteer == null)
            return;
        volunteerList.remove(selectedVolunteer);
        volunteerLV.refresh();
        volunteerLV.getSelectionModel().select(-1);
    }

    private void addInHouseVolunteer() {

        int age = 0;
        Long phoneNumber = 0L;
        String phoneNumberFormatted = "";

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

        try{
            phoneNumber = Long.parseLong(phoneNumberTF.getText());
            phoneNumberFormatted = String.valueOf(phoneNumber).replaceFirst
                    ("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
            phoneErrLabel.setVisible(false);
        } catch (NumberFormatException e )
        { phoneErrLabel.setVisible(true); }


        String email = emailTF.getText();
        emailErrorLabel.setVisible(email.isEmpty());

        String city = cityTF.getText();
        cityErrLabel.setVisible(city.isEmpty());

        String reason = reasonTF.getText();
        reasonErrorLabel.setVisible(reason.isEmpty());

        String animalType = animalSelected;
        animalTypeErrLabel.setVisible(animalType.isEmpty());

        String availability = availabilitySelected;
        availabilityErrLabel.setVisible(availability.isEmpty());

        String experience = experienceSelected;
        experienceErrLabel.setVisible(experience.isEmpty());

        String location = locationSelected;
        volunteerLocationErrLabel.setVisible(location.isEmpty());

        String date = dateSelected.toString();
        volunteerDateErrLabel.setVisible(date.isEmpty());

        String nickName = nickNameTF.getText();
        nickNameErrLabel.setVisible(nickName.isEmpty());

        Boolean walking = walkingSelected;
        // error Label switch within walkingSelect method


        if(firstNameErrLabel.isVisible() || lastNameErrLabel.isVisible() || ageErrorLabel.isVisible() ||
                phoneErrLabel.isVisible() || emailErrorLabel.isVisible() || cityErrLabel.isVisible() ||
                reasonErrorLabel.isVisible() || animalTypeErrLabel.isVisible() || availabilityErrLabel.isVisible() ||
                experienceErrLabel.isVisible() || volunteerLocationErrLabel.isVisible() || volunteerDateErrLabel.isVisible() ||
                nickNameErrLabel.isVisible() || walkingErrLabel.isVisible()
        )
            return;
        else{
            ageVerifyErrLabel.setVisible(false);
            ageErrorLabel.setVisible(false);

            volunteerList.add(new InHouseVolunteer(firstName,lastName, age, phoneNumberFormatted,
                    email, city, reason, animalType, availability, experience, location, date, nickName, walking));
            volunteerLV.refresh();
        }
        //Todo: add controller to volunteer List
        //Todo: ListView from volunteer list, from controller, CREATE!!!!!!!!!!
        //volunteerListView.refresh();

    }

    private void reset() {
        firstNameTF.clear();
        lastNameTF.clear();
        emailTF.clear();
        cityTF.clear();
        reasonTF.clear();
        animalTypeCB.getSelectionModel().select(0);
        volunteerAvailabilityCB.getSelectionModel().select(0);
        locationComboBox.getSelectionModel().select(0);
        phoneNumberTF.clear();
    }

    private void animalSelected(String newVal){
        animalSelected = newVal;
    }

    private void experienceSelect(String newVal) {
        experienceSelected = newVal;
    }

    private void availabilitySelect(String newVal) {
        availabilitySelected = newVal;
    }

    private void walkingSelect(String newVal) {
        if (newVal.equalsIgnoreCase("yes"))
            walkingSelected = true;
        else
            walkingSelected = false;
    }

    private void DateSelected(String newVal) {
        if(newVal == null)
            return;
        dateSelected = newVal;
    }

    private void locationSelected(String newVal) {
        locationSelected = newVal;
    }

}
