package com.joelle;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class rigstrar {

    private List<student> students;
    private List<faculty> facultys;
    private List<semester> semesters;
    private List<course> courses;

    public rigstrar() {
        // Initialize the lists in the constructor
        this.students = new ArrayList<>();
        this.facultys = new ArrayList<>();
        this.semesters = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void registerStudentForCourse(student student, course course) {
        // Add logic to register a student for a course
        // registeredStudents.computeIfAbsent(student, k -> new
        // ArrayList<>()).add(course);
    }

    // method that fills the map

    public void createstaff(String staffID, String name, String position, String department, double salary) {

    }

    public student createStudent(int ID, String name, String contactDetails, String major) {

        student student = new student(ID, name, contactDetails, major);
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

    public course createCourse(int courseID, String name, int credits, faculty faculty, List<schedule> schedule) {
        course course = new course(courseID, name, credits, faculty, schedule);
      if (this.courses != null) {
            this.courses.add(course);
        } else {
            // Handle the case where students is null (this should not happen if properly
            // initialized)
            System.out.println("Error: courses list is not initialized.");
        }
        return course;    }

    public void browseCourses() {
        if (this.courses != null) {

            courses.forEach(course -> {
                System.out.println("Course ID: " + course.getCourseID());
                System.out.println("Name: " + course.getCourseName());
                System.out.println("Faculty: " + course.getFaculty().getName());
                System.out.println("Credits: " + course.getCredits());

                List<section> sections = course.getSections();

                sections.forEach(section -> {
                    System.out.println("Section ID: " + section.getSectionId());
                    System.out.println("Section Schedule:");
                    section.getSectionSchedule().forEach(schedule -> {
                        System.out.println("- Day: " + schedule.getStudyDays());
                        System.out.println("  Time: " + schedule.getStartTime() + " - " + schedule.getEndTime());
                        System.out.println("  Lecture Status: " + schedule.checkStudyDay(DayOfWeek.MONDAY));
                    });

                    System.out.println("Students Enrolled:");
                    section.listEnrolledStudents()
                            .forEach(student -> System.out.println("- " + student.getContactDetails()));
                });

                System.out.println("Prerequisites:");
                course.getPrerequisites().forEach(p -> System.out.println("- " + p));

                System.out.println("Meeting Semesters:");
                course.getMeetingSemesters().forEach(semester -> System.out.println("- " + semester.getName()));

                System.out.println("-----------------------------------");
            });

        } else {
            // Handle the case where courses is null (this should not happen if properly
            // initialized)
            System.out.println("Error: courses list is not initialized.");
        }

    }

    public boolean haveConflict(List<section> sections) {
        return sections.stream()
                .flatMap(section -> sections.stream().filter(s -> !s.equals(section))
                        .flatMap(otherSection -> section.getSectionSchedule().stream()
                                .flatMap(schedule1 -> otherSection.getSectionSchedule().stream()
                                        .filter(schedule2 -> ConflictBetweenSchedules(schedule1, schedule2)))))
                .findAny()
                .isPresent();
    }

    private boolean ConflictBetweenSchedules(schedule schedule1, schedule schedule2) {
        List<DayOfWeek> days1 = schedule1.getStudyDays();
        List<DayOfWeek> days2 = schedule2.getStudyDays();

        boolean commonDays = !Collections.disjoint(days1, days2);

        LocalTime startTime1 = schedule1.getStartTime();
        LocalTime endTime1 = schedule1.getEndTime();
        LocalTime startTime2 = schedule2.getStartTime();
        LocalTime endTime2 = schedule2.getEndTime();

        boolean timeOverlap = startTime1.isBefore(endTime2) && endTime1.isAfter(startTime2);

        return commonDays && timeOverlap;
    }

    private boolean haveConflictBetweenSections(List<section> sections) {
        return sections.stream()
                .flatMap(section -> sections.stream().filter(s -> !s.equals(section))
                        .flatMap(otherSection -> section.getSectionSchedule().stream()
                                .flatMap(schedule1 -> otherSection.getSectionSchedule().stream()
                                        .filter(schedule2 -> ConflictBetweenSchedules(schedule1, schedule2)))))
                .findAny()
                .isPresent();
    }

    public void viewPrerequisites(course course) {
        List<String> prerequisites = course.getPrerequisites();

        System.out.println("Prerequisites for " + course.getCourseName() + ":");
        prerequisites.forEach(prerequisite -> System.out.println("- " + prerequisite));
    }

    public void registerStudentsForClass(List<student> students, course course) {
        List<section> sections = course.getSections();

        boolean hasConflict = haveConflictBetweenSections(sections);

        if (!hasConflict) {
            section section = course.getOrCreateSection(); // Get or create a section for the course
            section.addStudent(students); // Register students in the section
            course.addSection(section); // Optionally, update or add the section to the course

            System.out.println(students.size() + " students registered for " + course.getCourseName());
        } else {
            System.out.println("There is a schedule conflict. Cannot register students for this course.");
        }
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

 

    // Method to enter grades for a student in a course
    public void enterGrades(student student, course course, double grade) {
        // perarel

    }

    public String generateAcademicReport(student student) {
        Optional<student> stu=students.stream().filter(s -> s.getId() == student.getId()).findFirst();
       double overallGPA= stu.get().getGpa();
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
