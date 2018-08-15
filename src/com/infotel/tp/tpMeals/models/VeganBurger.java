package com.infotel.tp.tpMeals.models;

import java.util.*;

import com.infotel.tp.tpMeals.interfaces.Burger;

/**
 * 
 */
public class VeganBurger extends Item implements Burger {

    public VeganBurger() {
		this.packaging = new Wrapper();
		this.price = 21.50;
	}

	public String VB = "Vegan Burger";

    public String getName() {
        // TODO implement here
        return VB;
    }

    public void cook() {
    	System.out.println(this.getName());
    }

}