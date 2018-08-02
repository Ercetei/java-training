package com.infotel.tp.tp9object.manager;

import com.infotel.tp.tp9object.model.User;

public class UserManager {
	
	private User user;
	
	public UserManager(User user) {
		this.user = user;
	}
	
	public void attack(User defender) {
		int damage = this.user.getWeapon().getDamage();
		int actionCost = this.user.getWeapon().getActionCost();
		
		int defence = defender.getArmor().getDefence();
		int hpDefendor = defender.getStats().getHp();
		
		// joueur a attaque joueur b
		System.out.println(this.user.getName() + " attaque " + defender.getName() + ".");
		
		int totalDamage = damage - defence;
		int absorption = damage - totalDamage;
		
		if (totalDamage > 0) {
			int hpLeft = hpDefendor - totalDamage;
			defender.getStats().setHp(hpLeft);
			
			if (hpLeft <= 0) {
				System.out.println(defender.getName() + " perd " + totalDamage + " pv. Il est mort COMME UNE DAUBE.\n");

			} else {
				if (absorption > 0) {
					System.out.println(defender.getArmor().getName() +" de "+ defender.getName() + " absorbe " +absorption+ " de dégats.");				
				}
				
				System.out.println(defender.getName() + " perd " + totalDamage + " pv. Il lui reste "
						+ hpLeft + " pv.\n");
			}
		} else {
			System.out.println(defender.getArmor().getName() +" de "+ defender.getName() + " absorbe les dégats.\n");
		}
		
		// Soustraction des ap
		this.user.getStats().setAp(this.user.getStats().getAp() - actionCost);
	}
}
