package com.infotel.tp.tp11.model;

public class Case {

	private int x;
	private int y;
	private String state;
	
	public Case(int x, int y) {
		this.x = x;
		this.y = y;
		this.state = "Occup�";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}