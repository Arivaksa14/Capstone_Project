package com.animalshelter.capstone_project.view;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * The <code>MainScene</code> represents the very first scene for the application.

 * The <code>MainScene</code> also allows for a user to add a new laureate or remove existing entries.
 */
public class MainScene extends Scene {
    //ZC: updated from int to double to allow calculations
    public static final double WIDTH = 1000;
    public static final double HEIGHT = 600;

    private ImageView mainAppImage = new ImageView();
    private Button volunteerButton = new Button("Volunteer");
    private Button adoptButton = new Button("New Pet");
    private Button inventoryButton = new Button("Manage Inventory");

    /**
     * Constructs a new <code>MainScene</code>, representing the very first scene for the Animal Shelter application.
     */
    public MainScene() {
        super(new GridPane(), WIDTH, HEIGHT);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);

        mainAppImage.setImage(new Image("adoptapet.jpg"));
        mainAppImage.setFitWidth(WIDTH);
        mainAppImage.setFitHeight(WIDTH/1373*447);
        pane.add(mainAppImage, 0, 0, 3, 1);

        volunteerButton.setOnAction(e -> ViewNavigator.loadScene("Welcome Volunteer!", new VolunteerScene()));
        adoptButton.setOnAction(e -> ViewNavigator.loadScene("New Pet", new NewAnimalScene()));
        inventoryButton.setOnAction(e -> ViewNavigator.loadScene("Manage Inventory", new InventoryScene()));

        HBox hBox = new HBox(volunteerButton, adoptButton, inventoryButton);
        hBox.setSpacing(15); // Space between buttons
        hBox.setPadding(new Insets(10)); // Space around the buttons
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        pane.add(hBox,0,1);

        this.setRoot(pane);
   }

    /**
     * Updates the display after adding/modifying.
     */
    private void updateDisplay()
    {}

}