package com.animalshelter.capstone_project.model;

import java.io.Serializable;
import java.util.Objects;

public class CatDog extends Animal implements Comparable<Animal>, Serializable {

    private String mIndoorOrOutdoor;
    private String mTrained;
    private String mGoodWithOtherAnimals;
    private String mActive;

    public CatDog(String animalName, String animalType, String animalGender, String animalAgeCat, String indoorOrOutdoor, String trained, String goodWithOtherAnimals, String active) {
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
                "Animal Name = " + mAnimalName +
                ", Animal Type = " + mAnimalType +
                ", Animal Gender = " + mAnimalGender +
                ", Animal Age Category = " + mAnimalAgeCat +
                ", Indoor Or Outdoor = " + mIndoorOrOutdoor +
                ", Trained = " + mTrained +
                ", Good With Other Animals = " + mGoodWithOtherAnimals +
                ", Active = " + mActive +
                ']';
    }


    @Override
    public int compareTo(Animal o) {
        int superComp = super.compareTo(o);
        if(superComp != 0)
            return superComp;
        if(o instanceof CatDog) {
            CatDog other = (CatDog) o;
            int trainedComp = this.mTrained.compareTo(other.mTrained);
            if(trainedComp !=0)
                return trainedComp;
            int goodWithOtherAnimalsComp = this.mGoodWithOtherAnimals.compareTo(other.mGoodWithOtherAnimals);
            if(goodWithOtherAnimalsComp !=0)
                return goodWithOtherAnimalsComp;
        }
        return this.getClass().getCanonicalName().compareToIgnoreCase(o.getClass().getCanonicalName());

    }
}
