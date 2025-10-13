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
        if (index - 1 >= 0 && index - 1 < students.size()) {
            students.remove(index - 1);
        } else {
            System.out.println("Invalid number!");
        }
    }

    public void updateGPA(double GPA, int index) {
        if (index - 1 >= 0 && index - 1 < students.size()) {
            System.out.println("The GPA has been updated from " + this.students.get(index - 1).getGPA() + " to " + GPA);
            this.students.get(index - 1).setGPA(GPA);
        } else {
            System.out.println("Invalid number!");
        }
    }

    public void update(String update, int index, int classification) {
        if (index - 1 >= 0 && index - 1 < students.size()) {
            switch (classification) {
                case 1:
                    System.out.println("The name has been updated from " + this.students.get(index - 1).getName() + " to " + update);
                    this.students.get(index - 1).setName(update);
                    break;
                case 2:
                    System.out.println("The name has been updated from " + this.students.get(index - 1).getGender() + " to " + update);
                    this.students.get(index - 1).setGender(update);
                    break;
                case 3:
                    System.out.println("The name has been updated from " + this.students.get(index - 1).getCourse() + " to " + update);
                    this.students.get(index - 1).setCourse(update);
                    break;
                case 4:
                    System.out.println("The name has been updated from " + this.students.get(index - 1).getYear() + " to " + update);
                    this.students.get(index - 1).setYear(update);
                    break;
                default:
                    System.out.println("Invalid number!");
            }
        } else {
            System.out.println("Invalid number!");
        }
    }

    public void search(String search) {
        boolean found = false;
        for (Student student : students) {
            if (student.getId().equals(search) || student.getName().equals(search) || student.getCourse().equals(search) || student.getGPA() == Integer.parseInt(search)) {
                found = true;
                showDetails();
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    public void sortBy(int type) {
        switch (type) {
            case 1:
                students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
                showDetails();
                break;
                
            case 2:
                break;
                
            case 3:
                students.sort((s1, s2) -> Double.compare(s1.getGPA(), s2.getGPA()));
                showDetails();
                break;
                
            case 4:
                break;
            
            case 5:
                students.sort((s1, s2) -> s1.getCourse().compareTo(s2.getCourse()));
                break;
                
        }
    }
    
    public void topStudents(){
        
    }

    public void showDetails() {
        System.out.println("\n================================================================================================================");
        System.out.printf("%-4s | %-12s | %-20s | %-8s | %-10s | %-10s | %-4s%n",
                "No.", "Student ID", "Name", "Gender", "Course", "Year", "GPA");
        System.out.println("================================================================================================================");

        for (int i = 0; i < students.size(); i++) {
            System.out.printf("%-4d | %s%n", (i + 1), students.get(i).toString());
        }
    }
}
