package com.infotel.tp.tpMeals.models;

import java.util.*;

import com.infotel.tp.tpMeals.interfaces.Burger;
import com.infotel.tp.tpMeals.interfaces.Toy;

/**
 * 
 */
public class Dinosaur extends Item implements Toy {

    public Dinosaur() {
		this.packaging = new Wrapper();
	}

	public String DINO = "Dinosaur";

    public String getName() {
        return DINO;
    }

    public void which() {
    	System.out.println(this.getName());
    }


}