package com.us.patterns;

public class MultiThreadSingleTone {
	
	private static MultiThreadSingleTone singleTone =null;
	
	private MultiThreadSingleTone(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static MultiThreadSingleTone getSingleTone(){
		
		if(singleTone==null){
			synchronized(MultiThreadSingleTone.class){
				 if (singleTone == null) {
					 singleTone=new MultiThreadSingleTone();
				 }
			}
		}
		return singleTone;
	}
	
	public void f(){
		
	}

}

class Test{
	
	
	void testSingleTone(){
		//SingleTone test =new SingleTone(); 	//compile error
		
		MultiThreadSingleTone s =MultiThreadSingleTone.getSingleTone();
		s.f();
	}
}
