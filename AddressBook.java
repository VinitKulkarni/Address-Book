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
    int uniqueNumber;

    public Contact(String firstName, String lastName, String address, String city, String state, int zip,
                   long phoneNumber, String emailId, int uniqueNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.uniqueNumber = uniqueNumber;
    }

    public void displayContactDetails(){
        System.out.println("--- CONTACT DETAILS ---");
        System.out.println("UNIQUE NUMBER => " + uniqueNumber);
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
    static int index = 0;
    static int number = 1;

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

        while(index >= 0 && index < contactArray.length) {
            int uniqueNumber = number;
            number++;

            contactArray[index] = new Contact(fName, lName, address, city, state, zip, phoneNumber, email, uniqueNumber);
            index++;
            break;
        }
    }

    static void editContact(String name, Contact contactArray[]) {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        for (int i = 0; i < contactArray.length; i++) {
            if (contactArray[i].firstName.equals(name)) {
                flag = true;
                if (flag == true) {
                    System.out.println("1.lastName 2.address 3.city 4.state 5.zip 6.phoneNumber 7.email 8.exit");
                    int editOption = sc.nextInt();
                    switch (editOption) {
                        case 1:
                            System.out.print("edit last name:");
                            String tempLastName = sc.next();
                            contactArray[i].lastName = tempLastName;
                            break;
                        case 2:
                            System.out.print("edit address:");
                            String tempAddress = sc.next();
                            contactArray[i].address = tempAddress;
                            break;
                        case 3:
                            System.out.print("edit city:");
                            String tempCity = sc.next();
                            contactArray[i].city = tempCity;
                            break;
                        case 4:
                            System.out.print("edit state:");
                            String tempState = sc.next();
                            contactArray[i].state = tempState;
                            break;
                        case 5:
                            System.out.print("edit zip:");
                            int tempZip = sc.nextInt();
                            contactArray[i].zip = tempZip;
                            break;
                        case 6:
                            System.out.print("edit phone:");
                            long tempPhoneNumber = sc.nextLong();
                            contactArray[i].phoneNumber = tempPhoneNumber;
                            break;
                        case 7:
                            System.out.print("edit email:");
                            String tempEmail = sc.next();
                            contactArray[i].emailId = tempEmail;
                            break;
                        case 8:
                            System.exit(100);
                            break;
                        default:
                            System.out.println("something went wrong");
                            break;
                    }
                    break;
                } else {
                    flag = false;
                }
            }
        }
        if (flag == false)
            System.out.println(name + " not found in address book");
    }

    static void displayContacts(Contact contactArray[]){
        System.out.println("================");
        System.out.println();

        for(int i=0; i<contactArray.length; i++){
            if(contactArray[i] == null)
                System.out.println();
            else
                contactArray[i].displayContactDetails();
        }
        System.out.println();

        System.out.println("================");
    }

    static void deleteContact(String deleteName, Contact contactArray[]){
        boolean flag = false;
        for (int i = 0; i < contactArray.length; i++) {
            if(contactArray[i] == null) {
                System.out.println();
            }
            else {
                if (contactArray[i].firstName.equals(deleteName)){
                    flag = true;
                    contactArray[i] = null;
                    break;
                }
            }
        }
        if (flag == false)
            System.out.println(deleteName + " not found in address book");
    }

    public static void main(String[] args) {
        System.out.println(" * * * WELCOME TO ADDRESS BOOK * * * ");
        Contact contactArray[] = new Contact[3];
        Scanner sc = new Scanner(System.in);

        int temp = 1;
        while (temp != 0) {
            System.out.println("[1.ADD_CONTACT]  [2.EDIT]  [3.DISPLAY]  [4.DELETE]  [5.EXIT]");
            System.out.print("choice:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if(index == contactArray.length){
                        System.out.println("address book memory is full");
                        System.out.println("you cannot add new contacts");
                    }else {
                        addContact(contactArray);
                    }
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
                    System.out.print("Enter person name you want to delete the details:");
                    String deleteName = sc.next();
                    deleteContact(deleteName, contactArray);
                    break;
                case 5:
                    temp = 0;
                    break;
                default:
                    System.out.println("!!!something went wrong!!!");
                    break;
            }
        }
    }
}
