package com.mycompany.studentmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {

    static ArrayList<User> usersList = new ArrayList();

    public static void startPage(Scanner scan) {
        while (true) {
            System.out.println("\n========== Welcome to DNM University ===========");
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
        student = new Student("2022-1056789", "Joshua Hong", "BSCE", "4th Year", "Male", 4.0);
        student = new Student("2022-1089224", "Hyunjin Hwang", "BSArch", "4th Year", "Male", 3.25);
        student = new Student("2025-1023756", "Chenle Zhong", "BSIT-MWA", "1st Year", "Male", 3.0);
        student = new Student("2023-1034257", "Giselle Aeri Uchinaga", "BSArch", "3rd Year", "Female", 3.9);
        student = new Student("2023-1020951", "Karina Yoo", "BSArch", "3rd Year", "Female", 3.86);

        while (true) {
            System.out.println("\n========= DNM University =========");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All Student");
            System.out.println("6. Search Student");
            System.out.println("7. Sort Student");
            System.out.println("8. View My Information");
            System.out.println("9. Back to Start Page");
            System.out.println("0. Exit");
            System.out.println("==================================");

            System.out.print("Enter your choice: ");
            int action = scan.nextInt();

            switch (action) {
                case 1:

                case 8:
                    System.out.println("================= My Information ==================");
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
