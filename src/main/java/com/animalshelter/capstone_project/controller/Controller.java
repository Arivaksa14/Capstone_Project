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
    private ObservableList<Volunteer> mAllVolunteers;
    /**
     * Gets the one instance of the Controller.
     * @return The instance
     */
    public static Controller getInstance() {
        //if theInstance is null, create a new object
        //otherwise, return theInstance
        if (theInstance ==null) {
            theInstance = new Controller();
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
            if(Model.volunteerBinaryHasData())
                theInstance.mAllVolunteers = Model.populateListVolunteerBinaryFile();
            else
                theInstance.mAllVolunteers = Model.populateFromVolunteerCSVFile();
        }
        return theInstance;
    }
    private Controller() {
    }

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

    public ObservableList<Volunteer> getAllVolunteers(){
        return mAllVolunteers;
    }

    public void saveData() {
        Model.writeDataToAnimalsBinaryFile(mAllAnimalsList);
        Model.writeDataToMedicalRecordsBinaryFile(mAllMedicalRecordsList);
        Model.writeDataToPGBinaryFile(mPerishableGoods);
        Model.writeDataToNPGBinaryFile(mNonPerishable);
        Model.writeToVolunteerBinary(mAllVolunteers);
    }
}