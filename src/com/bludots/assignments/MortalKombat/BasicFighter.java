package com.bludots.assignments.MortalKombat;

public abstract class BasicFighter {
	
	public String name;
	public int health;
	
	public void kick(int health)
	{
		System.out.println("Basic Kick Attack By " + name);
	}
	
	public void punch(int health)
	{
		System.out.println("Basic Punch Attack By " + name);
	}
	
	public void upperCut(int health)
	{
		System.out.println("Basic Uppercut Attak By " + name);
	}
	
	public void jump()
	{
		System.out.println("Basic Jump By " + name);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	

}
