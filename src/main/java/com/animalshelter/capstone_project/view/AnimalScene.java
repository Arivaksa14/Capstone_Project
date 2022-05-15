package com.animalshelter.capstone_project.view;

import com.animalshelter.capstone_project.model.Animal;
import com.animalshelter.capstone_project.model.Cat;
import com.animalshelter.capstone_project.model.Dog;
import com.animalshelter.capstone_project.model.SmallAnimal;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

// TODO: 5/14/22 configure all Comboboxes, textfields. Adjust csv file to fit the variables, change variables in Animal class.
public class AnimalScene extends Scene {
    public static final int WIDTH = 900;
    public static final int HEIGHT = 900;

    private ImageView animalsImage = new ImageView();

    private ListView<Animal> applicantListView = new ListView<>();
    private ObservableList<Animal> applicantList;
    private Animal selectedApplicant;

    private Button resetButton = new Button("Reset Application");
    private Button applyButton = new Button("Apply for Adoption");
    private Button removeButton = new Button("Remove Applicant");

    private Label applicantNameLabel = new Label("Applicant's Name");
    private TextField applicantNameTF = new TextField();
    private Label applicantNameErrLabel = new Label("Name is required.");

    private Label animalTypeLabel = new Label("Type of Pet to Adopt");
    private ComboBox<String> animalTypeCB = new ComboBox<>();
    private Label animalTypeErrLabel = new Label("Type of pet is required.");

    //private Label householdSizeLabel = new Label("Household size");
    private TextField householdSizeTF = new TextField();

    //private Label petGenderLabel = new Label("Gender of pet");
    private ComboBox<String> petGenderCB = new ComboBox<>();

    //private Label petAgeLabel = new Label("Pet age category");
    private ComboBox<String> petAgeCB = new ComboBox<>();

    //private Label notGoodWithOtherAnimalsOkLabel = new Label("Ok if not good with other animals?");
    private ComboBox<String> notGoodWithOtherAnimalsOkCB = new ComboBox<>();

    //private Label activeLabel = new Label("Energy level");
    private ComboBox<String> activeCB = new ComboBox<>();

    private Label healthIssuesLabel = new Label("Health Issues ok?");
    private ComboBox<String> healthIssuesCB = new ComboBox<>();

    private Label reasonLabel = new Label("Reason for adoption");
    private TextField reasonTF = new TextField();

    //The idea is to activate these fields only based on pet type:
    //Dog:
    private Label spayedOrNeuteredLabel = new Label("Spayed/Neutered?");
    private ComboBox<String> spayedOrNeuteredCB = new ComboBox<>();
    private Label trainedLabel = new Label("Declawed or not?");
    private ComboBox<String> trainedCB = new ComboBox<>();

    //Cat:
    private Label indoorOrOutdoorLabel = new Label("Indoor or Outdoor Cat");
    private TextField indoorOrOutdoorTF = new TextField();
    private Label declawedLabel = new Label("Declawed or not?");
    private ComboBox<String> declawedCB = new ComboBox<>();

    //Small animals:
    private Label messyLabel = new Label("Messy or not?");
    private ComboBox<String> messyCB = new ComboBox<>();
    private Label lifespanLabel = new Label("Desired lifespan");
    private TextField lifespanTF = new TextField();

    //TODO: complete once controller is set up with rest of class
    //private Controller controller = Controller.getInstance();

