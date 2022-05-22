package com.animalshelter.capstone_project.view;
import com.animalshelter.capstone_project.model.PerishableGoods;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class FoodSupplyScene extends Scene {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;

    private TextField itemNoTF = new TextField();
    private Label itemNoErrLabel = new Label("Item Number is required.");

    private ComboBox<String> categoryCB = new ComboBox<>();
    private Label categoryErrLabel = new Label("Category is required.");

    private TextField productTF = new TextField();
    private Label productErrLabel = new Label("Product Name is required.");

    private TextField vendor = new TextField();
    private Label vendorErrLabel = new Label("Vendor is required.");

    private TextField priceTF = new TextField();
    private Label priceErrLabel = new Label("Price is required.");

    private TextField specTF = new TextField();
    private Label specErrLabel = new Label("Spec is required.");

    private TextField expireDateTF = new TextField();
    private Label expireDateErrLabel = new Label("Expiration date is required.");

    private ListView<PerishableGoods> perishableGoodsLV = new ListView<>();
    private Button returnButton = new Button("Return to Main Page");

    public FoodSupplyScene() {
        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(5));

        // Column#1
        pane.add(new Label("Item#:"), 0, 0);
        pane.add(new Label("Category:"), 0, 1);
        pane.add(new Label("Product Name:"), 0, 2);
        pane.add(new Label("Vendor: "), 0, 3);
        pane.add(new Label("Price: "), 0, 4);
        pane.add(new Label("Spec: "), 0, 5);
        pane.add(new Label("Expiration date: "), 0, 6);

        // Column#2
        pane.add(itemNoTF,1,0);
        pane.add(categoryCB,1,1);
        categoryCB.getItems().addAll("Cat Treat","Cat Food (Dry)","Cat Food (Wet)","Dog Treat","Dog Food (Dry)","Dog Food (Wet)");
        categoryCB.getSelectionModel().select(-1);
        pane.add(productTF,1,2);
        pane.add(vendor,1,3);
        pane.add(priceTF,1,4);
        pane.add(specTF,1,5);
        pane.add(expireDateTF,1,6);

        // Column#3
        // Order: 0-Item#, 1-Category, 2-Product Name, 3-Vendor, 4-Price, 5-Spec, 6-Expiration Date
        pane.add(itemNoErrLabel,2,0);
        itemNoErrLabel.setTextFill(Color.RED);
        itemNoErrLabel.setVisible(false);

        pane.add(categoryErrLabel,2,1);
        categoryErrLabel.setTextFill(Color.RED);
        categoryErrLabel.setVisible(false);

        pane.add(productErrLabel,2,2);
        productErrLabel.setTextFill(Color.RED);
        productErrLabel.setVisible(false);

        pane.add(vendorErrLabel,2,3);
        vendorErrLabel.setTextFill(Color.RED);
        vendorErrLabel.setVisible(false);

        pane.add(priceErrLabel,2,4);
        priceErrLabel.setTextFill(Color.RED);
        priceErrLabel.setVisible(false);

        pane.add(specErrLabel,2,5);
        specErrLabel.setTextFill(Color.RED);
        specErrLabel.setVisible(false);

        pane.add(expireDateErrLabel,2,6);
        expireDateErrLabel.setTextFill(Color.RED);
        expireDateErrLabel.setVisible(false);


        perishableGoodsLV.setPrefWidth(WIDTH);
        pane.add(perishableGoodsLV, 0, 8, 3, 1);

        pane.add(returnButton, 0, 10);
        returnButton.setOnAction(e -> ViewNavigator.loadScene( "Animal Shelter Application", new MainScene()));
        this.setRoot(pane);
    }

}