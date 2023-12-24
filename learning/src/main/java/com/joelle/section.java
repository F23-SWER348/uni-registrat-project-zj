package com.joelle;

import java.util.ArrayList;
import java.util.List;

public class section extends course{
   
   
    private int sectionId;
    // other fields and methods...

    
    // Getters and setters

     public section() {
        enrolledStudents = new ArrayList<>();
    }

    private List<student> enrolledStudents;

    private List<schedule> sectionSchedule;

        public section(int courseID, String courseName, int credits, faculty faculty, List<schedule> schedule, List<schedule> sectionSchedule) {
        super(courseID, courseName, credits, faculty, schedule);
        this.sectionSchedule = sectionSchedule;
    }

    public List<schedule> getSectionSchedule() {
        return sectionSchedule;
    }
public int getSectionId() {
        return sectionId;
    }

    public void setSectionSchedule(List<schedule> sectionSchedule) {
        this.sectionSchedule = sectionSchedule;
    }
    public void addStudent(List<student> students) {
        enrolledStudents.addAll(students);
    }
    

    
}
