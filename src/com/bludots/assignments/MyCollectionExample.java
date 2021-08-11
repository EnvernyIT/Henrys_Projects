package com.bludots.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//Assignment

public class MyCollectionExample {
	public static class Person implements Comparable<Person> {
		private String voornaam;
		private String achternaam;
		private String adres;
		private int leeftijd;

		public Person(String voornaam, String achternaam) {
			this.voornaam = voornaam;
			this.achternaam = achternaam;
			this.adres = "";
			this.leeftijd = 18;
		}

		public Person(String voornaam, String achternaam, String adres, int leeftijd) {
			this.voornaam = voornaam;
			this.achternaam = achternaam;
			this.adres = adres;
			this.leeftijd = leeftijd;
		}

		public String getVoorNaam() {
			return voornaam;
		}

		public String getAchterNaam() {
			return achternaam;
		}

		public String getAdres() {
			return adres;
		}

		public void setAdres(String adres) {
			this.adres = adres;
		}

		public int getLeeftijd() {
			return leeftijd;
		}

		public void setLeeftijd(int leeftijd) {
			this.leeftijd = leeftijd;
		}

		@Override
		public String toString() {
			return "Voornaam: " + voornaam + " Achternaam: " + achternaam;
		}

		@Override
		public boolean equals(Object obj1) {
			Person p1 = (Person) obj1;
			if (p1.getVoorNaam().equalsIgnoreCase(voornaam) && p1.getAchterNaam().equalsIgnoreCase((achternaam))) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public int compareTo(Person p1) {
			int c = achternaam.compareTo(p1.achternaam);
			if (c == 0) {
				c = voornaam.compareTo(p1.voornaam);
			}
			return c;
		}
	}

	public static void main(String args[]) {

		// Assignment 1 met ArrayList
		// vul een array met 1 miljoen records (allemaal zelfde naam)
		ArrayList<Person> people = new ArrayList<>();
		for (int i = 0; i < 1000000; i++) {
			people.add(new Person("Lebron", "James"));
		}

		// wijzig steeds van 1 record (de laatste, de middelste en de eerste) de naam
		int firstInList = 0;
		int lastInList = people.size() - 1;
		int middleInList = (lastInList + firstInList) / 2;

		people.set(firstInList, new Person("James", "Harden"));
		people.set(lastInList, new Person("Stephen", "Curry"));
		people.set(middleInList, new Person("Devin", "Booker"));

		System.out.println(people.get(firstInList));
		System.out.println(people.get(lastInList));
		System.out.println(people.get(middleInList));

		// zoek naar dit record en laat zien hoe lang dit duurt.
		long t_list = System.currentTimeMillis();
		Person personSearch = new Person("Stephen", "Curry");
		if (people.contains(personSearch)) {
			System.out.println(
					"Found The Name --- " + personSearch.toString() + " at index: " + people.indexOf(personSearch));
		}
		long t_list_1 = System.currentTimeMillis();
		long duration_list = t_list_1 - t_list;
		System.err.println(" it took " + duration_list + "  ms");
		System.out.println();

		// assignment 1 met array:
		// vul een array met 1 miljoen records (allemaal zelfde naam)
		String[] peopleArray = new String[1000000];
		for (int i = 0; i < 1000000; i++) {
			peopleArray[i] = "James";
		}

		System.out.println("name : " + peopleArray[40]);
		System.out.println("people length : " + peopleArray.length);

		// wijzig steeds van 1 record (de laatste, de middelste en de eerste) de naam
		int first = 0;
		int last = peopleArray.length - 1;
		int middle = (first + last) / 2;

		peopleArray[first] = "Timothy";
		peopleArray[middle] = "Shao Kahn";
		peopleArray[last] = "Lui Kang";

		System.out.println("first name : " + peopleArray[first]);
		System.out.println("last name : " + peopleArray[last]);
		System.out.println("middle name : " + peopleArray[middle]);

		// zoek naar dit record en laat zien hoe lang dit duurt.
		long t_0 = System.currentTimeMillis();
		for (int i = 0; i < peopleArray.length; i++) {
			if (peopleArray[i].equals("Lui Kang")) {
				System.out.println("Found The Name " + peopleArray[i]);
			}
		}
		long t_1 = System.currentTimeMillis();
		long duration_1 = t_1 - t_0;
		System.err.println(" it took " + duration_1 + "  ms");
		System.out.println();

		// -------------------------------------------------------------------------------------------

		// assignments 2:

		// vul een hashmap met 1 miljoen records, gebruik elke keer een unieke id, de
		// naam mag steeds hetzelfde
		// zijn of mag je veranderen als je dat voor elkaar krijgt
		HashMap<Integer, String> personMap = new HashMap<Integer, String>();
		for (int id = 1; id <= 1000000; id++) {
			personMap.put(id, "Lindsey");
		}

		System.out.println("Map Length: " + personMap.size());

		// meet hoe lang het duurt om een record op te vragen
		long t0 = System.currentTimeMillis();
		String person = personMap.get(45);
		System.out.println(person);
		long t1 = System.currentTimeMillis();
		long duration = t1 - t0;
		System.err.println(" it took " + duration + "  ms in een get manier");
		System.out.println();

		// maak 1 record met een andere naam,
		personMap.put(1000001, "Harry");

		// meet ook hoe lang het duurt om dit record via zijn key op te vragen...
		long t2 = System.currentTimeMillis();
		String person1 = personMap.get(1000001);
		System.out.println(person1);
		long t3 = System.currentTimeMillis();
		long duration1 = t3 - t2;
		System.err.println(" it took " + duration1 + "  ms");

	}
}
