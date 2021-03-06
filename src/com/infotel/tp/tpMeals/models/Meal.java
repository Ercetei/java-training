package com.infotel.tp.tpMeals.models;

import java.util.*;

import com.infotel.tp.tpMeals.builders.MealBuilder;

/**
 * 
 */
public class Meal {

    public List<Item> items = new ArrayList<Item>();
    
    /**
     * Default constructor
     */
    public Meal(MealBuilder builder) {
    	this.items = builder.items;
    }

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public double total() {
		double total = 0.00;
		
		for(Item item: this.items) {
			total += item.getPrice();
		}
		
		return total;
	}

	@Override
	public String toString() {
		return "Meal [items=" + items + ", getItems()=" + getItems() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}