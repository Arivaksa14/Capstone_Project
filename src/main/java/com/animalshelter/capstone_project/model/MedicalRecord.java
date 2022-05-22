package com.animalshelter.capstone_project.model;

import java.io.Serializable;
import java.util.Objects;

public class MedicalRecord extends Animal implements Serializable {

    private String mDeclawed;
    private String mHealthIssues;
    private String mSpayedOrNeutered;
    private String mVaccinated;

    public MedicalRecord(String animalName, String animalType, String animalGender, String animalAgeCat, String declawed, String healthIssues, String spayedOrNeutered, String vaccinated) {
        super(animalName, animalType, animalGender, animalAgeCat);
        mDeclawed = declawed;
        mHealthIssues = healthIssues;
        mSpayedOrNeutered = spayedOrNeutered;
        mVaccinated = vaccinated;
    }

    public String getDeclawed() {
        return mDeclawed;
    }

    public void setDeclawed(String declawed) {
        mDeclawed = declawed;
    }

    public String getHealthIssues() {
        return mHealthIssues;
    }

    public void setHealthIssues(String healthIssues) {
        mHealthIssues = healthIssues;
    }

    public String getSpayedOrNeutered() {
        return mSpayedOrNeutered;
    }

    public void setSpayedOrNeutered(String spayedOrNeutered) {
        mSpayedOrNeutered = spayedOrNeutered;
    }

    public String getVaccinated() {
        return mVaccinated;
    }

    public void setVaccinated(String vaccinated) {
        mVaccinated = vaccinated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MedicalRecord that = (MedicalRecord) o;
        return Objects.equals(mDeclawed, that.mDeclawed) && Objects.equals(mHealthIssues, that.mHealthIssues) && Objects.equals(mSpayedOrNeutered, that.mSpayedOrNeutered) && Objects.equals(mVaccinated, that.mVaccinated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mDeclawed, mHealthIssues, mSpayedOrNeutered, mVaccinated);
    }

    @Override
    public String toString() {
        return "Medical Record [" +
                "Animal Name = " + mAnimalName + '\'' +
                ", Animal Type = " + mAnimalType + '\'' +
                ", Animal Gender = " + mAnimalGender +
                ", Animal Age Category = " + mAnimalAgeCat + '\'' +
                ", Declawed = " + mDeclawed + '\'' +
                ", Health Issues = " + mHealthIssues + '\'' +
                ", Spayed Or Neutered = " + mSpayedOrNeutered + '\'' +
                ", Vaccinated = " + mVaccinated + '\'' +
                ']';
    }
}
