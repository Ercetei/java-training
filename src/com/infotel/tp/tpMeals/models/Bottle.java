package com.infotel.tp.tpMeals.models;

import java.util.*;

/**
 * @param <String>
 * 
 */
public class Bottle extends Packaging {

	public String BOTTLE = "Bottle";
    

    public String getName() {
        // TODO implement here
        return BOTTLE;
    }

    public String wrap() {
    	return this.getName();
    }

}