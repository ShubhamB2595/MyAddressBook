package com.mybook.service;

import com.mybook.exception.AddressBookException;

public interface AddressBookInterface {

	void addContact();
	
	void displayContact();
	
	void editContact() throws AddressBookException;
	
	void removeContact() throws AddressBookException;
	
	boolean checkDuplicate(String name);
	
	void sortContacts();
	
	
}
