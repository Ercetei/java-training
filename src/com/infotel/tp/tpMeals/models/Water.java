package com.infotel.tp.tpMeals.models;

import java.util.*;

import com.infotel.tp.tpMeals.interfaces.Burger;
import com.infotel.tp.tpMeals.interfaces.Drink;

/**
 * 
 */
public class Water extends Item implements Drink {

    public Water() {
		this.packaging = new Bottle();
		this.price = 3.40;
	}

	public String WATER = "Water";

    public String getName() {
        // TODO implement here
        return WATER;
    }

    public void fill() {
    	System.out.println(this.getName());
    }

}