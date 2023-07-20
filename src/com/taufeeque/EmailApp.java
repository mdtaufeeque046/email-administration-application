package com.taufeeque;

import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Name : ");
        String first_name = sc.next();

        System.out.print("Enter Last Name : ");
        String last_name = sc.next();


        // Create a new Email
        Email emp = new Email(first_name, last_name);

        int choice = -1;
        do {
            System.out.println("--------------------------------------------------");
            System.out.println("What operation you want to perform? " +
                    "\n1. Show Employee Info." +
                    "\n2. Change Password" +
                    "\n3. Change Mailbox Capacity" +
                    "\n4. Set Alternative Email" +
                    "\n5. Exit");

            System.out.print("Please Enter your choice  : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    emp.getEmpInfo();
                    break;
                case 2:
                    emp.changePassword();
                    break;
                case 3:
                    emp.setMailCapacity();
                    break;
                case 4:
                    emp.provideAlterEmail();
                    break;
                case 5:
                    System.out.println("Thanks !!!");
                    break;
                default:
                    System.out.println("Invalid Choice ! Please try again...!");
            }

        } while (choice != 5);


    }
}
