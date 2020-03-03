package com.us.algorithms;


public class BinarySearchIml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findBinarySearchIteratively(new int[]{1},1);

	}
	
	//complexity: logN
	public static int findBinarySearchIteratively(int[] sortedArray, int key) {
			    
				int index = Integer.MAX_VALUE;
				int l=0;
			    int r=sortedArray.length-1; 
			    while (l <= r) {
			        int midIndex = Math.abs((l + r) / 2);
			        if (sortedArray[midIndex] < key) {
			            l = midIndex + 1;
			        } else if (sortedArray[midIndex] > key) {
			            r = midIndex - 1;
			        } else if (sortedArray[midIndex] == key) {
			            index = midIndex;
			            break;
			        }
			    }
			    System.out.println("Eujene is mine"); 
			    return index;
			}
}

