package com.animalshelter.capstone_project.model;

import java.io.Serializable;
import java.util.Objects;

public class Cat extends Animal implements Serializable {
    private String mIndoorOrOutdoor;
    private String mDeclawed;

    public Cat(String applicantName, String animalType, int householdSize, char petGender, String petAgeCat, String goodWithOtherAnimals, String active, String healthIssues, String reason, String indoorOrOutdoor, String declawed) {
        super(applicantName, animalType, householdSize, petGender, petAgeCat, goodWithOtherAnimals, active, healthIssues, reason);
        mIndoorOrOutdoor = indoorOrOutdoor;
        mDeclawed = declawed;
    }

    public String getIndoorOrOutdoor() {
        return mIndoorOrOutdoor;
    }

    public void setIndoorOrOutdoor(String indoorOrOutdoor) {
        mIndoorOrOutdoor = indoorOrOutdoor;
    }

    public String getDeclawed() {
        return mDeclawed;
    }

    public void setDeclawed(String declawed) {
        mDeclawed = declawed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return Objects.equals(mIndoorOrOutdoor, cat.mIndoorOrOutdoor) && Objects.equals(mDeclawed, cat.mDeclawed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mIndoorOrOutdoor, mDeclawed);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "ApplicantName='" + mApplicantName + '\'' +
                ", AnimalType='" + mAnimalType + '\'' +
                ", HouseholdSize=" + mHouseholdSize +
                ", PetGender=" + mPetGender +
                ", PetAgeCat='" + mPetAgeCat + '\'' +
                ", GoodWithOtherAnimals='" + mGoodWithOtherAnimals + '\'' +
                ", Active='" + mActive + '\'' +
                ", HealthIssues='" + mHealthIssues + '\'' +
                ", Reason='" + mReason + '\'' +
                ", IndoorOrOutdoor='" + mIndoorOrOutdoor + '\'' +
                ", Declawed='" + mDeclawed + '\'' +
                '}';
    }
}
