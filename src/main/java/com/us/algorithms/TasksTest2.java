package com.us.algorithms;



import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class TasksTest2 {
	
	Map<String, Integer> globMap = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		//outPutCharOcur("Hello");
		maxSubArraySum(new int[]{-2, -3, 4, -1, -4, 1, 5, -3});
		System.out.println(reverseString("Hello World"));
		System.out.println(findFirst("rerverse"));
        
	}
	
	public static char findFirst(String input)
	  {
	    // TODO: Implement solution
	    char result = 0;
	    char[] ch = input.toCharArray();
	    Set<Character> chWeHave = new HashSet<Character>();
	
	    for (int i=0;i<ch.length;i++){
	    	System.out.println("i="+i);
	    	if(!chWeHave.contains(ch[i])){
		        chWeHave.add(ch[i]);
		        for (int j=i+1;j<ch.length;j++){
		        	System.out.println("j="+j);
		    		
		        	if(ch[i]==ch[j]){
		            	result=0;
		              break;            
		            } else if(result==0){
		            	result=ch[i];
		            }
		            if(ch[i]!=ch[j] && j==ch.length-1){
		            	System.out.println("Hello");
		            	return result;
		            }
		         }
	    	}
	     }
	 
	    //solution #2
/*	    
	    Map<Character, Integer> map = new HashMap<Character, Integer>();
	    for(int i=0;i<ch.length-1;i++){
	    	
	    	if(map.containsKey(ch[i])){
	    		map.replace(ch[i], map.get(ch[i]), map.get(ch[i])+1);
	    	}else{
	    		map.put(ch[i], 1);
	    	}
	    }
	    for (Character k : map.keySet()){
	    	if(map.get(k)==1){
	    		return k;
	    	}
	    }
*/	    
	    return result;
	  }
	
	public static void outPutCharOcur(String input){
		
		Map <Character, Integer> map =new HashMap <Character, Integer>();
		//int ocur=0;
		char[] chars = input.toCharArray();
		for (int i=0; i<chars.length; i++){
			
			if(!map.containsKey(chars[i])){
				
				map.put(chars[i], 1);
			} else{
				
				int ocur = map.get(chars[i]);
				map.replace(chars[i], ocur+1);
			}
	
		}
		for (Character key: map.keySet()){
			
			System.out.println(key+" : "+map.get(key));
		}
		
		
	}
	
	public static String reverseString(String input){
		
		String result="";
		char[] chars = input.toCharArray();
		
		for (int i=input.length()-1;i>=0;i--){
			 
			result+=chars[i];
			
		}
		
		
		return result;
		
		
		
		
	}

	public void appendMap (String line, HashMap<String, Integer> map){
		
		String[] words= line.split(" ");
		
		StringBuffer b= new StringBuffer("");
		for (int i=0; i< words.length; i++){
			if (map.containsKey(words[i])){
				
				int value = map.get(words[i]);
				map.replace(words[i], value+1);
				
			}else{
				
				map.put(words[i], 1);
				
			}
		}
		//for (String key:)
		//return (HashMap<String, Integer>) globMap; 
		
	}
	
	//in: {-2, -3, 4, -1, -2, 1, 5, -3}
	//out: 7, start: 3; end 6
	static void maxSubArraySum(int a[]){
		
		int max_sum = Integer.MIN_VALUE;
		int max_we_have_so_far = 0, start=0, end=0, s=0;
		int size=a.length;
		
		for (int i=0; i<size; i++){
			
			max_we_have_so_far+=a[i];
			
			if(max_sum<max_we_have_so_far){
				max_sum=max_we_have_so_far;
				start=s;
				end=i;
			}
			
			if(max_we_have_so_far<0){
				
				max_we_have_so_far=0;
				s=i+1;
			}
			
		}
		System.out.println("Maximum sum of subarray: " + max_sum);
		System.out.println("Starting index: " + start);
		System.out.println("Ending index :" + end);
		
		
    }
	
static int reductionArray(int[] num) {
		   
		   Arrays.sort(num);
		   int cost = 0;
		   LinkedList<Integer> ll = new LinkedList<Integer>();
		   for (int i : num)
		   {
			   ll.add(i);
		   }
		   
		   for(int i=0; i<ll.size()-1; ) {
			   int el=ll.get(i)+ll.get(i+1);
			   ll.set(i+1, el);
			   cost=cost+el;
			   ll.remove(i);
			   Collections.sort(ll);
		   }
		return cost;
		   
		      /*  
	        Arrays.sort(num);
			   int cost = 0;
			   for(int i=0; i<num.length-1; i++) {
				   num[i+1] = num[i] + num[i+1];
				   cost = cost + num[i+1];
			   }
			return cost;
	*/

}


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*

int[] input = {1,5,6,6,9};
int sum = 20;

int closestPairToSum = {6,9};

*/
/*
1.  
2. do binary search

1. loop all elements 
and put result in hashmap
*/
/*public class Solution {
    public static void main(String args[] ) throws Exception {
         Enter your code here. Read input from STDIN. Print output to STDOUT 
        System.out.println(Arrays.toString(getClosestKeyPair(new int[] {1,5,6,6,9}, 20)));
    }
    
    public static int[] getClosestKeyPair(int[] input, int sum){
        int result[]= new int[2];
        Set<Integer> set = new HashSet();
        int diff=Integer.MIN_VALUE;
        for(int i=0; i< input.length; i++){
            if(set.contains(input[i])){continue;}
            set.add(input[i]);
            for(int j=i; j< input.length;j++){
                //if(set.contains(input[j])){continue;}
                //set.add(input[j]);
                if(20-(input[i]+input[j])<=sum){
                    diff=20-(input[i]+input[j]);
                    result=new int[]{input[i],input[j]};
                }
            }
        }
        return result;
    }
   
}*/
	
	/* Problem Name is &&& Is Power of 10 &&& PLEASE DO NOT REMOVE THIS LINE. */
	/**
	 * Instructions to candidate.
	 *  1) Run this code in the REPL to observe its behaviour. The
	 *     execution entry point is main().
	 *  2) Consider adding some additional tests in doTestsPass().
	 *  3) Implement isPowerOf10() correctly.
	 *  4) If time permits, some possible follow-ups.
	 */


	

}


