package com.joelle;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;


public class rigstrar {

    public ArrayList<student> getStudents() {
        return students;
    }



    public ArrayList<faculty> getFacultys() {
        return facultys;
    }



    public ArrayList<semester> getSemesters() {
        return semesters;
    }



    public ArrayList<schedule> getSchedules() {
        return schedules;
    }



    public ArrayList<course> getCourses() {
        return courses;
    }



    public ArrayList<staff> getStaffs() {
        return staffs;
    }


    public ArrayList<student> students;
   public ArrayList<faculty> facultys;
    public ArrayList<semester> semesters;
     public ArrayList<schedule>schedules;
    
   public ArrayList<course> courses;
        public ArrayList<staff> staffs;
   public final Lock lock = new ReentrantLock();


   public rigstrar() {
    this.students = new ArrayList<>();
    this.facultys = new ArrayList<>();
    this.semesters = new ArrayList<>();
    this.courses = new ArrayList<>();
    this.schedules = new ArrayList<>();
    this.staffs = new ArrayList<>();
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

    public student createStudent(int ID, String name, String major,faculty faculty,String email,String phoneNumber ) {

        student student = new student(ID, name, major,faculty, email,phoneNumber);
        if (this.students != null) {
            this.students.add(student);
        } else {
            // Handle the case where students is null (this should not happen if properly
            // initialized)
            System.out.println("Error: students list is not initialized.");
        }
        return student;

    }

    public faculty createFaculty(int facultyID, String name, String phoneNumber,String email) {
        faculty faculty = new faculty(facultyID, name, phoneNumber,email);
        if (this.facultys != null) {
            this.facultys.add(faculty);
        } else {
            // Handle the case where students is null (this should not happen if properly
            // initialized)
            System.out.println("Error: facultys list is not initialized.");
        }
        return faculty;
    }
    
   

    public semester createSemester(int semesterID, String name, LocalDate startDate, LocalDate endDate) {
        semester Semester = new semester(semesterID, name, startDate, endDate);
        if (this.semesters != null) {
            this.semesters.add(Semester);
        } else {
            // Handle the case where students is null (this should not happen if properly
            // initialized)
            System.out.println("Error: semesters list is not initialized.");
        }
        return Semester;

    }
    public schedule createSchedule(int id ,List<DayOfWeek> studyDays, LocalTime startTime, LocalTime endTime) {
        schedule newSchedule = new schedule(id,studyDays, startTime, endTime);
        if (this.schedules != null) {
            this.schedules.add(newSchedule); // Add the new schedule to the schedules list
        } else {
            System.out.println("Error: schedules list is not initialized.");
            // Handle the error accordingly
        }
        return newSchedule; // Return the newly created schedule

    }

    public course createCourse(int courseID, String name, faculty faculty,int credits,schedule schedule ,semester semester) {
        lock.lock();
        try {
            course course = new course(courseID, name, faculty ,credits, schedule,semester);
            
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

    public void browseCourses() {
        System.out.println("Available Courses:");
        courses.stream()
                .map(c -> "Course ID: " + c.getCourseID() +
                        "\nCourse Name: " + c.getCourseName() +
                        "\nFaculty: " + c.getFaculty().getName() +
                        "\nCredits: " + c.getCredits() +
                        "\n------------------------")
                .forEach(System.out::println);
    }
        
    

       

    public boolean hasConflict(course course1, course course2) {
        schedule schedule1 = course1.getSchedule();
        schedule schedule2 = course2.getSchedule();

        // Check if the schedules are on the same day
        boolean sameDay = doSchedulesOverlap(schedule1, schedule2);

        // Check for time overlap
        boolean timeOverlap = doSchedulesOverlap(schedule1, schedule2);

        return sameDay && timeOverlap;
    }

    public boolean doSchedulesOverlap(schedule schedule1, schedule schedule2) {
        if (schedule1 == null || schedule2 == null) {
            return false; // Handle cases where schedule1 or schedule2 is null
        }

        List<DayOfWeek> studyDays1 = schedule1.getStudyDays();
        List<DayOfWeek> studyDays2 = schedule2.getStudyDays();

        boolean sameDay = studyDays1.stream().anyMatch(studyDays2::contains);

        if (!sameDay) {
            return false; // No conflict if not on the same day
        }

        LocalTime start1 = schedule1.getStartTime();
        LocalTime end1 = schedule1.getEndTime();
        LocalTime start2 = schedule2.getStartTime();
        LocalTime end2 = schedule2.getEndTime();

        // Check for time overlap
        return !(start1.isAfter(end2) || start2.isAfter(end1));
    }

    

    
    public boolean checkPrerequisites(course course, student student) {
        if (course == null || student == null) return false;
    
        List<course> completedCourses = student.getCompletedCourses();
        List<course> prerequisites = course.getPrerequisites();
    
        if (prerequisites == null || prerequisites.isEmpty()) return true; // No prerequisites
    
        return prerequisites.stream().allMatch(completedCourses::contains);
    }
    

      public String viewPrerequisites(course course) {
        StringBuilder output = new StringBuilder();
        Optional.ofNullable(course)
                .map(courseObj -> courseObj.getPrerequisites())
                .ifPresentOrElse(
                        prerequisites -> {
                            if (!prerequisites.isEmpty()) {
                                output.append("Prerequisites for ").append(course.getCourseName()).append(":").append("\n");
                                prerequisites.forEach(prereq -> output.append(prereq.getCourseName()).append("\n"));
                            } else {
                                output.append("No prerequisites for ").append(course.getCourseName());
                            }
                        },
                        () -> output.append("No prerequisites information available for ").append(course.getCourseName())
                );
        return output.toString();
    }
      
    public void registerStudentForCourse(student student, course course) {
        if (student == null || course == null) {
            System.out.println("Invalid input: Student or course provided is null.");
            return;
        }
    
        // Check for schedule conflicts
        List<course> studentCourses = student.getCompletedCourses();
        boolean conflictExists = studentCourses.stream()
                .anyMatch(enrolledCourse -> hasConflict(course, enrolledCourse));
    
        if (conflictExists) {
            System.out.println("There is a schedule conflict. Registration for " + course.getCourseName() + " is not allowed.");
            return;
        }
    
        // Check if prerequisites are met
        boolean prerequisitesMet = checkPrerequisites(course, student);
        if (!prerequisitesMet) {
            System.out.println("Student has not met all prerequisites for " + course.getCourseName());
            return;
        }
    
        // Check if the student is already enrolled
        if (!course.getStudentsEnrolled().contains(student)) {
            student.getCompletedCourses().add(course);
            course.addStudent(student);
            System.out.println(student.getName() + " has been registered for " + course.getCourseName());
        } else {
            System.out.println(student.getName() + " is already registered for " + course.getCourseName());
        }
    }
    

   

   

    public void addCourseToStaff(staff staff, course course) {
        if (staff == null || course == null) {
            throw new IllegalArgumentException("Invalid input: Staff or course provided is null.");
        }

        staff.setteachescourse(course);
        course.setStaff(staff);
        System.out.println("Course " + course.getCourseName() + " added to staff " + staff.getName() + "'s teaching courses.");
    }
   

    public List<course> coursesInSemester(semester semester) {
        if (semester == null) {
        throw new IllegalArgumentException("Invalid input: Semester is null.");
        }

        return courses.stream()
        .filter(course -> course.getSemester().equals(semester)).collect(Collectors.toList());
    }  


    public void enterGrades(student student, course course, double grade) {
        student.setGradess(course,grade);
     
    }
    
 
    public double calculateGPA(student student) {

    Map<course, Double> grades = student.getgradess();

    try ( ForkJoinPool forkJoinPool = new ForkJoinPool()){
        
    RecursiveTask<Double> task = new RecursiveTask<Double>() {
    @Override
    protected Double compute() {
    return grades.entrySet().parallelStream().mapToDouble(entry -> {
     course course = entry.getKey();
    double grade = entry.getValue();
    double credits = course.getCredits();
    return grade * credits; // Calculate grade points for each course
    }).sum();   } };
    
    double totalCredits = grades.entrySet().stream().mapToDouble(entry -> entry.getKey().getCredits()).sum();
            
    if (totalCredits == 0) {return 0.0;}
        
    double d= forkJoinPool.invoke(task) / totalCredits; 
    student.setGpa(d);
    return d;
 } 
    }


    public String generateAcademicReport(student student) {
        
    
        if (student != null) {
            double overallGPA = student.getGpa();
    
            if (overallGPA >= 3.8) {
                return "Highest Honours";
            } else if (overallGPA >= 3.5) {
                return "Honours";
            } else if (overallGPA >= 2.0) {
                return "Good Standing";
            } else {
                return "Probation";
            }
        } else {
            return "Student not found";
        }
    }
    
    
}