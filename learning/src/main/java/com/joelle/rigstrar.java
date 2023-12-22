package com.joelle;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class rigstrar  {

    List<student> students;
    List<faculty> faculty;
    List<semester> semester;
    List<course> courses; 
   

public void registerStudentForCourse(student student, course course) {
    // Add logic to register a student for a course
   // registeredStudents.computeIfAbsent(student, k -> new ArrayList<>()).add(course);
}

//method that fills the map 


public void createstaff(String staffID, String name, String position, String department, double salary) {
   




}



public void createStudent(int ID,String name, String contactDetails,String role,String major) {

    student student = new student(ID, name, contactDetails, role, major);
students.add(student);

}

public void createFaculty(int facultyID,String name, String contactDetails,String role) {
    faculty faculty = new faculty(facultyID,name,contactDetails,role);
faculty.add(faculty);
}

public void createSemester(int semesterID,String name, LocalDate startDate, LocalDate endDate) {
semester Semester = new semester(semesterID,name, startDate, endDate); 
semester.add(Semester);

}

public void createCourse(int courseID, String name, int credits, faculty faculty, List<schedule> schedule) {
    course course = new course(courseID, name, credits, faculty, schedule);
courses.add(course);
}


    public void browseCourses() {
        
       courses.forEach(course -> {
            System.out.println("Course ID: " + course.getCourseID());
            System.out.println("Name: " + course.getCourseName());
            System.out.println("Faculty: " + course.getFaculty().getName());
            System.out.println("Credits: " + course.getCredits());

            System.out.println("Schedule:");
            course.getSchedule().forEach(schedule -> {
                System.out.println("- Day: " + schedule.getStudyDays());
                System.out.println("  Time: " + schedule.getStartTime() + " - " + schedule.getEndTime());
                System.out.println("  Lecture Status: " + schedule.checkStudyDay(DayOfWeek.MONDAY)); // Example check for a specific day
            });

            // Print prerequisites using Stream
            System.out.println("Prerequisites:");
            course.getPrerequisites().forEach(p -> System.out.println("- " + p));

            // Print meeting semesters using Stream
            System.out.println("Meeting Semesters:");
course.getMeetingSemesters().forEach(semester -> System.out.println("- " + semester.getName()));
            // Print students enrolled using Stream
            System.out.println("Students Enrolled:");
            course.listEnrolledStudents().forEach(student -> System.out.println("- " + student.getContactDetails()));

            System.out.println("-----------------------------------");
        });
    }







// Additional methods related to Registrar's activities
// For example: validatePrerequisites(), notifyScheduleConflict(), etc.



// private boolean checkScheduleConflicts(student student, course course) {
//     List<course> registeredCourses = registeredStudents.getOrDefault(student, List.of());
//     if (courseHasScheduleConflict(course, registeredCourses)) {
//         System.out.println("Schedule conflict for student " + student.getName() + " with course " + course.getCourseName());
//         return false;
//     }
//     return true;
// }

private boolean courseHasScheduleConflict(course course, List<course> registeredCourses) {
    
    return false; 
}

public void viewPrerequisites(course course) {
   
    }

    // Method to register students for a course
    public void registerStudentsForClass(List<student> students, course course) {
    
    }
 // Method to enter grades for a student in a course
 public void enterGrades(student student, course course, double grade) {
 

}

public void generateAcademicReport(student student) {
 
}

private String determineAcademicStanding(double overallGPA) {
    if (overallGPA >= 3.8) {
        return "Highest Honours";
    } else if (overallGPA >= 3.5) {
        return "Honours";
    } else if (overallGPA >= 2.0) {
        return "Good Standing";
    } else {
        return "Probation";
    }
}




}

