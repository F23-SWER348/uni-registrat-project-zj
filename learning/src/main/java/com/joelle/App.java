package com.joelle;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        rigstrar r = new rigstrar();
        student s = r.createStudent(11, "zainab", "zainab@gmain.com", "swer");
        System.out.println(s.getRole());
        r.browseCourses();
      s.setGpa(3.9);
      System.out.println(r.generateAcademicReport(s));
      
    }
}
