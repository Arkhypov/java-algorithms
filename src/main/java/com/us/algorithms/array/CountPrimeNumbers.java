package com.us.algorithms.array;

import java.util.Deque;
import java.util.Stack;

public class CountPrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPrimes(20));
		//2, 3, 5, 7, 11, 13, 17, 19
	}
	
	public static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) { //not prime are numbers you are multiplying on to.
                    notPrime[i*j] = true;
                }
            }
        }  
        return count;
    }
}
