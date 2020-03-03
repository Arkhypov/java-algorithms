package com.us.patterns;

public class FactoryOfFactories {
	
	public static void main(String[] args) {
		
		AbstractFactory shapeF = new FactoryProducer().getFactory("Shape");
		AbstractFactory colorF = new FactoryProducer().getFactory("Color");
		
		Shape circle = shapeF.getShape("Circle");
		//draw a circle
		circle.draw();
		
		Shape triangle = shapeF.getShape("Triangle");
		//draw a triangle
		triangle.draw();
		
		Shape square = shapeF.getShape("Square");
		//draw a square
		square.draw();
		
		Color blue = colorF.getColor("Blue");
		//fill with blue clolor
		blue.fill();
		
		Color red = colorF.getColor("Red");
		red.fill();
		
		Color black = colorF.getColor("Black");
		black.fill();
	}
}

interface Shape{
	
	void draw();
}

class Circle implements Shape{
	
	
	public void draw(){	
		System.out.println("I am drawing "+this.getClass().getSimpleName());
		
	}
}

class Triangle implements Shape{
	
	public void draw(){
		System.out.println("I am drawing "+this.getClass().getSimpleName());
	}
}

class Square  implements Shape{
	
	public void draw(){
		System.out.println("I am drawing "+this.getClass().getSimpleName());
	}
}


interface Color {
	
	void fill();
}

class Blue implements Color{
	
	public void fill(){
		System.out.println("I am fill out "+this.getClass().getSimpleName());
	}
	
}

class Red implements Color{

	public void fill() {
		
		System.out.println("I am fill out "+this.getClass().getSimpleName());
		System.out.println("I am fill out ");
	
	}
}
class Black implements Color{

	public void fill() {
		
		System.out.println("I am fill out "+this.getClass().getSimpleName());

	}
}

abstract class AbstractFactory{
	
	abstract Color getColor(String color);
	abstract Shape getShape(String shape);
	
}

class ShapeFactory extends AbstractFactory{

	Shape getShape(String shape) {
		
		switch(shape){
		
			case "Circle" : return new Circle(); 
			case "Triangle" : return new Triangle(); 
			case "Square" : return  new Square(); 
		
		}
		return null;
	}
	
	Color getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}
}

class ColorFactory extends AbstractFactory{
	
	
	

	Color getColor(String color) {
		
		switch(color){
			case "Blue" : return new Blue();
			case "Red" : return new Red();
			case "Black" : return new Black();
		}
		return null;
	}

	Shape getShape(String shape) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class FactoryProducer{
	
	public AbstractFactory getFactory(String choice){
		
		if (choice.equals("Shape")){
			
			return new ShapeFactory();
		}
		if (choice.equals("Color")){
			
			return new ColorFactory();
		}
		return null;
	}
	
}
	
