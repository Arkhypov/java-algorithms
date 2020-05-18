package com.us.algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Sum3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
 
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
 
        while (j < k) {
 
            if (nums[i] + nums[j] + nums[k] > 0) {
                k--;
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                j++;
            } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(nums[i]);
                l.add(nums[j]);
                l.add(nums[k]);
                result.add(l);
                j++;
                k--;
            }
        }
    }
 
    return result.stream().collect(Collectors.toList()); 
  }

}
