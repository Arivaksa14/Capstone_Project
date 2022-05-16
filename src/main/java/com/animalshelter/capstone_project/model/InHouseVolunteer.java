package com.animalshelter.capstone_project.model;

import java.io.Serializable;

public class InHouseVolunteer extends Volunteer implements Serializable {

    private String [] availableLocations = {"Bahde Wildlife Center", "Escondido", "Oceanside", "Ramona", "San Diego"};

    private String mLocation;
    private String mTimeSlot;
    private String mDate;


    public InHouseVolunteer(String name, int age, String reason, String animalType, String location, String timeSlot, String date) {
        super(name, age, reason, animalType);
        mLocation = location;
        mTimeSlot = timeSlot;
        mDate = date;
    }


}
