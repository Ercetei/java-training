package com.infotel.tp.tp11.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infotel.tp.tp11.model.ship.Corvette;
import com.infotel.tp.tp11.model.ship.Croiseur;
import com.infotel.tp.tp11.model.ship.Destroyer;
import com.infotel.tp.tp11.model.ship.PorteAvion;
import com.infotel.tp.tp11.utils.TpUtils;

public class Board {

	private int height;
	private int width;

	private List<Ship> ships = new ArrayList<Ship>();
	
	private Map<String, String> grid = new HashMap<String, String>();
	
	public Board(int height, int width) {

		this.height = height;
		this.width = width;
		
		ships.add(new Corvette());
		ships.add(new Croiseur());
		ships.add(new Croiseur());
		ships.add(new Destroyer());
		ships.add(new Destroyer());
		ships.add(new PorteAvion());

		//this.grid = new String[height*width];
		
		for (int x = 1; x != width; x++) {
			TpUtils utils = new TpUtils();
			String letter = utils.getCharForNumber(x);
			
			for (int y = 1; y != height; y++) {
				this.grid.put(letter+y, "libre");
			}
		}
		
		
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

	public Map<String, String> getGrid() {
		return grid;
	}

	public void setGrid(Map<String, String> grid) {
		this.grid = grid;
	}
	
	
}
