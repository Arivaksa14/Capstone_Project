package com.animalshelter.capstone_project.View;

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

/**
 * The <code>MainScene</code> represents the very first scene for the Nobel Peace Prize application.

 * The <code>MainScene</code> also allows for a user to add a new laureate or remove existing entries.
 */
public class MainScene extends Scene {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;

    //Can have ImageView, ComboBox<String>, TextField, Label, ListView(for display data), Button,

    private ImageView mainAppImage = new ImageView();
    private Button volunteerButton = new Button("Volunteer");
    private Button adoptButton = new Button("Adopt A Pet");
    private Button donateButton = new Button("Donate");


    /**
     * Constructs a new <code>MainScene</code>, representing the very first scene for the Animal Shelter application.
     */
    public MainScene() {
        super(new GridPane(), WIDTH, HEIGHT);

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        // TODO: Uncomment after configuring res folder
        mainAppImage.setImage(new Image("adoptapet.png"));
        mainAppImage.setFitWidth(WIDTH);
        pane.add(mainAppImage, 0, 0, 3, 1);

        HBox hBox = new HBox(volunteerButton, adoptButton, donateButton);
        hBox.setSpacing(5);
        hBox.setAlignment(Pos.BASELINE_RIGHT);
        pane.add(hBox,1,4);

        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);

        volunteerButton.setOnAction(e -> ViewNavigator.loadScene("Welcome Volunteer!", new VolunteerScene()));
        adoptButton.setOnAction(e -> ViewNavigator.loadScene("Adopt A Pet!", new AnimalScene()));
        //donateButton.setOnAction(e -> ViewNavigator.loadScene("Thank you for your donation!", new donationScene()));

   }

    /**
     * Updates the display after adding/modifying.
     */
    private void updateDisplay()
    {}

}