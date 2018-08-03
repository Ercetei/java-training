package com.infotel.tp.tp11.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.infotel.tp.tp11.model.Board;
import com.infotel.tp.tp11.model.Case;
import com.infotel.tp.tp11.model.Player;
import com.infotel.tp.tp11.model.Ship;
import com.infotel.tp.tp11.model.ship.Corvette;
import com.infotel.tp.tp11.model.ship.Croiseur;
import com.infotel.tp.tp11.model.ship.Destroyer;

public class BattleShip {

	private int maxPoint = 0;
	private Boolean game = true;
	private List<Player> players = new ArrayList<Player>();

	public BattleShip(List<Player> players, List<Ship> ships, int x, int y) {
		
		this.players = players;
		
		for(Player player : this.players ) {
			Board board = new Board(ships, x, y);
			generateBoard(board);
			player.setBoard(board);
			
			if (this.maxPoint == 0) {
				for (Ship ship : board.getShips()) {
					this.maxPoint += ship.getWidth();
				}
			}
		}

		do {
			for (Player attacker : this.players) {

				// Par défaut, l'adversaire est le joueur suivant
				int indexNextPlayer = this.players.indexOf(attacker) + 1;

				// si le joueur courant est le dernier de la liste, on revient au début du
				// tableau.
				if (this.players.indexOf(attacker) + 1 == this.players.size()) {
					indexNextPlayer = 0;
				}

				// On récupère l'adversaire.
				Player defender = this.players.get(indexNextPlayer);

				// Gestion du tir.

				if (strike(attacker, defender)) {
					System.out.println("Touché");
					attacker.setScore(attacker.getScore() + 1);
				} else {
					System.out.println("Manqué");
				}

				// String result = showBoard(defenderBoard);
				// System.out.println(result);

				if (attacker.getScore() == maxPoint) {
					System.err.println("<<<<<<< " + attacker.getName() + " a gagné. >>>>>>>");
					System.out.println(showBoard(defender.getBoard()));
					game = false;
					break;
				}
			}
		} while (game);
	}

	

	/**
	 * Création d'un plateau
	 * 
	 * @param board
	 */
	public void generateBoard(Board board) {
		for (Ship ship : board.getShips()) {
			setPosition(board, ship);
		}
	}

	/**
	 * Placement des bateaux sur les plateaux des joueurs.
	 * 
	 * @param board
	 * @param ship
	 * @return
	 */
	public Boolean setPosition(Board board, Ship ship) {
		Boolean result = false;

		int x = board.getWidth();
		int y = board.getHeight();

		while (!result) {
			Random rand = new Random();
			// 0: vertical / 1: horizontal
			int verticalOrHorizontal = (rand.nextInt(2) % 2);
			int randX = (rand.nextInt(x) % x) + 1;
			int randY = (rand.nextInt(y) % y) + 1;

			Boolean stopped = false;

			for (Ship testedShip : board.getShips()) {

				int h = 1;
				while (h != ship.getWidth() + 1 && !stopped) {
					int indexToVerifyX = randX;
					int indexToVerifyY = randY;

					// si vertical
					if (verticalOrHorizontal == 0) {
						indexToVerifyY += (h - 1);

						// si horizontal
					} else {
						indexToVerifyX += (h - 1);
					}

					if (indexToVerifyY > y || indexToVerifyX > x) {
						stopped = true;
					}

					for (Case shipCase : testedShip.getCases()) {
						if (shipCase.getX() == indexToVerifyX && shipCase.getY() == indexToVerifyY) {
							stopped = true;
						}
					}

					h++;
				}
			}

			if (!stopped) {
				for (int w = 1; w != ship.getWidth() + 1; w++) {
					int indexToVerifyX = randX;
					int indexToVerifyY = randY;

					// si vertical
					if (verticalOrHorizontal == 0) {
						indexToVerifyY += (w - 1);

						// si horizontal
					} else {
						indexToVerifyX += (w - 1);
					}

					Case newCase = new Case(indexToVerifyX, indexToVerifyY);
					ship.getCases().add(newCase);
					result = true;
				}
			}

			if (result) {
				break;
			}
		}

		return result;
	}

