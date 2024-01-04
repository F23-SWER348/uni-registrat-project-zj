package com.joelle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
//  readddd read = new readddd();
   public  rigstrar r =new rigstrar();
     public student testStudent;
     public course testCourse1, testCourse2,prerequisiteCourse,targetCourse;
          public schedule schedule1, schedule2;

     public staff testStaff;
     public semester testSemester;
          public faculty testFaculty;

//     ArrayList<faculty> fArrayList = read.getFacultyList();
//     ArrayList<schedule> scheduleList = read.getScheduleList();

@Before
public void setUp() {
    r = new rigstrar();  
      testFaculty = new faculty(101, "Dr. Smith", "drsmith@example.com", "9876543210");  // Add a faculty member

    testStudent = new student(1, "Alice", "Computer Science", testFaculty, "alice@example.com", "1234567890");
    testStaff = new staff("S001", "John Doe", "1234567890", "johndoe@example.com");
    testSemester = new semester(1, "Spring 2024", LocalDate.now(), LocalDate.now().plusMonths(4));

    schedule schedule1 = new schedule(1,Arrays.asList(DayOfWeek.MONDAY), LocalTime.of(9, 0), LocalTime.of(10, 0));
    schedule schedule2 = new schedule(2,Arrays.asList(DayOfWeek.MONDAY), LocalTime.of(9, 30), LocalTime.of(10, 30));

    testCourse1 = new course(101, "Intro to Programming", null, 3, schedule1, testSemester);
    testCourse2 = new course(102, "Advanced Programming", null, 3, schedule2, testSemester);


  

}
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
 @Test
    public void testBrowseCourses() {
        // Set up the test data
        List<DayOfWeek> studyDays = Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY);
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(10, 30);
        schedule schedule = new schedule(1,studyDays, startTime, endTime);
        faculty faculty = new faculty(1, "Test Faculty", "email@example.com", "1234567890");
        course course = new course(101, "Test Course", faculty, 3, schedule, new semester(1, "Fall", LocalDate.now(), LocalDate.now().plusMonths(4)));

        // Create an instance of rigstrar and add the course
        rigstrar r = new rigstrar();
        r.getCourses().add(course);

        // Redirect System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the method under test
        r.browseCourses();

        // Verify the output
        String expectedOutput = "Course ID: 101\nCourse Name: Test Course\nFaculty: Test Faculty\nCredits: 3\n------------------------";
        assertTrue(outContent.toString().contains(expectedOutput));

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
  public  void testCreateStaff() {
        staff newStaff = r.createstaff("S001", "John Doe", "1234567890", "johndoe@example.com");
        assertNotNull(newStaff);
        assertTrue(r.getStaffs().contains(newStaff));
    }

    @Test
  public  void testCreateStudent() {
        faculty testFaculty = new faculty(1, "Test Faculty", "1234567890", "faculty@example.com");
        student newStudent = r.createStudent(1, "Alice Smith", "Computer Science", testFaculty, "alice@example.com", "0987654321");
        assertNotNull(newStudent);
        assertTrue(r.getStudents().contains(newStudent));
    }

    @Test
  public  void testCreateFaculty() {
        faculty newFaculty = r.createFaculty(2, "Bob Johnson", "2345678901", "bobj@example.com");
        assertNotNull(newFaculty);
        assertTrue(r.getFacultys().contains(newFaculty));
    }

    @Test
   public void testCreateSemester() {
        semester newSemester = r.createSemester(1, "Spring 2024", LocalDate.now(), LocalDate.now().plusMonths(4));
        assertNotNull(newSemester);
        assertTrue(r.getSemesters().contains(newSemester));
    }

    @Test
  public  void testCreateSchedule() {
        schedule newSchedule = r.createSchedule(3,Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY), LocalTime.of(9, 0), LocalTime.of(10, 30));
        assertNotNull(newSchedule);
        assertTrue(r.getSchedules().contains(newSchedule));
    }

    @Test
  public  void testCreateCourse() {
        faculty testFaculty = new faculty(3, "Eve Adams", "3456789012", "evea@example.com");
        semester testSemester = new semester(2, "Autumn 2024", LocalDate.now(), LocalDate.now().plusMonths(4));
        schedule testSchedule = new schedule(3,Arrays.asList(DayOfWeek.TUESDAY, DayOfWeek.THURSDAY), LocalTime.of(11, 0), LocalTime.of(12, 30));
        course newCourse = r.createCourse(101, "Intro to Programming", testFaculty, 4, testSchedule, testSemester);
        assertNotNull(newCourse);
        assertTrue(r.getCourses().contains(newCourse));
    }

    @Test
 public   void testHasConflict() {
        assertTrue(r.hasConflict(testCourse1, testCourse2));
        schedule nonOverlappingSchedule = new schedule(1,Arrays.asList(DayOfWeek.TUESDAY), LocalTime.of(11, 0), LocalTime.of(12, 0));
        course nonOverlappingCourse = new course(103, "Non Overlapping Course", null, 3, nonOverlappingSchedule, testSemester);
        assertFalse(r.hasConflict(testCourse1, nonOverlappingCourse));
    }
 


    @Test
    public void testCheckPrerequisites() {
        prerequisiteCourse = new course(101, "Intro to Programming", null, 3, schedule1, testSemester);
        targetCourse = new course(102, "Advanced Programming", null, 3, schedule2, testSemester);
    
        // Adding prerequisiteCourse as a prerequisite for targetCourse
        ArrayList<course> prerequisites = new ArrayList<>();
        prerequisites.add(prerequisiteCourse);
        targetCourse.setPrerequisites(prerequisites);
    
        // Assuming testStudent has completed the prerequisiteCourse
        ArrayList<course> completedCourses = new ArrayList<>();
        completedCourses.add(prerequisiteCourse);
        testStudent.setCompletedCourses(completedCourses);
    
        // Debugging information
        System.out.println("Completed Courses: " + testStudent.getCompletedCourses().stream().map(course::getCourseName).collect(Collectors.toList()));
        System.out.println("Prerequisites for targetCourse: " + targetCourse.getPrerequisites().stream().map(course::getCourseName).collect(Collectors.toList()));
    
        // Check if prerequisites are met for targetCourse by testStudent
        assertTrue(r.checkPrerequisites(targetCourse, testStudent));
    }

