package com.infotel.tp.tp2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User Jasmine = new User();
		User Aladdin = new User();
		
		Jasmine.addApple(7);
		Aladdin.addApple(5);
		
		int totalAppleJ = Jasmine.cart.apples.size();
		int totalAppleA = Aladdin.cart.apples.size();
		
		Cart newCart = new Cart();
				
		for(int i = 0; i < totalAppleJ; i++) {
			Jasmine.giveApple(newCart);
		}
		
		for(int i = 0; i < totalAppleA; i++) {
			Aladdin.giveApple(newCart);
		}

		System.out.println("Total panier Jasmine "+ Jasmine.getTotalCart());
		System.out.println("Total panier Aladdin "+ Aladdin.getTotalCart());

		System.out.println("Total nouveau panier "+ newCart.getTotal());
	}

}
