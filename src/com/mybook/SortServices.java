package com.mybook;

import java.util.Collections;
import java.util.List;

public class SortServices {

	// method to sort operation
	public static void sortByName(List<Person> person) {

		Collections.sort(person, Person.firstNameSorting);

		for (Person p : person) {
			System.out.println(p);
		}
	}

}
