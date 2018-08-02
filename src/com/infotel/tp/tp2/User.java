package com.infotel.tp.tp2;

public class User {
	
	public Cart cart = new Cart();
	
	public void addApple(int numberOfApples) {
		for(int i = 0; i < numberOfApples; i++) {
			Apple newApple = new Apple();
			this.cart.apples.add(newApple);
		}
	}
	
	public int getTotalCart() {
		return this.cart.getTotal();
	}
	
	public void giveApple(Cart newCart) {
		newCart.addAppleToCart(this.cart.apples.get(0));
		this.cart.apples.remove(this.cart.apples.get(0));
	}
}
