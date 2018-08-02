package com.infotel.tp.tp9object.model;

public class Stats {

	private int hp;
	private int ap;
	private int maxHp;
	private int maxAp;

	public Stats(int hp, int ap) {
		this.hp = this.maxHp = hp;
		this.ap = this.maxAp = ap;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAp() {
		return ap;
	}

	public void setAp(int ap) {
		this.ap = ap;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getMaxAp() {
		return maxAp;
	}

	public void setMaxAp(int maxAp) {
		this.maxAp = maxAp;
	}

}
