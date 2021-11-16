package com.mybook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contacts {

	List<Person> person = new ArrayList<Person>();

	// constructor
	public Contacts() {

	}

	// method to add contacts
	public void addContact() {

		String firstName, lastName, address, city, state, zip, pNumber, email;

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the First Name");
		firstName = scan.nextLine();

		System.out.println("Enter the Last Name");
		lastName = scan.nextLine();

		System.out.println("Enter the Address");
		address = scan.nextLine();

		System.out.println("Enter the City");
		city = scan.nextLine();

		System.out.println("Enter the State");
		state = scan.nextLine();

		System.out.println("Enter the Zip code");
		zip = scan.nextLine();

		System.out.println("Enter the Phone Number");
		pNumber = scan.nextLine();

		System.out.println("Enter the Email ID");
		email = scan.nextLine();

		person.add(new Person(firstName, lastName, address, city, state, zip, pNumber, email));
	}

	// method to display the contact
	public void displayContact() {

		if (person.isEmpty()) {
			System.out.println("Contacts are empty");
		} else {
			for (Person p : person) {

				System.out.println(p);
			}
		}

	}

	// method to edit the contact
	public void editContact() {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		// declaration
		String address, city, state, zip, number;
		int index = 0, choice;

		for (Person p : person) {

			System.out.println("ID: " + person.indexOf(p) + " : " + p + "\n");
		}

		System.out.println("Enter ID to edit");
		index = scan.nextInt();

		while (true) {

			System.out.println("Select what you wants to edit \n" + "1.   Address\n" + "2.   City\n" + "3.   State\n"
					+ "4.   Phone Number\n" + "5.   Zip Code\n" + "6.   Save and Exit\n");

			choice = scan.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Enter new Address");
				address = scan.nextLine();
				person.get(index).setAddress(address);
				break;

			case 2:
				System.out.println("Enter new City");
				city = scan.nextLine();
				person.get(index).setCity(city);
				break;

			case 3:
				System.out.println("Enter new State");
				state = scan.nextLine();
				person.get(index).setState(state);
				break;

			case 4:
				System.out.println("Enter new Phone Number");
				number = scan.nextLine();
				person.get(index).setpNumber(number);
				break;

			case 5:
				System.out.println("Enter new Zip Code");
				zip = scan.nextLine();
				person.get(index).setZip(zip);
				break;

			case 6:
				System.out.println("Done & Exit");
				System.exit(1);
				break;

			default:
				System.out.println("Enter correct choice");
			}

			System.out.println(person.get(index));
		}
	}

	// method to remove contact
	public void removeContact() {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int index = 0;

		for (Person p : person) {

			System.out.println("ID: " + person.indexOf(p) + " : " + p + "\n");
		}

		System.out.println("Enter ID to edit");
		index = scan.nextInt();
		person.remove(index);

	}
}
