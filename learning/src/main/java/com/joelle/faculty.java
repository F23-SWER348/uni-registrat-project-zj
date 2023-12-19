package com.joelle;


public class faculty implements user{
  
    private int facultyID;
    private String name;
    private String contactDetails;

    public faculty(int facultyID, String name, String contactDetails) {
        this.facultyID = facultyID;
        this.name = name;
        this.contactDetails = contactDetails;
    }

 

    public int getFacultyID() {
        return facultyID;
    }

    public String getName() {
        return name;
    }

    public String getContactDetails() {
        return contactDetails;
    }



    @Override
    public UserRole getRole() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRole'");
    }
}