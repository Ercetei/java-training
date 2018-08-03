package com.infotel.tp.tp11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.infotel.tp.tp11.manager.BattleShip;
import com.infotel.tp.tp11.model.Board;
import com.infotel.tp.tp11.model.Player;
import com.infotel.tp.tp11.model.Ship;
import com.infotel.tp.tp11.model.ship.Corvette;
import com.infotel.tp.tp11.model.ship.Croiseur;
import com.infotel.tp.tp11.model.ship.Destroyer;
import com.infotel.tp.tp11.model.ship.PorteAvion;

public class Main {

	static Boolean game = true;
	static Scanner sc = new Scanner(System.in);
	static int maxPoint = 0;

	public static void main(String[] args) {
		Player player1 = new Player("René");
		Player player2 = new Player("Jojo");
		
		List<Player> players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);
		
		List<Ship> ships = new ArrayList<Ship>();
		ships.add(new Corvette());
		ships.add(new Croiseur());
		ships.add(new Croiseur());
		ships.add(new Destroyer());
		ships.add(new Destroyer());
		ships.add(new PorteAvion());	

		BattleShip battleShip = new BattleShip(players, ships, 18, 24);
	}
}
