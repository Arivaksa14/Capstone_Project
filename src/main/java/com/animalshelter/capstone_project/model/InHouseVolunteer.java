package com.animalshelter.capstone_project.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class InHouseVolunteer extends Volunteer implements Comparable<Volunteer>, Serializable {


    private String mLocation;
    private String mDate;

    @Override
    public int compareTo(Volunteer o) {
        int superComp = super.compareTo(o);
        if(superComp!=0)
            return superComp;

        if(o instanceof InHouseVolunteer){
            InHouseVolunteer other = (InHouseVolunteer) o;
            int locationComp = this.mLocation.compareTo(other.mLocation);
            if(locationComp!=0)
                return locationComp;
        }
        return this.getClass().getCanonicalName().compareToIgnoreCase(o.getClass().getCanonicalName());
    }

    public InHouseVolunteer(String firstName, String lastName, int age, String formattedPhoneNumber,
                            String email, String city, String reason, String animalType,
                            String availability, String experience, String location,
                            String date) {
        super(firstName, lastName, age, formattedPhoneNumber, email, city, reason, animalType, availability, experience);
        mLocation = location;
        mDate = date;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InHouseVolunteer that = (InHouseVolunteer) o;
        return Objects.equals(mLocation, that.mLocation) && Objects.equals(mDate, that.mDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mLocation, mDate);
    }

    @Override
    public String toString() {
        return "InHouseVolunteer{" +
                "mLocation='" + mLocation + '\'' +
                ", mDate='" + mDate + '\'' +
                ", mFirstName='" + mFirstName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                ", mAge=" + mAge +
                ", formattedPhoneNumber='" + formattedPhoneNumber + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mCity='" + mCity + '\'' +
                ", mReason='" + mReason + '\'' +
                ", mAnimalType='" + mAnimalType + '\'' +
                ", mAvailability='" + mAvailability + '\'' +
                ", mExperience='" + mExperience + '\'' +
                '}';
    }
}
