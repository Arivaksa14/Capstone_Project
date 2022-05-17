package com.animalshelter.capstone_project.view;

import com.animalshelter.capstone_project.controller.Controller;
import com.animalshelter.capstone_project.model.Animal;
import com.animalshelter.capstone_project.model.CatDog;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


public class AnimalRegistryScene extends Scene {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 900;

    private ImageView animalsImage = new ImageView();

    private ListView<CatDog> animalListView = new ListView<>();
    private ObservableList<CatDog> animalList;
    private CatDog selectedAnimal;

    private Button resetButton = new Button("Reset");
    private Button applyButton = new Button("Add pet");
    private Button removeButton = new Button("Remove pet");
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

    private ComboBox<String> indoorOrOutdoorCB = new ComboBox<>();
    private Label indoorOrOutdoorErrLabel = new Label("This Field is required.");

    private ComboBox<String> trainedCB = new ComboBox<>();
    private Label trainedErrLabel = new Label("This Field is required.");

    private ComboBox<String> goodWithOtherAnimalsCB = new ComboBox<>();
    private Label goodWithOtherAnimalsErrLabel = new Label("This Field is required.");

    private ComboBox<String> activeCB = new ComboBox<>();
    private Label activeErrLabel = new Label("This Field is required.");

    //TODO: complete once controller is set up with rest of class
    private Controller controller = Controller.getInstance();

    public AnimalRegistryScene(){
        super(new GridPane(), WIDTH, HEIGHT);

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        animalsImage.setImage(new Image("catDog.jpg"));
        animalsImage.setFitWidth(WIDTH);
        animalsImage.setFitHeight(300);

        pane.add(animalsImage, 0, 0, 3, 1);

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

        pane.add(new Label("Indoor or Outdoor Animal"), 0, 5);
        pane.add(indoorOrOutdoorCB, 1, 5);
        indoorOrOutdoorCB.getItems().addAll("Indoor", "Outdoor");
        pane.add(indoorOrOutdoorErrLabel, 2, 5);
        indoorOrOutdoorErrLabel.setTextFill(Color.RED);
        indoorOrOutdoorErrLabel.setVisible(false);

        pane.add(new Label("Trained?"), 0, 6);
        pane.add(trainedCB, 1, 6);
        trainedCB.getItems().addAll("Yes","No");
        pane.add(trainedErrLabel, 2, 6);
        trainedErrLabel.setTextFill(Color.RED);
        trainedErrLabel.setVisible(false);

        pane.add(new Label("Good with other animals?"), 0, 7);
        pane.add(goodWithOtherAnimalsCB, 1, 7);
        goodWithOtherAnimalsCB.getItems().addAll("Yes","No");
        pane.add(goodWithOtherAnimalsErrLabel, 2, 7);
        goodWithOtherAnimalsErrLabel.setTextFill(Color.RED);
        goodWithOtherAnimalsErrLabel.setVisible(false);

        pane.add(new Label("Active?"), 0, 8);
        pane.add(activeCB, 1, 8);
        activeCB.getItems().addAll("Yes","No");
        pane.add(activeErrLabel, 2, 8);
        activeErrLabel.setTextFill(Color.RED);
        activeErrLabel.setVisible(false);


        //Wire up the addButton to addLaureate method:
        applyButton.setOnAction(actionEvent -> addAnimal());

        pane.add(applyButton, 1, 17);
        animalListView.setPrefWidth(WIDTH);
        pane.add(animalListView, 0, 18, 3, 1);
        pane.add(removeButton, 0, 19);

        removeButton.setOnAction(e -> removeAnimal());

        pane.add(returnButton, 2, 19);
        returnButton.setOnAction(e -> ViewNavigator.loadScene( "Animal Shelter Application", new MainScene()));

        animalList = controller.getAllAnimals();
        animalListView.setItems(animalList);

        //Wire up an event for the animalLV
        animalListView.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> selectedAnimal(newVal));
        removeButton.setDisable(true);
        this.setRoot(pane);

        pane.add(resetButton, 1, 19);
        resetButton.setOnAction(e -> reset());
    }

    private void reset() {
        animalNameTF.clear();
        animalTypeCB.getSelectionModel().select(-1);
        animalGenderCB.getSelectionModel().select(-1);
        animalAgeCatCB.getSelectionModel().select(-1);;
        indoorOrOutdoorCB.getSelectionModel().select(-1);;
        trainedCB.getSelectionModel().select(-1);;
        goodWithOtherAnimalsCB.getSelectionModel().select(-1);;
        activeCB.getSelectionModel().select(-1);;
        animalNameTF.requestFocus();
    }

    private void selectedAnimal(CatDog newVal) {
        selectedAnimal = newVal;
        removeButton.setDisable(selectedAnimal ==null);
    }

    private void removeAnimal() {
        animalList.remove(selectedAnimal);
        animalListView.refresh();
        animalListView.getSelectionModel().select(-1);
    }

    //Ask: how to deal with error messages for required fields of Combo Boxes? Tried getSelectionModel().getSelectedItem().isEmpty
    //and getItems().isEmpty(). Does not work
    private void addAnimal() {
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

        String indoorOrOutdoor = indoorOrOutdoorCB.getSelectionModel().getSelectedItem();

        String trained = trainedCB.getSelectionModel().getSelectedItem();

        String goodWithOtherAnimals = goodWithOtherAnimalsCB.getSelectionModel().getSelectedItem();

        String active = activeCB.getSelectionModel().getSelectedItem();

        animalList.add(0, new CatDog(animalName, animalType, animalGender, animalAgeCat, indoorOrOutdoor, trained, goodWithOtherAnimals, active));

        // Now update the list view with a new animal
        animalListView.refresh();

    }

}
