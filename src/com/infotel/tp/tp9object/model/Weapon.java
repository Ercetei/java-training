package com.infotel.tp.tp9object.model;

public class Weapon {

	private String name;
	private int damage;
	private int actionCost;

	/*
	 * public Weapon(String name, int damage, int actionCost) { this.name = name;
	 * this.damage = damage; this.actionCost = actionCost; }
	 */

	public Weapon (int i) {

		switch (i) {
		case 1:
			this.setName("Kekette");
			this.setDamage(1);
			this.setActionCost(2);
			break;
		case 2:
			this.setName("Pelle");
			this.setDamage(2);
			this.setActionCost(3);
			break;
		case 3:
			this.setName("Concasseur");
			this.setDamage(3);
			this.setActionCost(4);

			break;
		case 4:
			this.setName("Blaster");
			this.setDamage(6);
			this.setActionCost(5);
			break;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getActionCost() {
		return actionCost;
	}

	public void setActionCost(int actionCost) {
		this.actionCost = actionCost;
	}

}
