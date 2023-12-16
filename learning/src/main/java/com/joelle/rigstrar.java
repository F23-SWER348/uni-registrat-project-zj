package com.joelle;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class rigstrar  {

private Map<student, List<course>> registeredStudents = new HashMap<>();
   

public void registerStudentForCourse(student student, course course) {
    // Add logic to register a student for a course
    registeredStudents.computeIfAbsent(student, k -> new ArrayList<>()).add(course);}

//method that fills the map 


public rigstrar(String staffID, String name, String position, String department, double salary) {
}

public rigstrar() {
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





// Additional methods related to Registrar's activities
// For example: validatePrerequisites(), notifyScheduleConflict(), etc.



private boolean checkScheduleConflicts(student student, course course) {
    List<course> registeredCourses = registeredStudents.getOrDefault(student, List.of());
    if (courseHasScheduleConflict(course, registeredCourses)) {
        System.out.println("Schedule conflict for student " + student.getName() + " with course " + course.getCourseName());
        return false;
    }
    return true;
}

// Helper method to check if a course has a schedule conflict with the list of registered courses
private boolean courseHasScheduleConflict(course course, List<course> registeredCourses) {
    // Implement logic to check for schedule conflicts
    // For example, compare the schedule of 'course' with the schedules of 'registeredCourses'
    // Return true if there is a conflict, false otherwise
    return false; // Placeholder, replace with actual implementation
}

public void viewPrerequisites(course course) {
      //  Optional.ofNullable(course)
                // .map(course::getPrerequisites)
                // .filter(prerequisites -> !prerequisites.isEmpty())
                // .ifPresentOrElse(
                //         prerequisites -> {
                //             System.out.println("Prerequisites for the course " + course.getCourseName() + ":");
                //             prerequisites.stream().map(Course::getCourseName).forEach(System.out::println);
                //         },
                //         () -> System.out.println("No prerequisites for the course: " + course.getCourseName())
                // );
    }

    // Method to register students for a course
    public void registerStudentsForClass(List<student> students, course course) {
        // students.forEach(student -> {
        //     registerStudentForCourse(student, course);
        //     System.out.println("Student " + student.getName() + " registered for course " + course.getCourseName());
        // });
    }
 // Method to enter grades for a student in a course
 public void enterGrades(student student, course course, double grade) {
    // // Assuming the course is in the list of courses the student is registered for
    // List<Course> registeredCourses = registeredStudents.getOrDefault(student, List.of());
    // if (registeredCourses.contains(course)) {
    //     student.enterGrades(course, grade);
    //     System.out.println("Grade entered for " + student.getName() + " in course " + course.getCourseName());
    // } else {
    //     System.out.println(student.getName() + " is not registered for course " + course.getCourseName());
    // }
}

// Method to generate an academic report for a student
public void generateAcademicReport(student student) {
    // double overallGPA = student.calculateOverallGPA();
    // System.out.println("Academic Report for " + student.getName());
    // System.out.println("Overall GPA: " + overallGPA);

    // // Determine academic standing based on GPA
    // String academicStanding = determineAcademicStanding(overallGPA);
    // System.out.println("Academic Standing: " + academicStanding);
}

// Helper method to determine academic standing based on GPA
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

