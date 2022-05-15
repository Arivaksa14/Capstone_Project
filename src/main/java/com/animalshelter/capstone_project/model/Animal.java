package com.animalshelter.capstone_project.model;

import java.io.Serializable;
import java.util.Objects;

public class Animal implements Serializable {

    protected String mApplicantName;
    protected String mAnimalType;
    protected int mHouseholdSize;
    protected char mPetGender;
    protected String mPetAgeCat;
    protected String mGoodWithOtherAnimals;
    protected String mActive;
    protected String mHealthIssues;
    protected String mReason;

    public Animal(String applicantName, String animalType, int householdSize, char petGender, String petAgeCat, String goodWithOtherAnimals, String active, String healthIssues, String reason) {
        mApplicantName = applicantName;
        mAnimalType = animalType;
        mHouseholdSize = householdSize;
        mPetGender = petGender;
        mPetAgeCat = petAgeCat;
        mGoodWithOtherAnimals = goodWithOtherAnimals;
        mActive = active;
        mHealthIssues = healthIssues;
        mReason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return mHouseholdSize == animal.mHouseholdSize && mPetGender == animal.mPetGender && Objects.equals(mApplicantName, animal.mApplicantName) && Objects.equals(mAnimalType, animal.mAnimalType) && Objects.equals(mPetAgeCat, animal.mPetAgeCat) && Objects.equals(mGoodWithOtherAnimals, animal.mGoodWithOtherAnimals) && Objects.equals(mActive, animal.mActive) && Objects.equals(mHealthIssues, animal.mHealthIssues) && Objects.equals(mReason, animal.mReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mApplicantName, mAnimalType, mHouseholdSize, mPetGender, mPetAgeCat, mGoodWithOtherAnimals, mActive, mHealthIssues, mReason);
    }

    public String getApplicantName() {
        return mApplicantName;
    }

    public void setApplicantName(String applicantName) {
        mApplicantName = applicantName;
    }

    public String getAnimalType() {
        return mAnimalType;
    }

    public void setAnimalType(String animalType) {
        mAnimalType = animalType;
    }

    public int getHouseholdSize() {
        return mHouseholdSize;
    }

    public void setHouseholdSize(int householdSize) {
        mHouseholdSize = householdSize;
    }

    public char getPetGender() {
        return mPetGender;
    }

    public void setPetGender(char petGender) {
        mPetGender = petGender;
    }

    public String getPetAgeCat() {
        return mPetAgeCat;
    }

    public void setPetAgeCat(String petAgeCat) {
        mPetAgeCat = petAgeCat;
    }

    public String getGoodWithOtherAnimals() {
        return mGoodWithOtherAnimals;
    }

    public void setGoodWithOtherAnimals(String goodWithOtherAnimals) {
        mGoodWithOtherAnimals = goodWithOtherAnimals;
    }

    public String getActive() {
        return mActive;
    }

    public void setActive(String active) {
        mActive = active;
    }

    public String getHealthIssues() {
        return mHealthIssues;
    }

    public void setHealthIssues(String healthIssues) {
        mHealthIssues = healthIssues;
    }

    public String getReason() {
        return mReason;
    }

    public void setReason(String reason) {
        mReason = reason;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "ApplicantName='" + mApplicantName + '\'' +
                ", AnimalType='" + mAnimalType + '\'' +
                ", HouseholdSize=" + mHouseholdSize +
                ", PetGender=" + mPetGender +
                ", PetAgeCat='" + mPetAgeCat + '\'' +
                ", GoodWithOtherAnimals='" + mGoodWithOtherAnimals + '\'' +
                ", Active='" + mActive + '\'' +
                ", HealthIssues='" + mHealthIssues + '\'' +
                ", Reason='" + mReason + '\'' +
                '}';
    }
}
