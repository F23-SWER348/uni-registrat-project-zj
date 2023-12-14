package com.joelle;


public class student {
    private long id;
    private String name;
    private String major;
    private double gpa;
    private static long count = 1;
    


    
    public student(String name, String major, double gpa) {
        this.id = count++;
        this.name = name;
        this.major = major;
        this.gpa = gpa;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double curve(double points){
        return this.gpa+points;
    }

    @Override
    public String toString() {        
        return name + " " + major + " " + gpa;
    }

    public static long getCount() {
        return count;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.id == ((student)obj).getId())
            return true;
        return false;
    }
    
}
    

