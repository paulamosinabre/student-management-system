package com.mycompany.studentmanagement;

public class Student {

    private String id, name, course, year, gender;
    private double GPA;

    public Student(String id, String name, String gender, String course, String year, double GPA) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.course = course;
        this.year = year;
        this.GPA = GPA;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
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
        return String.format("%-12s | %-20s | %-8s | %-10s | %-10s | %-4.2f",
                id, name, gender, course, year, GPA);
    }

}
