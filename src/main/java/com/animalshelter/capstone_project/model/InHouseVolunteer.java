/**
 * Represents abstract InHouseVolunteer Class
 *
 * @author Jorge Garcia
 *
 **/

/** UML CLASS DIAGRAM:
 -----------------------------------------
 InHouseVolunteer
 -----------------------------------------
 <data, i.e. variables>
 - mLocation: String
 - mDate: String
 - mNickName: String
 - mWalking: boolean
 -----------------------------------------
 <actions, i.e. methods>
 + Full Constructor FosterVolunteer(firstName: String, lastName: String, age: int, formattedPhoneNumber: String,
                             email: String, city: String, reason: String, animalType: String,
                             availability: String, experience: String, startDate: String,
                             location: String, nickName: String, walking: boolean)
 +
 + compareTo(o: Volunteer) : int
 +
 + getLocation() : String
 + getDate() : String
 + getNickName() : String
 + isWalking(): boolean
 +
 + setLocation(startDate: String) : void
 + setDate(endDate: String) : void
 + setNickName(housing: String) : void
 + setWalking(reliableTransportation: boolean) : void
 +
 + equals (o: Object): Boolean
 + hashCode() : int
 + toString(): String
 --------------------------------------------------------------
 */

package com.animalshelter.capstone_project.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class InHouseVolunteer extends Volunteer implements Comparable<Volunteer>, Serializable {

    /***** INSTANCE VARIABLES *****/
    private String mLocation;
    private String mDate;
    private String mNickName;
    private boolean mWalking;

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

    /***** CONSTRUCTOR *****/
    public InHouseVolunteer(String firstName, String lastName, int age, String formattedPhoneNumber, String email,
                            String city, String reason, String animalType, String availability, String experience,
                            String location, String date, String nickName, boolean walking) {
        super(firstName, lastName, age, formattedPhoneNumber, email, city, reason, animalType, availability, experience);
        mLocation = location;
        mDate = date;
        mNickName = nickName;
        mWalking = walking;
    }

    /***** ACCESSORS *****/
    public String getLocation() {
        return mLocation;
    }
    public String getDate() {
        return mDate;
    }
    public String getNickName() {
        return mNickName;
    }
    public boolean isWalking() {
        return mWalking;
    }

    /***** MUTATORS *****/
    public void setLocation(String location) {
        mLocation = location;
    }
    public void setDate(String date) {
        mDate = date;
    }
    public void setNickName(String nickName) {
        mNickName = nickName;
    }
    public void setWalking(boolean walking) {
        mWalking = walking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InHouseVolunteer that = (InHouseVolunteer) o;
        return mWalking == that.mWalking && Objects.equals(mLocation, that.mLocation) &&
                Objects.equals(mDate, that.mDate) && Objects.equals(mNickName, that.mNickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mLocation, mDate, mNickName, mWalking);
    }

    @Override
    public String toString() {
        return "In House Volunteer [ " +
                " Name: " + mFirstName +
                " " + mLastName +
                ", Age: " + mAge +
                ", Phone Number: " + formattedPhoneNumber +
                ", Email: " + mEmail +
                ", City: " + mCity +
                ", Reason: " + mReason +
                ", Animal Preference: " + mAnimalType +
                ", Availability: " + mAvailability +
                ", Foster Experience: " + mExperience +
                ", Location: " + mLocation +
                ", Volunteer Date: " + mDate +
                ", NickName: " + mNickName +
                ", Walking " + mWalking +
                " ]";
    }
}

