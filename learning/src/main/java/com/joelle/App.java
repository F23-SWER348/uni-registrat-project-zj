package com.joelle;

import java.time.LocalDate;

// import java.time.DayOfWeek;
// import java.time.LocalDate;
// import java.time.LocalTime;
// import java.time.Month;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

rigstrar registrar = new rigstrar();

    // Create a faculty
    faculty f = registrar.createFaculty(1, null, null, null);
    // Create a semester
    semester s = registrar.createSemester(0, null, null, null);
    // Create two courses
    course c1 = registrar.createCourse(2, null, f, 3, null, s);
    course c2 = registrar.createCourse(1, null, f, 2, null, s);

    // Create a student
    student student = registrar.createStudent(1, null, null, f, null, null);
    // Enter grades for the courses
    registrar.enterGrades(student, c1, 3.0);
    registrar.enterGrades(student, c2, 3.5);

    // Calculate GPA (assuming this method is correctly implemented)
    double gpa = registrar.calculateGPA(student);

    System.out.println(gpa);
System.out.println(registrar.generateAcademicReport(student));



        
    }
}
    