package com.joelle;

public interface user {
    String getName();
    String getContactDetails();
 
    
    // Getter for role
    UserRole getRole();

    // Enum for user roles
    enum UserRole {
        STUDENT,
        FACULTY,
        STAFF
    }
}
