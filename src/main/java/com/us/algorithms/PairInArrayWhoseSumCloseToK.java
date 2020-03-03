package com.us.algorithms;

public class PairInArrayWhoseSumCloseToK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] =  {10, 22, 28, 29, 30, 40}, x = 54;  
		System.out.println(findPairsCloseToSum(arr, x)[0] +" "+findPairsCloseToSum(arr, x)[1]); 
	}
	
	private static int[] findPairsCloseToSum(int[] arr, int K){
		int[] result = new int[2];
		int l=0;
		int r=arr.length-1;
		int diff=Integer.MAX_VALUE;
		int left = 0;
		int right=0;
		while(l<=r){
			if(Math.abs(K-(arr[l]+arr[r]))<diff){
				diff=Math.abs(K-(arr[l]+arr[r]));	
				left=l;
				right=r;
			}	
			if(arr[l]+arr[r]>K){
				r--;
			}else{
				l++;
			}
		}
		result[0]=arr[left];
		result[1]=arr[right];
		return result;
	}

}
