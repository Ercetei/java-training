package com.infotel.tp.tpMeals.models;

import java.util.*;

import com.infotel.tp.tpMeals.interfaces.Burger;

/**
 * 
 */
public class Wrapper extends Packaging {

    public String WRAPPER = "Wrapper";

    public String getName() {
        return WRAPPER;
    }

    public String wrap() {
    	return this.getName();
    }

}