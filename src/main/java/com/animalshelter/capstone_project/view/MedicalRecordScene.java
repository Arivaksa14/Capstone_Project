package com.animalshelter.capstone_project.view;

import com.animalshelter.capstone_project.model.Animal;
import com.animalshelter.capstone_project.model.MedicalRecord;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MedicalRecordScene extends Scene {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 900;

    private ImageView medicalRecordImage = new ImageView();

    private ListView<MedicalRecord> medicalRecordListView = new ListView<>();
    private ObservableList<MedicalRecord> medicalRecordList;
    private MedicalRecord selectedMedicalRecord;

    private Button resetButton = new Button("Reset");
    private Button addButton = new Button("Add Medical Record");
    private Button removeButton = new Button("Remove Medical Record");
    private Button returnButton = new Button("Return to Main Page");

    private Label animalNameLabel = new Label("Pet's Name");
    private TextField animalNameTF = new TextField();
    private Label animalNameErrLabel = new Label("Name is required.");

    private Label animalTypeLabel = new Label("Type of Pet");
    private ComboBox<String> animalTypeCB = new ComboBox<>();
    private Label animalTypeErrLabel = new Label("Type of pet is required.");

    private ComboBox<String> animalGenderCB = new ComboBox<>();
    private Label animalGenderErrLabel = new Label("Pet Gender is required.");

    private ComboBox<String> animalAgeCatCB = new ComboBox<>();
    private Label animalAgeErrLabel = new Label("Pet Age Category is required.");

    private ComboBox<String> declawedCB = new ComboBox<>();
    private Label declawedErrLabel = new Label("This field is required.");

    private TextField healthIssuesTF = new TextField();
    private Label healthIssuesErrLabel = new Label("Health Issues field is required. Put None, if no issues.");

    private ComboBox<String> spayedOrNeuteredCB = new ComboBox<>();
    private Label spayedOrNeuteredErrLabel = new Label("This field is required.");

    private ComboBox<String> vaccinatedCB = new ComboBox<>();
    private Label vaccinatedErrLabel = new Label("This field is required.");


    //TODO: complete once controller is set up with rest of class
    //private Controller controller = Controller.getInstance();

    public MedicalRecordScene(){
        super(new GridPane(), WIDTH, HEIGHT);

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        medicalRecordImage.setImage(new Image("medicalRecord.jpg"));
        medicalRecordImage.setFitWidth(WIDTH);
        medicalRecordImage.setFitHeight(300);

        pane.add(medicalRecordImage, 0, 0, 3, 1);

        pane.add(animalNameLabel, 0, 1);
        pane.add(animalNameTF, 1, 1);
        pane.add(animalNameErrLabel, 2, 1);
        animalNameErrLabel.setTextFill(Color.RED);
        animalNameErrLabel.setVisible(false);

        pane.add(animalTypeLabel, 0, 2);
        pane.add(animalTypeCB, 1, 2);
        pane.add(animalTypeErrLabel, 2, 2);
        animalTypeCB.getItems().addAll("Cat", "Dog");
        animalNameErrLabel.setTextFill(Color.RED);
        animalNameErrLabel.setVisible(false);
        //optional:
        //animalTypeCB.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) ->changeNameLabel(newVal));

        pane.add( new Label("Gender of pet"), 0, 3);
        pane.add(animalGenderCB, 1, 3);
        animalGenderCB.getItems().addAll("F","M");
        pane.add(animalGenderErrLabel, 2, 3);
        animalGenderErrLabel.setTextFill(Color.RED);
        animalGenderErrLabel.setVisible(false);

        pane.add(new Label("Pet age category"), 0, 4);
        pane.add(animalAgeCatCB, 1, 4);
        animalAgeCatCB.getItems().addAll("Puppy", "Adult");
        pane.add(animalAgeErrLabel, 2, 4);
        animalAgeErrLabel.setTextFill(Color.RED);
        animalAgeErrLabel.setVisible(false);

        pane.add(new Label("Declawed"), 0, 5);
        pane.add(declawedCB, 1, 5);
        declawedCB.getItems().addAll("Yes", "No");
        pane.add(declawedErrLabel, 2, 5);
        declawedErrLabel.setTextFill(Color.RED);
        declawedErrLabel.setVisible(false);

        pane.add(new Label("Health Issues"), 0, 6);
        pane.add(healthIssuesTF, 1, 6);
        pane.add(healthIssuesErrLabel, 2, 6);
        healthIssuesErrLabel.setTextFill(Color.RED);
        healthIssuesErrLabel.setVisible(false);

        pane.add(new Label("Spayed/Neutered"), 0, 7);
        pane.add(spayedOrNeuteredCB, 1, 7);
        spayedOrNeuteredCB.getItems().addAll("Yes","No");
        pane.add(spayedOrNeuteredErrLabel, 2, 7);
        spayedOrNeuteredErrLabel.setTextFill(Color.RED);
        spayedOrNeuteredErrLabel.setVisible(false);

        pane.add(new Label("Vaccinated"), 0, 8);
        pane.add(vaccinatedCB, 1, 8);
        vaccinatedCB.getItems().addAll("Yes","No");
        pane.add(vaccinatedErrLabel, 2, 8);
        vaccinatedErrLabel.setTextFill(Color.RED);
        vaccinatedErrLabel.setVisible(false);


        //Wire up the addButton to addLaureate method:
        addButton.setOnAction(actionEvent -> addMedicalRecord());

        pane.add(addButton, 1, 17);
        medicalRecordListView.setPrefWidth(WIDTH);
        pane.add(medicalRecordListView, 0, 18, 3, 1);

        pane.add(removeButton, 0, 19);
        removeButton.setOnAction(e -> removeMedicalRecord());

        pane.add(resetButton, 1, 19);
        resetButton.setOnAction(e -> reset());

        pane.add(returnButton, 2, 19);
        returnButton.setOnAction(e -> ViewNavigator.loadScene( "Animal Shelter Application", new MainScene()));

        // animalList = controller.getAllAnimals();
        medicalRecordListView.setItems(medicalRecordList);

        medicalRecordListView.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> selectedMedicalRecord(newVal));
        removeButton.setDisable(true);
        this.setRoot(pane);

    }

    private void reset() {
        animalNameTF.clear();
        animalTypeCB.getSelectionModel().select(-1);
        animalGenderCB.getSelectionModel().select(-1);
        animalAgeCatCB.getSelectionModel().select(-1);;
        declawedCB.getSelectionModel().select(-1);;
        healthIssuesTF.clear();
        spayedOrNeuteredCB.getSelectionModel().select(-1);;
        vaccinatedCB.getSelectionModel().select(-1);;
        animalNameTF.requestFocus();
    }

    private void selectedMedicalRecord(MedicalRecord newVal) {
        selectedMedicalRecord = newVal;
        removeButton.setDisable(selectedMedicalRecord ==null);
    }

    private void removeMedicalRecord() {
        medicalRecordList.remove(selectedMedicalRecord);
        medicalRecordListView.refresh();
        medicalRecordListView.getSelectionModel().select(-1);
    }

    //Ask: how to deal with error messages for required fields of Combo Boxes? Tried getSelectionModel().getSelectedItem().isEmpty
    //and getItems().isEmpty(). Does not work
    private void addMedicalRecord() {
        //read from all text fields:
        String  animalName = animalNameTF.getText();
        if(animalName.isEmpty())
            animalNameErrLabel.setVisible(true);

        String animalType = animalTypeCB.getSelectionModel().getSelectedItem();
        // if(animalTypeCB.getItems().isEmpty())
        //animalTypeErrLabel.setVisible(true);

        char animalGender = animalGenderCB.getSelectionModel().getSelectedItem().charAt(0);

        String animalAgeCat = animalAgeCatCB.getSelectionModel().getSelectedItem();
        if(animalAgeCatCB.getItems().isEmpty())
            animalAgeErrLabel.setVisible(true);

        String declawed = declawedCB.getSelectionModel().getSelectedItem();

        String healthIssues = healthIssuesTF.getText();

        String spayedOrNeutered = spayedOrNeuteredCB.getSelectionModel().getSelectedItem();

        String vaccinated = vaccinatedCB.getSelectionModel().getSelectedItem();

        medicalRecordList.add(0, new MedicalRecord(animalName, animalType, animalGender, animalAgeCat, declawed, healthIssues, spayedOrNeutered, vaccinated));

        // Now update the list view with a new animal
        medicalRecordListView.refresh();

    }

}


