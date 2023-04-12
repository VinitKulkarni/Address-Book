package com.bridgelabz.addressbook;

import java.util.Scanner;

class Contact {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    int zip;
    long phoneNumber;
    String emailId;

    public Contact(String firstName, String lastName, String address, String city, String state, int zip,
                   long phoneNumber, String emailId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }
}

public class AddressBook {

    static void addContact(Contact contactArray[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the First Name:");
        String fName = sc.next();

        System.out.print("Enter the Last Name:");
        String lName = sc.next();

        System.out.print("Enter the Address:");
        String address = sc.next();

        System.out.print("Enter the City Name:");
        String city = sc.next();

        System.out.print("Enter the State Name:");
        String state = sc.next();

        System.out.print("Enter the ZIP Code:");
        int zip = sc.nextInt();

        System.out.print("Enter the Phone Number:");
        long phoneNumber = sc.nextLong();

        System.out.print("Enter the Email Id:");
        String email = sc.next();

        contactArray[0] = new Contact(fName, lName, address, city, state, zip, phoneNumber, email);
    }

    public static void main(String[] args) {
        System.out.println(" * * * WELCOME TO ADDRESS BOOK * * * ");
        Contact contactArray[] = new Contact[1];
        Scanner sc = new Scanner(System.in);

        int temp = 1;
        while (temp != 0) {
            System.out.println("[1.ADD_CONTACT]  [2.EXIT]");
            System.out.print("choice:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addContact(contactArray);
                    break;
                case 2:
                    temp = 0;
                    break;
                default:
                    System.out.println("!!!something went wrong!!!");
                    break;
            }
        }
    }
}
