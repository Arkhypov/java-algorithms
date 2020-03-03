package com.us.java_features;

public class VisibilityFeatures {

	private int m=0;
	protected int n=1;
	public int smth=2;
	public static int smt=2;
	
	
	
	public void f(){
		System.out.println("f");
	}
	public static void f(String s){
		System.out.println(s);
	}
	private static void f(Integer s){
		System.out.println(s);
	}
	
	protected void f(Double s){
		System.out.println(s);
	}
}

class TestVisibility extends VisibilityFeatures{
	
	public static void main(String[] args) {
		
		f("Hi");
		//f(5);   //error should be static
		//n =0;	  //error should be static	
	}
}
