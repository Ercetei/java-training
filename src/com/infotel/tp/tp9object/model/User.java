package com.infotel.tp.tp9object.model;

public class User {

	private String name;
	private Weapon weapon;
	private Armor armor;
	private Stats stats;

	public User(String name, Weapon weapon, Armor armor, Stats stats) {
		this.name = name;
		this.weapon = weapon;
		this.armor = armor;
		this.stats = stats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

}
