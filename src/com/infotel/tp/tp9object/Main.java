package com.infotel.tp.tp9object;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.infotel.tp.tp9object.manager.Arena;
import com.infotel.tp.tp9object.model.Armor;
import com.infotel.tp.tp9object.model.Stats;
import com.infotel.tp.tp9object.model.User;
import com.infotel.tp.tp9object.model.Weapon;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static Boolean endCreation = false;
	static int maxRounds = 30;


	public static void main(String[] args) {
		ArrayList<User> users = new ArrayList<User>();
		do {
			users.add(createUser());
			System.out.println("Créer un autre personnage tout moisi? O/N");
			String choice = sc.nextLine();
			
			if (choice.equals("N")) {
				System.out.println("CASSEZ VOUS LA GUEULE!");
				endCreation = true;
			}
		} while(!endCreation);
		
		int countDown = 0;
		
		Arena arena = new Arena(users);
		
		do {
			if (countDown == maxRounds) {
				arena.tie();
				break;
			}
			arena.battle();
			countDown++;
		} while (!arena.endOfTime);
		
	}	
	
	
	static User createUser() {
		System.out.println("Quel est le nom de votre personnage?");
		String name = sc.nextLine();	
		
		Random rand = new Random();
		int randA = (rand.nextInt(4)%4) + 1;
		int randB = (rand.nextInt(4)%4) + 1;
		int randHP = (rand.nextInt(16)%16) + 1;
		int randPA = (rand.nextInt(8)%8) + 5;
		
		Armor armor = new Armor(randA);
		Weapon weapon = new Weapon(randB);
		Stats stats = new Stats(randHP, randPA);
		
		return new User(name, weapon, armor, stats);
	}
	
}
