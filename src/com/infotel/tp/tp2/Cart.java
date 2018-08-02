package com.infotel.tp.tp2;
import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	List<Apple> apples = new ArrayList<Apple>();

	
	public void addAppleToCart(Apple apple) {
		this.apples.add(apple);
	}
	
	public int getTotal() {
		return this.apples.size();
	}
	
	public Boolean removeApple(Apple apple) {
		return this.apples.remove(apple);
	}
}
