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
                    "\nEnter a Option: \n1. Add Contact\n2. Display a Contact\n3. Edit Contact\n4. Delete a Contact\n0. Exit");
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
                    displayContactByName();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Enter any one of the above option: \n");
            }
            System.out.println("\n====================================================");
        } while (flag);
        System.out.println("------------Thank You--------------");
    }

    //This method is to print First name in every Contact object which are in array.
    public static void displayAllPersonsFirstName() {
        System.out.println("\nAll Contacts: ");
        for (int i = 0; i < noOfContacts; i++) {
            System.out.println((i + 1) + ". " + contacts[i].firstName);
        }
    }

    //This method displays the details of a person by taking input as first name.
    public static void displayContactByName() {
        System.out.println("Enter first name of the person to display details: ");
        displayAllPersonsFirstName();
        String nameTodispContact = scanner.next();
        for (Contact contact : contacts) {
            if (nameTodispContact.equalsIgnoreCase(contact.firstName)) {
                System.out.println(contact);
                break;
            }
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

    //This method is to edit contact details by taking input as first name and field name.
    public static void editContact() {
        System.out.println("Enter First name of the contact to be edit: ");
        displayAllPersonsFirstName();
        String nameToBeEdit = scanner.next();

        for (Contact contact : contacts) {
            if (nameToBeEdit.equalsIgnoreCase(contact.firstName)) {
                System.out.println("Enter number of field 4do you want to edit: ");

                System.out.println("1. First Name\n2. LastName\n3. Address\n4. City\n5. State\n6. Zip\n7. Phone Number\n8. Email");

                int select = scanner.nextInt();

                switch (select) {
                    case 1:
                        System.out.println("Enter First Name: ");
                        String firstName = scanner.next();
                        contact.firstName = firstName;
                        break;
                    case 2:
                        System.out.println("Enter Last Name: ");
                        String lastName = scanner.next();
                        contact.lastName = lastName;
                        break;
                    case 3:
                        System.out.println("Enter Address: ");
                        String address = scanner.next();
                        contact.address = address;
                        break;
                    case 4:
                        System.out.println("Enter City: ");
                        String city = scanner.next();
                        contact.city = city;
                        break;
                    case 5:
                        System.out.println("Enter State: ");
                        String state = scanner.next();
                        contact.state = state;
                        break;
                    case 6:
                        System.out.println("Enter Zip: ");
                        String zip = scanner.next();
                        contact.zip = zip;
                        break;
                    case 7:
                        System.out.println("Enter Phone Number: ");
                        String phoneNumber = scanner.next();
                        contact.phoneNumber = phoneNumber;
                        break;
                    case 8:
                        System.out.println("Enter Email: ");
                        String email = scanner.next();
                        contact.email = email;
                        break;
                    default:
                        System.out.println("Selected number is invalid");
                }
                System.out.println("\n" + contact);
                System.out.println("\nContact Edited Successfully");
                break;
            }
        }
    }//End of the editContact() method.

    //method to delete a contact by name
    public static void deleteContact() {
        System.out.println("Enter First name of the contact to be Delete: ");
        displayAllPersonsFirstName();
        String nameToBeDelete = scanner.next();

        for (int i = 0; i < noOfContacts; i++) {
            if (contacts[i].firstName.equalsIgnoreCase(nameToBeDelete)) {
                for (int j = i; j < noOfContacts - 1; j++) {
                    contacts[j] = contacts[j + 1];
                    if (j + 1 == noOfContacts - 1) {
                        contacts[j + 1] = null;
                        noOfContacts--;
                    }
                }
                break;
            }
        }
        System.out.println("\nContact deleted successfully");
    }
}