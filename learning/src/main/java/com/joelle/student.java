package com.joelle;

import java.util.HashMap;
import java.util.Map;

public class student implements user {
    private int id;
    private String name;
    private String major;
    private double gpa;
String contactDetails;
 String role;
    private static long count = 1;
    private Map<course, Double> grades = new HashMap<>();
        private Map<course, Double> gradess = new HashMap<>();

        public student(int id, String name, String contactDetails, String role, String major) {
            this.id = id;
            this.name = name;
            this.contactDetails = contactDetails;
            this.role = role;
            this.major = major;
        }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static void setCount(long count) {
        student.count = count;
    }

    public Map<course, Double> getGrades() {
        return grades;
    }

    public void setGrades(Map<course, Double> grades) {
        this.grades = grades;
    }

    public Map<course, Double> getGradess() {
        return gradess;
    }

    public void setGradess(Map<course, Double> gradess) {
        this.gradess = gradess;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {

        this.gpa = gpa;
    }
  

    @Override
    public String toString() {        
        return name + " " + major + " " + gpa;
    }

    public static long getCount() {
        return count;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContactDetails'");
    }
    @Override
    public UserRole getRole() {
        return UserRole.STUDENT;
        // TODO Auto-generated method stub
    }
    
}
    