    public AnimalScene (){
        super(new GridPane(), WIDTH, HEIGHT);

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        animalsImage.setImage(new Image("adoptapet.jpg"));
        animalsImage.setFitWidth(WIDTH);
        pane.add(animalsImage, 0, 0, 3, 1);

        pane.add(applicantNameLabel, 0, 1);
        pane.add(applicantNameTF, 1, 1);
        pane.add(applicantNameErrLabel, 2, 1);
        applicantNameErrLabel.setTextFill(Color.RED);
        applicantNameErrLabel.setVisible(false);

        pane.add(animalTypeLabel, 0, 2);
        pane.add(animalTypeCB, 1, 2);
        pane.add(animalTypeErrLabel, 2, 1);
        applicantNameErrLabel.setTextFill(Color.RED);
        applicantNameErrLabel.setVisible(false);
        animalTypeCB.getItems().addAll("Dogs", "Cats", "Small Animal"); // hamsters, bunnies, parrots
        animalTypeCB.getSelectionModel().select(0);
        //optional:
        //animalTypeCB.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) ->changeNameLabel(newVal));

        pane.add(new Label("Household size"), 0, 3);
        pane.add(householdSizeTF, 1, 3);
//        pane.add(householdSizeErrLabel, 2, 3);
//        householdSizeErrLabel.setTextFill(Color.RED);
//        householdSizeErrLabel.setVisible(false);

        pane.add( new Label("Gender of pet"), 0, 4);
        pane.add(petGenderCB, 1, 4);
        petGenderCB.getItems().addAll("F","M");
//        pane.add(petGenderErrLabel, 2, 4);
//        petGenderErrLabel.setTextFill(Color.RED);
//        petGenderErrLabel.setVisible(false);

        pane.add(new Label("Pet age category"), 0, 5);
        pane.add(petGenderCB, 1, 5);
        petGenderCB.getItems().addAll("Puppy", "Adult");
//        pane.add(petAgeErrLabel, 2, 5);
//        petAgeErrLabel.setTextFill(Color.RED);
//        petAgeErrLabel.setVisible(false);

        pane.add(new Label("Ok if not good with other animals?"), 0, 6);
        pane.add(notGoodWithOtherAnimalsOkCB, 1, 6);
        petGenderCB.getItems().addAll("Yes","No");
//        pane.add(notGoodWithOtherAnimalsOkErrLabel, 2, 6);
//        notGoodWithOtherAnimalsOkErrLabel.setTextFill(Color.RED);
//        notGoodWithOtherAnimalsOkErrLabel.setVisible(false);


        pane.add(new Label("Energy level"), 0, 7);
        pane.add(activeCB, 1, 7);
        activeCB.getItems().addAll("Yes","No");
//        pane.add(activeErrLabel, 2, 7);
//        activeErrLabel.setTextFill(Color.RED);
//        activeErrLabel.setVisible(false);

        pane.add(new Label("Health Issues ok?"), 0, 8);
        pane.add(healthIssuesCB, 1, 8);
        healthIssuesCB.getItems().addAll("Yes","No");
//        pane.add(healthIssuesErrLabel, 2, 6);
//        healthIssuesErrLabel.setTextFill(Color.RED);
//        healthIssuesErrLabel.setVisible(false);

        pane.add(new Label("Reason for adoption"), 0, 9);
        pane.add(reasonTF, 1, 9);
//        pane.add(householdSizeErrLabel, 2, 9);
//        householdSizeErrLabel.setTextFill(Color.RED);
//        householdSizeErrLabel.setVisible(false);


        //The idea is to activate these fields only based on pet type:

        //check if buttons appear properly
        //Dog:
        pane.add(spayedOrNeuteredLabel, 0, 10);
        pane.add(spayedOrNeuteredCB, 1, 10);
        spayedOrNeuteredCB.getItems().addAll("Yes","No");

        pane.add(trainedLabel, 0, 11);
        pane.add(trainedCB, 1, 11);
        trainedCB.getItems().addAll("Yes","No");

        if(petAgeCB.getItems().contains("Dog")) {
            spayedOrNeuteredCB.setVisible(true);
            spayedOrNeuteredCB.setDisable(false);
            trainedCB.setVisible(true);
            trainedCB.setDisable(false);
        }

        //Cat:
        pane.add(indoorOrOutdoorLabel, 0, 12);
        pane.add(indoorOrOutdoorTF, 1, 12);

        pane.add(declawedLabel, 0, 13);
        pane.add(declawedCB, 1, 13);
        trainedCB.getItems().addAll("Yes","No");

        if(petAgeCB.getItems().contains("Cat")) {
            indoorOrOutdoorTF.setVisible(true);
            indoorOrOutdoorTF.setDisable(false);
            declawedCB.setVisible(true);
            declawedCB.setDisable(false);
        }

        //Small animals:
        pane.add(messyLabel, 0, 14);
        pane.add(messyCB, 1, 14);
        messyCB.getItems().addAll("Yes","No");

        pane.add(lifespanLabel, 0, 15);
        pane.add(lifespanTF, 1, 15);

        if(petAgeCB.getItems().contains("Small Animal")) {
            messyCB.setVisible(true);
            messyCB.setDisable(false);
            lifespanTF.setVisible(true);
            lifespanTF.setDisable(false);
        }

        //Wire up the addButton to addLaureate method:
        applyButton.setOnAction(actionEvent -> addApplicant());

        pane.add(applyButton, 1, 17);
        applicantListView.setPrefWidth(WIDTH);
        pane.add(applicantListView, 0, 18, 3, 1);
        pane.add(removeButton, 0, 19);

        removeButton.setOnAction(e -> removeApplicant());

       // applicantList = controller.getAllApplicants();
        applicantListView.setItems(applicantList);

        //Wire up an event for the laureatesLV
        applicantListView.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> selectedApplicant(newVal));
        removeButton.setDisable(true);
        this.setRoot(pane);

