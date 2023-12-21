package com.joelle;

import java.util.ArrayList;
import java.util.List;

public class course {
    private int courseID;
    private String name;
    private faculty faculty;
    private List<student> studentsEnrolled = new ArrayList<>();
    private int credits;
    List<schedule> schedule ;
List<String> prerequisites ;
List<semester> meetingSemesters;
    public course(int courseID, String name, faculty faculty, List<student> studentsEnrolled , int credits, List<schedule> schedule) { 
        this.courseID = courseID;
        this.name = name;
        this.faculty = faculty;
        this.studentsEnrolled = studentsEnrolled;
        this.credits = credits;
        this.schedule = schedule;
    }
    public course(int courseID2, String name2, int credits2, com.joelle.faculty faculty2,
            List<com.joelle.schedule> schedule2) {
    }
    public void addStudent(student student) {
        studentsEnrolled.add(student);
    }

    public void removeStudent(student student) {
        studentsEnrolled.remove(student);
    }

    public List<student> listEnrolledStudents() {
        return studentsEnrolled;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return name;
    }

  
   
   // Constructor and other methods...

   public List<String> getPrerequisites() {
       return prerequisites;
   }
   public faculty getFaculty() {
        return faculty;
    }

    public int getCredits() {
        return credits;
    }

    // public List<schedule> getSchedule() {
    //     return schedule();
    // }

    // public void addLectureTime(schedule lectureTime) {
    //     schedule.add(lectureTime);
    // }
}
