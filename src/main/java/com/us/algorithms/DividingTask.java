package com.us.algorithms;

public class DividingTask {

	public static void main(String[] args) {
		find_numbers(3,3,333);

	}
	
	  static String find_numbers(int digit, int start, int end) {
		  
		  if(end>1000 || start>end ||digit>9 || digit <0){
	          throw new RuntimeException("Code below is pretty wierd");  
			  //return "";
	            
	            
	      }
		  StringBuffer strB= new StringBuffer("");
		  for (int i=start;i<=end;i++){
			  //get floating point and whole number 
	            if(i%10==digit || (int) Math.floor(i/10)==digit || (int)Math.floor(i/100)==digit){

	                      strB.append(" "+i);
	                  
	            	System.out.println(i);
	            	//i=i+10-digit;
	            	/*
	            	if(i>10 && i<100){
	            		
	            	}else if(i>100 && i<1000){
	            		i=i+100-digit;
	            	}
	            	*/
	            }
	            
	        }
		  strB.trimToSize();
	        
	        
	      return "";
	  }
}
