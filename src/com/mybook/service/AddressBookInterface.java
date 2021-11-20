package com.mybook.service;

import java.util.LinkedList;
import java.util.List;

import com.mybook.Person;
import com.mybook.enums.SortOption;
import com.mybook.exception.AddressBookException;

public interface AddressBookInterface {

	void sortData(List<Person> person, SortOption sortOptions);
	void searchBy(List<Person> person, String searchItem);
	List<Person> addContact(List<Person> personList, Person person);
	public void displayContact(List<Person> person);
	List<Person> editContact(List<Person> person) throws AddressBookException;
	List<Person> removeContact(List<Person> personList, int id);
	boolean checkDuplicate(String name, LinkedList<Person> person);

}
