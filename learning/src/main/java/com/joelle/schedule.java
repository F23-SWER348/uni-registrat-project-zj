package com.joelle;

import java.time.DayOfWeek;



import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class schedule {
    private List<DayOfWeek> studyDays;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<student> studentsEnrolled = new ArrayList<>();
    
    public schedule(List<DayOfWeek> studyDays, LocalTime startTime, LocalTime endTime) {
        this.studyDays = studyDays;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public List<DayOfWeek> getStudyDays() {
        return studyDays;
    }
    public synchronized void addStudents(List<student> students) {
        studentsEnrolled.addAll(students);
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String checkStudyDay(DayOfWeek day) {
        if (studyDays.contains(day)) {
            return "There are lectures on this day.";
        } else {
            return "There are no lectures on this day.";
        }
      }

      public List<student> listEnrolledStudents() {
        return studentsEnrolled;
    }
}
