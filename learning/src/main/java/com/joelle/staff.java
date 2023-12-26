package com.joelle;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.joelle.user.UserRole;


    public class staff implements user{
        // Data Fields
        private String staffID;
        private String name;
        private String email;
        private String phoneNumber;
    
        // Constructor
        public staff(String staffID, String name,String phoneNumber,String email) {
            this.staffID = staffID;
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;


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


        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email=email;;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
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

       
        
    

