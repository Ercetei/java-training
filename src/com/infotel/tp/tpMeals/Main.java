package com.infotel.tp.tpMeals;

import com.infotel.tp.tpMeals.builders.MealBuilder;
import com.infotel.tp.tpMeals.interfaces.Burger;
import com.infotel.tp.tpMeals.models.ChickenBurger;
import com.infotel.tp.tpMeals.models.Coke;
import com.infotel.tp.tpMeals.models.Dinosaur;
import com.infotel.tp.tpMeals.models.Item;
import com.infotel.tp.tpMeals.models.Meal;
import com.infotel.tp.tpMeals.models.Pokemon;

public class Main {
	
	public static void main(String[] args) {
		MealBuilder mb = new MealBuilder();
		
		Meal meal = mb.addItem(new ChickenBurger())
				.addItem(new Coke())
				.addItem(new Coke())
				.addItem(new Coke())
				.addItem(new Coke())
				.addItem(new Coke())
				.addItem(new Dinosaur())
				.addItem(new Pokemon())
				.build();
		
		for(Item item:meal.items) {
			//if(item instanceof Burger) {
				System.out.println(item.getName() + " packed in " + item.getPackaging().wrap());
			//}
		}
		System.out.println(meal.total());

		
		System.out.println("\n");
		
		MealBuilder mb2 = new MealBuilder();
		
		Meal meal2 = mb2.defaultMeal()
				.build();
		
		for(Item item:meal2.items) {
			System.out.println(item.getName() + " packed in " + item.getPackaging().wrap());
		}
		
		System.out.println(meal2.total());

	}
}
