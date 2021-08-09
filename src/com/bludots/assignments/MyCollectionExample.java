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
			if (p1.getVoorNaam().equalsIgnoreCase(voornaam) && p1.getAchterNaam().equalsIgnoreCase((achternaam)) ){
				return true;
			}
			else {
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
	//assignment 1:
	//vul een array met 1 miljoen records (allemaal zelfde naam)
	String [] people = new String[1000000];
	for(int i = 0; i < 1000000; i++) {
		people[i] = "James";
	}
	
	System.out.println("name : " + people[40]); 	
	System.out.println("people length : " + people.length); 	

	//wijzig steeds van 1 record (de laatste, de middelste en de eerste)  de naam
	int first = 0;
	int last = people.length - 1;
	int middle = (first + last)/2;
	
	people[first] = "Timothy";
	people[middle] = "Shao Kahn";
	people[last] = "Lui Kang";
	
	System.out.println("first name : " + people[first]); 	
	System.out.println("last name : " + people[last]); 	
	System.out.println("middle name : " + people[middle]); 	
	
	
	//zoek naar dit record en laat zien hoe lang dit duurt.
	long t_0 = System.currentTimeMillis();
	for(int i = 0; i < people.length; i++) {
		if(people[i].equals("Lui Kang")) {
			System.out.println("Found The Name " + people[i]);
		}
	}
	long t_1 = System.currentTimeMillis();
	long duration_1 = t_1-t_0;
	System.err.println(" it took " + duration_1 + "  ms");
	System.out.println();

	//-------------------------------------------------------------------------------------------
	
	//assignments 2:
	
	//vul een hashmap met 1 miljoen records, gebruik elke keer een unieke id, de naam mag steeds hetzelfde
	//zijn of mag je veranderen als je dat voor elkaar krijgt
	HashMap<Integer, String> personMap = new HashMap<Integer, String>();
		for(int id = 1; id <= 1000000; id++) {
		personMap.put(id, "Lindsey");
	}

	System.out.println("Map Length: " + personMap.size());
	
	
	
	//meet hoe lang het duurt om een record op te vragen
	long t0 = System.currentTimeMillis();
	String person = personMap.get(45);
	System.out.println(person);
	long t1 = System.currentTimeMillis();
	long duration = t1-t0;
	System.err.println(" it took " + duration + "  ms in een get manier");
	System.out.println();
	
	
	//maak 1 record met een andere naam,
	personMap.put(1000001, "Harry");
	
	
	//meet ook hoe lang het duurt om dit record via zijn key op te vragen...
	long t2 = System.currentTimeMillis();
	String person1 = personMap.get(1000001);
	System.out.println(person1);
	long t3 = System.currentTimeMillis();
	long duration1 = t3-t2;
	System.err.println(" it took " + duration1 + "  ms");
	
}
}
