package com.joelle;

import java.time.LocalDate;

public class semester {
   private int semesterID;
    private LocalDate startDate;
    private LocalDate endDate;
String name;
    public semester(int semesterID, String name,LocalDate startDate, LocalDate endDate) {
        this.semesterID = semesterID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.name=name;
    }

    public void setSemesterID(int semesterID) {
        this.semesterID = semesterID;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
}  

