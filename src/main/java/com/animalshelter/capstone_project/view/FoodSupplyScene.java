package com.animalshelter.capstone_project.view;
import com.animalshelter.capstone_project.model.FoodSupply;
import com.animalshelter.capstone_project.model.Inventory;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class FoodSupplyScene extends Scene {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;

    private ComboBox<String> laureateTypeCB = new ComboBox<>();
    private TextField nameTF = new TextField();
    private Label nameLabel = new Label("Individual's Name:");
    private Label nameErrLabel = new Label("Name is required.");

    private TextField countryTF = new TextField();
    private Label countryErrLabel = new Label("Country is required.");

    private TextField yearTF = new TextField();
    private Label yearErrLabel = new Label("Year is required.");

    private TextField prizeAmountTF = new TextField();
    private Label prizeAmountErrLabel = new Label("Prize amount is required.");

    private TextField motivationTF = new TextField();
    private Label motivationErrLabel = new Label("Motivation is required :)");

    private ListView<Inventory> inventoryLV = new ListView<>();

    private Button removeButton = new Button("- Remove Laureate");
    private Button addButton = new Button("+ Add Laureate");

    //private Controller controller = Controller.getInstance();
    private ObservableList<Inventory> inventoryList;
    private Inventory selectedItem;

    /**
     * Constructs a new <code>MainScene</code>, representing the very first scene for the Nobel Peace Price Laureates application.
     *
     * The <code>MainScene</code> also allows for a user to add a new laureate or remove an existing one.
     */
    public FoodSupplyScene() {
        super(new GridPane(), WIDTH, HEIGHT);

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        pane.add(new Label("Laureate Type:"), 0, 1);
        pane.add(laureateTypeCB, 1, 1);
        laureateTypeCB.getItems().addAll("Individual","Organization");
        laureateTypeCB.getSelectionModel().select(0);
        laureateTypeCB.getSelectionModel().selectedItemProperty().addListener((obsVal,oldVal,newVal)-> changeNameLabel(newVal));
        pane.add(nameLabel, 0, 2);

        pane.add(nameTF, 1, 2);
        pane.add(nameErrLabel, 2, 2);
        nameErrLabel.setTextFill(Color.RED);
        nameErrLabel.setVisible(false);

        pane.add(new Label("Award Year:"), 0, 3);
        pane.add(yearTF, 1, 3);
        yearTF.textProperty().addListener((obsVal,oldVal,newVal)->checkNum(newVal,yearErrLabel));

        pane.add(yearErrLabel, 2, 3);
        yearErrLabel.setTextFill(Color.RED);
        yearErrLabel.setVisible(false);

        pane.add(new Label("Motivation:"), 0, 4);
        pane.add(motivationTF, 1, 4);
        pane.add(motivationErrLabel, 2, 4);
        motivationErrLabel.setTextFill(Color.RED);
        motivationErrLabel.setVisible(false);

        pane.add(new Label("Country:"), 0, 5);
        pane.add(countryTF, 1, 5);
        pane.add(countryErrLabel, 2, 5);
        countryErrLabel.setTextFill(Color.RED);
        countryErrLabel.setVisible(false);

        pane.add(new Label("Prize Amount $"), 0, 6);
        pane.add(prizeAmountTF, 1, 6);
        prizeAmountTF.textProperty().addListener((obsVal,oldVal,newVal)->checkNum(newVal,prizeAmountErrLabel));
        pane.add(prizeAmountErrLabel, 2, 6);
        prizeAmountErrLabel.setTextFill(Color.RED);
        prizeAmountErrLabel.setVisible(false);

        pane.add(addButton, 1, 7);
        addButton.setOnAction(e -> addLaureate());
        inventoryLV.setPrefWidth(WIDTH);
        pane.add(inventoryLV, 0, 8, 3, 1);
        pane.add(removeButton, 0, 9);

        removeButton.setOnAction(e -> removeLaureate());
        //inventoryList = controller.getAllLaureates();
        inventoryLV.setItems(inventoryList);
        inventoryLV.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> selectLaureate(newVal));
        removeButton.setDisable(true);
        this.setRoot(pane);
    }
    private void changeNameLabel(String newVal) {
        nameLabel.setText(newVal + "'s Name:");
    }
    private void selectLaureate(Inventory newVal) {
        selectedItem = newVal;
        removeButton.setDisable(selectedItem ==null);
    }
    /**
     * Allows the user to modify an existing influencer by navigating to the ModifyInfluencer scene.
     * However, if the selected influencer is null, just return (do nothing)
     * Make sure to update the display (list view and combo boxes) after modifying the influencer.
     */
    private void removeLaureate() {
        inventoryList.remove(selectedItem);
        inventoryLV.refresh();
        inventoryLV.getSelectionModel().select(-1);
    }
    /**
     * Allows the user to add a new influencer review by navigating to the AddInfluencer scene.
     * Make sure to update the display (list view and combo boxes) after adding the new influencer.
     */
    private void addLaureate() {
        nameErrLabel.setVisible(nameTF.getText().isEmpty());
        countryErrLabel.setVisible(countryTF.getText().isEmpty());
        yearErrLabel.setVisible(yearTF.getText().isEmpty());
        prizeAmountErrLabel.setVisible(prizeAmountTF.getText().isEmpty());
        motivationErrLabel.setVisible(motivationTF.getText().isEmpty());
        if(!nameTF.getText().isEmpty()
                && !countryTF.getText().isEmpty()
                && !yearTF.getText().isEmpty()
                && !prizeAmountTF.getText().isEmpty()
                && !motivationTF.getText().isEmpty()) {
            try {
                String name = nameTF.getText();
                String country = countryTF.getText();
                int year = Integer.parseInt(yearTF.getText());
                double amount = Double.parseDouble(prizeAmountTF.getText());
                String motivation = motivationTF.getText();
                //inventoryList.add(0, new Inventory(name, year, motivation, country, amount));
                inventoryLV.refresh();
            } catch (NumberFormatException e){
                checkNum(yearTF.getText(),yearErrLabel);
                checkNum(prizeAmountTF.getText(),prizeAmountErrLabel);
            }
        }
    }
    /**
     * Updates the display after adding/modifying a influencer.  The idea being, if the user enters a new
     * location or country, it should appear in the appropriate combo box.  Also, the list view
     * should refresh to show the new/modified influencer.
     */
    private void updateDisplay(){
        inventoryLV.refresh();
    }
    private void checkNum(String s,Label l){
        try{
            if(!s.isEmpty()) {
                Double.parseDouble(s);
            }
            resetLabel();
            l.setVisible(false);
        } catch (NumberFormatException e){
            l.setText("Please enter number only.");
            l.setVisible(true);
        }
    }
    private void resetLabel(){
        yearErrLabel.setText("Year is required.");
        prizeAmountErrLabel.setText("Prize amount is required.");
    }
}