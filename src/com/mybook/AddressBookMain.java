package com.mybook;

import java.util.Scanner;

public class AddressBookMain {

	
	public static void main(String[] args) {

		Contacts contact = new Contacts();
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			//Menu of address book
			System.out.println("Address Book Menu");
			System.out.println();
			System.out.println("1.   Add New Person to Contacts");
			System.out.println("2.   Display Contacts");
			System.out.println("3.   Exit");
			System.out.println();
			System.out.println("Enter your choice");
			
			int choice = scan.nextInt();
			
			//switch cases
			switch(choice) {
			
			case 1:
				contact.addContact();
				break;
				
			case 2:
				contact.displayContact();
				break;
				
			case 3:
				System.out.println("Closing the menu");
				System.exit(1);
			}
			
		}

		
	}

}
