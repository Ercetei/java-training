package com.infotel.tp.tp9;

public class Attack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ID [arme, paArme, armure, pv, pa]
		
		int[][] chars = new int[][]{
				{2, 1, 1, 9, 7}, 
				{6, 3, 2, 4, 12}, 
				{3, 4, 4, 15, 8}
			};
		
		do{
			game(chars);
		} while(!game(chars));
	}
	
	public static Boolean game (int[][] c) {
		String[] names = {
				"Jean-Joseph",
				"Arthuro de la Chikita",
				"Hubert De La Batte",
		};
		
		for(int i = 0; i < 3; i++) {
			if (c[i][3] > 0) {
				System.out.println("<<<<<<<< " + names[i] + " commence son tour.>>>>>>>");

				int weapon = c[i][0];
				int weaponAction = c[i][1];

				// Perte d'un point d'action pour équiper l'arme
				c[i][4] = (c[i][4]-1);
				
				// Boucle d'attaque
				for(int a = 0; (a + weaponAction) <= c[i][4]; a = (a + weaponAction)) {
					
					int nextPlayer = getDefender(c, i);

					if (nextPlayer == -1) {
						System.err.println(names[i] + " a gagné! Il est tout content mais il pisse un peu le sang.");
						return true;
					}
					
					// joueur a attaque joueur b
					System.out.println(names[i] + " attaque "+names[nextPlayer]+ ".");
					
					int armor = c[nextPlayer][2];
					int atk = weapon - armor;
					
					if (atk > 0) {
						c[nextPlayer][3] = c[nextPlayer][3] - atk;
						if (c[nextPlayer][3] <= 0) {
							System.out.println(names[nextPlayer]+ " perd " + weapon + " pv. Il est mort COMME UNE DAUBE.\n");
							
						} else {
							System.out.println(names[nextPlayer] + " perd " + weapon + " pv. Il lui reste " + c[nextPlayer][3] + " pv.\n");					
						}
					} else {
						System.out.println(names[nextPlayer] + " ne perd pas de pv.\n");					
					}					
				}			
			}		
		}
		
		return false;

	}
	
	public static int getDefender(int[][] defenders, int attacker) {
		int defender = -1;
		
		for(int p = attacker+1; p != attacker; p++) {
			if (p == defenders.length) {
				p = 0;
			}
			// Un autre personnage vivant excepté le perso courant
			if (defenders[p][3] > 0 ) {
				defender = p;		
				break;
			} 
		}
		
		return defender;
	}
}
