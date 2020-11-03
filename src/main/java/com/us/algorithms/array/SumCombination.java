package com.us.algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumCombination {
/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. 
 * You may return the combinations in any order.
   The same number may be chosen from candidates an unlimited number of times. 
   Two combinations are unique if the frequency of at least one of the chosen numbers is different.
   It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * 
 * Input: candidates = [2,3,6,7], target = 7
   Output: [[2,2,3],[7]]

   Explanation:
	2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
	7 is a candidate, and 7 = 7.
   These are the only two combinations.
 */
	public static void main(String[] args) {
		System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
		System.out.println(combinationSumNoDub(new int[]{2,3,6,7}, 7));
	}
	public static List<List<Integer>> combinationSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new ArrayList<>(tempList));
	    else{ 
	        for(int i = start; i < nums.length; i++){
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
	
	public static List<List<Integer>> combinationSumNoDub(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrackNoDublicates(list, new ArrayList<>(), nums, target, 0);
	    return list;
	}
	
	private static void backtrackNoDublicates(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new ArrayList<>(tempList));
	    else{ 
	        for(int i = start; i < nums.length; i++){
	        	if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i+1);
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
	

}
