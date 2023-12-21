package com.joelle;


public class faculty implements user{
  
    private int facultyID;
    private String name;
    private String contactDetails;
String role;
    public faculty(int facultyID, String name, String contactDetails,String role) {
        this.facultyID = facultyID;
        this.name = name;
        this.contactDetails = contactDetails;
        this.role=role;
    }

 

    public int getFacultyID() {
        return facultyID;
    }

    public String getName() {
        return name;
    }

    public String getContactDetails() {
        return this.contactDetails;
    }



    @Override
    public UserRole getRole() {
        return UserRole.FACULTY;
    }



    public void add(faculty faculty) {
    }
}