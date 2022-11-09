package com.example.employeetestjava.data;

import android.os.Parcelable;

import java.io.Serializable;

public class ProfessionalData  implements Serializable {

    private String company;
    private String designation;
    private String dataOfjoining;
    private String address;
    private ProfileData profileData;

    public ProfessionalData(String company,String designation,String dataOfjoining,String address,ProfileData profileData){
        this.company = company;
        this.designation = designation;
        this.dataOfjoining = dataOfjoining;
        this.address = address;
        this.profileData = profileData;

    }

    public ProfileData getProfileData() {
        return profileData;
    }

    public void setProfileData(ProfileData profileData) {
        this.profileData = profileData;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDataOfjoining() {
        return dataOfjoining;
    }

    public void setDataOfjoining(String dataOfjoining) {
        this.dataOfjoining = dataOfjoining;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
