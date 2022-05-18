package com.animalshelter.capstone_project.controller;

import com.animalshelter.capstone_project.model.CatDog;
import com.animalshelter.capstone_project.model.Model;
import javafx.collections.ObservableList;

public class Controller {

    private static Controller theInstance;
    private ObservableList<CatDog> mAllAnimalsList;

    /**
     * Gets the one instance of the Controller.
     * @return The instance
     */
    public static Controller getInstance() {
        //if theInstance is null, create a new object
        if (theInstance ==null) {
            theInstance = new Controller();
            //otherwise, return theInstance

            //Fill the mAllAnimalsList with data from Model
            //if the binary file has data, fill with binary file. Otherwise, fill with csv file
            if (Model.binaryFileHasData()) {
                System.out.println("BLA BINARY");
                theInstance.mAllAnimalsList = Model.populateListFromBinaryFile();
            } else {
                System.out.println("BLA CSV");
                theInstance.mAllAnimalsList = Model.populateListFromCSVFile();
            }
        }
        return theInstance;
    }

    private Controller() {
    }

    /**
     * Gets the list of all animals.
     * @return The list of all animals.
     */
    public  ObservableList<CatDog> getAllAnimals() {
        return mAllAnimalsList;
    }

    /**
     * Makes a request for the model to save all the animals data (the list of all animals) to
     * a persistent binary file.
     */
    public void saveData() {
        System.out.println("BLA");
        Model.writeDataToBinaryFile(mAllAnimalsList);
    }
}