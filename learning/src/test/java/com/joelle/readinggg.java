    package com.joelle;



import java.io.File;
import java.util.*;
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


public class readinggg {
    
    public static void main(String[] args) throws FileNotFoundException {
          readinggg rr = new readinggg();

  
           rr.readFaculty();
           //ss
          System.out.println( "faculty list: "+rr.facultyList.size());
       System.out.println("faculty list from rigestrar class: "+r.getFacultys().size());
          rr.ReadScheduleFile();
          System.out.println("scheduale list: "+rr.scheduleList.size());
       System.out.println("scheduale list from rigestrar class: "+r.getSchedules().size());
   
     rr.ReadSemesterFile();
          System.out.println("semester list: "+rr.semesterList.size());
       System.out.println("semester list from rigestrar class: "+r.getSemesters().size());
    rr.ReadStaffFile();
          System.out.println("staff list from rigestrar class: "+rr.staffList.size());
       System.out.println("staff list from rigestrar class: "+r.getStaffs().size());
   rr.readStudent();
          System.out.println("student list from rigestrar class: "+rr.studentList.size());
       System.out.println("student list from rigestrar class: "+r.getStudents().size());
System.out.println("the name of the faculty of the first student in the text file: "+r.students.get(0).getFaculty().getName());
 rr.rrreadCourse();
    System.out.println("course list from rigestrar class: "+rr.courseList.size());
       System.out.println("course list from rigestrar class: "+r.getCourses().size());

}
    

     public  ArrayList<faculty> facultyList;
  public  ArrayList<semester> semesterList; 
 public  ArrayList<course> courseList; 
 public  ArrayList<staff> staffList;
  public  ArrayList<student> studentList; 
   public  ArrayList<schedule> scheduleList; 
 public static rigstrar r ;





 public void setUp() throws FileNotFoundException {
       
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
                    int schid = Integer.parseInt(parts[4].trim());
                    String semester = parts[5].trim();
    
                int schIndex = -1;
                for (int i = 0; i < scheduleList.size(); i++) {
                    if (scheduleList.get(i).getId() ==(schid)) {
                        schIndex = i;
                        break;
                    }
                }                    int facultyIndex = 0;
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
                    
                    course course = new course(courseID, name,facultyList.get(facultyIndex), credits,  scheduleList.get(schIndex), semster.get(semesterindex));
                    courseList.add(course);
                    r.courses.add(course);
                    System.out.println(courseList);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    
        }
          schedule ss;
          faculty ff;
           semester sss;

 public void rrreadCourse() throws FileNotFoundException {
  
    

   
      courseList = new ArrayList<>();

    String filePath = "C:\\Users\\Gigabyte\\Desktop\\hhhhhhhhhhhh\\uni-registrat-project-zj\\learning\\src\\test\\resources\\course.txt";
    try (Scanner scanner = new Scanner(new File(filePath))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            if (data.length >= 6) {
                int courseID = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                String facName = data[2].trim();
                int credits = Integer.parseInt(data[3].trim());
                int schid = Integer.parseInt(data[4].trim());
                String semesterName = data[5].trim();
     int semindex = 0;
                for (int i = 0; i < semesterList.size(); i++) {
                    if (semesterList.get(i).getName().equals(semesterName)) {
                        semindex = i;
                        sss = semesterList.get(i);
                        break;
                    }
                }
                int facultyIndex = -1;
                for (int i = 0; i < facultyList.size(); i++) {
                    if (facultyList.get(i).getName().equals(facName)) {
                        facultyIndex = i;
                        ff = facultyList.get(i);

                        break;
                    }
                }
              
                int schIndex = -1;
                for (int i = 0; i < scheduleList.size(); i++) {
                    if (scheduleList.get(i).getId() ==(schid)) {
                        schIndex = i;
                         ss = scheduleList.get(i);
                        break;
                    }
                }
             if(facultyIndex  != -1  && semindex != -1 && schIndex != -1){
                course newCourse = new course(courseID, name, ff, credits, ss, sss);
               System.out.println("course name: "+newCourse.getName());
                courseList.add(newCourse);
                r.courses.add(newCourse);
            }else{
            course newCourse = new course(courseID, name, facultyList.get(facultyIndex), credits, scheduleList.get(schIndex), semesterList.get(semindex)); 
            courseList.add(newCourse);
                r.courses.add(newCourse);
                }
                
            }
        }
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + e.getMessage());
        e.printStackTrace();
    }
}






 public void readFaculty() throws FileNotFoundException {
    r = new rigstrar();
facultyList= new ArrayList<>();
Scanner scanner = new Scanner(new File("C:\\Users\\Gigabyte\\Desktop\\hhhhhhhhhhhh\\uni-registrat-project-zj\\learning\\src\\test\\resources\\faculty.txt"));

while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
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
scanner.close();}

   

    public void ReadScheduleFile() {
        String filePath = "C:\\Users\\Gigabyte\\Desktop\\hhhhhhhhhhhh\\uni-registrat-project-zj\\learning\\src\\test\\resources\\schedule.txt"; // File path
        scheduleList=new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
                            int schid = Integer.parseInt(parts[0].trim());

            DayOfWeek day = DayOfWeek.valueOf(parts[1].trim().toUpperCase());
            LocalTime startTime = LocalTime.parse(parts[2].trim());
            LocalTime endTime = LocalTime.parse(parts[3].trim());

            schedule schedule = new schedule(schid,Arrays.asList(day), startTime, endTime);
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





    public void ReadSemesterFile() {
        String filePath = "C:\\Users\\Gigabyte\\Desktop\\hhhhhhhhhhhh\\uni-registrat-project-zj\\learning\\src\\test\\resources\\semester.txt"; // File path
    
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
            String filePath = "C:\\Users\\Gigabyte\\Desktop\\hhhhhhhhhhhh\\uni-registrat-project-zj\\learning\\src\\test\\resources\\staff.txt"; // File path
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
                    r.staffs.add(staff);
    
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
        public void readStudent() {
            studentList = new ArrayList<>();
            String filePath = "C:\\Users\\Gigabyte\\Desktop\\hhhhhhhhhhhh\\uni-registrat-project-zj\\learning\\src\\test\\resources\\student.txt";
    
            try (Scanner scanner = new Scanner(new File(filePath))) {
                boolean firstLine = true; // To skip the header line
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (firstLine) {
                        firstLine = false;
                        continue;
                    }
    
                    String[] data = line.split(",");
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
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
                e.printStackTrace();
            }
        }
   }


