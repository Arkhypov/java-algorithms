package com.us.algorithms;

import java.awt.List;
import java.util.ArrayList;

public class MagicalSubsequence {
	
	
	 public static void main(String[] args) throws Exception {
		 
		 System.out.println(getMinOperations(10));
		 System.out.println(longestSubsequence("aeiaaioooaauuaeiou"));
		 System.out.println(maxDifference(new int[]{100,99,100,101,80}));
	 }
	 /*
	  * A string, s, consisting of one or more of the following letters: a, e, i, o, and u.
	  * We define a magical subsequence of s to be a sequence of letters derived from s that contains all five vowels in order. 
	  * This means a magical subsequence will have 
	  * one or more a's followed by one or more e's followed by one or more i's followed by one or more o's followed by one or more u's. 
	  * For example, if s = "aeeiooua", then "aeiou" and "aeeioou" are magical subsequences but "aeio" and "aeeioua" are not.
	  * 
	  * Complete the longestSubsequence function in your editor. 
	  * It has 1 parameter: a string, s. It must return an integer denoting the length of the longest magical subsequence in s. 
	  * If no magical subsequence can be constructed, return 0.
	  * 
	  * Sample Input 1: "aeiaaioooaauuaeiou"
	  * Sample Output 1: 10
	  * Explanation 1: aeiiooouuu
	  * 
	  * Sample Input 2: "aeiaaioooaa"
	  * Sample Output 2: 0
	  * Explanation 2: String s does not contain the letter u, so it is not possible to construct a magical subsequence.
	  */
	 static int longestSubsequence(String s) {
		
		 char[] c = s.toCharArray();
		 char[] m = {'a','e','i','o','u'};
		 String subseq= "";
		 int index=0;
		 
		 
			 
			 for (int j=0; j<c.length;j++){
				 
				 if(c[j]==m[index]){
					 subseq+=c[j];
				 } else if(index<4 && c[j]==m[index+1]){
						index++; 
						subseq+=c[j];
				 }

			 }
			 for (char k : m){
				 if(!subseq.contains(Character.toString(k))){
					 return 0;
				 }
				 
			 }
		 return subseq.length();

	 }
	 
	 
	 /*										Maximum Difference in an Array
	  * 
	  * The maximum difference between elements in some array, a, is defined as the largest difference between any a[i] and a[j] 
	  * where i < j and a[i] < a[j]. For example, if a = [4, 1, 2, 3], the maximum difference would be a[3] - a[1] = 3 - 1 = 2 
	  * because this is the largest difference between any two elements satisfying the aforementioned criteria.
	  * 
	  * 
	  * Complete the maxDifference function in the editor below. It has 1 parameter: an array of integers, a. 
	  * It must return an integer denoting the maximum difference between any pair of elements in a; 
	  * if no such number exists (e.g., if a is in descending order and all a[j] < a[i]), return -1 instead.
	  * 
	  * Input Format:
	  * Locked stub code in the editor reads the following input from stdin and passes it to the function:
	  * The first line contains a single integer, n, denoting the number of elements in array a.
	  * Each line i of the n subsequent lines (where 0 <= i < n) contains a single integer describing element a[i].
	  * 
	  * Constraints:
	  * 1 <= n <= 2 * 105
	  * -106 <= a[i] <= 106  i  [0, n - 1]
	  * 
	  * Output Format:
	  * The function must return an integer denoting the maximum difference in a. 
	  * This is printed to stdout by locked stub code in the editor.
	  * 
	  * Sample Input:  7, 2, 3, 10, 2, 4, 8, 1
	  * Sample Output: 8
	  * 
	  * Explanation:
	  * n = 7, a = [2, 3, 10, 2, 4, 8, 1]
	  * As a[2] = 10 is largest element in the array, we must find the smallest a[i] where 0 <= i < 2. 
	  * This ends up being 2 at index i = 0.
	  * We then calculate the difference between the two elements: a[2] - a[0] = 10 - 2 = 8, and return the result (8).
	  * Note: While the largest difference between any two numbers in this array is 9 (between a[2] = 10 and a[6] = 1), 
	  * this cannot be the maximum difference because the element having the smaller value (a[6]) must be of a lesser index 
	  * than the element having the higher value (a[2]). As j = 2 is not less than i = 6, these elements cannot be used to calculate 
	  * the maximum difference.
	  * 
	  * 
	  * Sample Input2: 6, 7, 9, 5, 6, 3, 2
	  * Sample Output2: 2
	  * 
	  * Explanation2:
	  * n = 6, a = [7, 9, 5, 6, 3, 2]
	  * The maximum difference returned by the function is a[1] - a[0] = 9 - 7 = 2, because 2 is the largest difference between 
	  * any a[i] and a[j] satisfying the conditions that a[i] < a[j] and i < j.
	  * 
	  */
	 
	 static int maxDifference(int [] a){
		 //write code here
		 
		 int max_diff = a[1] - a[0];
		 int min_element= a[0];
		 
		 for (int i=0; i<a.length; i++){
			 
			 if(a[i]<min_element){
				 min_element=a[i];
			 }
			 if(a[i] - min_element>max_diff){
				 max_diff=a[i] - min_element;
			 }
			 
		 }
		 
		 return max_diff;
	 }
	 
	 /*
	  * You have two operations: add by one and multiply by 2. 
	  * Find  the minimum number of operations to get from 0 to any particular integer.
	  * 
	  */
	 static int getMinOperations(int num){
		 int count=0;
		 int value=0;
		 while(num!=1){
			 if(num%2==0){
				 num=num/2;
				 count++;
			 }else{
				num--;
				count++;
			 }
		 }
		 return count;
	 }
	 
	 
}
