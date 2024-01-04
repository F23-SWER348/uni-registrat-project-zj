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
ArrayList<course> prerequisites ;
semester semester;
staff staff;
public staff getStaff() {
    return staff;
}

public void setStaff(staff staff) {
    this.staff = staff;
}

public schedule getSchedule() {
        return schedule;
    }

    public semester getSemester() {
    return semester;
}

public void setSemester(semester semester) {
    this.semester = semester;
}

    public synchronized void setSchedule(schedule schedule) {
        this.schedule = schedule;
    }
public String getName() {
    return name;
}

public List<student> getStudentsEnrolled() {
    return studentsEnrolled;
}
public ArrayList<course> getPrerequisites() {
    return prerequisites;
}
public synchronized  void setPrerequisites(ArrayList<course> prerequisites) {
    this.prerequisites = prerequisites;
}

     public void addStudent(student student) {
        studentsEnrolled.add(student);
    }

public course(int courseID, String name, faculty faculty, int credits,schedule schedule,semester semester) { 
    this.courseID = courseID;
    this.name = name;
    this.faculty = faculty;
    this.credits = credits;
    this.schedule= schedule;
    this.semester= semester;
    this.studentsEnrolled =new ArrayList<>();
}
    
    public synchronized void removeStudent(student student) {
        studentsEnrolled.remove(student);
    }

    
    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return name;
    }
   
   public faculty getFaculty() {
        return faculty;
    }

    public int getCredits() {
        return credits;
    } 
}