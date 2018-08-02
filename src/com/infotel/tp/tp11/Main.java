package com.infotel.tp.tp11;

import java.util.Random;

import com.infotel.tp.tp11.model.Board;
import com.infotel.tp.tp11.model.Player;
import com.infotel.tp.tp11.model.Ship;
import com.infotel.tp.tp11.model.ship.Corvette;
import com.infotel.tp.tp11.utils.TpUtils;

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
	
	public static void generateBoard(Board board) {		
		for(Ship ship: board.getShips()) {
			setPosition(board, ship);
		}	
	}
	
	public static Boolean setPosition(Board board, Ship ship) {
		Boolean result = false;
		
		int x = board.getWidth();
		int y = board.getHeight();
		
		while(!result) {
			Random rand = new Random();
			// 0: vertical / 1: horizontal
			int verticalOrHorizontal = (rand.nextInt(2)%2);
			int randX = (rand.nextInt(x)%x) + 1;
			int randY = (rand.nextInt(y)%y) + 1;
			
			TpUtils utils = new TpUtils();
			String letter = utils.getCharForNumber(randX);
			
			if(board.getGrid().get(letter+randY) == "libre") {
				
				Boolean stopped = false;
				
				for (int h = 1; h != ship.getWidth(); h++) {
					String indexToVerify;
					
					// si vertical
					if(verticalOrHorizontal == 0) {
						indexToVerify = letter+(randY + h);
						if(board.getGrid().get(indexToVerify) != "libre" || (randY+h) > y) {
							stopped = true;
							break;
						}
						
					// si horizontal
					} else {
						String newLetter = utils.getCharForNumber(randX +h);
						indexToVerify = newLetter+randY;
						if(board.getGrid().get(indexToVerify) != "libre" || newLetter == null) {
							stopped = true;
							break;
						}
					}
				}
				
				// Si tout s'est déroulé sans arrêt, on ajoute le bateau au plateau
				if (!stopped) {
					
				}
			}
		}
		
		return result;
	}

}
