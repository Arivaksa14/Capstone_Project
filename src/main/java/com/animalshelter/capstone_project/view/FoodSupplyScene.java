package com.animalshelter.capstone_project.view;
import com.animalshelter.capstone_project.model.Inventory;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class FoodSupplyScene extends Scene {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;

    private TextField productTF = new TextField();
    private Label productErrLabel = new Label("Product Name is required.");

    private TextField skuTF = new TextField();
    private Label skuErrLabel = new Label("SKU# is required.");

    private TextField qtyTF = new TextField();
    private Label qtyErrLabel = new Label("QTY is required.");

    private TextField expTF = new TextField();
    private Label expErrLabel = new Label("Expiration Date is required.");


    public FoodSupplyScene() {
        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(5));

        // Column#1
        pane.add(new Label("Product Name:"), 0, 0);
        pane.add(new Label("SKU#:"), 0, 1);
        pane.add(new Label("QTY:"), 0, 2);
        pane.add(new Label("Expiration Date: "), 0, 3);

        // Column#2
        pane.add(productTF,1,0);
        pane.add(skuTF,1,1);
        pane.add(qtyTF,1,2);
        pane.add(expTF,1,3);


        // Column#3
        pane.add(productErrLabel,2,0);
        productErrLabel.setTextFill(Color.RED);
        productErrLabel.setVisible(false);
        pane.add(skuErrLabel,2,1);
        skuErrLabel.setTextFill(Color.RED);
        skuErrLabel.setVisible(false);
        pane.add(qtyErrLabel,2,2);
        qtyErrLabel.setTextFill(Color.RED);
        qtyErrLabel.setVisible(false);
        pane.add(expErrLabel,2,3);
        expErrLabel.setTextFill(Color.RED);
        expErrLabel.setVisible(false);

        // Display
        this.setRoot(pane);
    }

}