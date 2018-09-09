package com.example.smitlimbani.noticeme5253;

public class UserDetails {
    private String displayName;
    private String dob;
    private String contactNo;
    private String gender;
    private String emailId;
    private String org_id;
    private String user_type;

    public UserDetails() {
    }

    public UserDetails(String displayName, String dob, String contactNo, String gender, String emailId, String org_id, String user_type) {
        this.displayName = displayName;
        this.dob = dob;
        this.contactNo = contactNo;
        this.gender = gender;
        this.emailId = emailId;
        this.org_id = org_id;
        this.user_type = user_type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
