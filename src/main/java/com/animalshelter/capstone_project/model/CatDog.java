package com.animalshelter.capstone_project.model;

import java.io.Serializable;
import java.util.Objects;

public class CatDog extends Animal implements Serializable {

    private String mIndoorOrOutdoor;
    private String mTrained;
    private String mGoodWithOtherAnimals;
    private String mActive;

    public CatDog(String animalName, String animalType, char animalGender, String animalAgeCat, String indoorOrOutdoor, String trained, String goodWithOtherAnimals, String active) {
        super(animalName, animalType, animalGender, animalAgeCat);
        mIndoorOrOutdoor = indoorOrOutdoor;
        mTrained = trained;
        mGoodWithOtherAnimals = goodWithOtherAnimals;
        mActive = active;
    }

    public String getIndoorOrOutdoor() {
        return mIndoorOrOutdoor;
    }

    public void setIndoorOrOutdoor(String indoorOrOutdoor) {
        mIndoorOrOutdoor = indoorOrOutdoor;
    }

    public String getTrained() {
        return mTrained;
    }

    public void setTrained(String trained) {
        mTrained = trained;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CatDog catDog = (CatDog) o;
        return Objects.equals(mIndoorOrOutdoor, catDog.mIndoorOrOutdoor) && Objects.equals(mTrained, catDog.mTrained) && Objects.equals(mGoodWithOtherAnimals, catDog.mGoodWithOtherAnimals) && Objects.equals(mActive, catDog.mActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mIndoorOrOutdoor, mTrained, mGoodWithOtherAnimals, mActive);
    }

    @Override
    public String toString() {
        return "Cat/Dog [" +
                "AnimalName='" + mAnimalName + '\'' +
                ", AnimalType='" + mAnimalType + '\'' +
                ", AnimalGender=" + mAnimalGender +
                ", AnimalAgeCat='" + mAnimalAgeCat + '\'' +
                ", IndoorOrOutdoor='" + mIndoorOrOutdoor + '\'' +
                ", Trained='" + mTrained + '\'' +
                ", GoodWithOtherAnimals='" + mGoodWithOtherAnimals + '\'' +
                ", Active='" + mActive + '\'' +
                ']';
    }
}
