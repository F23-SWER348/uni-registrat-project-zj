package com.joelle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class semester {
   private int semesterID;
    private LocalDate startDate;
    private LocalDate endDate;
    String name;
    private ArrayList<course> coursesinsemester;
    public semester(int semesterID, String name,LocalDate startDate, LocalDate endDate) {
        this.semesterID = semesterID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.name=name;
        this.coursesinsemester=new ArrayList<course>();
    }

    public synchronized void setSemesterID(int semesterID) {
        this.semesterID = semesterID;
    }

    public synchronized void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public synchronized void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public int getSemesterID() {
        return semesterID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ArrayList<course> getCoursesinsemester() {
        return coursesinsemester;
    }

    public void setCoursesinsemester(ArrayList<course> coursesinsemester) {
        this.coursesinsemester = coursesinsemester;
    }

}  

