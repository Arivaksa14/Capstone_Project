package com.animalshelter.capstone_project.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Objects;

public abstract class Volunteer implements Comparable<Volunteer>, Serializable {

    protected static NumberFormat currency = NumberFormat.getCurrencyInstance();
    protected static NumberFormat number = NumberFormat.getNumberInstance();

    @Override
    public int compareTo(Volunteer other) {
        return this.mAnimalType.compareTo(other.mAnimalType);
    }

    protected String mFirstName;
    protected String mLastName;
    protected int mAge;
    protected Long mPhoneNumber;
    protected String formattedPhoneNumber = String.valueOf(mPhoneNumber).replaceFirst
            ("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
    protected String mEmail;
    protected String mCity;
    protected String mReason;
    protected String mAnimalType;
    protected String mAvailability;
    protected String mExperience;

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

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }

    public Long getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public String getFormattedPhoneNumber() {
        return formattedPhoneNumber;
    }

    public void setFormattedPhoneNumber(String formattedPhoneNumber) {
        this.formattedPhoneNumber = formattedPhoneNumber;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getReason() {
        return mReason;
    }

    public void setReason(String reason) {
        mReason = reason;
    }

    public String getAnimalType() {
        return mAnimalType;
    }

    public void setAnimalType(String animalType) {
        mAnimalType = animalType;
    }

    public String getAvailability() {
        return mAvailability;
    }

    public void setAvailability(String availability) {
        mAvailability = availability;
    }

    public String getExperience() {
        return mExperience;
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
                Objects.equals(mPhoneNumber, volunteer.mPhoneNumber) &&
                Objects.equals(formattedPhoneNumber, volunteer.formattedPhoneNumber) &&
                Objects.equals(mEmail, volunteer.mEmail) && Objects.equals(mCity, volunteer.mCity) &&
                Objects.equals(mReason, volunteer.mReason) && Objects.equals(mAnimalType, volunteer.mAnimalType) &&
                Objects.equals(mAvailability, volunteer.mAvailability) &&
                Objects.equals(mExperience, volunteer.mExperience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mFirstName, mLastName, mAge, mPhoneNumber, formattedPhoneNumber, mEmail, mCity, mReason, mAnimalType, mAvailability, mExperience);
    }
}
