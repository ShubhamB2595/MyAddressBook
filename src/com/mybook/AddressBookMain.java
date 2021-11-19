package com.mybook;

import java.util.Scanner;

import com.mybook.exception.AddressBookException;
import com.mybook.service.AddressBookService;

public class AddressBookMain {

	public static void main(String[] args) throws AddressBookException {
		
		AddressBookService addBook = new AddressBookService();

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

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
				addBook.addContact();
				break;

			case 2:
				addBook.displayContact();
				break;
				
			case 3:
				addBook.editContact();
				break;
				
			case 4:
				addBook.removeContact();
				break;
				
			case 5:
				addBook.SearchContact();
				break;

			case 6:
				addBook.sortContacts();
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
