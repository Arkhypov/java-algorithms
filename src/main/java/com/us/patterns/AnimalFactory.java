package com.us.patterns;

public class AnimalFactory {

	public static void main(String[] args){
		
		Animal dog = new Dog();
		dog.printAnimal(dog.getClass().getSimpleName());
		Animal cow = new Cow();
		cow.printAnimal(cow.getClass().getSimpleName());
		Animal duck = new Duck();
		duck.printAnimal(duck.getClass().getSimpleName());
	}
}
abstract class Animal {

    protected boolean isMammal;
    protected boolean isCarnivorous;


    public Animal(boolean isMammal, boolean isCarnivorous) {
        this.isMammal = isMammal;
        this.isCarnivorous = isCarnivorous;
    }

    public boolean getIsMammal() {
        return this.isMammal;
    }


    public boolean getIsCarnivorous() {
        return this.isCarnivorous;
    }
    

    abstract public String getGreeting();


    public void printAnimal(String name) {


        System.out.println( 

            "A " + name + " says '" + this.getGreeting() 
            + "', is " + (this.getIsCarnivorous() ? "" : "not ") 
            + "carnivorous, and is " + (this.getIsMammal() ? "" : "not ") + "a mammal."
        );

    }


}

class Dog extends Animal{

	public Dog(boolean isMammal, boolean isCarnivorous) {
		super(isMammal, isCarnivorous);
		// TODO Auto-generated constructor stub
	}
	
	public Dog(){
		
		super(true, true);
	}

	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return "ruff";
	}
	
}

class Cow extends Animal{

	public Cow(boolean isMammal, boolean isCarnivorous) {
		super(isMammal, isCarnivorous);
		// TODO Auto-generated constructor stub
	}
	
	public Cow(){
		
		super(false, true);
	}

	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return "moo";
	}
	
}

class Duck extends Animal{

	public Duck(boolean isMammal, boolean isCarnivorous) {
		super(isMammal, isCarnivorous);
		// TODO Auto-generated constructor stub
	}
	
	public Duck(){
		
		super(false, false);
	}

	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return "qa-qa";
	}
}


