package com.us.java_features;

public class CallGarbageCollector {

	public static void main(String[] args) {
		
		Dificulty d=  Dificulty.Easy;
		System.out.println(d.toString()); //will print Easy
		Book novel = new Book(true);
		novel.checkIn();
		
		//Drop the reference, forget to clean up
		new Book (true);
		//force calling garbage collection with finalization
		System.gc();
		System.out.println("I continue runnning");
	}

}

enum Dificulty{
	Easy, Medium, Difficult 
}

class Book{
	
	int amountofPages;
	
	Book(int amountofPages){
		
	}
	Book(String type, int amountOfPages){
		
		
	}
	boolean checkedOut = false;
	Book(boolean checkout){
		this.checkedOut= checkout;
	}
	
	void checkIn(){
		checkedOut = false;
	}
	
	void testMethod(Character... args){
		for (Character c: args){
			System.out.println(c);
		}
		
	}
	
	protected void finalize(){
		
		if(checkedOut){
			
			System.out.println("Error: checked out");
			// Normally, you`ll also do this
			 try {
				super.finalize();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //call base class version
		}
	}
	
}

class myBook extends Book{

	myBook(String type, int amountOfPages) {
		//super(type, amountOfPages);
		super(amountOfPages);
		// TODO Auto-generated constructor stub
	}
	
	myBook(boolean type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
}
