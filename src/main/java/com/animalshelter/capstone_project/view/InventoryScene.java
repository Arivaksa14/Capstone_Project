package com.animalshelter.capstone_project.view;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class InventoryScene extends Scene {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    private ComboBox<String> supplyTypeCB = new ComboBox<>();
    private Button addButton = new Button("Manage");
    private Button returnButton = new Button("Return to Main Page");
    private ImageView foodOrToy = new ImageView();

    public InventoryScene() {
        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        pane.add(returnButton, 0, 0);
        returnButton.setOnAction(e -> ViewNavigator.loadScene( "Animal Shelter Application", new MainScene()));

        foodOrToy.setImage(new Image("HungryCat.jpg"));
        pane.add(foodOrToy, 0, 1, 1, 20);


        pane.add(new Label("Type:"), 2, 1);
        pane.add(supplyTypeCB, 3, 1);

        supplyTypeCB.getItems().addAll("Perishable Goods","Non-Perishable Goods");
        supplyTypeCB.getSelectionModel().select(0);
        supplyTypeCB.getSelectionModel().selectedItemProperty().addListener((obsVal,oldVal,newVal)-> changeImage(newVal));

        pane.add(addButton,3,2);
        addButton.setOnAction(e -> ViewNavigator.loadScene("Manage Inventory", manageInventory(supplyTypeCB.getSelectionModel().getSelectedItem())));
        this.setRoot(pane);
    }
    public Scene manageInventory(String s){
        if (s=="Perishable Goods") return new FoodSupplyScene();
        else return new NonPGScene();
    }
    private void changeImage(String newVal) {
        if (newVal.equals("Perishable Goods"))
            foodOrToy.setImage(new Image("HungryCat.jpg"));
        else
            foodOrToy.setImage(new Image("PlayfulDog.jpg"));
    }
}
