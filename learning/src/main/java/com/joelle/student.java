package com.joelle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class student implements user {
    private int id;
    private String name;
   

   
    private String major;
    private double gpa;
String contactDetails;
 String role;
 private String email;
 private String phoneNumber;
    private static long count = 1;
    private Map<course, Double> grades = new HashMap<>();
        private Map<course, Double> gradess = new HashMap<>();
private faculty faculty;
        public student(int id, String name, String contactDetails, String major,faculty faculty) {
            this.id = id;
            this.name = name;
            this.contactDetails = contactDetails;
            this.major = major;
            this.faculty = faculty;

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

    public synchronized void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public synchronized void  setRole(String role) {
        this.role = role;
    }

    public static synchronized void setCount(long count) {
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

    public String getEmail() {
        return "stu123@betleem.edu";
    }

    public void setEmail(String email) {
        this.email = "stu123@betleem.edu";
    }

    public String getPhoneNumber() {
        return "05987545";
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = "05987545";
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
    

