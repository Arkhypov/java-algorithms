package com.us.java_features;

public class Overriding {

	public static void main(String[] args) {
		
			Triangle triangle = new Triangle();
			Circle circle = new Circle();
			
			doActions(circle);
			doActions(triangle);
			
		}
	
	static void doActions(Shape shape){
		
		shape.draw();
		shape.erase();

	}

}

class Shape{
	
	void draw(){
		
		System.out.println("I am drawing some shape");
		
	}
	
	void erase(){
		
		System.out.println("I am erasing shape");
		
	}
	
}

class Triangle extends Shape{
	
	void draw(){
		
		System.out.println("I am drawing a Triangle");
		
	}
	
	void erase(){
		
		System.out.println("I am erasing erasing Triangle");
		
	}
	
}

class Circle extends Shape{
	
	void draw(){
		
		System.out.println("I am drawing a Circle");
		
	}
	
	void erase(){
		
		System.out.println("I am erasing erasing Circle");
		
	}
	
}
