package com.infotel.tp.tp6;

import java.util.Random;
import java.util.Scanner;

public class Cuisine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int selection;
		Cuisson cuisson = null;
		Satisfaction satisfaction = null;
		
		Random rand = new Random();
		selection = rand.nextInt(5) + 1;
		
		switch(selection) {
		case 1:
			cuisson = Cuisson.Bleu;
			break;
		case 2:
			cuisson = Cuisson.Saignant;
			break;
		case 3:
			cuisson = Cuisson.Cuit;
			break;
		case 4:
			cuisson = Cuisson.APoint;
			break;
		case 5:
			cuisson = Cuisson.Brule;
			break;
		}
		
		switch(cuisson) {
		case Bleu:
			satisfaction = Satisfaction.Cuire;
			break;
		case Saignant:
			satisfaction = Satisfaction.Cuire;
			break;
		case Brule:
			satisfaction = Satisfaction.Decu;
			break;
		case Cuit:
			satisfaction = Satisfaction.Content;
			break;
		case APoint:
			satisfaction = Satisfaction.Content;
			break;
		}
		
		System.out.println(satisfaction);
		
		sc.close();
	}
	
	public enum Cuisson{
		Bleu,
		Saignant,
		Cuit,
		APoint,
		Brule
	}
	
	public enum Satisfaction{
		Cuire,
		Decu,
		Content
	}
}
