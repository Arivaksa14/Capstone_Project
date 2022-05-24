package com.animalshelter.capstone_project.model;

import javafx.scene.control.DatePicker;

import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;


public class FosterVolunteer extends Volunteer implements Comparable<Volunteer>, Serializable {


    private String mStartDate;
    private String mEndDate;
    private String mHousing;
    private boolean mReliableTransportation;

    @Override
    public int compareTo(Volunteer o) {
        int superComp = super.compareTo(o);
        if(superComp!=0)
            return superComp;

        if(o instanceof FosterVolunteer){
            FosterVolunteer other = (FosterVolunteer) o;
            int startDateComp = this.mStartDate.compareTo(other.mStartDate);
            if(startDateComp!=0)
                return startDateComp;
        }

        return this.getClass().getCanonicalName().compareToIgnoreCase(o.getClass().getCanonicalName());
    }

    public FosterVolunteer(String firstName, String lastName, int age, String formattedPhoneNumber, String email,
                           String city, String reason, String animalType, String availability, String experience,
                           String startDate, String endDate, String housing, boolean reliableTransportation) {
        super(firstName, lastName, age, formattedPhoneNumber, email, city, reason, animalType, availability, experience);
        mStartDate = startDate;
        mEndDate = endDate;
        mHousing = housing;
        mReliableTransportation = reliableTransportation;
    }

    public String getStartDate() {
        return mStartDate;
    }

    public void setStartDate(String startDate) {
        mStartDate = startDate;
    }

    public String getEndDate() {
        return mEndDate;
    }

    public void setEndDate(String endDate) {
        mEndDate = endDate;
    }

    public String getHousing() {
        return mHousing;
    }

    public void setHousing(String housing) {
        mHousing = housing;
    }

    public boolean isReliableTransportation() {
        return mReliableTransportation;
    }

    public void setReliableTransportation(boolean reliableTransportation) {
        mReliableTransportation = reliableTransportation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FosterVolunteer that = (FosterVolunteer) o;
        return mReliableTransportation == that.mReliableTransportation && Objects.equals(mStartDate, that.mStartDate) && Objects.equals(mEndDate, that.mEndDate) && Objects.equals(mHousing, that.mHousing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mStartDate, mEndDate, mHousing, mReliableTransportation);
    }

    @Override
    public String toString() {
        return "Foster Volunteer [" +
                " Start Date = " + mStartDate +
                ", End Date = " + mEndDate +
                ", Housing = " + mHousing +
                ", Reliable Transportation = " + mReliableTransportation +
                ", First Name = " + mFirstName +
                ", Last Name = " + mLastName +
                ", Age = " + mAge +
                ", Phone Number = " + formattedPhoneNumber +
                ", Email= " + mEmail +
                ", City = " + mCity +
                ", Reason = " + mReason +
                ", Animal Preference = " + mAnimalType +
                ", Availability = " + mAvailability +
                ", Foster Experience =" + mExperience +
                " ]";
    }
}
