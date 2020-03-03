package com.us.patterns;


//implemented with interface
public class FoodFactory {
	
	
	
	
	
	public static void main(String[] args) {
		Factory myFoods = new Factory(); 
		Food food1 = myFoods.getFood("FastFood"); 
		Food food2 = myFoods.getFood("Fruit"); 
		System.out.println("My name is: " + food1.getClass().getSimpleName()); 
		System.out.println("My name is: " + food2.getClass().getSimpleName()); 
		//System.out.println("Our superclass is: " + food1.getClass().getSuperclass().getSimpleName()); 
		food1.serveFood(); 
		food2.serveFood();
	}
}

interface Food{
	
	 void getName();
	 
	 default void serveFood(){
		 
		 System.out.println("I am serving"+this.getClass().getSimpleName());
	 }
		 
	
}

class Fruit implements Food{
	
	public void getName(){
		
		System.out.println("I am serving Fruit");
	}
	
}

class FastFood implements Food{
	
	
	public void getName(){
		System.out.println("I am serving FastFood");
	}
	
}

class Meat implements Food{
	
	public void getName(){
		System.out.println("I am serving Meat");
	}
	
}

class Factory{
	
public Food getFood(String name){
		
		Food type = null;
		switch(name){
		
			case "FastFood" : type = new FastFood();
			case "Fruit" : type = new Fruit();
			case "Meat" : type = new Meat();
			
		}
		return type;
	}	
}
