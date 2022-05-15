package com.animalshelter.capstone_project.model;

import java.io.Serializable;

public class InHouseVolunteer extends Volunteer implements Serializable {

    String [] availableLocations = {"Bahde Wildlife Center", "Escondido", "Oceanside", "Ramona", "San Diego"};

    private String mLocation;
    private String mTimeSlot;
    private String mDate;



}