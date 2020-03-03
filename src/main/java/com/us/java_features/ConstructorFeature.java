package com.us.java_features;



public class ConstructorFeature {

	
	int petalCount = 0;
	String s="initial value";
	
	ConstructorFeature(int petals){
		
		petalCount= petals;
		System.out.println("Constructor w/ String arg only, petalCount= "+ petals);
	}
	
	ConstructorFeature(String ss){
		
		System.out.println("Constructor w/ String arg only, petalCount= "+ ss);
		s=ss;
	}
	
	ConstructorFeature(String ss, int petals){
		
		this(petals);
		//this(ss); //can not call twice
		this.s = ss;
		System.out.println("String & int arg");
	}
	ConstructorFeature(){
		
		this("hi", 47);
		System.out.println("Default constructor, no args");
	}
	
	void printPetalCount(){
		
		//this(11); //Can be used, just inside constructor
		System.out.println("petalCount = " +petalCount +" s = "+s);
	}
	
	public static void main(String[] args) {
		
		ConstructorFeature c = new ConstructorFeature();
		//ConstructorFeature k = new ConstructorFeature("", 23);
		c.printPetalCount();
		new Person().eat(new Apple());

	}

}

class Person {
	
	public void eat(Apple apple){
		
		Apple peeled = apple.getPeeled();
		System.out.println("Our apple is peeled");
	}
	
}
class Peeler {
	
	static Apple peel (Apple apple){
		
		//remove peel
		return apple; //peeled apple
	}
}

class Apple {
	
	Apple getPeeled(){
		
		return Peeler.peel(this);
	}
}

