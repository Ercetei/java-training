package com.infotel.tp.tp11.model;

import java.util.ArrayList;
import java.util.List;

import com.infotel.tp.tp11.model.ship.Corvette;
import com.infotel.tp.tp11.model.ship.Croiseur;
import com.infotel.tp.tp11.model.ship.Destroyer;
import com.infotel.tp.tp11.model.ship.PorteAvion;

public class Board {

	private int height;
	private int width;

	private List<Ship> ships = new ArrayList<Ship>();
		
	public Board(List<Ship> ships, int height, int width) {
		this.ships = ships;
		this.height = height;
		this.width = width;	
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public List<Ship> getShips() {
		return ships;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}
}
