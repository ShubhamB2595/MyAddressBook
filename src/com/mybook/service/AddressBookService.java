package com.mybook.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.mybook.Person;
import com.mybook.enums.SortOption;
import com.mybook.exception.AddressBookException;
import com.mybook.utility.InputUtil;

public class AddressBookService implements AddressBookInterface {

	List<Person> person = new ArrayList<Person>();

	// methods for sorting operation
	public void sortData(List<Person> person, SortOption sortOptions) {

		person.stream().sorted(sortOptions.comparator).forEach(System.out::println);
	}

	// methods for searching operation
	public void searchBy(List<Person> person, String searchItem) {

		List<Person> matches = new ArrayList<>();
		int flag = 0;
		for (Person p : person) {
			if (p.getCity().equalsIgnoreCase(searchItem)) {
				flag = 1;
				matches.add(p);
			} else if (p.getState().equalsIgnoreCase(searchItem)) {
				flag = 1;
				matches.add(p);
			}
		}
		if (flag == 1) {
			System.out.println("---Match Found---");
			matches.forEach(System.out::println);
		} else {
			System.out.println("Match not found..");
		}
	}

	// method to add contacts
	public List<Person> addContact(List<Person> personList, Person person) {

		personList.add(person);
		return personList;
	}

	// method to display the contact
	public void displayContact(List<Person> person) {

		if (person.isEmpty()) {
			System.out.println("Contacts are empty");
		} else {
			person.forEach(System.out::println);
		}
	}

	// method to edit the contact
	public List<Person> editContact(List<Person> person) throws AddressBookException {

		String address, city, state, zip, number;
		int index = 0, choice;
		try {
			if (person.isEmpty()) {
				System.out.println("No contacts to edit");
			} else {
				for (Person p : person) {
					System.out.println("ID: " + person.indexOf(p) + " : " + p + "\n");
				}

				System.out.println("Enter ID to edit");
				index = InputUtil.getIntValue();

				while (true) {

					System.out.println("Select what you wants to edit \n" + "1.   Address\n" + "2.   City\n"
							+ "3.   State\n" + "4.   Phone Number\n" + "5.   Zip Code\n" + "6.   Save and Exit\n");

					choice = InputUtil.getIntValue();

					switch (choice) {

					case 1:
						System.out.println("Enter new Address");
						address = InputUtil.getStringValue();
						person.get(index).setAddress(address);
						break;

					case 2:
						System.out.println("Enter new City");
						city = InputUtil.getStringValue();
						person.get(index).setCity(city);
						break;

					case 3:
						System.out.println("Enter new State");
						state = InputUtil.getStringValue();
						person.get(index).setState(state);
						break;

					case 4:
						System.out.println("Enter new Phone Number");
						number = InputUtil.getStringValue();
						person.get(index).setpNumber(number);
						break;

					case 5:
						System.out.println("Enter new Zip Code");
						zip = InputUtil.getStringValue();
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
	@Override
	public List<Person> removeContact(List<Person> personList, int id) {

		personList.remove(id);
		return person;

	}

	// method to check duplicate
	public boolean checkDuplicate(String name, LinkedList<Person> person) {

		int flag = person.stream().anyMatch(p -> p.getFirstName().equalsIgnoreCase(name)) ? 1 : 0;

		return flag == 1;
	}

}
