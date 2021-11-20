package com.mybook;

import java.util.List;
import com.mybook.exception.AddressBookException;
import com.mybook.service.AddressBookService;
import com.mybook.service.DataBaseCRUDOperations;
import com.mybook.service.SearchSortOperations;
import com.mybook.utility.AddressBookUtility;
import com.mybook.utility.FileOperations;
import com.mybook.utility.InputUtil;

public class AddressBookMain {

	public static void main(String[] args) throws AddressBookException, Exception {
		final String JSON_SIMPLE_FILE_PATH = "src/main/resources/JSonSimpleAddressBook.json";
		final String OPEN_CSV_FILE_PATH = "src/main/resources/CSVAddressBook.csv";
		final String GSON_JSON_FILE_PATH = "src/main/resources/gsonJSONAddressBook.json";
		final int jsonSampleOperation = 1, openCSVOperation = 2, gsonOperation = 3;
		int operations = 0;
		String filePath = null;
		List<Person> personList;
		FileOperations fileOperations = new FileOperations();
		DataBaseCRUDOperations dataBaseCRUDOperations = new DataBaseCRUDOperations();
		SearchSortOperations searchSortOperations = new SearchSortOperations();
		AddressBookUtility addressBookUtility = new AddressBookUtility();
		final AddressBookService addBook = new AddressBookService();

		System.out.println(
				"Select Below Operations:\n1. JSON SAMPLE\n2. OPEN CSV \n3. Using GSON \n4. Using MySQL Database \n");
		int option = InputUtil.getIntValue();
		switch (option) {
		case 1:
			filePath = JSON_SIMPLE_FILE_PATH;
			operations = jsonSampleOperation;
			break;
		case 2:
			filePath = OPEN_CSV_FILE_PATH;
			operations = openCSVOperation;
			break;
		case 3:
			filePath = GSON_JSON_FILE_PATH;
			operations = gsonOperation;
			break;
		case 4:
			break;
		default:
			System.out.println("Invalid choice");
			System.exit(0);
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

			int choice = InputUtil.getIntValue();

			// switch cases
			switch (choice) {

			case 1:
				if (option == 4) {
                    dataBaseCRUDOperations.addRecordToDB();
                    break;
                }
				personList = fileOperations.getDataInList(filePath, operations);
				personList = addressBookUtility.addRecord(personList);
				fileOperations.convertToFile(personList, filePath, operations);
				break;
			case 2:
				if (option == 4) {
                    List<Person> personDetails = dataBaseCRUDOperations.getDataFromDB();
                    addBook.displayContact(personDetails);
                    break;
                }
				personList = fileOperations.getDataInList(filePath, operations);
				addBook.displayContact(personList);
				break;
			case 3:
				 if (option == 4) {
                     dataBaseCRUDOperations.editPersonDetails();
                     break;
                 }
				personList = fileOperations.getDataInList(filePath, operations);
				personList = addBook.editContact(personList);
				fileOperations.convertToFile(personList, filePath, operations);

				break;
			case 4:
				if (option == 4) {
                    dataBaseCRUDOperations.deleteRecord();
                    break;
                }
				personList = fileOperations.getDataInList(filePath, operations);
				personList = addBook.removeContact(personList,operations);
				fileOperations.convertToFile(personList, filePath, operations);
				break;
			case 5:
				if (option == 4) {
                    searchSortOperations.sortRecords();
                    break;
                }
				personList = fileOperations.getDataInList(filePath, operations);
				addressBookUtility.sortRecords(personList);
				break;
			case 6:
				if (option == 4) {
                    searchSortOperations.searchInRecords();
                    break;
                }
				personList = fileOperations.getDataInList(filePath, operations);
				addressBookUtility.searchInRecords(personList);
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
