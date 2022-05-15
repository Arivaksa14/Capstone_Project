package com.animalshelter.capstone_project.model;

import java.io.Serializable;
import java.util.Objects;

public class SmallAnimal extends Animal implements Serializable {
    protected String mMessy;
    protected int mLifespan;

    public SmallAnimal(String applicantName, String animalType, int householdSize, char petGender, String petAgeCat, String goodWithOtherAnimals, String active, String healthIssues, String reason, String messy, int lifespan) {
        super(applicantName, animalType, householdSize, petGender, petAgeCat, goodWithOtherAnimals, active, healthIssues, reason);
        mMessy = messy;
        mLifespan = lifespan;
    }

    public String getMessy() {
        return mMessy;
    }

    public void setMessy(String messy) {
        mMessy = messy;
    }

    public int getLifespan() {
        return mLifespan;
    }

    public void setLifespan(int lifespan) {
        mLifespan = lifespan;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmallAnimal that = (SmallAnimal) o;
        return mLifespan == that.mLifespan && Objects.equals(mMessy, that.mMessy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mMessy, mLifespan);
    }

    @Override
    public String toString() {
        return "SmallAnimal{" +
                "ApplicantName='" + mApplicantName + '\'' +
                ", AnimalType='" + mAnimalType + '\'' +
                ", HouseholdSize=" + mHouseholdSize +
                ", PetGender=" + mPetGender +
                ", PetAgeCat='" + mPetAgeCat + '\'' +
                ", GoodWithOtherAnimals='" + mGoodWithOtherAnimals + '\'' +
                ", Active='" + mActive + '\'' +
                ", HealthIssues='" + mHealthIssues + '\'' +
                ", Reason='" + mReason + '\'' +
                ", Messy='" + mMessy + '\'' +
                ", Lifespan=" + mLifespan +
                '}';
    }
}
