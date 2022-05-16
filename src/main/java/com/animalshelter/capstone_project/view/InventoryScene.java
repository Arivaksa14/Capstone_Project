package com.animalshelter.capstone_project.view;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class InventoryScene extends Scene {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    private ComboBox<String> supplyTypeCB = new ComboBox<>();
    private Button addButton = new Button("Manage");

    public InventoryScene() {
        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));
        pane.setAlignment(Pos.CENTER);
        pane.add(new Label("Supply Type:"), 0, 1);
        pane.add(supplyTypeCB, 1, 1);
        supplyTypeCB.getItems().addAll("Food Supply","Other Supply");
        supplyTypeCB.getSelectionModel().select(0);
        pane.add(addButton,1,2);
        addButton.setOnAction(e -> ViewNavigator.loadScene("Manage Inventory", new FoodSupplyScene()));
        this.setRoot(pane);
    }
}