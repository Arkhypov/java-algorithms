package com.us.algorithms;

import java.util.Scanner;
import java.util.Stack;

public class BracketChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        String brackets = sc.nextLine();
        char[] bracketsArr = brackets.toCharArray();
        Stack<Character> stack = new Stack<Character>();//CREATING THE stack FOR THE BRACKETS
        
        boolean isBalanced = true;//CHECKING WHETHER THE BRACKETS ARE BALANCED
        for (int i=0;i<bracketsArr.length; i++){
        	char bracket = 0;
        	if(bracketsArr[i]=='{' || bracketsArr[i]=='[' || bracketsArr[i]=='('){
        		
        		stack.push(bracketsArr[i]);
        		continue;
        	}
        	if(bracketsArr[i]=='}'){
        		bracket='{';
        	}else if(bracketsArr[i]==']'){
        		bracket='[';
        	}else if(bracketsArr[i]==')'){
        		bracket='(';
        	}
        	if(stack.isEmpty()){
            	isBalanced=false;
            	break;
            }
        	if(stack.peek()==bracket){
        		stack.pop();
        	}else{
        		isBalanced=false;
            	break;
        	}
        }
        
        if(isBalanced){
        	System.out.println("Is balanced");
        }else{
        	System.out.println("Is not balanced");
        }
        
        
	}
	
	static String[] braces(String[] values) {
        
        String[] result = new String[values.length];
        
        for (int i=0; i<values.length;i++){
	            
            Stack<Character> stack = new Stack<Character>();
            boolean isBalanced = true;
            char[] bracketsArr=values[i].toCharArray();
            
            for (int j=0;j<bracketsArr.length; j++){
        	char bracket = 0;
        	if(bracketsArr[j]=='{' || bracketsArr[j]=='[' || bracketsArr[j]=='('){
        		
        		stack.push(bracketsArr[i]);
        		continue;
        	}
        	if(bracketsArr[j]=='}'){
        		bracket='{';
        	}else if(bracketsArr[j]==']'){
        		bracket='[';
        	}else if(bracketsArr[j]==')'){
        		bracket='(';
        	}
        	if(stack.isEmpty()){
            	isBalanced=false;
            	break;
            }
        	if(stack.peek()==bracket){
        		stack.pop();
        	}else{
        		isBalanced=false;
            	break;
        	}
        }
	            if(isBalanced){
	                
	                result[i]=new String("Yes");
	            } else {
	                
	                result[i]=new String("No");
	            }
	        }
	        return result;
        
        
            
    }
	

}
