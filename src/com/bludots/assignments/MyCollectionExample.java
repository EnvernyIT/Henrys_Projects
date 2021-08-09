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
	String [] newPeople = new String[1000000];
	for(int i = 0; i < 1000000; i++) {
		String newPerson = people[i].replace('J', 'T');
		String newPerson1 = newPerson.replace('J', 'T');
		newPeople[i] = newPerson;
	}
	
	System.out.println("name : " + people[40]); 	
	System.out.println("new name : " + newPeople[40]); 

	
	
	//zoek naar dit record en laat zien hoe lang dit duurt.


	//--------------------------------------------------------------------------
	//Tweede Versie van assignment 1
	//vul een array met 1 miljoen records (allemaal zelfde naam)
	ArrayList <Person> arrayList = new ArrayList<Person>();
	for(int i = 0; i < 1000000; i++) {
		arrayList.add(new Person("Enverny", "Iengibe", "gigilaan 9", 23));
	}
	
	System.out.println("rray Length: " + arrayList.size());
	
	//wijzig steeds van 1 record (de laatste, de middelste en de eerste)  de naam
	
	
	
	
	//zoek naar dit record en laat zien hoe lang dit duurt.


	//-------------------------------------------------------------------------------------------
	
	//assignments 2:
	
	//vul een hashmap met 1 miljoen records, gebruik elke keer een unieke id, de naam mag steeds hetzelfde
	//zijn of mag je veranderen als je dat voor elkaar krijgt
	HashMap<Integer, Person> personMap = new HashMap<Integer, Person>();
		for(int id = 1; id <= 1000000; id++) {
		personMap.put(id, new Person("Jason", "Kidd", "paramaribostraat 9", 20));
	}

	System.out.println("Map Length: " + personMap.size());
	
	
	
	//meet hoe lang het duurt om een record op te vragen
	long t0 = System.currentTimeMillis();
	Person person = personMap.get(45);
	System.out.println(person);
	long t1 = System.currentTimeMillis();
	long duration = t1-t0;
	System.err.println(" it took " + duration + "  ms");
	
	
	//maak 1 record met een andere naam,
	personMap.put(1000001, new Person("Martin", "Luther", "martinlutherkingjrstraat 23", 40));
	
	
	//meet ook hoe lang het duurt om dit record via zijn key op te vragen...
	long t2 = System.currentTimeMillis();
	Person person1 = personMap.get(1000001);
	System.out.println(person1);
	long t3 = System.currentTimeMillis();
	long duration1 = t3-t2;
	System.err.println(" it took " + duration1 + "  ms");
	
}
}
