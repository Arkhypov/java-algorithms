package com.us.algorithms;

import java.util.Arrays;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class TestTaskTranswise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello");
		
		//System.out.println(find_numbers(3,1,13));
	}
	static String find_numbers(int digit, int start, int end) {
		String result ="";
		for(int i=start; i<=end && i<1000;){
			if(i<10 && i==digit){
				result+=i;
				i=10; continue;
			} else if((int)Math.floor(i/10)==digit || i%10==digit && i<100){
				result=result.isEmpty() ? String.valueOf(i) : result+" "+i;
				
			} else if((int)Math.floor(i/100)==digit || i%10==digit){
				result=result.isEmpty() ? String.valueOf(i) : result+" "+i;
				
			}
			i++;
		}
		
		
		return result;
    }
	
}

//Say there's an array that contains all the integers, from 1 to 1 million with no duplicates.
//Now, before I give you this array, I take out a number at random and replace it with zero.


//Could you write a method that would take this modified array and return the missing number?