package com.mycompany.studentmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {

    static ArrayList<User> usersList = new ArrayList();

    public static void startPage(Scanner scan) {
        while (true) {
            System.out.println("\n============ Welcome to DNM Academy =============");
            System.out.println("1. Sign-up");
            System.out.println("2. Login");
            System.out.println("0. Exit");
            System.out.println("================================================");

            System.out.print("\nChoose an action: ");
            int startAction = scan.nextInt();
            //for debugging purposes
            scan.nextLine();

            switch (startAction) {
                case 1:
                    signUp(scan);
                    break;
                case 2:
                    login(scan);
                    break;
                case 3:
                    System.out.println("Closing...");
                    scan.close();
                default:
                    System.out.println("Invalid input!");
            }
        }
    }

    public static void signUp(Scanner scan) {
        System.out.println("\n=========== Registration ============");
        //create a validation that is must end with @gmail.com, @outlook.com, and etc...
        System.out.print("Enter your e-mail: ");
        String email = scan.nextLine();

        //create a validation that it must be a number and it should contain exactly 11 numbers
        System.out.print("Enter your contact number: ");
        String contactNumber = scan.nextLine();

        System.out.print("Enter your username: ");
        String username = scan.nextLine();

        //create a validation that it should contain one special character, atleast one uppercase, atleast one lowercase
        System.out.print("Enter your password: ");
        String password = scan.nextLine();

        System.out.println("You have successfully created an account!");

        User user = new User(email, contactNumber, username, password);
        usersList.add(user);
        home(scan, user);
    }

    public static void login(Scanner scan) {
        System.out.println("\n============ Log-in ===============");
        System.out.print("Enter your username: ");
        String username = scan.nextLine();

        System.out.print("Enter your password: ");
        String password = scan.nextLine();

        //create a validation that if the user is found, proceed to home, if not then login again
        boolean found = false;
        for (User user : usersList) {
            if (user.getUsername().equals(username)) {
                found = true;
                if (user.getPassword().equals(password)) {
                    home(scan, user);
                } else {
                    System.out.println("Incorrect Password. Try Again");
                }
            }
        }

        if (!found) {
            System.out.println("Create an account first!");
            signUp(scan);
        }
    }

    public static void addStudent(Scanner scan, Manager manager) {
        System.out.print("\nEnter name: ");
        String name = scan.nextLine();

        System.out.println("\nGender.");
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.print("Choose a gender: ");
        int genderChooser = scan.nextInt();
        scan.nextLine();
        String gender = "";

        switch (genderChooser) {
            case 1:
                gender = "Male";
                break;
            case 2:
                gender = "Female";
                break;
            default:
                System.out.println("Invalid number!");
                break;
        }

        System.out.println("\nCourse.");
        System.out.println("1. BSArch");
        System.out.println("2. BSCE");
        System.out.println("3. BSIT-MWA");
        System.out.println("4. BSCS-ML");
        System.out.println("5. BSCPE");
        System.out.print("Choose a course: ");
        int courseChooser = scan.nextInt();
        scan.nextLine();
        String course = "";

        switch (courseChooser) {
            case 1:
                course = "BSArch";
                break;
            case 2:
                course = "BSCE";
                break;
            case 3:
                course = "BSIT-MWA";
                break;
            case 4:
                course = "BSCS-ML";
                break;
            case 5:
                course = "BSCPE";
                break;
            default:
                System.out.println("Invalid number!");
                break;
        }

        System.out.println("\nYear.");
        System.out.println("1. 1st Year");
        System.out.println("2. 2nd Year");
        System.out.println("3. 3rd Year");
        System.out.println("4. 4th Year");
        System.out.print("Choose year level: ");
        int yearChooser = scan.nextInt();
        scan.nextLine();
        String year = "";

        switch (yearChooser) {
            case 1:
                year = "1st Year";
                break;
            case 2:
                year = "2nd Year";
                break;
            case 3:
                year = "3rd Year";
                break;
            case 4:
                year = "4th Year";
                break;
            default:
                System.out.println("Invalid number!");
                break;
        }

        System.out.print("Enter GPA: ");
        double GPA = scan.nextDouble();

        //TO DO: GENERATE A RANDOM NUMBER FOR STUDENT ID
        String id = "2025-" + (1000000 + (int) (Math.random() * 10000000));
        manager.add(new Student(id, name, gender, course, year, GPA));

        System.out.println("Successfully Added!");
    }

    public static void updateStudent(Scanner scan, Manager manager) {
        manager.showDetails();
        //Palitan ng enter student id to update
        System.out.print("\nEnter number to update: ");
        int index = scan.nextInt();
        scan.nextLine();

        System.out.println("\n1. Name");
        System.out.println("2. Gender");
        System.out.println("3. Course");
        System.out.println("4. Year");
        System.out.println("5. GPA");

        System.out.print("Choose among the 5 to update: ");
        int update = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter new information: ");
        String newInfo = scan.nextLine();
        switch (update) {
            case 1:
                manager.update(newInfo, index, 1);
                break;
            case 2:
                manager.update(newInfo, index, 2);
                break;
            case 3:
                manager.update(newInfo, index, 3);
                break;
            case 4:
                manager.update(newInfo, index, 4);
                break;
            case 5:
                double gpa = Double.parseDouble(newInfo);
                manager.updateGPA(gpa, index);
                break;
            default:
                System.out.println("Invalid number!");
                break;
        }
    }

    public static void searchStudent(Scanner scan, Manager manager) {
        System.out.println("\n============== Search ===============");
        System.out.print("Search for: ");
        String search = scan.nextLine();

        manager.search(search);

    }

    public static void sortStudent(Scanner scan, Manager manager) {
        System.out.println("\n============== Sort ===============");
        System.out.println("1. Name (From A-Z)");
        System.out.println("2. Name (From Z-A)");
        System.out.println("3. GPA (From Lowest-Highest)");
        System.out.println("4. GPA (From Highest-Lowest)");
        System.out.println("5. Course");

        int sortChooser = scan.nextInt();
        scan.nextLine();

        manager.sortBy(sortChooser);
    }

    public static void home(Scanner scan, User user) {
        //pre-defined students
        Student student;
        Manager manager = new Manager();
        manager.add(new Student("2022-1056789", "Alyssa Nicole S. Bacsal", "Female", "BSCE", "4th Year", 4.0));
        manager.add(new Student("2022-1089224", "Diane Nicole L. Mondejar", "Female", "BSArch", "4th Year", 4.0));
        manager.add(new Student("2025-1023756", "Paula Bianca P. Mosinabre", "Female", "BSIT-MWA", "1st Year", 4.0));
        manager.add(new Student("2023-1034257", "Samantha Lorin G. Hidalgo", "Female", "BSArch", "3rd Year", 4.0));
        manager.add(new Student("2023-1020951", "Jayma Marie M. Magsino", "Female", "BSArch", "3rd Year", 4.0));
        while (true) {
            System.out.println("\n=========== DNM Academy ===========");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Sort Student");
            System.out.println("7. Display Top 3 Students");
            System.out.println("8. View My Information");
            System.out.println("9. Back to Start Page");
            System.out.println("0. Exit");
            System.out.println("==================================");

            System.out.print("Enter your choice: ");
            int action = scan.nextInt();
            scan.nextLine();

            switch (action) {
                case 1:
                    addStudent(scan, manager);
                    break;

                case 2:
                    manager.showDetails();
                    break;

                case 3:
                    updateStudent(scan, manager);
                    break;

                case 4:
                    manager.showDetails();
                    System.out.print("\nEnter a number to delete: ");
                    int num = scan.nextInt();

                    manager.delete(num);
                    System.out.println("Successfully deleted!");
                    break;

                case 5:
                    searchStudent(scan, manager);
                    break;

                case 6:
                    sortStudent(scan, manager);
                    break;

                case 7:
                    break;

                case 8:
                    System.out.println("\n================= My Information ==================");
                    user.showDetails();
                    break;

                case 9:
                    startPage(scan);
                    break;
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        startPage(scan);
    }
}
