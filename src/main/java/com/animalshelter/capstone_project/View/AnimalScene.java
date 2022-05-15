package com.animalshelter.capstone_project.View;

import com.animalshelter.capstone_project.Model.Volunteer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

// TODO: 5/14/22 configure all Comboboxes, textfields. Adjust csv file to fit the variables, change variables in Animal class.
public class AnimalScene extends Scene {
    public static final int WIDTH = 900;
    public static final int HEIGHT = 900;

    private ImageView animalsImage = new ImageView();

    private ListView<Volunteer> animalListView = new ListView<>();

    private Button resetButton = new Button("Reset Application");
    private Button applyButton = new Button("Apply for Adoption");

    private Label applicantNameLabel = new Label("Applicant's Name");
    private TextField applicantNameTF = new TextField();
    private Label applicantNameErrLabel = new Label("Name is required.");

    private Label animalTypeLabel = new Label("Type of Pet to Adopt");
    private ComboBox<String> animalTypeCB = new ComboBox<>();
    private Label animalTypeErrLabel = new Label("Type of pet is required.");

    private Label householdSizeLabel = new Label("Household size");
    private TextField householdSizeTF = new TextField();

    private Label petGenderLabel = new Label("Gender of pet");
    private ComboBox<String> petGenderCB = new ComboBox<>();

    private Label petAgeLabel = new Label("Pet age category");
    private ComboBox<String> petAgeCB = new ComboBox<>();

    private Label notGoodWithOtherAnimalsOkLabel = new Label("Ok if not good with other animals?");
    private ComboBox<String> notGoodWithOtherAnimalsOkCB = new ComboBox<>();

    private Label activeLabel = new Label("Energy level");
    private ComboBox<String> activeCB = new ComboBox<>();

    private Label healthIssuesLabel = new Label("Health Issues ok?");
    private ComboBox<String> healthIssuesCB = new ComboBox<>();

    private Label reasonLabel = new Label("Reason for adoption");
    private TextField reasonTF = new TextField();

    //The idea is to activate these fields only based on pet type:

    //Dog:
    private Label SpayedOrNeuteredLabel = new Label("Spayed/Neutered?");
    private ComboBox<String> SpayedOrNeuteredCB = new ComboBox<>();
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
    //private HelloController controller = HelloController.getInstance();

    public AnimalScene (){
        super(new GridPane(), WIDTH, HEIGHT);

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        animalsImage.setImage(new Image("adoptapet.png"));
        animalsImage.setFitWidth(WIDTH);
        pane.add(animalsImage, 0, 0, 3, 1);

        //check if buttons appear properly
        if(petAgeCB.getItems().contains("Dog")) {
            SpayedOrNeuteredCB.setVisible(true);
            SpayedOrNeuteredCB.setDisable(false);
            trainedCB.setVisible(true);
            trainedCB.setDisable(false);
        }
        if(petAgeCB.getItems().contains("Cat")) {
            indoorOrOutdoorTF.setVisible(true);
            indoorOrOutdoorTF.setDisable(false);
            declawedCB.setVisible(true);
            declawedCB.setDisable(false);
        }
        if(petAgeCB.getItems().contains("Small Animal")) {
            messyCB.setVisible(true);
            messyCB.setDisable(false);
            lifespanTF.setVisible(true);
            lifespanTF.setDisable(false);
        }

        animalTypeCB.getItems().addAll("Dogs", "Cats", "Small Animal"); // hamsters, bunnies, parrots

    }

}