@Test
public void testViewPrerequisites() {
    ArrayList<course> prerequisites = new ArrayList<>(Arrays.asList(testCourse2)); // Corrected line
    testCourse1.setPrerequisites(prerequisites);
    String output = r.viewPrerequisites(testCourse1);
    // Verify output
    assertTrue(output.contains("Prerequisites for " + testCourse1.getCourseName() + ":"));
    assertTrue(output.contains(testCourse2.getCourseName()));
}

    @Test
  public  void testRegisterStudentForCourse() {
        r.registerStudentForCourse(testStudent, testCourse1);
        // Check if student is registered for the course
        assertTrue(testStudent.getCompletedCourses().contains(testCourse1));
    }
    @Test
public void testAddCourseToStaff() {
    // Ensure testStaff and testCourse1 are initialized properly
    staff testStaff = new staff("StaffID", "StaffName", "StaffEmail", "StaffPhone");
    course testCourse1 = new course(1, "uidhf", testFaculty, 3, schedule1, testSemester);

    r.addCourseToStaff(testStaff, testCourse1);

    // Verify staff teaches the course
    assertTrue(testStaff.getGivescourse().contains(testCourse1));
}

    @Test
    public void testCoursesInSemester() {
        // Add testCourse1 to the courses list in 'r' if not already added
        r.getCourses().add(testCourse1);
    
        List<course> coursesInTestSemester = r.coursesInSemester(testSemester);
    
        // Debugging: Check if courses list in 'r' contains testCourse1
        System.out.println("Courses in 'r': " + r.getCourses());
        System.out.println("Courses in Test Semester: " + coursesInTestSemester);
    
        // Check if the returned list contains testCourse1
        assertTrue(coursesInTestSemester.contains(testCourse1));
    }

    @Test
  public  void testEnterGrades() {
        r.enterGrades(testStudent, testCourse1, 2.0);
        // Assuming there's a way to get grades from student for a course
        assertEquals(2.0, testStudent.getGradeForCourse(testCourse1), 0.01);
    }
   

        }
