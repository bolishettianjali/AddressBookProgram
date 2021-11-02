package com.addressBook;
import java.util.Scanner;

public class AddressBookProgram {


    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program\n");
        addContact();
    }

    public static void addContact() {
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
    }

}