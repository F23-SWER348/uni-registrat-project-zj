package com.joelle;

import java.util.ArrayList;
import java.util.List;

public class course {
  
    private int courseID;
    private String name;
    private faculty faculty;
    private List<student> studentsEnrolled = new ArrayList<>();
    private int credits;
    private List<lectureTime> schedule = new ArrayList<>();

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
