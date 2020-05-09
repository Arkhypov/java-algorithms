package com.us.java_features;

import java.awt.List;
import java.util.AbstractList;

public final class ImmutableObject {

	public final int x;
	public final int y;
	public final String o;

	ImmutableObject(int x, int y, String o) {
	        this.x = x;
	        this.y = y;
	        this.o=o;
	}
	
	ImmutableObject p = new ImmutableObject(5, 10, "");

	p.x = 50;
	// Compilation error: cannot assign a value to a final variable
	
	public static void main(String[] args){
		
		String first = "first";
		
		System.out.println(first.hashCode());
		// prints something

		first = first + "!";
		
		System.out.println(first.hashCode());
		// prints something different
		List p = new List();
		
	}
}