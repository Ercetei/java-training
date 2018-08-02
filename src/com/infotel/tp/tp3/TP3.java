package com.infotel.tp.tp3;

import java.util.Scanner;

public class TP3 {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int Aladdin = 0;
		int Jasmine = 0;
		
		do {
			System.out.println("Donner des pommes à Jasmine");
			Jasmine = sc.nextInt();
		} while (Jasmine < 0);
		
		do {
			System.out.println("Donner des pommes à Aladdin");
			Aladdin = sc.nextInt();
		} while (Aladdin < 0);
		
		int panierCommun = Aladdin + Jasmine;
		
		System.out.println(panierCommun);
		sc.close();

	}

}
