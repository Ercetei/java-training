package com.infotel.tp.tpMeals.models;

import java.util.*;

import com.infotel.tp.tpMeals.interfaces.Burger;

/**
 * 
 */
public class ChickenBurger extends Item implements Burger {

    public ChickenBurger() {
		this.packaging = new Wrapper();
		this.price = 6.80;
	}

	private String CB = "Chicken Burger";

    public String getName() {
        // TODO implement here
        return CB;
    }

    public void cook() {
    	System.out.println(this.getName());
    }

}