package com.bludots.assignments.MortalKombat;

public class KungLao extends BasicFighter implements Supers{

	@Override
	public void Attack(int health) {
		System.out.println("Hat Throw attack");
		health = health - 10;		
	}

	@Override
	public void specialAttack(int health) {
		System.out.println("Whirlwind Spin Attack");
		health = health - 20;
	}

	@Override
	public void Fatality() {
		System.out.println("Throws the hat pass the opponent and calls it back and slices its head off. Back to Kung Lao!");		
	}

}
