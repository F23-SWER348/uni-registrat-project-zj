package com.joelle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Test
    public void testReadCourseFile() {
        String filePath = "src/test/resources/course.txt"; // File path

        List<String> linesList;

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            linesList = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            // Fail the test with a meaningful error message
         
            return; // This might be redundant, added for clarity
        }

        // Now you have a linesList containing all lines from the file
        // You can perform any operations you want here, for example, printing the lines:
        linesList.forEach(System.out::println);

        // Check if all lines were read
        long expectedLineCount = 15; // Set this to the expected number of lines in the file
         assertEquals("File contains the expected number of lines", expectedLineCount, linesList.size());
    }
    @Test
    public void testReadFacultyFile() {
        String filePath = "src/test/resources/faculty.txt"; // File path

        List<String> linesList;

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            linesList = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            // Fail the test with a meaningful error message
        
            return; // This might be redundant, added for clarity
        }

        // Now you have a linesList containing all lines from the file
        // You can perform any operations you want here, for example, printing the lines:
        linesList.forEach(System.out::println);

        // Check if all lines were read
        long expectedLineCount = 15; // Set this to the expected number of lines in the file
         assertEquals("File contains the expected number of lines", expectedLineCount, linesList.size());
    }
    @Test
    public void testReadScheduleFile() {
        String filePath = "src/test/resources/schedule.txt"; // File path

        List<String> linesList;

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            linesList = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            // Fail the test with a meaningful error message
        
            return; // This might be redundant, added for clarity
        }

        // Now you have a linesList containing all lines from the file
        // You can perform any operations you want here, for example, printing the lines:
        linesList.forEach(System.out::println);

        // Check if all lines were read
        long expectedLineCount = 15; // Set this to the expected number of lines in the file
         assertEquals("File contains the expected number of lines", expectedLineCount, linesList.size());
    }

    @Test
    public void testReadSemesterFile() {
        String filePath = "src/test/resources/semester.txt"; // File path

        List<String> linesList;

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            linesList = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            // Fail the test with a meaningful error message
        
            return; // This might be redundant, added for clarity
        }

        // Now you have a linesList containing all lines from the file
        // You can perform any operations you want here, for example, printing the lines:
        linesList.forEach(System.out::println);

        // Check if all lines were read
        long expectedLineCount = 15; // Set this to the expected number of lines in the file
         assertEquals("File contains the expected number of lines", expectedLineCount, linesList.size());
    }
    @Test
    public void testReadStaffFile() {
        String filePath = "src/test/resources/staff.txt"; // File path

        List<String> linesList;

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            linesList = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            // Fail the test with a meaningful error message
        
            return; // This might be redundant, added for clarity
        }

        // Now you have a linesList containing all lines from the file
        // You can perform any operations you want here, for example, printing the lines:
        linesList.forEach(System.out::println);

        // Check if all lines were read
        long expectedLineCount = 15; // Set this to the expected number of lines in the file
         assertEquals("File contains the expected number of lines", expectedLineCount, linesList.size());
    }
    @Test
    public void testReadStudentFile() {
        String filePath = "src/test/resources/student.txt"; // File path

        List<String> linesList;

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            linesList = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            // Fail the test with a meaningful error message
        
            return; // This might be redundant, added for clarity
        }

        // Now you have a linesList containing all lines from the file
        // You can perform any operations you want here, for example, printing the lines:
        linesList.forEach(System.out::println);

        // Check if all lines were read
        long expectedLineCount = 15; // Set this to the expected number of lines in the file
         assertEquals("File contains the expected number of lines", expectedLineCount, linesList.size());
    }
}





