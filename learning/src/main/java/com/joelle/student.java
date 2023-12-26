package com.joelle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class student implements user {
    private int id;
    private String name;
    List<schedule> schedule;
    private String major;
    private double gpa;
    String role;
    private String email;
    private String phoneNumber;
    private List<course> completedCourses=new ArrayList<>();
    private Map<course, Double> gradess = new HashMap<>();
    private faculty faculty;




    public List<schedule> getSchedule() {
        return schedule;
    }
    public void setSchedule(List<schedule> schedule) {
        this.schedule = schedule;
    }
   
    public List<course> getCompletedCourses() {
        return completedCourses;
    }
    
  
        public student(int id, String name, String major,faculty faculty,String email,String phoneNumber) {
            this.id = id;
            this.name = name;
            this.major = major;
            this.faculty = faculty;
            this.email = email;
            this.phoneNumber = phoneNumber;

    }

        
         public void setFaculty(faculty faculty) {
        this.faculty = faculty;
    }
     public faculty getFaculty() {
        return faculty;
    }
    public void setId(int id) {
        this.id = id;
    }

    public synchronized void  setRole(String role) {
        this.role = role;
    }

   



    public Map<course, Double> getGradess() {
        return gradess;
    }

    public String getEmail() {
        return email;
    }

 

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public synchronized void setGradess(Map<course, Double> gradess) {
        this.gradess = gradess;
    }

    public String getName() {
        return name;
    }
  
    public String getMajor() {
        return major;
    }
  
    public double getGpa() {
        return gpa;
    }

    public synchronized void setGpa(double gpa) {

        this.gpa = gpa;
    }
public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.id == ((student)obj).getId())
            return true;
        return false;
    }
    @Override
    public String getContactDetails() {
    if (email != null && phoneNumber != null) {
        return "Email: " + email + ", Phone: " + phoneNumber;
    } else {
        return "Contact details are incomplete";
    }
}

 public static List<String> getContactDetailsList(List<student> staffList) {
        return staffList.stream()
                .map(student::getContactDetails)
                .collect(Collectors.toList());
    }
    @Override
    public UserRole getRole() {
        return UserRole.STUDENT;
    }
    
}
    

