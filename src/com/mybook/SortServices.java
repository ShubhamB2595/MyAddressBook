package com.mybook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortServices {

	// methods for sorting operation
	public static void sortByName(List<Person> person) {

		person.sort(Person.firstNameSorting);
		person.forEach(System.out::println);
	}

	public static void sortByCity(List<Person> person) {

		person.sort(Person.citySorting);
		person.forEach(System.out::println);
	}

	public static void sortByState(List<Person> person) {

		person.sort(Person.stateSorting);
		person.forEach(System.out::println);
	}

	public static void sortByZip(List<Person> person) {

		person.sort(Person.zipSorting);
		person.forEach(System.out::println);
	}

	// methods for searching operation
	public static void searchByCity(List<Person> person) {

		Scanner scan = new Scanner(System.in);
		String search;
		List<Person> matches = new ArrayList<>();
		System.out.println("Enter the city to search: ");
		search = scan.nextLine();
		int flag = 0;
		for (Person p : person) {
			if (p.getCity().equalsIgnoreCase(search)) {
				flag = 1;
				matches.add(p);
			}
		}

		if (flag == 1) {
			System.out.println("---Match Found---");
			for (Person p : matches) {
				System.out.println(p);
			}
		} else {
			System.out.println("Match not found..");
		}

	}

	public static void searchByState(List<Person> person) {

		Scanner scan = new Scanner(System.in);
		String search;
		List<Person> matches = new ArrayList<>();
		System.out.println("Enter the state to search: ");
		search = scan.nextLine();
		int flag = 0;
		for (Person p : person) {
			if (p.getState().equalsIgnoreCase(search)) {
				flag = 1;
				matches.add(p);
			}
		}

		if (flag == 1) {
			System.out.println("---Match Found---");
			for (Person p : matches) {
				System.out.println(p);
			}
		} else {
			System.out.println("Match not found..");
		}

	}
}
