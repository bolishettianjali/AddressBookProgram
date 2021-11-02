package com.addressBook;
import java.util.Scanner;

public class AddressBookProgram {

    static Scanner scanner = new Scanner(System.in);
    static Contact[] contacts;

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program\n");

        //To take no.of contacts to be added for creating an array for saving contact objects.
        System.out.println("Enter how many Contacts do you want add: ");
        int noOfContacts = scanner.nextInt();
        contacts = new Contact[noOfContacts]; //Created an array with size of no.of contacts to be add.

        //for loop to take details and save Contact objects in Contact array.
        for (int i = 0; i < contacts.length; i++) {
            System.out.println("\nEnter person-"+(i+1)+" details: \n");
            Contact contact = addContact();
            contacts[i] = contact;
        }
    }

    //Method to take input and create a Contact
    public static Contact addContact() {
        System.out.println("Enter First Name:");
        String firstName = scanner.next();
        System.out.println("Enter Last Name:");
        String lastName = scanner.next();
        System.out.println("Enter Address:");
        String address = scanner.next();
        System.out.println("Enter City:");
        String city = scanner.next();
        System.out.println("Enter State:");
        String state = scanner.next();
        System.out.println("Enter Zip:");
        String zip = scanner.next();
        System.out.println("Enter Phone Number:");
        String phoneNumber = scanner.next();
        System.out.println("Enter email:");
        String email = scanner.next();

        Contact contact = new Contact(firstName, lastName, address, city,
                state, zip, phoneNumber, email);

        System.out.println(contact);

        return contact;
    }

}

