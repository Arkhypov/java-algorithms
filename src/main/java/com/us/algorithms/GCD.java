package com.us.algorithms;

//greater common divider
public class GCD {

	public static void main(String[] args) {
		int arr[] = { 6, 10, 20, 30, 90 }; 
        int n = arr.length; 
        System.out.println(findGCD(arr, n)); 
	}
	
	// Function to return gcd of a and b 
	// Euclidean algorithm
    static int gcd(int a, int b) 
    {
    	//b		a
    	//77	49
    	//49	28
    	//28	21
    	//21	7
    	//7		0
    	//return 7
    	if (a == 0) 
            return b;
    	int k=b%a;
        return gcd(b % a, a); 
    } 
  
    // Function to find gcd of array of 
    // numbers 
    static int findGCD(int arr[], int n) 
    { 
        int result = arr[0]; 
        for (int i = 1; i < n; i++) {
            result = gcd(arr[i], result); 
            //System.out.println(result);
        }
        return result; 
    } 
}
