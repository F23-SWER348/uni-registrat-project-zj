package com.joelle;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class rigstrar {

    private ArrayList<student> students;
    private ArrayList<faculty> facultys;
    private ArrayList<semester> semesters;
     private ArrayList<schedule>schedules;
    
    private ArrayList<course> courses;
        private ArrayList<staff> staffs;
    private final Lock lock = new ReentrantLock();


    public rigstrar() {
        // Initialize the lists in the constructor
        this.students = new ArrayList<>();
        this.facultys = new ArrayList<>();
        this.semesters = new ArrayList<>();
        this.courses = new ArrayList<>();
         this.schedules = new ArrayList<>();
    }

   

    // method that fills the map

    public staff createstaff(String staffID, String name,String phoneNumber ,String email ) {
    staff staff = new staff(staffID, name,phoneNumber, email);
        if (this.staffs != null) {
            this.staffs.add(staff);
        } else {
            // Handle the case where students is null (this should not happen if properly
            // initialized)
            System.out.println("Error: students list is not initialized.");
        }
        return staff;
    }

    public student createStudent(int ID, String name, String contactDetails, String major,faculty faculty,List<course> completedCourses) {

        student student = new student(ID, name, contactDetails, major,faculty, completedCourses);
        if (this.students != null) {
            this.students.add(student);
        } else {
            // Handle the case where students is null (this should not happen if properly
            // initialized)
            System.out.println("Error: students list is not initialized.");
        }
        return student;

    }

    public faculty createFaculty(int facultyID, String name, String contactDetails, String role) {
        faculty faculty = new faculty(facultyID, name, contactDetails, role);
        if (this.facultys != null) {
            this.facultys.add(faculty);
        } else {
            // Handle the case where students is null (this should not happen if properly
            // initialized)
            System.out.println("Error: facultys list is not initialized.");
        }
        return faculty;
    }

    public semester createSemester(int semesterID, String name, LocalDate startDate, LocalDate endDate,
            String contactsemesterDetails) {
        semester Semester = new semester(semesterID, name, startDate, endDate, contactsemesterDetails);
        if (this.semesters != null) {
            this.semesters.add(Semester);
        } else {
            // Handle the case where students is null (this should not happen if properly
            // initialized)
            System.out.println("Error: semesters list is not initialized.");
        }
        return Semester;

    }

    public course createCourse(int courseID, String name, int credits, faculty faculty, schedule schedule) {
        lock.lock();
        try {
            course course = new course(courseID, name, credits, faculty, schedule);
            
            if (this.courses != null) {
                this.courses.add(course);
            } else {
                // Handle the case where courses list is not initialized (this should not happen if properly initialized)
                System.out.println("Error: courses list is not initialized.");
            }
            
            return course;
        } finally {
            lock.unlock();
        }
    }

    public void browseCourses(List<course> courses) {
        System.out.println("Available Courses:");
        courses.stream()
                .map(c -> "Course ID: " + c.getCourseID() +
                        "\nCourse Name: " + c.getCourseName() +
                        "\nFaculty: " + c.getFaculty().getName() +
                        "\nCredits: " + c.getCredits() +
                        "\n------------------------")
                .forEach(System.out::println);
    }
        
    

       

    private boolean hasConflict(List<student> students) {
        if (students == null || students.isEmpty()) {
            return false; // No students, hence no conflicts
        }
    
        List<schedule> allSchedules = students.stream()
                .flatMap(student -> {
                    List<schedule> studentSchedules = student.getSchedule();
                    return studentSchedules != null ? studentSchedules.stream() : null;
                })
                .filter(schedule -> schedule != null)
                .collect(Collectors.toList());
    
        return allSchedules.stream()
                .anyMatch(schedule1 -> allSchedules.stream()
                        .filter(schedule2 -> !schedule1.equals(schedule2))
                        .filter(schedule2 -> haveCommonDay(schedule1, schedule2))
                        .anyMatch(schedule2 -> doSchedulesOverlap(schedule1, schedule2)));
    }
    
    
    // Helper method to check if schedules occur on the same day
    private boolean haveCommonDay(schedule schedule1, schedule schedule2) {
        List<DayOfWeek> days1 = schedule1.getStudyDays();
        List<DayOfWeek> days2 = schedule2.getStudyDays();
    
        return days1.stream().anyMatch(days2::contains);
    }
    
    // Helper method to check if schedules have overlapping time slots
private boolean doSchedulesOverlap(schedule schedule1, schedule schedule2) {
    LocalTime start1 = schedule1.getStartTime();
    LocalTime end1 = schedule1.getEndTime();
    LocalTime start2 = schedule2.getStartTime();
    LocalTime end2 = schedule2.getEndTime();

    return !(start1.isAfter(end2) || start2.isAfter(end1));
}
       
    

    
        public void checkPrerequisites(course course, student student) {
            List<course> completedCourses = student.getCompletedCourses();
            Optional.ofNullable(course)
                    .map(courseObj -> courseObj.getPrerequisites())
                    .ifPresentOrElse(
                            prerequisites -> {
                                boolean allPrerequisitesTaken = prerequisites.stream().allMatch(completedCourses::contains);
                                if (allPrerequisitesTaken) {
                                    System.out.println("Student has taken all prerequisites for " + course.getCourseName());
                                } else {
                                    System.out.println("Student needs to take prerequisites first for " + course.getCourseName());
                                }
                            },
                            () -> System.out.println("No prerequisites information available for " + course.getCourseName())
                    );
        
      }
      public void viewPrerequisites(course course) {
        Optional.ofNullable(course)
                .map(courseObj -> courseObj.getPrerequisites())
                .ifPresentOrElse(
                        prerequisites -> {
                            if (!prerequisites.isEmpty()) {
                                System.out.println("Prerequisites for " + course.getCourseName() + ":");
                                prerequisites.forEach(prereq -> System.out.println(prereq.getCourseName()));
                            } else {
                                System.out.println("No prerequisites for " + course.getCourseName());
                            }
                        },
                        () -> System.out.println("No prerequisites information available for " + course.getCourseName())
                );
    }

        // Add students to the section or class
      
    public void registerStudentsForCourse(List<student> students, course course) {
    if (students == null || students.isEmpty() || course == null) {
        System.out.println("Invalid input: No students or course provided.");
        return;
    }

    if (course.getStudentsEnrolled() == null || course.getPrerequisites() == null) {
        System.out.println("Course properties are not properly initialized.");
        return;
    }

    boolean conflictExists = hasConflict(students);

    if (conflictExists) {
        System.out.println("There is a schedule conflict. Registration for " + course.getCourseName() + " is not allowed.");
        return;
    }

    students.stream()
            .filter(student -> !course.getStudentsEnrolled().contains(student))
            .filter(student -> course.getPrerequisites().stream().allMatch(student.getCompletedCourses()::contains))
            .forEach(student -> {
                course.addStudent(student);
                System.out.println(student.getName() + " has been registered for " + course.getCourseName());
            });
}
    // public double calculateGPA(student student) {
    // Map<course, Double> grades = student.getGrades();

    // try (// Create a ForkJoinPool
    // ForkJoinPool forkJoinPool = new ForkJoinPool()) {
    // // Create a RecursiveTask to perform parallel computation
    // RecursiveTask<Double> task = new RecursiveTask<Double>() {
    // @Override
    // protected Double compute() {
    // return grades.entrySet()
    // .parallelStream()
    // .mapToDouble(entry -> {
    // course course = entry.getKey();
    // double grade = entry.getValue();
    // double credits = course.getCredits();
    // return grade * credits; // Calculate grade points for each course
    // })
    // .sum(); // Sum all grade points
    // }
    // };

    // // Invoke the task in the ForkJoinPool
    // return forkJoinPool.invoke(task) / grades.size(); // Calculate average GPA
    // }
    // }
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



public schedule createSchedule(List<DayOfWeek> of, LocalTime of2, LocalTime of3) {
    return null;
}



public course createCourse(int i, String string, faculty faculty1, int j, ArrayList<schedule> arrayList,
        schedule schedule1) {
    return null;
}
}
