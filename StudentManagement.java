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
        System.out.print("Enter you username: ");
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

    public static void home(Scanner scan, User user) {
        //pre-defined students
        Student student;
        Manager manager = new Manager();
        manager.add(new Student("2022-1056789", "Joshua Hong", "Male", "BSCE", "4th Year", 4.0));
        manager.add(new Student("2022-1089224", "Hyunjin Hwang", "Male", "BSArch", "4th Year", 3.25));
        manager.add(new Student("2025-1023756", "Chenle Zhong", "Male", "BSIT-MWA", "1st Year", 3.0));
        manager.add(new Student("2023-1034257", "Aeri Uchinaga", "Female", "BSArch", "3rd Year", 3.9));
        manager.add(new Student("2023-1020951", "Karina Yoo", "Female", "BSArch", "3rd Year", 3.86));
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
                    System.out.print("\nEnter name: ");
                    String name = scan.nextLine();

                    //validation that it must be male or female only
                    System.out.print("Enter Gender");
                    String gender = scan.nextLine();
                    if (!(gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("Male"))) {
                        System.out.println("Invalid gender!");
                        break;
                    }

                    System.out.println("Enter course: (BSArch, BSCE, BSIT-MWA, BSCS-ML, BSCPE");
                    String course = scan.nextLine();

                    if (!(course.equalsIgnoreCase("BSARCH") || course.equalsIgnoreCase("BSCE") || course.equalsIgnoreCase("BSIT-MWA") || course.equalsIgnoreCase("BSCS-ML") || course.equalsIgnoreCase("BSCPE"))) {
                        System.out.println("Invalid course!");
                        break;
                    }

                    System.out.println("Enter year level: ");
                    String year = scan.nextLine();

                    System.out.println("Enter GPA");
                    double GPA = scan.nextDouble();

                    //TO DO: GENERATE A RANDOM NUMBER FOR STUDENT ID
                    manager.add(new Student("2024-10978923", name, gender, course, year, GPA));
                    break;

                case 2:
                    manager.showDetails();
                    break;

                case 3:
                    System.out.println("\n============== Update ===============");
                    manager.showDetails();
                    
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
