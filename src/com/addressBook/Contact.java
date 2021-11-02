package com.addressBook;

public class Contact {

    String firstName, lastName, address, city, state, zip, phoneNumber, email;

    public Contact(String firstName, String lastName, String address, String city,
                   String state, String zip, String phoneNumber, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String toString() {
        return "First Name: " + firstName +"\nLast Name: " + lastName + "\nAddress: "
                + address + "\nCity: " + city + "\nState: " + state + "\nZip: " + zip
                + "\nPhone Number: " + phoneNumber + "\nEmail: " + email;
    }
}

