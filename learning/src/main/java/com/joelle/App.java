package com.joelle;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// import java.time.DayOfWeek;
// import java.time.LocalDate;
// import java.time.LocalTime;
// import java.time.Month;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws FileNotFoundException {
 ArrayList<faculty> l = new ArrayList<>();
rigstrar r = new rigstrar();
;

  
            Scanner scanner = new Scanner(new File("C:\\Users\\Gigabyte\\Desktop\\hhhhhhhhhhhh\\uni-registrat-project-zj\\learning\\src\\test\\resources\\faculty.txt"));

            System.out.println("Contents of the file:");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
            String[] data = line.split(",", 4); // Split by comma and limit the split to 4 parts

            if (data.length >= 4) {
                int facultyID = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                String email = data[2].trim();
                String phoneNumber = data[3].trim();

                faculty facultyMember = new faculty(facultyID, name, email, phoneNumber);
                l.add(facultyMember);
                r.facultys.add(facultyMember);
            }
        }
            scanner.close();

System.out.println(l.get(0).email);

System.out.println(r.facultys.size());






            }
 
    }
