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

        for (Student student : students) {
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
                //lambda comparator to sort from a-z
                students.sort((s1, s2) -> s1.getFullName().compareTo(s2.getFullName()));
                showDetails();
                break;
            case 2:
                //sort from z-a
                students.sort((s1, s2) -> s2.getFullName().compareTo(s1.getFullName()));
                showDetails();
                break;
            case 3:
                //sort by gpa from lowesr to highest
                students.sort((s1, s2) -> Double.compare(s1.getGPA(), s2.getGPA()));
                showDetails();
                break;
            case 4:
                //sort by gpa from highest to lowesr
                students.sort((s1, s2) -> Double.compare(s2.getGPA(), s1.getGPA()));
                showDetails();
                break;
            case 5:
                //sort by course
                students.sort((s1, s2) -> s1.getCourse().compareTo(s2.getCourse()));
                showDetails();
                break;
            default:
                System.out.println("Invalid number!");
        }
    }

    public int totalStudents(String category, String specification) {
        int count = 0;

        for (Student student : students) {
            switch (category) {
                case "Gender":
                    if (student.getGender().equals(specification)) {
                        count++;
                    }
                    break;
                case "Course":
                    if (student.getCourse().equals(specification)) {
                        count++;
                    }
                    break;
                case "Year":
                    if (student.getYear().equals(specification)) {
                        count++;
                    }
                    break;
            }
        }
        return count;
    }

    public void topStudents() {
        //overall students
        sortBy(4);
        System.out.println("\n-------------------------- Overall Top Students ----------------------------");
        System.out.printf("%-4s | %-26s |  %-4s%n",
                "No.", "Name", "GPA");
        System.out.println("----------------------------------------------------------------------------");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%-4d | %s%n", (i + 1), students.get(i).getFullName(), students.get(i).getGPA());
        }
        String[] courses = {"BSArch", "BSCE", "BSCpE", "BSIT-MWA", "BSCS-ML"};

        //iterating by course
        for (int i = 0; i < courses.length; i++) {
            String course = courses[i];
            System.out.println("\n------- Top 3 Students for " + course + " ------");
            System.out.println("--------------------------------------------");
            System.out.printf("%-4s | %-26s |  %-4s%n",
                    "No.", "Name", "GPA");
            System.out.println("--------------------------------------------");
            
            // track how many students printed
            int count = 0; 

            //iterate all students by specific course
            for (int j = 0; j < students.size(); j++) {
                Student s = students.get(j);
                if (s.getCourse().equalsIgnoreCase(course)) {
                    count++;
                    System.out.printf("%-4d | %-26s |  %-4.2f%n",
                            count, s.getFullName(), s.getGPA());
                }

                // Stop after top 3
                if (count == 3) {
                    break;
                }
            }

            // If no students found for that course
            if (count == 0) {
                System.out.println("No students found for this course.");
            } 
        }
    }

    public void showDetails() {
        System.out.println("\n----------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-4s | %-12s | %-26s | %-8s | %-10s | %-10s | %-4s%n",
                "No.", "Student ID", "Name", "Gender", "Course", "Year", "GPA");
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < students.size(); i++) {
            System.out.printf("%-4d | %s%n", (i + 1), students.get(i).toString());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }
}
