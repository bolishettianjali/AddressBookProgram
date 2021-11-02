package com.addressBook;
import java.util.Scanner;

public class AddressBookProgram {


    static Scanner scanner = new Scanner(System.in);
    static Contact[] contacts;
    static int noOfContacts;

    public static void main(String[] args) {
        //This variable is used to exit the do while loop when user enters Exit as option.
        boolean flag = true;
        System.out.println("Welcome to Address Book Program");

        //do while is used to continue the Address book system until user enters Exit.
        do {
            //This line is to display options.
            System.out.println(
                    "\nEnter a Option: \n1. Add Contact\n2. Display All Contacts" + "\n3. Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    //This if conditions checks weather Contacts arrys is empty or not,
                    //If array is empty it creates an Contact array.
                    if (contacts == null) {
                        System.out.println("Enter how many Contacts do you want add: ");
                        noOfContacts = scanner.nextInt();
                        contacts = new Contact[noOfContacts];
                        noOfContacts = 0;
                    }
                    //It Checks the contacts added in array were less than array size,
                    // and have space in array, if its true then a new contact will be added.
                    if (noOfContacts < contacts.length) {
                        System.out.println("\nEnter person-" + (noOfContacts + 1) + " details: \n");
                        Contact contact = addContact();
                        contacts[noOfContacts] = contact;
                        noOfContacts++;
                    } else {
                        System.out.println("\nAddress book is full can not be added new Contact");
                    }
                    break;
                case 2:
                    displayPersonNames();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Enter any one of the above option: \n");
            }
        } while (flag);
        System.out.println("------------Thank You--------------");
    }

    //This method is to print First name in every contact object which are in array.
    public static void displayPersonNames() {
        System.out.println("\nAll Contacts: ");
        for (int i = 0; i < noOfContacts; i++) {
            System.out.println((i + 1) + ". " + contacts[i].firstName);
        }
    }

    /*This method is to take person details from console and create contact object,
    and returns Contact object.*/
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

        Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        System.out.println(contact);
        System.out.println("\nContact Added to Address Book successfully.");
        return contact;
    }
}
