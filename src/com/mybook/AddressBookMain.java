package com.mybook;

import java.util.LinkedList;
import java.util.Scanner;

import com.mybook.service.AddressBookService;
import com.mybook.utility.FileOperations;

public class AddressBookMain {

	public static void main(String[] args) throws Exception {
		final String JSON_SIMPLE_FILE_PATH = "src/main/resources/JSonSimpleAddressBook.json";
		final String OPEN_CSV_FILE_PATH = "src/main/resources/CSVAddressBook.csv";
		final int jsonSampleOperation = 1, openCSVOperation = 2;
		int operations = 0, flag = 0;
		String filePath = null;
		LinkedList<Person> personList;
		FileOperations fileOperations = new FileOperations();

		final AddressBookService addBook = new AddressBookService();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.println("Select Below Operations:\n1. JSON SAMPLE\n2. OPEN CSV \n");
		int option = scan.nextInt();
		switch (option) {
		case 1:
			filePath = JSON_SIMPLE_FILE_PATH;
			operations = jsonSampleOperation;
			break;
		case 2:
			filePath = OPEN_CSV_FILE_PATH;
			operations = openCSVOperation;
			break;
		}

		while (true) {

			// Menu of address book
			System.out.println("Address Book Menu");
			System.out.println();
			System.out.println("1.   Add New Contacts");
			System.out.println("2.   Display Contacts");
			System.out.println("3.   Edit Contacts");
			System.out.println("4.   Delete Contacts");
			System.out.println("5.   Search Contacts");
			System.out.println("6.   Sort Contacts");
			System.out.println("7.   Exit");
			System.out.println();
			System.out.println("Enter your choice");

			int choice = scan.nextInt();

			// switch cases
			switch (choice) {

			case 1:
				personList = fileOperations.getDataInList(filePath, operations);
				personList = addBook.addContact(personList);
				fileOperations.convertToFile(personList, filePath, operations);
				break;
			case 2:
				LinkedList<Person> person = fileOperations.getDataInList(filePath, operations);
				addBook.displayContact(person);
				break;
			case 3:
				personList = fileOperations.getDataInList(filePath, operations);
				personList = addBook.editContact(personList);
				fileOperations.convertToFile(personList, filePath, operations);

				break;
			case 4:
				personList = fileOperations.getDataInList(filePath, operations);
				personList = addBook.removeContact(personList);
				fileOperations.convertToFile(personList, filePath, operations);
				break;
			case 5:
				personList = fileOperations.getDataInList(filePath, operations);
				addBook.sortContacts(personList);
				break;
			case 6:
				personList = fileOperations.getDataInList(filePath, operations);
				addBook.SearchContact(personList);
				break;
			case 7:
				System.out.println("Closing the menu");
				System.exit(1);

			default:
				System.out.println("Please enter valid option");

			}

		}

	}

}
