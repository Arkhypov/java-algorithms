package com.us.algorithms;


import java.util.Scanner;

public class GetAreaFactory {
	
	
	public static void main(String[] args) {
			
        	// Declare the object and initialize with
            // predefined standard input object
			Scanner sc= new Scanner(System.in);
            int i=1;
            
            while(sc.hasNext()){
            	
            	String input = sc.nextLine();
            	if(i==1 || i==3){
            		Circle c = new Circle(Float.parseFloat(input));
            		System.out.println("Circle area: "+ c.getArea());
            	} else if(i==2 || i==5){
            		Rectangle r = new Rectangle(Float.parseFloat(input.split(" ")[0]),
            				Float.parseFloat(input.split(" ")[1]));
            		System.out.println("Rectangle area: "+ r.getArea());
            	} else{
            		Square s = new Square(Float.parseFloat(input));
            		System.out.println("Square area: "+ s.getArea());
            	}
            	//System.out.println("incrementing");
            	i++;
            }
	
	}	
}
	
	
	
	class Circle{
		
		private float radius;
		
		public Circle(float radius){
			this.radius=radius;
			
		}
		
		public int getArea(){
			
			int area=(int) Math.ceil(3.14159265 * radius * radius);
			return area; 
		}
	}
	
	class Rectangle{
		
		private float width;
		private float height;
		
		public Rectangle(float height,float width){
			
			this.height=height;
			this.width=width;
		} 
		public int getArea(){
			
			int area= (int) Math.ceil(width * height);
			return area;
		}
		
	}
	
	class Square{
		
		private float width;
		
		public Square(float width){
			this.width=width;
		}
		
		public int getArea(){
			
			int area= (int) Math.ceil(width * width);
			return area;
		}
	}