	/**
	 * Montre le plateau de jeu d'un joueur et la position des bateaux.
	 * 
	 * @param board
	 * @return
	 */
	public String showBoard(Board board) {
		int x = board.getWidth();
		int y = board.getHeight();
		String line = "";

		for (int ly = 1; ly != y; ly++) {
			Boolean match = false;

			for (int lx = 1; lx != x; lx++) {
				String type = "X ";

				for (Ship ship : board.getShips()) {
					for (Case testCase : ship.getCases()) {
						if (testCase.getX() == lx && testCase.getY() == ly) {
							match = true;

							if (ship instanceof Corvette) {
								type = "T ";
							} else if (ship instanceof Destroyer) {
								type = "D ";
							} else if (ship instanceof Croiseur) {
								type = "C ";
							} else {
								type = "P ";
							}
						}
					}
				}

				if (match) {
					line += type;
				} else {
					line += ". ";
				}

				if ((lx + 1) == x) {
					line += "\n";
				}

				match = false;
			}
		}

		return line;
	}

	/**
	 * Lance un missile sur des coordonnées
	 * 
	 * @param attacker
	 * @param defender
	 * @return
	 */
	public Boolean strike(Player attacker, Player defender) {
		Board defenderBoard = defender.getBoard();

		Boolean coordinatesNeverUsed = false;
		int strikeX = 0;
		int strikeY = 0;

		do {
			Random rand = new Random();
			strikeX = (rand.nextInt(defenderBoard.getWidth()) % defenderBoard.getWidth()) + 1;
			strikeY = (rand.nextInt(defenderBoard.getHeight()) % defenderBoard.getHeight()) + 1;
			if (verifyCoordonate(attacker, strikeX, strikeY)) {
				coordinatesNeverUsed = true;
			}
		} while (!coordinatesNeverUsed);

		System.out.println(attacker.getName() + " tire aux coordonnées X:" + strikeX + " Y:" + strikeY);

		Boolean touched = false;
		for (Ship ship : defenderBoard.getShips()) {
			for (Case testCase : ship.getCases()) {
				if (testCase.getX() == strikeX && testCase.getY() == strikeY) {
					testCase.setState("touché");
					touched = true;
				}
			}
		}

		Case newShot = new Case(strikeX, strikeY);

		if (touched) {
			newShot.setState("touché");
		} else {
			newShot.setState("raté");
		}

		attacker.getShot().add(newShot);

		System.out.println(showHiddenBoard(attacker, defender.getBoard(), strikeX, strikeY));

		return touched;
	}

	/**
	 * Vérifie si les coordonnées n'ont pas déjà été utilisées par le joueur.
	 * 
	 * @param attacker
	 * @param strikeX
	 * @param strikeY
	 * @return
	 */
	public Boolean verifyCoordonate(Player attacker, int strikeX, int strikeY) {
		Boolean result = true;

		for (Case shot : attacker.getShot()) {
			if (shot.getX() == strikeX && shot.getY() == strikeY) {
				result = false;
				break;
			}
		}

		return result;
	}

	/**
	 * Montre l'état du plateau de l'adversaire
	 * 
	 * @param attacker
	 * @param defenderBoard
	 * @param strikeX
	 * @param strikeY
	 * @return
	 */
	public String showHiddenBoard(Player attacker, Board defenderBoard, int strikeX, int strikeY) {
		int x = defenderBoard.getWidth();
		int y = defenderBoard.getHeight();
		String line = "";

		for (int ly = 1; ly != y; ly++) {

			for (int lx = 1; lx != x; lx++) {
				String status = ". ";

				for (Case shot : attacker.getShot()) {
					if (shot.getX() == lx && shot.getY() == ly) {
						if (shot.getState().equals("raté")) {
							status = "* ";
						} else {
							status = "X ";
						}
					}
				}

				line += status;

				if ((lx + 1) == x) {
					line += "\n";
				}
			}
		}

		return line;
	}
}
