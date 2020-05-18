package com.us.patterns;


public class FoodFactory {
    
	public static void main(String[] args) {
		
		FoodFactoryy myFoods = new FoodFactoryy(); 
		Food food1 = myFoods.getFood("FastFood"); 
		Food food2 = myFoods.getFood("Fruit"); 
		System.out.println("My name is: " + food1.getClass().getSimpleName()); 
		System.out.println("My name is: " + food2.getClass().getSimpleName()); 
		System.out.println("Our superclass is: " + food1.getClass().getSuperclass().getSimpleName()); 
		food1.serveFood(); 
		food2.serveFood();
		
	}
}

class Food {
	
	public void serveFood() {
		System.out.println("I'm serving " + this.getClass().getSimpleName());
	}
};

class FastFood extends Food {
};

class Fruit extends Food {
};

class FoodFactoryy {
    public static Food getFood(String type){
        switch(type){
            case "FastFood" : return new FastFood();
            case "Fruit" : return new Fruit();
            default : return new Food();
        }     
    }
    final class C{}
}

