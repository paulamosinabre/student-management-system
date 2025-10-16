package com.mycompany.studentmanagement;

import java.util.ArrayList;

public class Manager {

    private ArrayList<Student> students;

    public Manager() {
        this.students = new ArrayList();
    }

    public void add(Student student) {
        if (student.getGPA() >= 0 && student.getGPA() <= 4.0) {
            students.add(student);
        } else {
            System.out.println("Could not add student. Make sure the GPA does not exceed 4.0");
        }

    }

    public void delete(int index) {
        if (isItInTheList(index)) {
            students.remove(index - 1);
            System.out.println("Successfully Deleted!");
        } else {
            System.out.println("Invalid number!");
        }
    }

    public boolean isItInTheList(int index) {
        return index - 1 >= 0 && index - 1 < students.size();
    }

    public void updateFirstName(String firstName, int index) {
        if (isItInTheList(index)) {
            this.students.get(index - 1).setFirstName(firstName);
            System.out.println("Successfully Updated!");
        } else {
            System.out.println("Invalid number!");
        }
    }

    public void updateLastName(String lastName, int index) {
        if (isItInTheList(index)) {
            this.students.get(index - 1).setLastName(lastName);
            System.out.println("Successfully Updated!");
        } else {
            System.out.println("Invalid number!");
        }
    }

    public void updateGender(String gender, int index) {
        if (isItInTheList(index)) {
            this.students.get(index - 1).setGender(gender);
            System.out.println("Successfully Updated!");
        } else {
            System.out.println("Invalid number!");
        }
    }

    public void updateCourse(String course, int index) {
        if (isItInTheList(index)) {
            this.students.get(index - 1).setCourse(course);
            System.out.println("Successfully Updated!");
        } else {
            System.out.println("Invalid number!");
        }
    }

    public void updateYear(String year, int index) {
        if (isItInTheList(index)) {
            this.students.get(index - 1).setYear(year);
            System.out.println("Successfully Updated!");
        } else {
            System.out.println("Invalid number!");
        }
    }

    public void updateGPA(double GPA, int index) {
        if (isItInTheList(index) && (this.students.get(index - 1).getGPA() >= 0 && this.students.get(index - 1).getGPA() <= 4.0)) {
            System.out.println("The GPA has been updated from " + this.students.get(index - 1).getGPA() + " to " + GPA);
            this.students.get(index - 1).setGPA(GPA);
        } else {
            System.out.println("Invalid number!");
        }
    }

    public boolean isNumeric(String search) {
        if (search == null || search.isEmpty()) {
            return false;
        }

        try {
            Double.parseDouble(search);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void search(String search) {
        boolean found = false;

        for (Student student: students) {
            boolean match
                    = student.getId().equalsIgnoreCase(search)
                    || student.getFirstName().equalsIgnoreCase(search)
                    || student.getLastName().equalsIgnoreCase(search)
                    || student.getFullName().equalsIgnoreCase(search)
                    || student.getCourse().equalsIgnoreCase(search);

            // If input is numeric, compare with GPA
            if (isNumeric(search)) {
                double gpaSearch = Double.parseDouble(search);
                if (student.getGPA() == gpaSearch) {
                    match = true;
                }
            }

            if (match) {
                found = true;

                System.out.println("\n============================================= Search Results ===============================================");
                System.out.printf("%-12s | %-26s | %-8s | %-10s | %-10s | %-4s%n",
                         "Student ID", "Name", "Gender", "Course", "Year", "GPA");
                System.out.println("============================================================================================================");

                System.out.println(student);
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    public void sortBy(int type) {
        switch (type) {
            case 1:
                //lambda comparator
                students.sort((s1, s2) -> s1.getFullName().compareTo(s2.getFullName()));
                showDetails();
                break;
            case 2:
                students.sort((s1, s2) -> s2.getFullName().compareTo(s1.getFullName()));
                showDetails();
                break;
            case 3:
                students.sort((s1, s2) -> Double.compare(s1.getGPA(), s2.getGPA()));
                showDetails();
                break;
            case 4:
                students.sort((s1, s2) -> Double.compare(s2.getGPA(), s1.getGPA()));
                showDetails();
                break;
            case 5:
                students.sort((s1, s2) -> s1.getCourse().compareTo(s2.getCourse()));
                showDetails();
                break;

        }
    }

    public void topStudents() {
        students.sort((s1, s2) -> Double.compare(s2.getGPA(), s1.getGPA()));
        System.out.println("\n=============================================== Top Students ===================================================");
        System.out.printf("%-4s | %-12s | %-26s | %-8s | %-10s | %-10s | %-4s%n",
                "No.", "Student ID", "Name", "Gender", "Course", "Year", "GPA");
        System.out.println("================================================================================================================");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%-4d | %s%n", (i + 1), students.get(i).toString());
        }
    }

    public void showDetails() {
        System.out.println("\n================================================================================================================");
        System.out.printf("%-4s | %-12s | %-26s | %-8s | %-10s | %-10s | %-4s%n",
                "No.", "Student ID", "Name", "Gender", "Course", "Year", "GPA");
        System.out.println("================================================================================================================");

        for (int i = 0; i < students.size(); i++) {
            System.out.printf("%-4d | %s%n", (i + 1), students.get(i).toString());
        }
    }
}
