package com.mycompany.studentmanagement;

import java.util.ArrayList;

public class Manager {

    private ArrayList<Student> students;

    public Manager() {
        this.students = new ArrayList();
    }

    public void add(Student student) {
        students.add(student);
    }

    public void delete(int index) {
        if (index - 1 > students.size() && index - 1 < 0) {
            students.remove(index);
        } else {
            System.out.println("Invalid number!");
        }
    }
    //Solution 1
/*
    public void updateName(String name, int index) {
        if (index - 1 > students.size() && index - 1 < 0) {
            System.out.println("The name has been updated from " + this.students.get(index - 1).getName() + " to" + name);
            this.students.get(index - 1).setName(name);
        } else {
            System.out.println("Invalid number!");
        }
    }

    public void updateGender(String gender, int index) {
        if (index - 1 > students.size() && index - 1 < 0) {
            System.out.println("The gender has been updated from " + this.students.get(index - 1).getGender() + " to" + gender);
            this.students.get(index - 1).setGender(gender);
        } else {
            System.out.println("Invalid number!");
        }
    }

    public void updateCourse(String course, int index) {
        if (index - 1 > students.size() && index - 1 < 0) {
            System.out.println("The course has been updated from " + this.students.get(index - 1).getCourse() + " to" + course);
            this.students.get(index - 1).setCourse(course);
        } else {
            System.out.println("Invalid number!");
        }
    }

    public void updateYear(String year, int index) {
        if (index - 1 > students.size() && index - 1 < 0) {
            System.out.println("The year has been updated from " + this.students.get(index - 1).getYear() + " to" + year);
            this.students.get(index - 1).setYear(year);
        } else {
            System.out.println("Invalid number!");
        }
    }
     */

    //Solution 2
    public void updateGPA(double GPA, int index) {
        if (index - 1 > students.size() && index - 1 < 0) {
            System.out.println("The GPA has been updated from " + this.students.get(index - 1).getGPA() + " to" + GPA);
            this.students.get(index - 1).setGPA(GPA);
        } else {
            System.out.println("Invalid number!");
        }
    }

    public void update(String update, int index, int classification) {
        if (index - 1 > students.size() && index - 1 < 0) {
            switch (classification) {
                case 1:
                    System.out.println("The name has been updated from " + this.students.get(index - 1).getName() + " to" + update);
                    this.students.get(index - 1).setName(update);
                    break;
                case 2:
                    System.out.println("The name has been updated from " + this.students.get(index - 1).getGender() + " to" + update);
                    this.students.get(index - 1).setGender(update);
                    break;
                case 3:
                    System.out.println("The name has been updated from " + this.students.get(index - 1).getCourse() + " to" + update);
                    this.students.get(index - 1).setCourse(update);
                    break;
                case 4:
                    System.out.println("The name has been updated from " + this.students.get(index - 1).getYear() + " to" + update);
                    this.students.get(index - 1).setYear(update);
                    break;
                default:
                    System.out.println("Invalid number!");
            }
        } else {
            System.out.println("Invalid number!");
        }
    }

    public void showDetails() {
        System.out.println("================================================================================================================");
        System.out.printf("%-4s | %-12s | %-20s | %-8s | %-10s | %-10s | %-4s%n",
                "No.", "Student ID", "Name", "Gender", "Course", "Year", "GPA");
        System.out.println("================================================================================================================");

        for (int i = 0; i < students.size(); i++) {
            System.out.printf("%-4d | %s%n", (i + 1), students.get(i).toString());
        }
    }
}
