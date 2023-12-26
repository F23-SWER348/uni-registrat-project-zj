package com.joelle;

import java.util.ArrayList;
import java.util.List;

public class course {
    private int courseID;
    private String name;
    private faculty faculty;
    private List<student> studentsEnrolled ;
    private int credits;
    List<schedule> schedule ;
ArrayList<course> prerequisites ;
public String getName() {
    return name;
}
private schedule courseSchedule;

    public void setCourseSchedule(schedule courseSchedule) {
    this.courseSchedule = courseSchedule;
}


    public course(schedule courseSchedule) {
        this.courseSchedule = courseSchedule;
    }

    public schedule getCourseSchedule() {
        return courseSchedule;
    }


public List<student> getStudentsEnrolled() {
    return studentsEnrolled;
}
public ArrayList<course> getPrerequisites() {
    return prerequisites;
}
public void setPrerequisites(ArrayList<course> prerequisites) {
    this.prerequisites = prerequisites;
}
ArrayList<semester> meetingSemesters;


    
    public List<semester> getMeetingSemesters() {
    return meetingSemesters;
}
public course(int courseID, String name, faculty faculty, List<student> studentsEnrolled , int credits, List<schedule> schedule) { 
    this.courseID = courseID;
    this.name = name;
    this.faculty = faculty;
    this.credits = credits;

    // Initialize the lists
    this.studentsEnrolled = new ArrayList<>(studentsEnrolled != null ? studentsEnrolled : new ArrayList<>());
    this.schedule = new ArrayList<>(schedule != null ? schedule : new ArrayList<>());
    this.prerequisites = new ArrayList<>();
}

   
    

    public void addStudent(student student) {
        studentsEnrolled.add(student);
    }

    public void removeStudent(student student) {
        studentsEnrolled.remove(student);
    }

    
    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return name;
    }
  
  

  
   
   // Constructor and other methods...

   
   public faculty getFaculty() {
        return faculty;
    }

    public int getCredits() {
        return credits;
    }
    public List<schedule> getSchedule() {
        return schedule;
    }

   
}