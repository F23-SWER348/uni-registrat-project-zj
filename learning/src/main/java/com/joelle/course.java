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
private List<section> sections;




    public List<section> getSections() {
    return sections;
}
    public List<semester> getMeetingSemesters() {
    return meetingSemesters;
}
    public course(int courseID, String name, faculty faculty, List<student> studentsEnrolled , int credits, List<schedule> schedule) { 
        this.courseID = courseID;
        this.name = name;
        this.faculty = faculty;
        this.studentsEnrolled = studentsEnrolled;
        this.credits = credits;
        this.schedule = schedule;
    }
    public course() {
        sections = new ArrayList<>();
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
    public void addSection(section section) {
        sections.add(section);
    }
    public section getOrCreateSection() {
        // Check if a section already exists for the course
        if (sections.isEmpty()) {
            // If no section exists, create a new one and add it to the list of sections
            section newSection = new section();
            sections.add(newSection);
            return newSection;
        } else {
            // If a section exists, return the first one (you might need to refine this logic)
            return sections.get(0);
        }
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
    public List<schedule> getSchedule() {
        return schedule;
    }

   
    }