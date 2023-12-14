package com.joelle;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class rigstrar  {
String name;
Integer rigstrarID;
ArrayList<String> listofcontactdetail = new ArrayList<>();
//index0 name
//index1 email
//index2 phonenumber
private Map<student, List<course>> registeredStudents = new HashMap<>();
   

public void registerStudentForCourse(student student, course course) {
    // Add logic to register a student for a course
    registeredStudents.computeIfAbsent(student, k -> new ArrayList<>()).add(course);}

//method that fills the map 


public rigstrar(String staffID, String name, String position, String department, double salary) {
}

public void createStudent(String name, String contactDetails) {
// Add logic to create a new student
}

public void createFaculty(String name, String contactDetails) {
// Add logic to create a new faculty member
}

public void createSemester(int semesterID, LocalDate startDate, LocalDate endDate) {
// Add logic to create a new semester
}

public void createCourse(int courseID, String name, int credits, faculty faculty, List<lectureTime> schedule) {
// Add logic to create a new course (logic of conflict) 
}

public void browseCourses() {
// Add logic to browse available courses
}



public void enterGrades(student student, course course, double Grade ) {
// Add logic to enter grades for a student in a course
}

public void generateAcademicReport(student student) {
// Add logic to generate academic report for a student
}

// Additional methods related to Registrar's activities
// For example: validatePrerequisites(), notifyScheduleConflict(), etc.
}



