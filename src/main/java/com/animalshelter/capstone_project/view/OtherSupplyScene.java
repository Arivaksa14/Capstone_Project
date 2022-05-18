package com.animalshelter.capstone_project.view;
import com.animalshelter.capstone_project.model.Inventory;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;

public class OtherSupplyScene extends Scene{
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    public OtherSupplyScene() {
        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();
        this.setRoot(pane);
    }
}
