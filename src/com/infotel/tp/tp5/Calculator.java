package com.infotel.tp.tp5;

import java.util.Scanner;

public class Calculator {
	static int number0 = 0;
	static int number1 = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Numéro 1:");
		number0 = sc.nextInt();
		
		System.out.println("Numéro 2:");
		number1 = sc.nextInt();
		
		if (number0 == number1) {
			System.out.println("Somme: " + (number0 + number1));
		}
		
		else if (number0 < 0 && number1 >= 0) {
			System.out.println("Produit: " + (number0 * number1));
		}
		
		else if (((number0 >= 0 && number1 >= 0) || (number0 < 0 && number1 <0)) 
				&& ((number0 > 10 || number1 < -10) || number1 > 10 || number1 < -10)) {
			if (number1 == 0) {
				System.out.println("Division par zéro");
			} else {
				System.out.println("Division: " + (number0 / number1));
			}
		}
		
		sc.close();
	}
}
