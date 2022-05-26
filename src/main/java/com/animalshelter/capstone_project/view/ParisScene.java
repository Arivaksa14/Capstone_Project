package com.animalshelter.capstone_project.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ParisScene extends Scene {


    public static final int WIDTH = 700;
    public static final int HEIGHT = 900;

    public static final ImageView parisPic = new ImageView();
    public static final Label loveYouParis = new Label("""
            In Loving Memory of Paris
            March 2006 - May 2022
            You were the sweetest anyone could have ever asked for, you'll forever be missed.""");
    public static final Button returnButton = new Button("Return to previous page");

    public ParisScene() {
        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();
        pane.setVisible(true);
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        parisPic.setImage(new Image("ParisPic.png"));
        parisPic.setFitWidth(WIDTH);
        pane.add(parisPic, 0, 0, 3, 1);
        pane.add(loveYouParis, 0, 2);


        pane.add(returnButton, 0, 10);
        returnButton.setOnAction(e -> ViewNavigator.loadScene("Welcome Volunteer!", new VolunteerScene()));

        this.setRoot(pane);
    }
}
