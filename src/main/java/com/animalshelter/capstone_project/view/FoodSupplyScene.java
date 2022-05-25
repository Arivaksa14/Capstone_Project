package com.animalshelter.capstone_project.view;
import com.animalshelter.capstone_project.controller.Controller;
import com.animalshelter.capstone_project.model.PerishableGoods;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import java.time.format.DateTimeFormatter;

public class FoodSupplyScene extends Scene {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;

    private TextField itemNoTF = new TextField();
    private Label itemNoErrLabel = new Label("Item Number is required.");

    private ComboBox<String> categoryCB = new ComboBox<>();
    private Label categoryErrLabel = new Label("Category is required.");

    private TextField productTF = new TextField();
    private Label productErrLabel = new Label("Product Name is required.");

    private ComboBox<String> vendorCB = new ComboBox<>();
    private Label vendorErrLabel = new Label("Vendor is required.");

    private TextField priceTF = new TextField();
    private Label priceErrLabel = new Label("Price is required.");

    private TextField specTF = new TextField();
    private Label specErrLabel = new Label("Spec is required.");

    private DatePicker expireDate = new DatePicker();
    private Label expireDateErrLabel = new Label("Expiration date is required.");

    private ListView<PerishableGoods> perishableGoodsLV = new ListView<>();
    private ObservableList<PerishableGoods> PGList;
    private Controller controller = Controller.getInstance();
    private Button addButton = new Button("Add Product");
    private Button removeButton = new Button("Remove Product");
    private Button returnButton = new Button("Return to Main Page");
    private ImageView ohDog = new ImageView();
    private PerishableGoods selectedPG;

    public FoodSupplyScene() {
        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(5));

        // Column#1
        pane.add(returnButton, 0, 0);
        returnButton.setOnAction(e -> ViewNavigator.loadScene( "Animal Shelter Application", new MainScene()));

        ohDog.setImage(new Image("HungryDog.png"));
        ohDog.setFitWidth(460);
        ohDog.setFitHeight(230);
        pane.add(ohDog, 0, 1, 1, 8);

        pane.add(perishableGoodsLV, 0, 9, 4, 1);

        // Column#2
        pane.add(new Label("Item#:"), 1, 1);
        pane.add(new Label("Category:"), 1, 2);
        pane.add(new Label("Product Name:"), 1, 3);
        pane.add(new Label("Vendor: "), 1, 4);
        pane.add(new Label("Price: "), 1, 5);
        pane.add(new Label("Spec: "), 1, 6);
        pane.add(new Label("Expiration date: "), 1, 7);

        // Column#3
        pane.add(itemNoTF,2,1);
        pane.add(categoryCB,2,2);
        categoryCB.getItems().addAll("Cat Treats","Cat Food (Dry)",
                "Cat Food (Wet)","Dog Treats","Dog Food (Dry)",
                "Dog Food (Wet)");
        categoryCB.getSelectionModel().select(-1);
        pane.add(productTF,2,3);
        pane.add(vendorCB,2,4);
        vendorCB.getItems().addAll("American Journey",
                "Blue Buffalo", "Cat Chow", "Fancy Feast",
                "Friskies", "Meow Mix", "Pedigree", "PureBites",
                "Purina Beneful", "Shameless Pets", "SmartBones",
                "Tiny Tiger", "True Acre Foods");

        pane.add(priceTF,2,5);
        pane.add(specTF,2,6);
        pane.add(expireDate,2,7);
        pane.add(addButton, 2, 8);
        addButton.setOnAction(e -> addPG());

        pane.add(removeButton,2,10);
        removeButton.setOnAction(e -> removePG());
        removeButton.setDisable(true);

        // Column#4
        pane.add(itemNoErrLabel,3,1);
        itemNoErrLabel.setTextFill(Color.RED);
        itemNoErrLabel.setVisible(false);

        pane.add(categoryErrLabel,3,2);
        categoryErrLabel.setTextFill(Color.RED);
        categoryErrLabel.setVisible(false);

        pane.add(productErrLabel,3,3);
        productErrLabel.setTextFill(Color.RED);
        productErrLabel.setVisible(false);

        pane.add(vendorErrLabel,3,4);
        vendorErrLabel.setTextFill(Color.RED);
        vendorErrLabel.setVisible(false);

        pane.add(priceErrLabel,3,5);
        priceErrLabel.setTextFill(Color.RED);
        priceErrLabel.setVisible(false);

        pane.add(specErrLabel,3,6);
        specErrLabel.setTextFill(Color.RED);
        specErrLabel.setVisible(false);

        pane.add(expireDateErrLabel,3,7);
        expireDateErrLabel.setTextFill(Color.RED);
        expireDateErrLabel.setVisible(false);

        perishableGoodsLV.setPrefWidth(WIDTH);
        PGList = controller.getAllPG();
        perishableGoodsLV.setItems(PGList);
        perishableGoodsLV.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> selectPG(newVal));

        this.setRoot(pane);
    }

    private void selectPG(PerishableGoods newVal) {
        selectedPG = newVal;
        removeButton.setDisable(selectedPG==null);
    }
    private void removePG() {
        PGList.remove(selectedPG);
        perishableGoodsLV.refresh();
        perishableGoodsLV.getSelectionModel().select(-1);
    }

    private void updateDisplay(){
        perishableGoodsLV.refresh();
    }
    private void addPG() {
        // Order: 0-Item#, 1-Category, 2-Product Name, 3-Vendor, 4-Price, 5-Spec, 6-Expiration Date
        itemNoErrLabel.setVisible(itemNoTF.getText().isEmpty());
        categoryErrLabel.setVisible(categoryCB.getSelectionModel().getSelectedIndex()==-1);
        productErrLabel.setVisible(productTF.getText().isEmpty());
        vendorErrLabel.setVisible(vendorCB.getSelectionModel().getSelectedIndex()==-1);
        priceErrLabel.setVisible(priceTF.getText().isEmpty());
        specErrLabel.setVisible(specTF.getText().isEmpty());
        expireDateErrLabel.setVisible(expireDate.getValue() == null);
        if (itemNoErrLabel.isVisible() || categoryErrLabel.isVisible() ||
                productErrLabel.isVisible() || vendorErrLabel.isVisible() ||
                priceErrLabel.isVisible() || specErrLabel.isVisible() ||
                expireDateErrLabel.isVisible())
            return;
        else{
            PGList.add(0,
                    new PerishableGoods(Integer.parseInt(itemNoTF.getText()),
                            categoryCB.getSelectionModel().getSelectedItem(),
                            productTF.getText(),
                            vendorCB.getSelectionModel().getSelectedItem(),
                            Double.parseDouble(priceTF.getText()),
                            specTF.getText(),
                            expireDate.getValue().format(DateTimeFormatter.ofPattern("M/d/yyyy"))));
        }
    }
}
