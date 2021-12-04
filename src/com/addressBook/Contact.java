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

    @Override
    public String toString() {
        return "First Name: " + firstName + "\nLast Name: " + lastName + "\nAddress: "
                + address + "\nCity: " + city + "\nState: " + state + "\nZip: " + zip
                + "\nPhone Number: " + phoneNumber + "\nEmail: " + email;
    }

    @Override
    public boolean equals(Object obj) {

        // If the object is compared with itself then return true
        if (obj == this) {
            return true;
        }
        // Check if obj is an instance of Contact or not
        if (!(obj instanceof Contact)) {
            return false;
        }
        // typecast obj to Contact so that we can compare data members
        Contact contact = (Contact) obj;

        // Compare the data members and return accordingly
        return firstName.equalsIgnoreCase(contact.firstName);
    }
}

