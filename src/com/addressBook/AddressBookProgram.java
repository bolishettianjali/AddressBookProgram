package com.addressBook;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AddressBookProgram {
    static Scanner scanner = new Scanner(System.in);
    static LinkedList<Contact> contactsList;
    static String addressBookName;
    static Map<String, LinkedList> addressBookMap = new HashMap<>();
    static Map<String, String> cityAndPersonsMap = new HashMap<>();
    static Map<String, String> stateAndPersonsMap = new HashMap<>();


    public static void main(String[] args) {
        //This variable is used to exit the do while loop when user enters Exit as option.

        System.out.println("Welcome to Address Book Program");

        boolean flag = true;

        do {
            System.out.println("\nEnter a Option: \n1. Create AddressBook\n2. Display all Address Books\n3. Enter a Address Book" +
                    "\n4. Search a Person in a city across all Address Books\n5. View persons in City or State" +
                    "\n6. Count no.of persons in city or state\n0. Exit Address Book Program");
            String option = scanner.next();

            switch (option) {
                case "1":
                    createAddressBook();
                    break;
                case "2":
                    displayAddressBookNames();
                    break;
                case "3":
                    enterAddressBook();
                    break;
                case "4":
                    searchPersonInCityAcrossAllAddressBooks();
                    break;
                case "5":
                    displayPersonsByCityOrState();
                    break;
                case "6":
                    getNoOfPersonsCountInCityOrState();
                    break;
                case "0":
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
        System.out.println("\nEntered in to " + addressBookName + " Address Book: ");
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

    /**
     * Method is to view persons in City or State
     */
    public static void displayPersonsByCityOrState() {

        System.out.println("Enter a option to show persons in : \n1 - city: \n2 - state: ");
        String option = scanner.next();
        if (option.equals("1")) {
            System.out.println("Enter City Name: ");
            String city = scanner.next();

            cityAndPersonsMap.forEach((key, value) -> {
                if (value.equalsIgnoreCase(city)) {
                    System.out.println("Person Name: " + key + ", City: " + value);
                }
            });
        } else if (option.equals("2")) {
            System.out.println("Enter State Name: ");
            String state = scanner.next();

            stateAndPersonsMap.forEach((key, value) -> {
                if (value.equalsIgnoreCase(state)) {
                    System.out.println("Person Name: " + key + ", State: " + value);
                }
            });
        } else {
            System.out.println("Entered invalid option");
        }
    }

    /**
     * Method is used to count toatal no of persons in a city or state.
     */
    public static void getNoOfPersonsCountInCityOrState() {
        System.out.println("Enter a option to show persons in : \n1 - city: \n2 - state: ");
        String option = scanner.next();
        if (option.equals("1")) {
            System.out.println("Enter City Name: ");
            String city = scanner.next();
            long totalPersonsInCity = cityAndPersonsMap.entrySet().stream().filter(count -> count.getValue().equalsIgnoreCase(city)).count();
            System.out.println("Number of Persons In City " + city + ": " + totalPersonsInCity);
        }
        else if (option.equals("2")) {
            System.out.println("Enter State Name: ");
            String state = scanner.next();
            long totalPersonsInState = stateAndPersonsMap.entrySet().stream().filter(count -> count.getValue().equalsIgnoreCase(state)).count();
            System.out.println("Number of Persons In State " + state + ": " + totalPersonsInState);
        }
    }

    public static void contactOperations() {
        boolean flag = true;
        //do while is used to continue the Address book system until user enters Exit.
        do {
            System.out.println("\n---------" + addressBookName + " Address Book--------");
            //This line is to display options.
            System.out.println(
                    "\nEnter a Option: \n1. Add Contact\n2. Display a Contact by name\n3. Edit Contact" +
                            "\n4. Delete a Contact\n5. Display all Contact Names" +
                            "\n6. Sort and display contacts\n0. Exit " + addressBookName + " Address Book");
            String option = scanner.next();

            switch (option) {
                case "1":
                    addContact();
                    break;
                case "2":
                    displayContactByName();
                    break;
                case "3":
                    editContact();
                    break;
                case "4":
                    deleteContact();
                    break;
                case "5":
                    displayAllContactPersonNames();
                    break;
                case "6":
                    sortContactsByPersonsName();
                    break;
                case "0":
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
        IntStream.range(0, contactsList.size()).mapToObj(i -> (i + 1) + ". " + contactsList.get(i).firstName).forEachOrdered(System.out::println);
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
        } else {
            contactsList.add(contact);
            System.out.println(contact);
            System.out.println("\nContact Added to '" + addressBookName + "' Address Book successfully.");
            cityAndPersonsMap.put(firstName, city);
            stateAndPersonsMap.put(firstName, state);
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

    /**
     * This method is used to print all contacts first name
     */
    public static void displayAllContactPersonNames() {
        int i = 1;
        for (Contact contact : contactsList) {
            System.out.println(i++ + ". " + contact.firstName);
        }
    }

    /**
     * This method is to check weather a contact is exists or not.
     *
     * @param contactToBeCheck
     * @return
     */
    public static boolean checkContactIsExistsOrNot(Contact contactToBeCheck) {
        return contactsList.stream().anyMatch(contact -> contact.equals(contactToBeCheck));
    }

    /**
     * This method is used to search person in city across all AddressBooks
     */
    public static void searchPersonInCityAcrossAllAddressBooks() {
        System.out.println("\nEnter First Name: ");
        String firstName = scanner.next();
        System.out.println("Enter City Name: ");
        String city = scanner.next();

        addressBookMap.forEach((key, value) -> {
            LinkedList<Contact> contactList = value;
            for (Contact contact : contactList) {
                if (contact.firstName.equalsIgnoreCase(firstName) && contact.city.equalsIgnoreCase(city)) {
                    System.out.println("\nAddress Book Name: " + key);
                    System.out.println("City Name: " + contact.city);
                    System.out.println("Person Name: " + contact.firstName);
                }
            }
        });
    }

    /**
     * Method is used to sort contacts alphabetically in a Address Book by persons Name.
     */
    public static void sortContactsByPersonsName() {
        List<Contact> contacts = contactsList.stream().sorted(Comparator.comparing(contact -> contact.firstName)).collect(Collectors.toList());
        contactsList.clear();
        contactsList.addAll(contacts);
        displayAllPersonsFirstName();
    }
}