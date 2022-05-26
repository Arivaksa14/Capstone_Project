package com.animalshelter.capstone_project.view;
import com.animalshelter.capstone_project.controller.Controller;
import com.animalshelter.capstone_project.controller.VolunteerController;
import com.animalshelter.capstone_project.model.FosterVolunteer;
import com.animalshelter.capstone_project.model.InHouseVolunteer;
import com.animalshelter.capstone_project.model.Volunteer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.Scanner;

public class VolunteerScene extends Scene {

    /*** EASIER TO MANAGE SCENE POSITIONING ***/
    public static final int IMAGE_ROW = 0;
    public static final int SELECT_VOLUNTEER_ROW = 2;
    public static final int FOSTER_CHOICE_CB_ROW = 3;
    public static final int VOLUNTEER_SELECTION_ROW = 4;
    public static final int CURRENT_VOLUNTEERS_ROW = 5;
    public static final int LV_ROW = 6;
    public static final int NEXT_BUTTON_ROW = 10;
    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;

    private ImageView volunteerImage = new ImageView();

    private ObservableList<Volunteer> volunteersList;
    private ListView<Volunteer> volunteerListView = new ListView<>();
    private Controller controller = Controller.getInstance();

    private Button nextButton = new Button("Next");
    private Button removeButton = new Button("- Volunteer");
    private Button inLovingMemory = new Button("In Loving Memory");

    private Label selectVolunteerLabel = new Label("Please select to enter either Foster or In House Volunteer");
    private Label volunteerTypeLabel = new Label();
    private ComboBox<String> volunteerTypeComboBox = new ComboBox<>();
    private String volunteerTypeSelected = "Foster";
    private Label currentVolunteersLabel = new Label("Currently entered Volunteers:");
    private Volunteer selectedVolunteer;

    public VolunteerScene (){

        super(new GridPane(), WIDTH, HEIGHT);

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        pane.add(inLovingMemory, 3, 3);
        inLovingMemory.setOnAction(e -> ViewNavigator.loadScene("In Loving Memory", new ParisScene()));

        volunteerImage.setImage(new Image("volunteerpic2.png"));
        volunteerImage.setFitWidth(WIDTH);
        pane.add(volunteerImage, 0, IMAGE_ROW, 3, 1);

        pane.add(volunteerTypeLabel, 0, VOLUNTEER_SELECTION_ROW);
        pane.add(currentVolunteersLabel, 0, CURRENT_VOLUNTEERS_ROW);

        HBox selectCBHbox = new HBox(selectVolunteerLabel, volunteerTypeComboBox);
        selectCBHbox.setSpacing(10);
        selectCBHbox.setAlignment(Pos.CENTER);
        pane.add(selectCBHbox, 0, FOSTER_CHOICE_CB_ROW);

        volunteerTypeComboBox.getItems().addAll( "Foster", "In House Volunteer");
        volunteerTypeComboBox.getSelectionModel().selectedItemProperty().addListener
                ((obsVal, oldVal, newVal) -> changeVolunteerTypeLabel(newVal));
        volunteerTypeComboBox.getSelectionModel().selectedItemProperty().addListener
                ((obsVal, oldVal, newVal) -> volunteerTypeSelection(newVal));
        volunteerTypeComboBox.getSelectionModel().select(0);

        volunteersList = controller.getAllVolunteers();
        volunteerListView.setItems(volunteersList);
        volunteerListView.setPrefWidth(WIDTH);
        volunteerListView.getSelectionModel().selectedItemProperty().addListener
                ((obsVal, oldVal, newVal) -> selectVolunteer(newVal));
        pane.add(volunteerListView, 0, LV_ROW, 3, 1);

        pane.add(nextButton, 4, NEXT_BUTTON_ROW);

        nextButton.setOnAction(e -> selectScene(volunteerTypeSelected));

        pane.add(removeButton, 0, 10);
        removeButton.setDisable(true);
        removeButton.setOnAction(event -> removeVolunteer());

        this.setRoot(pane);
    }

    private void removeVolunteer(){
        if(selectedVolunteer == null)
            return;
        volunteersList.remove(selectedVolunteer);
        volunteerListView.refresh();
        volunteerListView.getSelectionModel().select(-1);
    }

    private void selectVolunteer(Volunteer newVal){
        selectedVolunteer = newVal;
        removeButton.setDisable(selectedVolunteer == null);
    }

    /**
     * creates String of either (Foster or In House) Volunteer
     */
    private void volunteerTypeSelection(String newVal) {
        volunteerTypeSelected = newVal;
    }

    /**
     * Creates new scene from volunteerTypeSelected
     */
    public void selectScene(String volunteerTypeSelected){
        if(volunteerTypeSelected.equalsIgnoreCase("Foster"))
            ViewNavigator.loadScene("Foster Volunteer Data Entry", new FosterVolunteerScene());
        else
            ViewNavigator.loadScene("In House Volunteer Data Entry", new InHouseVolunteerScene());
    }

    /**
     * changes volunteerTypeLabel to reflect what is selected
     */
    private void changeVolunteerTypeLabel(String newVal) {
        volunteerTypeLabel.setText(newVal + " selected.");
    }

}