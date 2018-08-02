package com.infotel.tp.tp9object.model;

public class Armor {

	private String name;
	private int defence;

	/*
	 * public Armor(String name, int defence) { this.name = name; this.defence =
	 * defence; }
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public Armor(int i) {

		switch (i) {
		case 1:
			this.setName("Gilet Bleu");
			this.setDefence(1);
			break;
		case 2:
			this.setName("Armure en cuir");
			this.setDefence(2);
			break;
		case 3:
			this.setName("Armure en plaques");
			this.setDefence(4);
			break;
		case 4:
			this.setName("Caleçon");
			this.setDefence(0);
			break;
		}
	}

}
