package com.infotel.tp.tpMeals.models;

import java.util.*;

import com.infotel.tp.tpMeals.interfaces.Burger;
import com.infotel.tp.tpMeals.interfaces.Drink;

/**
 * 
 */
public class Coke extends Item implements Drink {

    public Coke() {
		this.packaging = new Bottle();
		this.price = 2.00;
	}

	public String COKE = "Coke";

    public String getName() {
        return COKE;
    }

    public void fill() {
    	System.out.println(this.getName());
    }

}