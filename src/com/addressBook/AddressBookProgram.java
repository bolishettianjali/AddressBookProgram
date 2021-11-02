package com.addressBook;

public class AddressBookProgram {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program\n");

        Contact contact = new Contact("Anjali", "Bolishetti",
                "Annaram", "Nalgonda", "Telangana", "123456",
                "1234567891", "anjali@gmail.com");

        System.out.println(contact);
    }
}