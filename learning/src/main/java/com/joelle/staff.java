package com.joelle;

public class staff {
    public class Staff implements user{
        // Data Fields
        private String staffID;
        private String name;
        private String position;
        private String department;
        private double salary;
    
        // Constructor
        public Staff(String staffID, String name, String position, String department, double salary) {
            this.staffID = staffID;
            this.name = name;
            this.position = position;
            this.department = department;
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
    
        public double calculateBonus() {
            // Add bonus calculation logic here
            return 0.0; // Placeholder, replace with actual calculation
        }
    
        public void updateSalary(double newSalary) {
            // Add logic to update salary
            this.salary = newSalary;
        }
    
        public void assignToProject(String projectName) {
            // Add logic to assign the staff to a project
            System.out.println(name + " has been assigned to the project: " + projectName);
        }

        @Override
        public String getContactDetails() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getContactDetails'");
        }

        @Override
        public UserRole getRole() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getRole'");
        }
    }
}
