package com.mybook.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.mybook.Person;
import com.mybook.enums.SortOption;
import com.mybook.exception.AddressBookException;
import com.mybook.utility.WriteToCSV;

public class AddressBookService implements AddressBookInterface {

	List<Person> person = new ArrayList<Person>();

	// methods for sorting operation
	public static void sortData(List<Person> person, SortOption sortOptions) {

		person.stream().sorted(sortOptions.comparator).forEach(System.out::println);
	}

	// methods for searching operation
	public static void searchByCity(List<Person> person) {

		Scanner scan = new Scanner(System.in);
		String search;
		List<Person> matches = new ArrayList<>();
		System.out.println("Enter the city to search: ");
		search = scan.nextLine();
		int flag = 0, count = 0;
		for (Person p : person) {
			if (p.getCity().equalsIgnoreCase(search)) {
				flag = 1;
				matches.add(p);
				count++;
			}
		}

		if (flag == 1) {
			System.out.println("---Match Found---");
			System.out.println("Number of City: " + count);
			for (Person p : matches) {
				System.out.println(p);
			}
		} else {
			System.out.println("Match not found..");
		}

	}

	public static void searchByState(List<Person> person) {

		Scanner scan = new Scanner(System.in);
		String search;
		List<Person> matches = new ArrayList<>();
		System.out.println("Enter the state to search: ");
		search = scan.nextLine();
		int flag = 0, count = 0;
		;
		for (Person p : person) {
			if (p.getState().equalsIgnoreCase(search)) {
				flag = 1;
				matches.add(p);
				count++;
			}
		}

		if (flag == 1) {
			System.out.println("---Match Found---");
			System.out.println("Number of State: " + count);
			for (Person p : matches) {
				System.out.println(p);
			}
		} else {
			System.out.println("Match not found..");
		}

	}

	// method to add contacts
	public LinkedList<Person> addContact(LinkedList<Person> personList) {

		String firstName, lastName, address, city, state, zip, pNumber, email;

		Scanner scan = new Scanner(System.in);

		while (true) {

			System.out.println("Enter the First Name");
			firstName = scan.nextLine();

			if (!(checkDuplicate(firstName, personList))) {
				break;
			} else {
				System.out.println(firstName + " is already exits \n please enter different name");
			}
		}

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

		Person person = new Person(firstName, lastName, address, city, state, zip, pNumber, email);
		personList.add(person);
		return personList;
	}

	// method to display the contact
	public void displayContact(LinkedList<Person> person) {

		if (person.isEmpty()) {
			System.out.println("Contacts are empty");
		} else {
			person.forEach(System.out::println);
		}

	}

	// method to edit the contact
	public LinkedList<Person> editContact(LinkedList<Person> person) throws AddressBookException {

		Scanner scan = new Scanner(System.in);

		try {
			if (person.isEmpty()) {
				System.out.println("No contacts to edit");
			} else {
				String address, city, state, zip, number;
				int index = 0, choice;

				for (Person p : person) {

					System.out.println("ID: " + person.indexOf(p) + " : " + p + "\n");
				}

				System.out.println("Enter ID to edit");
				index = scan.nextInt();

				while (true) {

					System.out.println("Select what you wants to edit \n" + "1.   Address\n" + "2.   City\n"
							+ "3.   State\n" + "4.   Phone Number\n" + "5.   Zip Code\n" + "6.   Save and Exit\n");

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
		} catch (IndexOutOfBoundsException e) {
			throw new AddressBookException("Entered Wrong id", AddressBookException.exceptionType.ENTERED_WRONG_ID);
		}
		return person;
	}

	// method to remove contact
	public LinkedList<Person> removeContact(LinkedList<Person> person) throws AddressBookException {

		try {
			if (person.isEmpty()) {
				System.out.println("No contacts to Delete");
			} else {
				Scanner scan = new Scanner(System.in);
				int index = 0;

				for (Person p : person) {

					System.out.println("ID: " + person.indexOf(p) + " : " + p + "\n");
				}

				System.out.println("Enter ID to edit");
				index = scan.nextInt();
				person.remove(index);
				WriteToCSV.writeFromDelete(person);
			}
		} catch (IndexOutOfBoundsException e) {
			throw new AddressBookException("Entered Wrong id", AddressBookException.exceptionType.ENTERED_WRONG_ID);
		}
		return person;

	}

	// method to check duplicate
	public boolean checkDuplicate(String name, LinkedList<Person> person) {

		int flag = person.stream().anyMatch(p -> p.getFirstName().equalsIgnoreCase(name)) ? 1 : 0;

		return flag == 1;
	}

	// method for sorting the contacts by first name
	public void sortContacts(LinkedList<Person> personList) {

		Scanner scan = new Scanner(System.in);

		System.out
				.println("Sort By...\n" + "1: First Name\n" + "2: City\n" + "3: State\n" + "4: Zip Code\n" + "5: Exit");
		int choice = scan.nextInt();

		switch (choice) {

		case 1:
			sortData(personList, SortOption.NAME);
			break;

		case 2:
			sortData(personList, SortOption.CITY);
			break;

		case 3:
			sortData(personList, SortOption.STATE);
			break;

		case 4:
			sortData(personList, SortOption.ZIP);
			break;

		case 5:
			return;

		default:
			System.out.println("Please Enter Valid Option...");
		}
	}

	public void SearchContact(LinkedList<Person> person) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Search By...\n" + "1:  City\n" + "2: State\n" + "3: Exit");
		int choice = scan.nextInt();

		switch (choice) {

		case 1:
			searchByCity(person);
			break;

		case 2:
			searchByState(person);
			break;

		case 3:
			return;

		default:
			System.out.println("Please Enter Valid Option...");
		}

	}

	@Override
	public void sortContacts() {
		// TODO Auto-generated method stub
		
	}


}
