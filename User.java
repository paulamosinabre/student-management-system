package com.mycompany.studentmanagement;

public class User {

    private String email, contactNumber, username, password;

    public User(String email, String contactNumber, String username, String password) {
        this.email = email;
        this.contactNumber = contactNumber;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void showDetails() {
        System.out.println("E-mail: " + email);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Username: " + username);
    }
}
