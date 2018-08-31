package com.example.smitlimbani.noticeme5253;

public class UserDetails {
    private String displayName;
    private String dob;
    private String contactNo;
    private String gender;

    public UserDetails() {
    }

    public UserDetails(String displayName, String lastName, String dob, String contactNo, String gender) {
        this.displayName = displayName;
        this.dob = dob;
        this.contactNo = contactNo;
        this.gender = gender;
    }

    public String getdisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
