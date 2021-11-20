package com.mybook.service;

import java.util.LinkedList;

import com.mybook.Person;
import com.mybook.exception.AddressBookException;

public interface AddressBookInterface {

	LinkedList<Person> addContact(LinkedList<Person> personList);

	void displayContact(LinkedList<Person> person);

	LinkedList<Person> editContact(LinkedList<Person> person) throws AddressBookException;

	LinkedList<Person> removeContact(LinkedList<Person> person) throws AddressBookException;

	void SearchContact(LinkedList<Person> person);

	void sortContacts(LinkedList<Person> person);

	boolean checkDuplicate(String name, LinkedList<Person> person);

	void sortContacts();

}
