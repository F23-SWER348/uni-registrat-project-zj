package com.joelle;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.joelle.user.UserRole;

public class staff {
    public class Staff implements user{
        // Data Fields
        private String staffID;
        private String name;
        private String position;
        private String department;
        private double salary;
        private String email;
        private String phoneNumber;
    
        // Constructor
        public Staff(String staffID, String name, String position, String department, double salary) {
            this.staffID = staffID;
            this.name = name;
            this.position = position;
            this.department = department;
            this.salary = salary;
        }
    
        public String getStaffID() {
            return staffID;
        }

        public void setStaffID(String staffID) {
            this.staffID = staffID;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        // Methods
        public String getStateID() {
            return staffID;
        }
    
        public String getName() {
            return name;
        }
    
        public String getPosition() {
            return position;
        }
    
        public String getDepartment() {
            return department;
        }
    
        public double getSalary() {
            return salary;
        }
    
        
    
        public void updateSalary(double newSalary) {
            Optional.of(newSalary)
                    .filter(s -> s >= 0) // Ensure the new salary value is positive or zero
                    .ifPresentOrElse(
                            s -> {
                                this.salary = s;
                                System.out.println("Salary updated successfully to: " + s);
                            },
                            () -> System.out.println("Error: Salary must be a positive value.")
                    );
        }
    
        public void assignToProject(String projectName) {
            // Add logic to assign the staff to a project
            System.out.println(name + " has been assigned to the project: " + projectName);
        }

        @Override
        public String getContactDetails() {
        if (email != null && phoneNumber != null) {
            return "Email: " + email + ", Phone: " + phoneNumber;
        } else {
            return "Contact details are incomplete";
        }
    }

    // Other methods or fields related to Staff class...

    // Example method using Stream to get contact details for a list of Staff
    public static List<String> getContactDetailsList(List<Staff> staffList) {
        return staffList.stream()
                .map(Staff::getContactDetails)
                .collect(Collectors.toList());
    }
}

       
        
    }

