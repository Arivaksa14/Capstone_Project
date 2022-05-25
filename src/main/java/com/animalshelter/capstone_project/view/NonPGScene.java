package com.animalshelter.capstone_project.view;
import com.animalshelter.capstone_project.controller.Controller;
import com.animalshelter.capstone_project.model.NonPerishable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class NonPGScene extends Scene {
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

    private TextField sizeTF = new TextField();
    private Label sizeErrLabel = new Label("Size is required.");

    private ListView<NonPerishable> NonPerishableLV = new ListView<>();
    private ObservableList<NonPerishable> NPGList;
    private Controller controller = Controller.getInstance();
    private Button addButton = new Button("Add Product");
    private Button removeButton = new Button("Remove Product");
    private Button returnButton = new Button("Return to Main Page");
    private ImageView ohCat = new ImageView();
    private NonPerishable selectedPG;

    public NonPGScene() {
        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(5));

        // Column#1
        pane.add(returnButton, 0, 0);
        returnButton.setOnAction(e -> ViewNavigator.loadScene("Animal Shelter Application", new MainScene()));

        ohCat.setImage(new Image("PlayfulCat.jpg"));
        ohCat.setFitWidth(460);
        ohCat.setFitHeight(230);
        pane.add(ohCat, 0, 1, 1, 8);
        pane.add(NonPerishableLV, 0, 9, 4, 1);

        // Column#2
        pane.add(new Label("Item#:"), 1, 1);
        pane.add(new Label("Category:"), 1, 2);
        pane.add(new Label("Product Name:"), 1, 3);
        pane.add(new Label("Vendor: "), 1, 4);
        pane.add(new Label("Price: "), 1, 5);
        pane.add(new Label("Size: "), 1, 6);
        pane.add(new Label(""), 1, 7);
        pane.add(new Label(""), 1, 8);
        // Column#3
        pane.add(itemNoTF, 2, 1);
        pane.add(categoryCB, 2, 2);
        categoryCB.getItems().addAll("Accessories","Cat Toy","Dog Toy","Chew Toy");
        categoryCB.getSelectionModel().select(-1);
        pane.add(productTF, 2, 3);
        pane.add(vendorCB, 2, 4);
        vendorCB.getItems().addAll("Benebone","Disney",
                "Frisco","Pets First", "Petstages", "SmartyKat",
                "SnugglyCat","ZEZE");

        pane.add(priceTF, 2, 5);
        pane.add(sizeTF, 2, 6);
        pane.add(addButton, 2, 8);
        addButton.setOnAction(e -> addNPG());

        pane.add(removeButton, 2, 10);
        removeButton.setOnAction(e -> removePG());
        removeButton.setDisable(true);

        // Column#4
        pane.add(itemNoErrLabel, 3, 1);
        itemNoErrLabel.setTextFill(Color.RED);
        itemNoErrLabel.setVisible(false);

        pane.add(categoryErrLabel, 3, 2);
        categoryErrLabel.setTextFill(Color.RED);
        categoryErrLabel.setVisible(false);

        pane.add(productErrLabel, 3, 3);
        productErrLabel.setTextFill(Color.RED);
        productErrLabel.setVisible(false);

        pane.add(vendorErrLabel, 3, 4);
        vendorErrLabel.setTextFill(Color.RED);
        vendorErrLabel.setVisible(false);

        pane.add(priceErrLabel, 3, 5);
        priceErrLabel.setTextFill(Color.RED);
        priceErrLabel.setVisible(false);

        pane.add(sizeErrLabel, 3, 6);
        sizeErrLabel.setTextFill(Color.RED);
        sizeErrLabel.setVisible(false);

        NonPerishableLV.setPrefWidth(WIDTH);
        NPGList = controller.getAllNPG();
        NonPerishableLV.setItems(NPGList);
        NonPerishableLV.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> selectPG(newVal));

        this.setRoot(pane);
    }

    private void selectPG(NonPerishable newVal) {
        selectedPG = newVal;
        removeButton.setDisable(selectedPG == null);
    }

    private void removePG() {
        NPGList.remove(selectedPG);
        NonPerishableLV.refresh();
        NonPerishableLV.getSelectionModel().select(-1);
    }

    private void updateDisplay() {
        NonPerishableLV.refresh();
    }

    private void addNPG() {
        itemNoErrLabel.setVisible(itemNoTF.getText().isEmpty());
        categoryErrLabel.setVisible(categoryCB.getSelectionModel().getSelectedIndex() == -1);
        productErrLabel.setVisible(productTF.getText().isEmpty());
        vendorErrLabel.setVisible(vendorCB.getSelectionModel().getSelectedIndex() == -1);
        priceErrLabel.setVisible(priceTF.getText().isEmpty());
        sizeErrLabel.setVisible(sizeTF.getText().isEmpty());
        if (itemNoErrLabel.isVisible() || categoryErrLabel.isVisible() ||
                productErrLabel.isVisible() || vendorErrLabel.isVisible() ||
                priceErrLabel.isVisible() || sizeErrLabel.isVisible())
            return;
        else {
            NPGList.add(0,
                    new NonPerishable(Integer.parseInt(itemNoTF.getText()),
                            categoryCB.getSelectionModel().getSelectedItem(),
                            productTF.getText(),
                            vendorCB.getSelectionModel().getSelectedItem(),
                            Double.parseDouble(priceTF.getText()),
                            sizeTF.getText()));
        }
    }
}
