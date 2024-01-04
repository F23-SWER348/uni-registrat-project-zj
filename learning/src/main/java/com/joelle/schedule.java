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
   private int id;
    public schedule(int id,List<DayOfWeek> studyDays, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.studyDays = studyDays;
        this.startTime = startTime;
        this.endTime = endTime;
        this.studentsEnrolled = new ArrayList<>();
    }

    public List<DayOfWeek> getStudyDays() {
        return studyDays;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
