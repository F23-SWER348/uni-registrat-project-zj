package com.joelle;

import java.util.ArrayList;
import java.util.List;

public class course {
    private int courseID;
    private String name;
    private faculty faculty;
    private List<student> studentsEnrolled =new ArrayList<>();
    private int credits;
    schedule schedule ;
public schedule getSchedule() {
        return schedule;
    }


    public void setSchedule(schedule schedule) {
        this.schedule = schedule;
    }
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
public course(int courseID, String name, faculty faculty, int credits,List<student> studentsEnrolled, schedule schedule) { 
    this.courseID = courseID;
    this.name = name;
    this.faculty = faculty;
    this.credits = credits;
    this.studentsEnrolled = studentsEnrolled;
    this.schedule= schedule;
    // Initialize the lists
   
}
   
    

    public course(int courseID2, String name2, int credits2, com.joelle.faculty faculty2,
        com.joelle.schedule schedule2) {
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
   

   
}