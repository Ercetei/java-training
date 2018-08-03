package com.infotel.tp.tp11.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private int score = 0;
	private Board board;
	private List<Case> shots = new ArrayList<Case>();

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public List<Case> getShot() {
		return shots;
	}

	public void setShot(List<Case> shots) {
		this.shots = shots;
	}

}
