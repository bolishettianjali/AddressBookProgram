package com.addressBook;

import java.util.*;
import java.util.stream.Stream;

public class AddressBookProgram {
    static Scanner scanner = new Scanner(System.in);
    static LinkedList<Contact> contactsList;
    static String addressBookName;
    static Map<String, LinkedList> addressBookMap = new HashMap<>();


    public static void main(String[] args) {
        //This variable is used to exit the do while loop when user enters Exit as option.

        System.out.println("Welcome to Address Book Program");

        boolean flag = true;

        do {
            System.out.println("\nEnter a Option: \n1. Create AddressBook\n2. Display all Address Books\n3. Enter a Address Book\n0. Exit Address Book Program");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    createAddressBook();
                    break;
                case 2:
                    displayAddressBookNames();
                    break;
                case 3:
                    enterAddressBook();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("\nEnter any one of the above option: ");

            }
            System.out.println("\n====================================================");
        } while (flag);

        System.out.println("\n-------Thank You-----");
    }

    public static void enterAddressBook() {
        System.out.println("Enter name of Adress book do you want to enter: ");
        displayAddressBookNames();
        String addressBookNameToEnter = scanner.next();
        for (Map.Entry<String, LinkedList> entry : addressBookMap.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(addressBookNameToEnter)) {
                contactsList = entry.getValue();
                addressBookName = entry.getKey();
                break;
            }
        }
        System.out.println("Entered in to " + addressBookName + " Address Book: ");
        contactOperations();
    }

    public static void createAddressBook() {
        System.out.println("\nEnter a name to create new Address Book: ");
        String addressBookNameToCreate = scanner.next().toLowerCase();//key

        if (addressBookMap.containsKey(addressBookNameToCreate)) {
            System.out.println("\nAddress Book " + addressBookNameToCreate + " is already Exists.");
        } else {
            LinkedList<Contact> list = new LinkedList<>();//Value
            addressBookMap.put(addressBookNameToCreate, list);
            System.out.println("\nAddress Book Creted Successfully");
            displayAddressBookNames();
        }
    }

    public static void displayAddressBookNames() {
        System.out.println("\n------Address Books------");
        int i = 1;
        for (String addressBookName : addressBookMap.keySet()) {
            System.out.println(i + "." + addressBookName);
            i++;
        }
    }

    public static void contactOperations() {
        boolean flag = true;
        //do while is used to continue the Address book system until user enters Exit.
        do {
            System.out.println("\n---------" + addressBookName + " Address Book--------");
            //This line is to display options.
            System.out.println(
                    "\nEnter a Option: \n1. Add Contact\n2. Display a Contact\n3. Edit Contact\n4. Delete a Contact\n0. Exit the Address Book");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addContact();
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
        System.out.println("-------" + addressBookName + " Adress Book Exited-------");
    }

    //This method is to print First name in every Contact object which are in array.
    public static void displayAllPersonsFirstName() {
        System.out.println("\nAll Contacts: ");
        for (int i = 0; i < contactsList.size(); i++) {
            System.out.println((i + 1) + ". " + contactsList.get(i).firstName);
        }
    }

    //This method displays the details of a person by taking input as first name.
    public static void displayContactByName() {
        System.out.println("Enter first name of the person to display details: ");
        displayAllPersonsFirstName();
        String nameTodispContact = scanner.next();
        for (Contact contact : contactsList) {
            if (nameTodispContact.equalsIgnoreCase(contact.firstName)) {
                System.out.println(contact);
                break;
            }
        }
    }

    /*This method is to take person details from console and create contact object,
    and returns Contact object.*/
    public static void addContact() {
        System.out.println("\nEnter person-" + (contactsList.size() + 1) + " details: \n");

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
        if (checkContactIsExistsOrNot(contact)) {
            System.out.println("Contact with name '" + firstName + "' is already exists!");
        }
        else {
            contactsList.add(contact);
            System.out.println(contact);
            System.out.println("\nContact Added to '" + addressBookName + "' Address Book successfully.");
        }
    }

    //This method is to edit contact details by taking input as first name and field name.
    public static void editContact() {
        System.out.println("Enter First name of the contact to be edit: ");
        displayAllPersonsFirstName();
        String nameToBeEdit = scanner.next();

        for (Contact contact : contactsList) {
            if (nameToBeEdit.equalsIgnoreCase(contact.firstName)) {
                System.out.println("Enter number of field do you want to edit: ");

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

        for (Contact contact : contactsList) {
            if (contact.firstName.equalsIgnoreCase(nameToBeDelete)) {
                contactsList.remove(contact);
                break;
            }
        }
        System.out.println("\nContact deleted successfully");
    }

    public static boolean checkContactIsExistsOrNot(Contact contactToBeCheck) {

      boolean flag = contactsList.stream().anyMatch(contact -> contact.equals(contactToBeCheck));

      return flag;

    }
}