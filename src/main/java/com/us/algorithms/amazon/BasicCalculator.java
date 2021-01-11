package com.us.algorithms.amazon;

import java.util.Stack;

public class BasicCalculator {
/**
	Implement a basic calculator to evaluate a simple expression string.
	The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
	The integer division should truncate toward zero.
*/	
	public static void main(String[] args) {
	}
	public int calculate(String s) {
	    int length;
	    if(s==null || (length = s.length())==0) return 0;
	    Stack<Integer> stack = new Stack<Integer>();
	    int num = 0;
	    char sign = '+';
	    for(int i=0;i<length;i++){
	        if(Character.isDigit(s.charAt(i))){
	            num = num*10+s.charAt(i)-'0';
	        }
	        if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==length-1){
	            if(sign=='-'){
	                stack.push(-num);
	            }
	            if(sign=='+'){
	                stack.push(num);
	            }
	            if(sign=='*'){
	                stack.push(stack.pop()*num);
	            }
	            if(sign=='/'){
	                stack.push(stack.pop()/num);
	            }
	            sign = s.charAt(i);
	            num = 0;
	        }
	    }

	    int result = 0;
	    for(int i:stack){
	        result += i;
	    }
	    return result;
	}

}
