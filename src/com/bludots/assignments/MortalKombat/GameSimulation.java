package com.bludots.assignments.MortalKombat;

import java.util.Random;

public class GameSimulation {

	public static void main(String[] args) {
		battle();
	}

	public static void battle() {
		LuiKang fighter1 = new LuiKang();
		KungLao fighter2 = new KungLao();
		
		System.out.println("Begin fight between " + fighter1.name + " and " + fighter2.name);
		System.out.println("----------FIGHT----------");

		fighter1.setHealth(100);
		fighter2.setHealth(100);
		do {
			Random random = new Random();
			int choice = random.nextInt(7);
			int temp = (Math.random() <= 0.5) ? 1 : 2;

			switch (temp) {
			case 1:
				if (choice == 1) {
					fighter1.kick(fighter2.health);
				}
				if (choice == 2) {
					fighter1.punch(fighter2.health);
				}
				if (choice == 3) {
					fighter1.upperCut(fighter2.health);
				}
				if (choice == 4) {
					fighter1.Attack(fighter2.health);
				}
				if (choice == 5) {
					fighter1.specialAttack(fighter2.health);
				}

			case 2:
				if (choice == 1) {
					fighter2.kick(fighter1.health);
				}
				if (choice == 2) {
					fighter2.punch(fighter1.health);
				}
				if (choice == 3) {
					fighter2.upperCut(fighter1.health);
				}
				if (choice == 4) {
					fighter2.Attack(fighter1.health);
				}
				if (choice == 5) {
					fighter2.specialAttack(fighter1.health);
				}
			}
		} while (fighter1.health >= 1 || fighter2.health >= 1);

		if (fighter1.health < 1) {
			System.out.println(fighter1.name + " has lost the fight");
		} else if (fighter2.health < 1) {
			System.out.println(fighter2.name + " has lost the fight");
		}
	}

}
