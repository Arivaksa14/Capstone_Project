package com.animalshelter.capstone_project.controller;

import com.animalshelter.capstone_project.model.*;
import javafx.collections.ObservableList;

import static com.animalshelter.capstone_project.model.Model.BINARY_FILE_ANIMALS;
import static com.animalshelter.capstone_project.model.Model.BINARY_FILE_MEDICAL_RECORD;

public class Controller {

    private static Controller theInstance;
    private ObservableList<CatDog> mAllAnimalsList;
    private ObservableList<MedicalRecord> mAllMedicalRecordsList;
    private ObservableList<PerishableGoods> mPerishableGoods;
    private ObservableList<NonPerishable> mNonPerishable;

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
            if (Model.binaryFileHasData(BINARY_FILE_ANIMALS)) {
                theInstance.mAllAnimalsList = Model.populateAnimalsListFromBinaryFile();
            } else {
                theInstance.mAllAnimalsList = Model.populateAnimalsListFromCSVFile();
            }
            if (Model.binaryFileHasData(BINARY_FILE_MEDICAL_RECORD)) {
                theInstance.mAllMedicalRecordsList = Model.populateMedicalRecordsListFromBinaryFile();
            } else {
                theInstance.mAllMedicalRecordsList = Model.populateMedicalRecordsListFromCSVFile();
            }
            if (Model.PGBinaryFileHasData()) {
                theInstance.mPerishableGoods = Model.PGListFromBinaryFile();
            } else {
                theInstance.mPerishableGoods = Model.PGListFromTXTFile();
            }
            if (Model.NPGBinaryFileHasData()) {
                theInstance.mNonPerishable = Model.NPGListFromBinaryFile();
            } else {
                theInstance.mNonPerishable = Model.NPGListFromTXTFile();
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
    public ObservableList<CatDog> getAllAnimals() {
        return mAllAnimalsList;
    }
    public ObservableList<MedicalRecord> getAllMedicalRecords() {
        return mAllMedicalRecordsList;
    }
    public  ObservableList<PerishableGoods> getAllPG() {
        return mPerishableGoods;
    }
    public  ObservableList<NonPerishable> getAllNPG() {
        return mNonPerishable;
    }

    /**
     * Makes a request for the model to save all the animals data (the list of all animals) to
     * a persistent binary file.
     */
    public void saveData() {
        Model.writeDataToAnimalsBinaryFile(mAllAnimalsList);
        Model.writeDataToMedicalRecordsBinaryFile(mAllMedicalRecordsList);
        Model.writeDataToPGBinaryFile(mPerishableGoods);
        Model.writeDataToNPGBinaryFile(mNonPerishable);
    }


}