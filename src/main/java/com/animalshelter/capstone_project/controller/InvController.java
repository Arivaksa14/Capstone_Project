package com.animalshelter.capstone_project.controller;
import com.animalshelter.capstone_project.model.InvModel;
import com.animalshelter.capstone_project.model.PerishableGoods;
import javafx.collections.ObservableList;

public class InvController {

    private static InvController theInstance;
    private ObservableList<PerishableGoods> mPerishableGoods;

    /**
     * Gets the one instance of the Controller.
     * @return The instance
     */
    public static InvController getInstance() {
        //if theInstance is null, create a new object
        if (theInstance ==null) {
            theInstance = new InvController();
            //otherwise, return theInstance

            //Fill the mAllAnimalsList with data from Model
            //if the binary file has data, fill with binary file. Otherwise, fill with csv file
            if (InvModel.binaryFileHasData()) {
                System.out.println("BLA BINARY");
                theInstance.mPerishableGoods = InvModel.populateListFromBinaryFile();
            } else {
                System.out.println("BLA CSV");
                theInstance.mPerishableGoods = InvModel.populateListFromTXTFile();
            }
        }
        return theInstance;
    }

    private InvController() {
    }

    public  ObservableList<PerishableGoods> getAllAnimals() {
        return mPerishableGoods;
    }

    public void saveData() {
        InvModel.writeDataToBinaryFile(mPerishableGoods);
    }
}
