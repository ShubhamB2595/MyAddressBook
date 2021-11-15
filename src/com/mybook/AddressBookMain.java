package com.mybook;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {

		System.out.println("Welcome to Address Book Problem");

		String firstName, lastName, address, city, state, zip, pNumber, email;
		
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

		scan.close();
	}

}
