package com.us.algorithms;

public class CountStairs {

	public static void main(String[] args) {
		int s = 3;
		System.out.println("Number of ways = " + fib(s));
	}
	
	static int fib(int n){
		if (n == 1)
		return n;
		if(n==0)
		return 1;
	return fib(n - 1) + fib(n - 2);
	}
}
