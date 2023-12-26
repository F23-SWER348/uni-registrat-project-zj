package com.joelle;

import java.util.List;
import java.util.stream.Collectors;

public class faculty implements user{
  
    private int facultyID;
    private String name;
    String email;
    String phoneNumber;
String role;
    public faculty(int facultyID, String name,String email, String phoneNumber,String role) {
        this.facultyID = facultyID;
        this.name = name;
        this.role=role;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

 

    public synchronized void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }



    public synchronized void setName(String name) {
        this.name = name;
    }




    public String getEmail() {
        return email;
    }



    public synchronized String getPhoneNumber() {
        return phoneNumber;
    }




    public synchronized void setRole(String role) {
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