package com.taufeeque;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Email {


    // Setting the variables
    //Defined the variables as 'private' so that these cannot be accessed directly
    private String name;
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alternativeEmail;

    Scanner sc = new Scanner(System.in);

    // Constructor to receive the first name and the last name

    Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("-------------------------------------------------------");
        System.out.println("New Employee : " + this.firstName + " " + this.lastName);
        System.out.println("-------------------------------------------------------");


        // Calling a method for the department -return the department
        this.department = this.setDepartment();

        // Combine elements to generate an Email
        this.email = this.generateEmail();

        //Call a method that returns a random password
        this.password = this.generatePassword(8);


    }

    // Generating the email according to the given syntax
    private String generateEmail() {
        return this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + ".ncodeit.com";
    }

    private String setDepartment() {
        System.out.println("Department Codes : " +
                "\n1. for Accounting" +
                "\n2. for Development" +
                "\n3. for Sales" +
                "\n0. for None");

        boolean flag = false;
        do {
            System.out.print("Please Enter the Department Code : ");
            int choice = sc.nextInt();
            System.out.println("--------------------------------------------------");

            switch (choice) {
                case 1:
                    return "Accounting";
                case 2:
                    return "Development";
                case 3:
                    return "Sales";
                case 0:
                    return "___";
                default:
                    System.out.println("Invalid Choice. Please Enter Valid Code...!");


            }
        }
        while (!flag);
        return null;

    }

    //Generate a random password
    private String generatePassword(int length) {
        Random r = new Random();

        String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&";

        String values = capitalChars + smallChars + numbers + symbols;

        String password = "";
        for (int i = 0; i < length; i++) {
            password = password + values.charAt(r.nextInt(values.length()));
        }
        return password;

    }

    //Change the password
    public void changePassword() {

        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        do {
            System.out.println("=================================================");
            System.out.print("Are you sure you want to change your password? (Y/N) : ");
            char choice = sc.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.print("Enter current password : ");
                String temp = sc.next();
                if (temp.equals(this.password)) {
                    System.out.print("Enter new password : ");
                    this.password = sc.next();
                    System.out.println("Your password has been reset successfully...!");
                } else {
                    System.out.println("Oops! you have entered, Incorrect Password.. ");
                }
            } else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Cancel request to change password");
            } else {
                System.out.println("Please enter a valid choice..");
            }
        } while (!flag);
    }

    // Set the mailbox capacity
    public void setMailCapacity() {

        System.out.println("Current capacity : " + this.mailCapacity + " mb");
        System.out.print("Enter new capacity : ");
        this.mailCapacity = sc.nextInt();
        System.out.println("Mail box capacity has been changed successfully...!");

    }

    // Set the alternative email
    public void provideAlterEmail() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an alternative email : ");
        this.alternativeEmail = sc.next();
        System.out.println("Alternate email has been set successfully...!");
    }


    // Displaying the Employee's Information
    public void getEmpInfo() {
        System.out.println("--------------Employee Details-------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Name : " + this.firstName + " " + this.lastName);
        System.out.println("Department : " + this.department);
        System.out.println("Email :" + this.email);
        System.out.println("Password : " + this.password);
        System.out.println("Mailbox Capacity : " + this.mailCapacity + " mb");
        System.out.println("Alternative Email : " + this.alternativeEmail);
        System.out.println("--------------------------------------------------");


    }

}
