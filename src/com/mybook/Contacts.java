package com.mybook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contacts {

	List<Person> person = new ArrayList<Person>();
	
	//constructor
	public Contacts() {
		
	}

	
	//method to add contacts
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
	
	
	//method to display the contact
	public void displayContact() {
		
		for(Person p : person) {
			
			System.out.println(p);
		}
	}
}
