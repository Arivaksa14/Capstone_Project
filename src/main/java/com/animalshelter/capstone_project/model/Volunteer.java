/**
 * Represents abstract Volunteer Class
 *
 * @author Jorge Garcia
 *
 **/

/** UML CLASS DIAGRAM:
 -----------------------------------------
 Volunteer
 -----------------------------------------
 <data, i.e. variables>
 # mFirstName: String
 # mLastName: String
 # mAge: int
 # mEmail: String
 # mReason: String
 # mAnimalType: String
 # mAvailability: String
 # mExperience: String
 #
 # currency: NumberFormat
 # number: NumberFormat
 -----------------------------------------
 <actions, i.e. methods>
 + Full Constructor Volunteer(firstName: String, lastName: String, age: int, formattedPhoneNumber: String,
                     email: String, city: String, reason: String, animalType: String,
                     availability: String, experience: String)
 +
 + compareTo(other: Volunteer) : int
 +
 + getFirstName() : String
 + getLastName() : String
 + getAge() : int
 + getFormattedPhoneNumber(): String
 + getEmail(): String
 + getCity(): String
 + getReason(): String
 + getAnimalType(): String
 + getAvailability(): String
 + getExperience(): String
 +
 + setFirstName(firstName: String) : void
 + setLastName(lastName: String) : void
 + setAge(age: int) : void
 + setFormattedPhoneNumber(formattedPhoneNumber: String) : void
 + setEmail(email: String) : void
 + setCity(city: String) : void
 + setReason(reason: String) : void
 + setAnimalType(animalType: String) : void
 + setAvailability(availability: String) : void
 + setExperience(experience: String) : void
 +
 + equals (o: Object): Boolean
 + hashCode() : int
 --------------------------------------------------------------
 */

package com.animalshelter.capstone_project.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Objects;

public abstract class Volunteer implements Comparable<Volunteer>, Serializable {

    /***** STATIC VARIABLES *****/
    protected static NumberFormat currency = NumberFormat.getCurrencyInstance();
    protected static NumberFormat number = NumberFormat.getNumberInstance();

    /***** INSTANCE VARIABLES *****/
    protected String mFirstName;
    protected String mLastName;
    protected int mAge;
    protected String formattedPhoneNumber;// = String.valueOf(mPhoneNumber).replaceFirst ("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
    protected String mEmail;
    protected String mCity;
    protected String mReason;
    protected String mAnimalType;
    protected String mAvailability;
    protected String mExperience;

    /***** CONSTRUCTOR *****/
    public Volunteer(String firstName, String lastName, int age, String formattedPhoneNumber,
                     String email, String city, String reason, String animalType,
                     String availability, String experience) {
        mFirstName = firstName;
        mLastName = lastName;
        mAge = age;
        this.formattedPhoneNumber = formattedPhoneNumber;
        mEmail = email;
        mCity = city;
        mReason = reason;
        mAnimalType = animalType;
        mAvailability = availability;
        mExperience = experience;
    }

    @Override
    public int compareTo(Volunteer other) {
        return this.mAnimalType.compareTo(other.mAnimalType);
    }
    /***** ACCESSORS *****/
    public String getFirstName() {
        return mFirstName;
    }
    public String getLastName() {
        return mLastName;
    }
    public int getAge() {
        return mAge;
    }
    public String getFormattedPhoneNumber() {
        return formattedPhoneNumber;
    }
    public String getEmail() {
        return mEmail;
    }
    public String getCity() {
        return mCity;
    }
    public String getReason() {
        return mReason;
    }
    public String getAnimalType() {
        return mAnimalType;
    }
    public String getAvailability() {
        return mAvailability;
    }
    public String getExperience() {
        return mExperience;
    }

    /***** MUTATORS *****/
    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }
    public void setLastName(String lastName) {
        mLastName = lastName;
    }
    public void setAge(int age) {
        mAge = age;
    }
    public void setFormattedPhoneNumber(String formattedPhoneNumber) {
        this.formattedPhoneNumber = formattedPhoneNumber;
    }
    public void setEmail(String email) {
        mEmail = email;
    }
    public void setCity(String city) {
        mCity = city;
    }
    public void setReason(String reason) {
        mReason = reason;
    }
    public void setAnimalType(String animalType) {
        mAnimalType = animalType;
    }
    public void setAvailability(String availability) {
        mAvailability = availability;
    }
    public void setExperience(String experience) {
        mExperience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volunteer volunteer = (Volunteer) o;
        return mAge == volunteer.mAge && Objects.equals(mFirstName, volunteer.mFirstName) &&
                Objects.equals(mLastName, volunteer.mLastName) &&
                Objects.equals(formattedPhoneNumber, volunteer.formattedPhoneNumber) &&
                Objects.equals(mEmail, volunteer.mEmail) && Objects.equals(mCity, volunteer.mCity) &&
                Objects.equals(mReason, volunteer.mReason) && Objects.equals(mAnimalType, volunteer.mAnimalType) &&
                Objects.equals(mAvailability, volunteer.mAvailability) &&
                Objects.equals(mExperience, volunteer.mExperience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mFirstName, mLastName, mAge, formattedPhoneNumber, mEmail, mCity, mReason, mAnimalType, mAvailability, mExperience);
    }
}
