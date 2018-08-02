package com.infotel.tp.tp11;

import java.util.Random;

import com.infotel.tp.tp11.model.Board;
import com.infotel.tp.tp11.model.Player;
import com.infotel.tp.tp11.model.Ship;
import com.infotel.tp.tp11.model.ship.Corvette;

public class Main {

	public static void main(String[] args) {
		
		// création des plateaux
		Board board1 = new Board(18,24);
		Board board2 = new Board(18,24);
			
		Player player1 = new Player("René");
		Player player2 = new Player("Jojo");
		
		player1.setBoard(board1);
		player2.setBoard(board2);
	}
	
	public static void placeShip(Board board) {
		int x = board.getWidth();
		int y = board.getHeight();
		
		Random rand = new Random();

		int randX = (rand.nextInt(x)%x) + 1;
		int randY = (rand.nextInt(y)%y) + 1;
		
		Corvette corvette = new Corvette();
		corvette.setY(randY);
		corvette.setX(randX);
		
		if (isPositionOk(board, corvette)) {
			board.getShips().add(corvette);
		}
	}
	
	/**
	 * Vérifie dans le plateau si le bâteau peut se placer à cet endroit
	 * @param board
	 * @param ship
	 * @return
	 */
	public static Boolean isPositionOk(Board board, Ship ship) {
		Boolean result = false;
		
		Boolean Xok = false;
		Boolean Yok = false;
		
		for(Ship currentShip : board.getShips()) {
			if (currentShip != ship) {
				
			}
		}
		
		return result;
	}

}
