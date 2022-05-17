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
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        // TODO: Uncomment after configuring res folder
        mainAppImage.setImage(new Image("adoptapet.jpg"));
        //ZC: image size: 1373 x 447
        //ZC: below set image height is calculated to lock the ratio.
        mainAppImage.setFitWidth(WIDTH);
        mainAppImage.setFitHeight(WIDTH/1373*447);
        pane.add(mainAppImage, 0, 0, 3, 1);

        HBox hBox = new HBox(volunteerButton, adoptButton, inventoryButton);
        hBox.setSpacing(5);
        hBox.setAlignment(Pos.BASELINE_RIGHT);
        pane.add(hBox,1,4);

        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);

        volunteerButton.setOnAction(e -> ViewNavigator.loadScene("Welcome Volunteer!", new VolunteerScene()));
        adoptButton.setOnAction(e -> ViewNavigator.loadScene("New Pet", new NewAnimalScene()));
        inventoryButton.setOnAction(e -> ViewNavigator.loadScene("Manage Inventory", new InventoryScene()));

        pane.add(volunteerButton, 0, 6);
        pane.add(adoptButton, 1, 6);
        pane.add(inventoryButton, 2, 6);
        this.setRoot(pane);
   }

    /**
     * Updates the display after adding/modifying.
     */
    private void updateDisplay()
    {}

}