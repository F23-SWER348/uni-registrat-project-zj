package com.joelle;

import java.util.ArrayList;
import java.util.List;

public class course {
    private int courseID;
    private String courseName;
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
        return courseName;
    }

    public course(int courseID, String courseName, com.joelle.faculty faculty, List<student> studentsEnrolled,
      int credits, List<lectureTime> schedule) {
      this.courseID = courseID;
      this.courseName = courseName;
      this.faculty = faculty;
      this.studentsEnrolled = studentsEnrolled;
      this.credits = credits;
      this.schedule = schedule;
   }

   public faculty getFaculty() {
        return faculty;
    }

    public int getCredits() {
        return credits;
    }

    public List<lectureTime> getSchedule() {
        return schedule;
    }

    public void addLectureTime(lectureTime lectureTime) {
        schedule.add(lectureTime);
    }
}
