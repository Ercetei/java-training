package com.infotel.tp.tpMeals.builders;

import java.util.*;

import com.infotel.tp.tpMeals.models.ChickenBurger;
import com.infotel.tp.tpMeals.models.Coke;
import com.infotel.tp.tpMeals.models.Item;
import com.infotel.tp.tpMeals.models.Meal;
import com.infotel.tp.tpMeals.models.Pokemon;

/**
 * 
 */
public class MealBuilder {
	
    public List<Item> items = new ArrayList<Item>();

    /**
     * @param item 
     * @return MealBuilder
     */
    public MealBuilder addItem(Item item) {
        // TODO implement here
    	this.items.add(item);
        return this;
    }

    /**
     * @return Meal
     */
    public Meal build() {
        return new Meal(this);
    }

	public MealBuilder defaultMeal() {
		this.items.add(new ChickenBurger());
		this.items.add(new Coke());
		this.items.add(new Pokemon());
		return this;
	}

}