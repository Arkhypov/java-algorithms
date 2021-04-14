package com.us.algorithms.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadBalancer {

  /*
   * Load balancing problem Write a function which takes as input an array of random integers, sort
   * them into two output arrays where sum of values in each array is as close to equal sum as
   * possible.
   * 
   * Example: input = [5, 3, 7, 5, 1] output_a = [5, 5] output_b = [3, 7, 1]
   * 
   * input = [1, 3, 5, 5, 7] output_a = [1,5,5] output_b = [7,3]
   * 
   * Example 2: input = [5, 3, 7, 5, 99] output_a = [99] output_b = [7, 5, 5, 3]
   * 
   * input = [3, 5, 5, 7, 98, 99] output_a = [3, 98, 7] //108 output_b = [99, 5, 5] //109
   * 
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(get2sizedArray(new int[] {3, 5, 5, 7, 98, 99}));
    System.out.println(get2sizedArray(new int[] {5, 3, 7, 5, 1}));
  }

  public static List<ArrayList<Integer>> get2sizedArray(int[] arr) {

    Arrays.sort(arr);
    List<Integer> rArr = new ArrayList<Integer>();
    List<Integer> lArr = new ArrayList<Integer>();
    int start = 1;
    int end = arr.length - 2;
    int leftSum = arr[0];
    int rightSum = arr[arr.length - 1];
    rArr.add(rightSum);
    lArr.add(leftSum);
    while (start <= end) {
      if (leftSum < rightSum) {
        lArr.add(arr[end]);
        leftSum += arr[end];
        end--;
      } else if (leftSum > rightSum) {
        rArr.add(arr[start]);
        rightSum += arr[start];
        start++;
      } else { // rightsum==leftSum
        rightSum += arr[start];
        start++;
      }
    }
    return new ArrayList() {
      {
        add(rArr);
        add(lArr);
      }
    };
  }

}
