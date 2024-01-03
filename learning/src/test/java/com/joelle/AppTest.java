package com.joelle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    private ArrayList<faculty> facultyList;
 private ArrayList<semester> semesterList; 
private ArrayList<course> courseList; 
private ArrayList<staff> staffList;
 private ArrayList<student> studentList; 
  private ArrayList<schedule> scheduleList; 

 rigstrar r = new rigstrar();

@Before
    public void setUp() {
       
readFaculty();
ReadScheduleFile();
ReadSemesterFile();
ReadStaffFile();
readStudent();
courseList = new ArrayList<>();
System.out.println("Faculty List Size: " + facultyList.size());
    System.out.println("Schedule List Size: " + scheduleList.size());
    System.out.println("Semester List Size: " + semesterList.size());
    System.out.println("Staff List Size: " + staffList.size());
    System.out.println("Student List Size: " + studentList.size());
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
String filePath = "src/test/resources/course.txt"; // File path
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int courseID = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                String facname = parts[2].trim();
                int credits = Integer.parseInt(parts[3].trim());
                String[] scheduleParts = parts[4].trim().split(" ");
                DayOfWeek day = DayOfWeek.valueOf(scheduleParts[0].toUpperCase());
                LocalTime startTime = LocalTime.parse(scheduleParts[1] + " " + scheduleParts[2], timeFormatter);
                LocalTime endTime = LocalTime.parse(scheduleParts[4] + " " + scheduleParts[5], timeFormatter);
                String semester = parts[5].trim();

                schedule scheduleObj = new schedule(Arrays.asList(day), startTime, endTime);
                int facultyIndex = 0;
                    for (int i = 0; i < facultyList.size(); i++) {
                        if (facultyList.get(i).getName().equals(facname)) {
                            facultyIndex = i;
                        }
                    }
                      int semesterindex = 0;
                      ArrayList<semester> semster=new ArrayList<>();
                    for (int i = 0; i < semesterList.size(); i++) {
                        if (semesterList.get(i).getName().equals(semester)) {
                            semesterindex = i;
                            semster.add(semesterList.get(i));
                        }
                    }
                
                course course = new course(courseID, name,facultyList.get(facultyIndex), credits, scheduleObj, semster.get(semesterindex));
                courseList.add(course);
                r.courses.add(course);
                System.out.println(courseList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Test
    public void shouldAnswerWithTrue(){
        assertTrue( true );
    }
   

    public void ReadScheduleFile() {
        String filePath = "src/test/resources/schedule.txt"; // File path
        scheduleList=new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            DayOfWeek day = DayOfWeek.valueOf(parts[1].trim().toUpperCase());
            LocalTime startTime = LocalTime.parse(parts[2].trim());
            LocalTime endTime = LocalTime.parse(parts[3].trim());

            schedule schedule = new schedule(Arrays.asList(day), startTime, endTime);
            scheduleList.add(schedule);
            r.schedules.add(schedule);

        }
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filePath);
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}



public void readFaculty() {
    facultyList = new ArrayList<>();
    String filePath = "src/test/resources/faculty.txt"; // Adjusted path
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        System.out.println("Reading file from path: " + filePath);
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Line read: " + line); // Print each line read for debugging
            String[] data = line.split(",", 4); // Split by comma and limit the split to 4 parts
            if (data.length >= 4) {
                int facultyID = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                String email = data[2].trim();
                String phoneNumber = data[3].trim();

                faculty facultyMember = new faculty(facultyID, name, email, phoneNumber);
                facultyList.add(facultyMember);
                r.facultys.add(facultyMember);
            }
        }
        System.out.println("Faculty List Size: " + facultyList.size());
        for (faculty f : facultyList) {
            System.out.println(f.getName());
        }
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filePath);
        e.printStackTrace();
    } catch (IOException e) {
        System.err.println("Error reading file: " + filePath);
        e.printStackTrace();
    }
}



    public void ReadSemesterFile() {
        String filePath = "src/test/resources/semester.txt"; // File path
    
              semesterList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int semesterID = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                LocalDate startDate = LocalDate.parse(parts[2].trim());
                LocalDate endDate = LocalDate.parse(parts[3].trim());

                semester semester = new semester(semesterID, name, startDate, endDate);
                semesterList.add(semester);    r.semesters.add(semester);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } }


        public void ReadStaffFile() {
            String filePath = "src/test/resources/staff.txt"; // File path
            staffList = new ArrayList<>(); // You might need to remove this line if staffList is already initialized elsewhere
    
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    String staffID = parts[0].trim();
                    String name = parts[1].trim();
                    String email = parts[2].trim();
                    String phoneNumber = parts[3].trim();
    
                    staff staff = new staff(staffID, name, email, phoneNumber);
                    staffList.add(staff);
                    
    
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    

        public void readStudent() {
            studentList = new ArrayList<>();
            try (InputStream is = getClass().getClassLoader().getResourceAsStream("student.txt")) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line;
                boolean firstLine = true; // To skip the header line
                while ((line = reader.readLine()) != null) {
                    if (firstLine) {
                        firstLine = false;
                        continue;
                    }
                    String[] data = line.split(",\\s*");
                    if (data.length >= 6) {
                        int id = Integer.parseInt(data[0].trim());
                        String name = data[1].trim();
                        String major = data[2].trim();
                        String facName = data[3].trim();
                        String email = data[4].trim();
                        String phoneNumber = data[5].trim();
                        
                        int facultyIndex = -1; // Initialize with an invalid index
                        for (int i = 0; i < facultyList.size(); i++) {
                            if (facultyList.get(i).getName().equals(facName)) {
                                facultyIndex = i;
                                break; // Exit loop when faculty is found
                            }
                        }
                        
                        if (facultyIndex != -1) {
                            student newStudent = new student(id, name, major,
                                    facultyList.get(facultyIndex), email, phoneNumber);
                            studentList.add(newStudent);
                            r.students.add(newStudent);
                        } else {
                            // Handle case where faculty is not found for a student
                            System.out.println("Faculty not found for student: " + name);
                            // You might want to log this or perform another action based on your requirements
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
