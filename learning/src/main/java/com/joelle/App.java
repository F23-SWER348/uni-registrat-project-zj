package com.joelle;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //i am adding randome thing just for testing puspose

        //helllooooooooooooooooooo
     faculty faculty1 = new faculty(1, "Faculty 1", "Contact 1", "Role 1");
    faculty faculty2 = new faculty(2, "Faculty 2", "Contact 2", "Role 2");
    // Create more objects as needed...

    schedule schedule1 = new schedule(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY), LocalTime.of(9, 0), LocalTime.of(11, 0));
    schedule schedule2 = new schedule(Arrays.asList(DayOfWeek.TUESDAY, DayOfWeek.THURSDAY), LocalTime.of(10, 0), LocalTime.of(12, 0));
    // Create more schedules as needed...

    course course1 = new course(1, "Course 1", faculty1, new ArrayList<>(), 3, Arrays.asList(schedule1));
    course course2 = new course(2, "Course 2", faculty2, new ArrayList<>(), 4, Arrays.asList(schedule2));
    // Create more courses as needed...

    student student1 = new student(1, "Student 1", "Contact 1", "Major 1", faculty1);
    student student2 = new student(2, "Student 2", "Contact 2", "Major 2", faculty2);
    // Create more students as needed...

    // Assume students have completed some courses
    List<course> completedCoursesStudent1 = Arrays.asList(course1, course2);
    List<course> completedCoursesStudent2 = Arrays.asList(course1);
    student1.setCompletedCourses(completedCoursesStudent1);
    student2.setCompletedCourses(completedCoursesStudent2);

    // Add schedules to students
    student1.setSchedule(Arrays.asList(schedule1));
    student2.setSchedule(Arrays.asList(schedule2));
    // Add more schedules to students as needed...

    List<student> students = Arrays.asList(student1, student2);

    rigstrar registrar = new rigstrar(); // Creating an instance of the Registrar class (or use an existing instance)

    // Assuming course1 and course2 are instances of the Course class
    registrar.browseCourses(Arrays.asList(course1, course2));

    // Test other methods similarly using sample data...
    // For example:
    registrar.checkPrerequisites(course1, student1);
    registrar.viewPrerequisites(course2);
   registrar.registerStudentsForCourse(students, course1);
}    


    }

