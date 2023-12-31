package com.joelle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
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

        List<String> linesList = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            linesList.add(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
        return;
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

    List<String> linesList = new ArrayList<>();

    try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            linesList.add(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
        return;
    }

    // List to store faculty members
    List<faculty> facultyList = new ArrayList<>();

    // Now you have a linesList containing all lines from the file
    linesList.forEach(line -> {
        // Split the line by comma or any other delimiter if needed
        String[] values = line.split(",");

        // Extract values and create a faculty object
        int facultyID = Integer.parseInt(values[0]);
        String name = values[1];
        String email = values[2];
        String phoneNumber = values[3];

        // Create a faculty object
        faculty faculty = new faculty(facultyID, name, email, phoneNumber);

        // Add the faculty object to the facultyList
        facultyList.add(faculty);

        // Perform necessary assertions here or use the facultyList in other tests
        assertNotNull(faculty);
    });

    // Check if all lines were read
    long expectedLineCount = 15; // Set this to the expected number of lines in the file
    assertEquals("File contains the expected number of lines", expectedLineCount, linesList.size());
}
   @Test
public void testReadScheduleFile() {
    String filePath = "src/test/resources/schedule.txt"; // File path

    List<String> linesList = new ArrayList<>();

    try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            linesList.add(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
        return;
    }

    // List to store schedules
    List<schedule> scheduleList = new ArrayList<>();

    // Now you have a linesList containing all lines from the file
    linesList.forEach(line -> {
        // Split the line by comma or any other delimiter if needed
        String[] values = line.split(",");

        // Extract values and create studyDays list
        List<DayOfWeek> studyDays = Arrays.stream(Arrays.copyOfRange(values, 0, values.length - 2))
                .map(DayOfWeek::valueOf)
                .collect(Collectors.toList());

        // Extract start time and end time
        LocalTime startTime = LocalTime.parse(values[values.length - 2]);
        LocalTime endTime = LocalTime.parse(values[values.length - 1]);

        // Create a schedule object
        schedule schedule = new schedule(studyDays, startTime, endTime);

        // Add the schedule object to the scheduleList
        scheduleList.add(schedule);

        // Perform necessary assertions here or use the scheduleList in other tests
        assertNotNull(schedule);
    });

    // Check if all lines were read
    long expectedLineCount = 15; // Set this to the expected number of lines in the file
    assertEquals("File contains the expected number of lines", expectedLineCount, linesList.size());
}
    @Test
    public void testReadSemesterFile() {
        String filePath = "src/test/resources/semester.txt"; // File path
    
        List<String> linesList = new ArrayList<>();
    
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                linesList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    
        // List to store semesters
        List<semester> semesterList = new ArrayList<>();
    
        // Now you have a linesList containing all lines from the file
        linesList.forEach(line -> {
            // Split the line by comma or any other delimiter if needed
            String[] values = line.split(",");
    
            // Extract values and create a semester object
            int semesterID = Integer.parseInt(values[0]);
            String name = values[1];
            LocalDate startDate = LocalDate.parse(values[2]); // Assuming the date format is ISO_LOCAL_DATE (YYYY-MM-DD)
            LocalDate endDate = LocalDate.parse(values[3]);
    
            // Create a semester object
            semester semester = new semester(semesterID, name, startDate, endDate);
    
            // Add the semester object to the semesterList
            semesterList.add(semester);
    
            // Perform necessary assertions here or use the semesterList in other tests
            assertNotNull(semester);
        });
    
        // Check if all lines were read
        long expectedLineCount = 15; // Set this to the expected number of lines in the file
        assertEquals("File contains the expected number of lines", expectedLineCount, linesList.size());
    }
    @Test
    public void testReadStaffFile() {
        String filePath = "src/test/resources/staff.txt"; // File path
    
        List<String> linesList = new ArrayList<>();
    
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                linesList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    
        // List to store staff members
        List<staff> staffList = new ArrayList<>();
    
        // Now you have a linesList containing all lines from the file
        linesList.forEach(line -> {
            // Split the line by comma
            String[] values = line.split(",");
    
            // Extract values and create a staff object
            String staffID = values[0];
            String name = values[1];
            String email = values[2];
            String phoneNumber = values[3];
    
            // Create a staff object
            staff staff = new staff(staffID, name, email, phoneNumber);
    
            // Add the staff object to the staffList
            staffList.add(staff);
    
            // Perform necessary assertions here or use the staffList in other tests
            assertNotNull(staff);
        });
    
        // Check if all lines were read
        long expectedLineCount = 15; // Set this to the expected number of lines in the file
        assertEquals("File contains the expected number of lines", expectedLineCount, linesList.size());
    }
    @Test
public void testReadStudentFile() {
String filePath = "src/test/resources/student.txt"; // File path

List<String> linesList = new ArrayList<>();

try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
String line;
while ((line = reader.readLine()) != null) {
linesList.add(line);
}
} catch (IOException e) {
e.printStackTrace();

return;
}

// Now you have a linesList containing all lines from the file
// You can perform any operations you want here, for example, printing the lines:
linesList.forEach(line -> {
// Split the line by comma
String[] values = line.split(",");

// Extract values and create a student object
int id = Integer.parseInt(values[0]);
String name = values[1];
String major = values[2];
// Assuming you have a method to create a faculty object from a string (implementation needed)
faculty faculty = createFacultyFromString(values[3]);
String email = values[4];
String phoneNumber = values[5];

// Create a student object
student student = new student(id, name, major, faculty, email, phoneNumber);

// Now you can perform assertions or store the student object for further testing
assertNotNull(student);
});

// Check if all lines were read
long expectedLineCount = 15; // Set this to the expected number of lines in the file
assertEquals("File contains the expected number of lines", expectedLineCount, linesList.size());
}

// Method to create a faculty object from a string (you need to implement this based on your faculty class)
private faculty createFacultyFromString(String facultyString) {
// Implement this based on your faculty class
return null;
}



}





