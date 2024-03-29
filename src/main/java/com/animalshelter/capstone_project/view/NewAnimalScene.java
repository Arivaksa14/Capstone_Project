package com.animalshelter.capstone_project.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.util.Objects;


public class NewAnimalScene extends Scene {

    private ImageView animalsImage = new ImageView();
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    private ComboBox<String> registryTypeCB = new ComboBox<>();
    private Button goButton = new Button("Go");

    public NewAnimalScene() {
        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));
        pane.setAlignment(Pos.CENTER);

        animalsImage.setImage(new Image("AnimalKingdom.jpg"));
        animalsImage.setFitWidth(WIDTH);
        animalsImage.setFitHeight(HEIGHT);

        pane.add(animalsImage, 0, 0, 5, 5);


        pane.add(new Label("Registry Type:"), 0, 1);
        pane.add(registryTypeCB, 1, 1);
        registryTypeCB.getItems().addAll("Enter a New Animal Record","Enter a New Medical Record");
        goButton.setPrefSize(50,50);
        pane.add(goButton,1,2);
        // Button wiring to "get" the selected item, without adding listener to the selection
        goButton.setOnAction(e -> ViewNavigator.loadScene("Enter a New Record", manageNewRecord(registryTypeCB.getSelectionModel().getSelectedItem())));
        this.setRoot(pane);

    }
    // Helper method to decide which scene to use
    public Scene manageNewRecord(String s){
        if (Objects.equals(s, "Enter a New Animal Record")) return new AnimalRegistryScene();
        else return new MedicalRecordScene();
    }
}
