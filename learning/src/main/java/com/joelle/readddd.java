package com.joelle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
public class readddd {

public static void main(String[] args) {
    readddd readder = new readddd();
    // ArrayList<schedule> schedules = readder.scheduleList;
    // for (schedule sch : schedules) {
    //     System.out.println(sch.getStartTime()); 
    // }
    readder.readcourse();
   } 

 

    public ArrayList<faculty> facultyList;
    public ArrayList<semester> semesterList; 
   public ArrayList<course> courseList; 
   public ArrayList<staff> staffList;
    public ArrayList<student> studentList; 
     public  ArrayList<schedule> scheduleList; 
     public  rigstrar r = new rigstrar();


public void readcourse() {
r = new rigstrar();
courseList = new ArrayList<>();
    scheduleList= new ArrayList<>() ;
   facultyList = new ArrayList<>() ;
   semesterList= new ArrayList<>() ; 
 staffList= new ArrayList<>() ;
  studentList= new ArrayList<>() ;

readFaculty();
ReadScheduleFile();
ReadSemesterFile();
ReadStaffFile();
readStudent();
 // Handle facultyList
 if (!facultyList.isEmpty()) {
    faculty firstFaculty = facultyList.get(0);
    // Example operation: print the first faculty's name
    System.out.println("First faculty name: " + firstFaculty.getName());
} else {
    System.out.println("Faculty list is empty.");
}

// Handle semesterList
if (!semesterList.isEmpty()) {
    semester firstSemester = semesterList.get(0);
    // Example operation: print the first semester's details
    System.out.println("First semester details: " + firstSemester.getName());
} else {
    System.out.println("Semester list is empty.");
}

// Handle courseList
if (!courseList.isEmpty()) {
    course firstCourse = courseList.get(0);
    // Example operation: print the first course's name
    System.out.println("First course name: " + firstCourse.getCourseName());
} else {
    System.out.println("Course list is empty.");
}

// Handle staffList
if (!staffList.isEmpty()) {
    staff firstStaff = staffList.get(0);
    // Example operation: print the first staff's name
    System.out.println("First staff name: " + firstStaff.getName());
} else {
    System.out.println("Staff list is empty.");
}

// Handle studentList
if (!studentList.isEmpty()) {
    student firstStudent = studentList.get(0);
    // Example operation: print the first student's name
    System.out.println("First student name: " + firstStudent.getName());
} else {
    System.out.println("Student list is empty.");
}

// Handle scheduleList
if (!scheduleList.isEmpty()) {
    schedule firstSchedule = scheduleList.get(0);
    // Example operation: print the first schedule's details
    System.out.println("First schedule details: " + firstSchedule.toString()); // Replace toString() with actual method
} else {
    System.out.println("Schedule list is empty.");
}

System.out.println("Faculty List Size: " + facultyList.size());
    System.out.println("Schedule List Size: " + scheduleList.size());
    System.out.println("Semester List Size: " + semesterList.size());
    System.out.println("Staff List Size: " + staffList.size());
    System.out.println("Student List Size: " + studentList.size());
    for (faculty fac : r.getFacultys()) {
        // Assuming 'faculty' class has a method to return a string representation, 
        // such as 'getName'. If not, you can modify this to suit the available methods.
        System.out.println(fac.getName());
    }    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
    String filePath = "course.txt"; // File path
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
                r.getCourses().add(course);
                System.out.println(courseList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    System.out.println("course List Size: " + courseList.size());

    }

    public void ReadScheduleFile() {

        String filePath = "schedule.txt"; // File path
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            DayOfWeek day = DayOfWeek.valueOf(parts[1].trim().toUpperCase());
            LocalTime startTime = LocalTime.parse(parts[2].trim());
            LocalTime endTime = LocalTime.parse(parts[3].trim());

            schedule schedule = new schedule(Arrays.asList(day), startTime, endTime);
            scheduleList.add(schedule);
            r.getSchedules().add(schedule);

        }
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filePath);
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}



public void readFaculty() {

    String filePath = "faculty.txt"; // Adjusted path
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
                r.getFacultys().add(facultyMember);
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

    String filePath = "semester.txt"; // File path

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            int semesterID = Integer.parseInt(parts[0].trim());
            String name = parts[1].trim();
            LocalDate startDate = LocalDate.parse(parts[2].trim());
            LocalDate endDate = LocalDate.parse(parts[3].trim());

            semester semester = new semester(semesterID, name, startDate, endDate);
            semesterList.add(semester); 

            // Check if the semesters list in 'r' is not null before adding
            if (r.getSemesters() != null) {
                r.getSemesters().add(semester);
            } else {
                System.err.println("Error: Semesters list in rigstrar is null");
            }
        }
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filePath);
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void ReadStaffFile() {

    String filePath = "staff.txt"; // File path

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String staffID = parts[0].trim();
            String name = parts[1].trim();
            String email = parts[2].trim();
            String phoneNumber = parts[3].trim();

            staff staffMember = new staff(staffID, name, email, phoneNumber);
            staffList.add(staffMember);

            // Check if the staffs list in 'r' is not null before adding
            if (r.getStaffs() != null) {
                r.getStaffs().add(staffMember);
            } else {
                System.err.println("Error: Staffs list in rigstrar is null");
            }
        }
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filePath);
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void readStudent() {

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

                    // Check if the students list in 'r' is not null before adding
                    if (r.getStudents() != null) {
                        r.getStudents().add(newStudent);
                    } else {
                        System.err.println("Error: Students list in rigstrar is null");
                    }
                } else {
                    // Handle case where faculty is not found for a student
                    System.out.println("Faculty not found for student: " + name);
                }
            }
        }
    } catch (FileNotFoundException e) {
        System.err.println("File not found: student.txt");
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
