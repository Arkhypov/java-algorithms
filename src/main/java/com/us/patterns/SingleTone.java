package com.us.patterns;

public class SingleTone {
	
	private static SingleTone singleTone = new SingleTone();
	
	private SingleTone(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static SingleTone getSingleTone(){
		
		return singleTone;
	}
	
	public void f(){
		
	}

}

class Test{
	
	
	void testSingleTone(){
		//SingleTone test =new SingleTone(); 	//compile error
		
		SingleTone s =SingleTone.getSingleTone();
		s.f();
	}
}
