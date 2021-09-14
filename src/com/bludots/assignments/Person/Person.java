package com.bludots.assignments.Person;

public class Person {
	{
		personCount = 10;
	}
	static {
		personCount = 20;
	}
	private static int personCount = 1000;
	{
		personCount = 30;
	}
	static {
		personCount = 40;
	}
	public static void main(String[] args) {
		System.out.println(Person.personCount);
		Person p = new Person();
		System.out.println(Person.personCount);
		Person.personCount = 100;
		p = new Person();
		System.out.println(Person.personCount);
		System.out.println(Person.personCount);

	}
}