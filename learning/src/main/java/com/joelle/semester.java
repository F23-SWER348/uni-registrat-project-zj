package com.joelle;

import java.time.LocalDate;

public class semester {
   private int semesterID;
    private LocalDate startDate;
    private LocalDate endDate;

    public semester(int semesterID, LocalDate startDate, LocalDate endDate) {
        this.semesterID = semesterID;
        this.startDate = startDate;
        this.endDate = endDate;
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

