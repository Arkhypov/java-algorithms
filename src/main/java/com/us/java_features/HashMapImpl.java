package com.us.java_features;

import java.util.HashMap;
import java.util.Map;

public class HashMapImpl {
	
	static class Dog {

		String color;

		Dog(String c) {

		color = c;

		}

		public String toString(){

		return color + " dog";

		}
		
		
		//with appending below methods HashMap will not accept dublicates inside itself
		public boolean equals(Object o) {

			return ((Dog) o).color == this.color;

		}

		public int hashCode() {

			return color.length();

		}

		}

		private static class TestHashMap {

			public static void main(String[] args) {

		Map<Dog, Integer> hashMap = new HashMap<Dog, Integer>();

		Dog d1 = new Dog("red");
		Dog d2 = new Dog("black");
		Dog d3 = new Dog("white");
		Dog d4 = new Dog("white");
		
		hashMap.put(d1, 10);
		hashMap.put(d2, 15);
		hashMap.put(d3, 5);
		hashMap.put(d4, 20);

		//print size
		// 4
		System.out.println(hashMap.size());

		
		//loop HashMap
		for (Dog dog : hashMap.keySet()) {

		System.out.println(dog.toString() + " - " +  hashMap.get(dog));
		
		/*
			white dog - 20
			red dog - 10
			black dog - 15
			white dog - 5
		*/
		}

		}

		}

}

