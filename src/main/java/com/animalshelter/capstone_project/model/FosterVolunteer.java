package com.animalshelter.capstone_project.model;

import java.io.Serializable;

public class FosterVolunteer extends Volunteer implements Serializable {

    private String mStartDate;
    private String mEndDate;

    public FosterVolunteer(String name, int age, String reason, String animalType, String startDate, String endDate) {
        super(name, age, reason, animalType);
        mStartDate = startDate;
        mEndDate = endDate;
    }
}
