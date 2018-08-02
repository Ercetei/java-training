package com.infotel.tp.tp1;

import java.util.Scanner;

public class Lock {
	
	public static int currentNumber = 0;
	public static int currentPosition = 0;
	public static int[] combinaison = new int[]{4, 3, 5, 1};
	public static Boolean success = false;
	
	public static void main(String[] args) {
		System.out.println("Quel est le MOT DE PAAAAAAAAAAAAASSE????");
		System.out.println("Numéro courant: 0");
		System.out.println("Tapez + ou - pour trouver la bonne combinaison.");
		Scanner sc = new Scanner(System.in);

		while(!success) {
			String value = sc.nextLine();

			if(value.equals("+")) {
				currentNumber++;
				increment();
			} else if (value.equals("-")) {
				currentNumber--;
				decrement();
			}
		}
		
		System.out.println("Bravo! Vous avez trouvé la bonne combinaison!");
		sc.close();
	}
	
	public static void increment() {
		if (currentPosition == 0 && combinaison[currentPosition] < 0) {
			lose();
		}
		
		if (currentPosition == 0 || combinaison[currentPosition] > combinaison[currentPosition - 1]) {
			if(currentNumber == combinaison[currentPosition]) {
				//System.out.println("Numéro courant: " + currentNumber);
				//System.out.println("Clic!");
				
				if (currentPosition == 3) {
					success = true;
				}
				currentPosition++;
			} else {
				//System.out.println("Numéro courant: " + currentNumber);
			}
		} else {
			lose();
		}
	}
	
	public static void decrement() {
		if (currentPosition == 0 && combinaison[currentPosition] > 0) {
			lose();
		}
		
		if (currentPosition == 0 || combinaison[currentPosition] < combinaison[currentPosition - 1]) {
			if(currentNumber == combinaison[currentPosition]) {
				//System.out.println("Numéro courant: " + currentNumber);
				//System.out.println("Clic!");
				if (currentPosition == 3) {
					success = true;		
				}
				currentPosition++;
			} else {
				//System.out.println("Numéro courant: " + currentNumber);
			}
		} else {
			lose();
		}
	}
	
	public static void lose() {
		//System.out.println("Perdu! On retourne à 0, gros naze");
		reset();
	}
	
	public static void reset() {
		currentPosition = 0;
		currentNumber = 0;	
	}
}
