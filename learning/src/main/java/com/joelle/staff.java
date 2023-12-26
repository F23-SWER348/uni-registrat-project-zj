package com.joelle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



    public class staff implements user{
        // Data Fields
        private String staffID;
        private String name;
        private String email;
        private String phoneNumber;    
        private ArrayList<course> givescourse;

        // Constructor
        public staff(String staffID, String name,String email,String phoneNumber) {
            this.staffID = staffID;
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;


        }
    public ArrayList<course> getGivescourse() {
            return givescourse;
        }

       public synchronized void setteachescourse(course c){
              givescourse.add(c);
       }

    
        public String getStaffID() {
            return staffID;
        }

        public synchronized void setStaffID(String staffID) {
            this.staffID = staffID;
        }

        public synchronized void setName(String name) {
            this.name = name;
        }


        public String getEmail() {
            return email;
        }

        public synchronized void setEmail(String email) {
            this.email=email;;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public synchronized void setPhoneNumber(String phoneNumber) {
            this.phoneNumber=phoneNumber;
        }

        public String getName() {
            return name;
        }
    
        @Override
        public String getContactDetails() {
        if (email != null && phoneNumber != null) {
            return "Email: " + email + ", Phone: " + phoneNumber;
        } else {
            return "Contact details are incomplete";
        }
    }
    public static List<String> getContactDetailsList(List<staff> staffList) {
        return staffList.stream()
                .map(staff::getContactDetails)
                .collect(Collectors.toList());
    }

    @Override
    public UserRole getRole() {
return UserRole.STAFF;
    }
}

       
        
    

