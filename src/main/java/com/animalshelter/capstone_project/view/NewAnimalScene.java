package com.animalshelter.capstone_project.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class NewAnimalScene extends Scene {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    private ComboBox<String> registryTypeCB = new ComboBox<>();
    private Button goButton = new Button("Go");

    public NewAnimalScene() {
        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));
        pane.setAlignment(Pos.CENTER);
        pane.add(new Label("Registry Type:"), 0, 1);
        pane.add(registryTypeCB, 1, 1);
        registryTypeCB.getItems().addAll("Enter a New Animal Record","Enter a New Medical Record");
        pane.add(goButton,1,2);
        registryTypeCB.getSelectionModel().select(0);
        if(registryTypeCB.getSelectionModel().getSelectedItem().equals("Enter a New Animal Record")) {

            goButton.setOnAction(e -> ViewNavigator.loadScene("Enter a New Pet", new AnimalRegistryScene()));
        }
//        if(registryTypeCB.getSelectionModel().getSelectedItem().equals("Enter a New Medical Record")) {
//            registryTypeCB.getSelectionModel().select(1);
//            goButton.setOnAction(e -> ViewNavigator.loadScene("New Medical Record", new MedicalRecordScene()));
//        }
        this.setRoot(pane);
    }
}
