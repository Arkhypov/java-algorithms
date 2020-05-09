package com.us.algorithms;

public class MaxSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxSubArraySum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});
	}
	//in: {-2, -3, 4, -1, -2, 1, 5, -3}
		//out: 7, start: 2; end 6
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

}
