package com.mycompany.studentmanagement;

public class Student {

    private String id, firstName, lastName, course, year, gender;
    private double GPA;

    public Student(String id, String firstName, String lastName, String gender, String course, String year, double GPA) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.course = course;
        this.year = year;
        this.GPA = GPA;
    }

    public String getId() {
        return id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getCourse() {
        return course;
    }

    public String getYear() {
        return year;
    }

    public String getGender() {
        return gender;
    }

    public double getGPA() {
        return GPA;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    
    public String toString() {
        return String.format("%-12s | %-26s | %-8s | %-10s | %-10s | %-4.2f",
                id, getFullName(), gender, course, year, GPA);
    }

}
