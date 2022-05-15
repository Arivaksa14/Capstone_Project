package com.animalshelter.capstone_project.model;

import java.io.Serializable;
import java.util.Objects;

public class Dog extends Animal implements Serializable {
    private String mSpayedOrNeutered;
    private String mTrained;

    public Dog(String applicantName, String animalType, int householdSize, char petGender, String petAgeCat, String goodWithOtherAnimals, String active, String healthIssues, String reason, String spayedOrNeutered, String trained) {
        super(applicantName, animalType, householdSize, petGender, petAgeCat, goodWithOtherAnimals, active, healthIssues, reason);
        mSpayedOrNeutered = spayedOrNeutered;
        mTrained = trained;
    }

    public String getSpayedOrNeutered() {
        return mSpayedOrNeutered;
    }

    public void setSpayedOrNeutered(String spayedOrNeutered) {
        mSpayedOrNeutered = spayedOrNeutered;
    }

    public String getTrained() {
        return mTrained;
    }

    public void setTrained(String trained) {
        mTrained = trained;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(mSpayedOrNeutered, dog.mSpayedOrNeutered) && Objects.equals(mTrained, dog.mTrained);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mSpayedOrNeutered, mTrained);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "ApplicantName='" + mApplicantName + '\'' +
                ", AnimalType='" + mAnimalType + '\'' +
                ", HouseholdSize=" + mHouseholdSize +
                ", PetGender=" + mPetGender +
                ", PetAgeCat='" + mPetAgeCat + '\'' +
                ", GoodWithOtherAnimals='" + mGoodWithOtherAnimals + '\'' +
                ", Active='" + mActive + '\'' +
                ", HealthIssues='" + mHealthIssues + '\'' +
                ", Reason='" + mReason + '\'' +
                ", SpayedOrNeutered='" + mSpayedOrNeutered + '\'' +
                ", Trained='" + mTrained + '\'' +
                '}';
    }
}
