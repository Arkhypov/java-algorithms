package com.us.algorithms.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(twoSum(new int[]{3,2,4},6));
	}
	
	 public static int[] twoSum(int[] nums, int target) {
	        int[] result = new int[2];
	        Map<Integer, Integer> map = new HashMap<>();
	        for(int i=0; i<nums.length; i++){
	        	map.put(nums[i], i);
	        }
	        
	        for(int i=0; i<nums.length; i++){
	        	int num2 = target - nums[i];
	        	if(map.containsKey(num2) && map.get(num2) != i){
	        		result[0]=i; result[1]=map.get(num2);
	                return result;
	        	}
	        }
	       return result; 
	    }
}
