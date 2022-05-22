package com.animalshelter.capstone_project.model;

import java.io.Serializable;
import java.util.Objects;

public class Animal implements Serializable {

    protected String mAnimalName;
    protected String mAnimalType;
    protected String mAnimalGender;
    protected String mAnimalAgeCat;

    public Animal(String animalName, String animalType, String animalGender, String animalAgeCat) {
        mAnimalName = animalName;
        mAnimalType = animalType;
        mAnimalGender = animalGender;
        mAnimalAgeCat = animalAgeCat;
    }

    public String getAnimalName() {
        return mAnimalName;
    }

    public void setAnimalName(String animalName) {
        mAnimalName = animalName;
    }

    public String getAnimalType() {
        return mAnimalType;
    }

    public void setAnimalType(String animalType) {
        mAnimalType = animalType;
    }

    public String getAnimalGender() {
        return mAnimalGender;
    }

    public void setAnimalGender(String animalGender) {
        mAnimalGender = animalGender;
    }

    public String getAnimalAgeCat() {
        return mAnimalAgeCat;
    }

    public void setAnimalAgeCat(String animalAgeCat) {
        mAnimalAgeCat = animalAgeCat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return mAnimalGender == animal.mAnimalGender && Objects.equals(mAnimalName, animal.mAnimalName) && Objects.equals(mAnimalType, animal.mAnimalType) && Objects.equals(mAnimalAgeCat, animal.mAnimalAgeCat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mAnimalName, mAnimalType, mAnimalGender, mAnimalAgeCat);
    }

    @Override
    public String toString() {
        return "Animal [" +
                "AnimalName='" + mAnimalName + '\'' +
                ", AnimalType='" + mAnimalType + '\'' +
                ", AnimalGender=" + mAnimalGender +
                ", AnimalAgeCat='" + mAnimalAgeCat + '\'' +
                ']';
    }
}
