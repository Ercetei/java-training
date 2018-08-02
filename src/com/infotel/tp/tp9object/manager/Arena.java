package com.infotel.tp.tp9object.manager;

import java.util.ArrayList;

import com.infotel.tp.tp9object.model.User;


public class Arena {

	public ArrayList<User> users;
	public Boolean endOfTime = false;
	
	public Arena(ArrayList<User> users) {
		this.users = users;
	}
	
	public void battle() {		
		for (User user : this.users) {
			if (user.getStats().getHp() > 0) {
				
				// Perte d'un point d'action pour équiper l'arme
				user.getStats().setAp(user.getStats().getAp()-1);
				
				System.out.println("<<<<<<<< " + user.getName() + " commence son tour.>>>>>>>");
				
				while (user.getWeapon().getActionCost() < user.getStats().getAp()) {
					int indexDefender = getDefender(user);
					
					if (indexDefender == -1) {
						endBattle(user);
						break;
					} 
					
					User defender =  this.users.get(indexDefender);
					UserManager userManager = new UserManager(user);
					userManager.attack(defender);
				}
				
				// Reset des AP
				user.getStats().setAp(user.getStats().getMaxAp());	
			}
		}
	}
	
	public int getDefender(User attacker) {
		int indexDefender = this.users.indexOf(attacker) + 1;
		Boolean defenderFound = false;
		
		for(int i = indexDefender; i != this.users.indexOf(attacker); i++) {
			if (i >= this.users.size()) {
				i = 0;
			}
			
			if (this.users.get(i).getStats().getHp() > 0) {
				indexDefender = i;
				defenderFound = true;
				break;
			}
		}
		
		if (!defenderFound) {
			indexDefender = -1;
		}
		
		return indexDefender;			
	}
	
	public void endBattle(User user) {
		System.err.println(user.getName() + " a gagné! Il est tout content mais il pisse un peu le sang.");
		this.endOfTime = true;
	}
	
	public void tie() {
		System.err.println("Personne n'a gagné. Les personnages étaient tous des bras cassés, le public s'est barré.");
		this.endOfTime = true;
	}

}
