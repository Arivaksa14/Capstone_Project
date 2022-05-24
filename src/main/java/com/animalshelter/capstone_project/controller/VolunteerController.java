package com.animalshelter.capstone_project.controller;

import com.animalshelter.capstone_project.model.Model;
import com.animalshelter.capstone_project.model.Volunteer;
import javafx.collections.ObservableList;

public class VolunteerController {

    private static VolunteerController theInstance;
    private ObservableList<Volunteer> mAllVolunteers;

    private VolunteerController (){}

    public static VolunteerController getInstance(){

        if(theInstance == null) {
            theInstance = new VolunteerController();
            if(Model.volunteerBinaryHasData())
                theInstance.mAllVolunteers = Model.populateListVolunteerBinaryFile();
            else
                theInstance.mAllVolunteers = Model.populateFromVolunteerCSVFile();
        }
        return theInstance;
    }

    public ObservableList<Volunteer> getAllVolunteers(){
        return mAllVolunteers;
    }

    public void saveVolunteerData(){
        Model.writeToVolunteerBinary(mAllVolunteers);
    }

}
