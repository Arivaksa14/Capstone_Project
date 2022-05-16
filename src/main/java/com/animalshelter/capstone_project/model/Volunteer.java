package com.animalshelter.capstone_project.model;

import java.io.Serializable;

public class Volunteer implements Serializable {

    protected String mName;
    protected int mAge;
    protected String mReason;
    private String mAnimalType;

    public Volunteer(String name, int age, String reason, String animalType) {
        mName = name;
        mAge = age;
        mReason = reason;
        mAnimalType = animalType;
    }




}