        // TODO: 5/15/22 reset and apply buttons:


    }

    private void selectedApplicant(Animal newVal) {
        selectedApplicant = newVal;
        removeButton.setDisable(selectedApplicant ==null);
    }

    private void removeApplicant() {
        //remove an applicant from ObservableList, update (refresh) the list view:
        applicantList.remove(selectedApplicant);
        applicantListView.refresh();
        applicantListView.getSelectionModel().select(-1);
    }

    private void addApplicant() {
        //read from all text fields:
        String  applicantName = applicantNameTF.getText();
        if(applicantName.isEmpty())
            applicantNameErrLabel.setVisible(true);

        String animalType = animalTypeCB.getSelectionModel().getSelectedItem();
        if(animalType.isEmpty())
            animalTypeErrLabel.setVisible(true);

        int householdSize = Integer.parseInt(householdSizeTF.getText());

        char petGender = petGenderCB.getSelectionModel().getSelectedItem().charAt(0);

        String petAgeCat = petAgeCB.getSelectionModel().getSelectedItem();

        String goodWithOtherAnimals = notGoodWithOtherAnimalsOkCB.getSelectionModel().getSelectedItem();

        String active = activeCB.getSelectionModel().getSelectedItem();

        String healthIssues = healthIssuesCB.getSelectionModel().getSelectedItem();

        String reason = reasonTF.getText();

        //Dog
        if(animalType.equals("Dog")) {
        String spayedOrNeutered = spayedOrNeuteredCB.getSelectionModel().getSelectedItem();
        String trained = trainedCB.getSelectionModel().getSelectedItem();
        applicantList.add(0, new Dog(applicantName, householdSize, animalType, petGender, petAgeCat,goodWithOtherAnimals, active, healthIssues, reason, spayedOrNeutered, trained));
        }

        //Cat
        else if(animalType.equals("Cat")) {
        String indoorOrOutdoor = indoorOrOutdoorTF.getText();
        String declawed = declawedCB.getSelectionModel().getSelectedItem();
        applicantList.add(0, new Cat(applicantName, householdSize, animalType, petGender, petAgeCat,goodWithOtherAnimals, active, healthIssues, reason, indoorOrOutdoor, declawed));
        }

        //Small Animal
        else{
        String messy = messyCB.getSelectionModel().getSelectedItem();
        int lifespan = Integer.parseInt(lifespanTF.getText());
        applicantList.add(0, new SmallAnimal(applicantName, householdSize, animalType, petGender, petAgeCat,goodWithOtherAnimals, active, healthIssues, reason, messy, lifespan));
        }

        // Now update the list view with a new applicant
        applicantListView.refresh();

    }

}
