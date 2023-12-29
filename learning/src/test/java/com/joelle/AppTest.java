package com.joelle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
   @Test
public void testcalculategpa() {
    // Create an instance of the Registrar class
    rigstrar registrar = new rigstrar();

    // Create a faculty
    faculty f = new faculty(1, "John Faculty", "faculty@university.com", null);

    // Create a semester
    semester s = new semester(1, null, LocalDate.now(), LocalDate.now().plusMonths(4));

    // Create two courses
    course c1 = new course(1, "Course 1", f, 3, null, s);
    course c2 = new course(2, "Course 2", f, 2, null, s);

    // Create a student
    student student = new student(1, "John", "Software Engineering", f, "john@example.com", "1234-5678-9101");

    // Enter grades for the courses
    registrar.enterGrades(student, c1, 3.0);
    registrar.enterGrades(student, c2, 3.5);

    // Calculate GPA (assuming this method is correctly implemented)
    double gpa = registrar.calculateGPA(student);
    // Assert the expected result based on the calculated GPA
    assertEquals(3.2, gpa, 0.01);
}
 @Test
public void testgenerateacademicreport() {
    // Create an instance of the Registrar class
    rigstrar registrar = new rigstrar();

  // Create an instance of the Registrar class

// Create a faculty
faculty f = registrar.createFaculty(1, "John Faculty", "faculty@university.com", "Computer Science");

// Create a semester
semester s = registrar.createSemester(1, "fall",LocalDate.now(), LocalDate.now().plusMonths(4));

// Create two courses
course c1 = registrar.createCourse(1, "Course 1", f, 3,null, s);
course c2 = registrar.createCourse(2, "Course 2", f, 2,null, s);

// Note: The above assumes that createFaculty, createSemester, and createCourse methods are implemented in the Registrar class.


    // Create a student
student student = registrar.createStudent(1, null, null, f, null, null);
    // Enter grades for the courses
    registrar.enterGrades(student, c1, 3.0);
    registrar.enterGrades(student, c2, 3.5);

    // Calculate GPA (assuming this method is correctly implemented)
    double gpa = registrar.calculateGPA(student);
    String res = registrar.generateAcademicReport(student);
    // Assert the expected result based on the calculated GPA
    assertEquals("Good Standing", res);
}

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue(){
        assertTrue( true );
    }
}