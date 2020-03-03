package com.us.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class OddandEvenNumbers {

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line;
	    while ((line = in.readLine()) != null) {
	      StringBuffer result = new StringBuffer("");
	      
	      int[] num = new int[line.length()];

	      for (int i = 0; i < line.length(); i++){
	          num[i] = line.charAt(i) - '0';
	      }
	      for(int i=0;i<num.length; i++){
		        result.append(num[i]);
		        if(!(i==num.length-1)){
		          if(num[i]%2==0 && num[i+1]%2==0){
		        	  result.append("*");
		          
		          }else if(num[i]%2!=0 && num[i+1]%2!=0){
		            result.append("-");
		          }
		   }
	      
	      /*
	      char[] digits = line.toCharArray();
	      Character.getNumericValue('3');
	      int[] num = Integer.par
	      */
	    }
	      System.out.println(result.toString());
	  }

	}
}
