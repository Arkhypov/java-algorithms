package com.us.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackerRankSimpleQueries {

	
	public static void main(String[] args) throws Exception {
		 
		 System.out.println(Arrays.toString(counts(new int[] {1,2,3}, new int[] {2,4})));
		 
	 }
	// Complete the counts function below.
    static int[] counts(int[] nums, int[] maxes) {
		
    	List<Integer> result = new ArrayList<Integer>();
    	
    	for (int i=0; i<maxes.length; i++){
    		int count=0;
    		for(int j=0;j<nums.length;j++){
    			if(maxes[i]>=nums[j]){
    				count++;
    			}
    			if(j==nums.length-1 && count!=0){
    				result.add(count);
    			}
    		}
    		
    	}
    		
    	return result.stream().mapToInt(i->i).toArray();
        
        

    }
}
