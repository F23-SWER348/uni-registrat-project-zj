package com.joelle;

import java.util.List;
import java.util.stream.Collectors;

public class faculty implements user{
  
    private int facultyID;
    private String name;
    private String contactDetails;
    String email;
    String phoneNumber;
String role;
    public faculty(int facultyID, String name, String contactDetails,String role) {
        this.facultyID = facultyID;
        this.name = name;
        this.contactDetails = contactDetails;
        this.role=role;
    }

 

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }



    public void setName(String name) {
        this.name = name;
    }



    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = "facult@kkfgbgb";
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }



    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = "34578558";
    }



    public void setRole(String role) {
        this.role = role;
    }



    public int getFacultyID() {
        return facultyID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getContactDetails() {
    if (email != null && phoneNumber != null) {
        return "Email: " + email + ", Phone: " + phoneNumber;
    } else {
        return "Contact details are incomplete";
    }
}


    @Override
    public UserRole getRole() {
        return UserRole.FACULTY;
    }

public static List<String> getContactDetailsList(List<faculty> staffList) {
        return staffList.stream()
                .map(faculty::getContactDetails)
                .collect(Collectors.toList());
    }

    public void add(faculty faculty) {
    }
}