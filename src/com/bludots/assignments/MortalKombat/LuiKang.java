package com.bludots.assignments.MortalKombat;

public class LuiKang extends BasicFighter implements Supers{

	@Override
	public void Attack(int health) {
		System.out.println("Fireball attack");
		health = health - 10;
	}

	@Override
	public void specialAttack(int health) {
		System.out.println("Bycicle Attack");
		health = health - 20;
	}

	@Override
	public void Fatality() {
		System.out.println("Turns into a dragon and ends the oponents life.");
	}

}
