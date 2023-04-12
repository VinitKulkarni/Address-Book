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

    public void displayContactDetails(){
        System.out.println("--- CONTACT DETAILS ---");
        System.out.println("FIRST NAME => " + firstName);
        System.out.println("LAST NAME => " + lastName);
        System.out.println("ADDRESS => " + address);
        System.out.println("CITY => " + city);
        System.out.println("STATE => " + state);
        System.out.println("ZIP => " + zip);
        System.out.println("PHONE NUMBER => " + phoneNumber);
        System.out.println("EMAIL ID => " + emailId);
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

    static void editContact(String name, Contact contactArray[]) {
        Scanner sc = new Scanner(System.in);

        boolean flag = false;
        if (contactArray[0].firstName.equals(name)) {
            flag = true;
            if (flag == true) {
                System.out.println("1.LastName 2.Address 3.City 4.State 5.ZipCode 6.PhoneNumber 7.Email 8.Exit");
                int editOption = sc.nextInt();
                switch (editOption) {
                    case 1:
                        System.out.print("Edit last name:");
                        String tempLastName = sc.next();
                        contactArray[0].lastName = tempLastName;
                        break;
                    case 2:
                        System.out.print("Edit address:");
                        String tempAddress = sc.next();
                        contactArray[0].address = tempAddress;
                        break;
                    case 3:
                        System.out.print("Edit city:");
                        String tempCity = sc.next();
                        contactArray[0].city = tempCity;
                        break;
                    case 4:
                        System.out.print("Edit state:");
                        String tempState = sc.next();
                        contactArray[0].state = tempState;
                        break;
                    case 5:
                        System.out.print("Edit zip:");
                        int tempZip = sc.nextInt();
                        contactArray[0].zip = tempZip;
                        break;
                    case 6:
                        System.out.print("Edit phone:");
                        long tempPhoneNumber = sc.nextLong();
                        contactArray[0].phoneNumber = tempPhoneNumber;
                        break;
                    case 7:
                        System.out.print("Edit email:");
                        String tempEmail = sc.next();
                        contactArray[0].emailId = tempEmail;
                        break;
                    case 8:
                        System.exit(100);
                        break;
                    default:
                        System.out.println("!!!something went wrong!!!");
                        break;
                    }
                } else {
                    flag = false;
                }
            }
        if (flag == false)
            System.out.println(name + " not found in address book");
    }

    static void displayContacts(Contact contactArray[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("================");
        System.out.println();

        if(contactArray[0] == null)
            System.out.println();
        else
            contactArray[0].displayContactDetails();

        System.out.println();
        System.out.println("================");
    }

    public static void main(String[] args) {
        System.out.println(" * * * WELCOME TO ADDRESS BOOK * * * ");
        Contact contactArray[] = new Contact[1];
        Scanner sc = new Scanner(System.in);

        int temp = 1;
        while (temp != 0) {
            System.out.println("[1.ADD_CONTACT]  [2.EDIT]  [3.DISPLAY]  [4.EXIT]");
            System.out.print("choice:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addContact(contactArray);
                    break;
                case 2:
                    System.out.print("Enter person name you want to edit the details:");
                    String name = sc.next();
                    editContact(name, contactArray);
                    break;
                case 3:
                    displayContacts(contactArray);
                    break;
                case 4:
                    temp = 0;
                    break;
                default:
                    System.out.println("!!!something went wrong!!!");
                    break;
            }
        }
    }
}
