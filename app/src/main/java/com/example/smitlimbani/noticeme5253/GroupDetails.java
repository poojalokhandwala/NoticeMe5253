package com.example.smitlimbani.noticeme5253;

public class GroupDetails {
    private String group_admin;
    private String group_name;
    private String org_id;
    private String org_name;

    public GroupDetails() {
    }

    public GroupDetails(String group_admin, String group_name, String org_id, String org_name) {
        this.group_admin = group_admin;
        this.group_name = group_name;
        this.org_id = org_id;
        this.org_name = org_name;
    }

    public String getGroup_admin() {
        return group_admin;
    }

    public void setGroup_admin(String group_admin) {
        this.group_admin = group_admin;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }
}
