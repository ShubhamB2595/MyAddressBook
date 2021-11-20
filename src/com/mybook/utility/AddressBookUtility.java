package com.mybook.utility;

import java.util.ArrayList;
import java.util.List;

import com.mybook.Person;
import com.mybook.enums.SortOption;
import com.mybook.exception.AddressBookException;
import com.mybook.service.AddressBookService;

public class AddressBookUtility {

	AddressBookService addressBookService = new AddressBookService();

	// Method To Add Person Records
	public List<Person> addRecord(List<Person> personList) {
		int flag = 0;
		String firstName = null;
		final String lastName, address, city, state, phone, zip, email = null;
		while (flag == 0) {
			firstName = ValidateInputs.validateName("First Name");
			if (checkExists(firstName, personList)) {
				System.out.println("Person Name Already Exists!!\nPlease enter different name...");
			} else {
				flag = 1;
			}
		}
		lastName = ValidateInputs.validateName("Last Name");
		phone = ValidateInputs.validatePhone();
		address = ValidateInputs.validateAddress();
		city = ValidateInputs.validateName("City");
		zip = ValidateInputs.validateZip();
		state = ValidateInputs.validateName("State");
		Person person = new Person(firstName, lastName, address, city, state, zip, phone, email);
		return addressBookService.addContact(personList, person);
	}

	// Method to Check Duplication of First Name

	public boolean checkExists(String firstName, List<Person> person) {
		int flag = person.stream().anyMatch(p -> p.getFirstName().equalsIgnoreCase(firstName)) ? 1 : 0;
		return flag == 1;
	}

	// Method To Delete Person Details
	List<Person> deleteRecord(List<Person> personList) throws AddressBookException {
		List<Person> deleteRecord = new ArrayList<>();
		try {
			int id;
			if (personList.isEmpty()) {
				System.out.println("No Records To Delete!!!");
			} else {
				personList.stream().map(p -> "ID: #" + personList.indexOf(p) + " : " + p).forEach(System.out::println);
				System.out.print("\nEnter #ID to delete Contact : ");
				id = InputUtil.getIntValue();
				deleteRecord = addressBookService.removeContact(personList, id);
			}
		} catch (IndexOutOfBoundsException e) {
			throw new AddressBookException("Entered Wrong #ID", AddressBookException.exceptionType.ENTERED_WRONG_ID);
		}
		return deleteRecord;
	}

	// Method To Search In Person Records

	public void searchInRecords(List<Person> person) {
		int flag = 0;
		while (flag == 0) {
			System.out.println("1. Search By City\n" + "2. Search By State\n" + "3. Back\n" + "Choose Your Option");
			int choice = InputUtil.getIntValue();
			switch (choice) {
			case 1:
				System.out.println("Enter City Name To Search: ");
				String city = InputUtil.getStringValue();
				addressBookService.searchBy(person, city);
				break;
			case 2:
				System.out.println("Enter State Name To Search: ");
				String state = InputUtil.getStringValue();
				addressBookService.searchBy(person, state);
				break;
			case 3:
				flag = 1;
				break;
			default:
				System.out.println("Please Enter Correct Option...");
			}
		}
	}

	// Method To Sort Records By Given Options

	public void sortRecords(List<Person> personList) {
		System.out
				.println("Sort By...\n" + "1: First Name\n" + "2: City\n" + "3: State\n" + "4: Zip Code\n" + "5: Back");
		int choice = InputUtil.getIntValue();
		switch (choice) {
		case 1:
			addressBookService.sortData(personList, SortOption.NAME);
			break;
		case 2:
			addressBookService.sortData(personList, SortOption.CITY);
			break;
		case 3:
			addressBookService.sortData(personList, SortOption.STATE);
			break;
		case 4:
			addressBookService.sortData(personList, SortOption.ZIP);
			break;
		case 5:
			return;
		default:
			System.out.println("Please Enter Valid Option...");
		}
	}
}
