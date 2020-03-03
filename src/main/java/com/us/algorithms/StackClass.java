package com.us.algorithms;

import java.util.ArrayList;
import java.util.List;
/*
	stack.push(1); //max()=1, Stack = (1), maxItem =1;  history_of_maxes = [1]
	stack.push(0); //max()=5, Stack = (1,0,5,2)   history_of_maxes = [1]
	stack.push(4); //max()=5, Stack = (1,0,5,2)   history_of_maxes = [1,4]
	stack.push(5); //max()=5, Stack = (1,0,5)    history_of_maxes = [1,5]
	stack.pop();  //history_of_maxes = [1], max()=1
	stack.push(2); //max()=5, Stack = (1,0,5,2)  history_of_maxes = [1,5]
	
	stack.push(1); //max()=5        history_of_maxes = [1,5]
	stack.push(6); //max()=6        history_of_maxes = [1,5,6]
	stack.pop();  //max()=5        history_of_maxes = [1,5]
*/

public class StackClass implements Stack {
	    
	    List<Object> arrList;
	    Object maxItem;
	    List<Object> history_of_maxes = new ArrayList<Object>();
	    
	   public StackClass(){
	        arrList = new ArrayList<Object>();
	    }
	    
	    @Override
		public void push(Object item){
	    	if(maxItem<item){
	    		history_of_maxes.add(item);
	    		maxItem=item;
	    	}
	        arrList.add(item);
	    }
	    
	    @Override
	    public Object pop(){
	        if(arrList.isEmpty()){
	            return new RuntimeException("Stack is empty");
	        }
	        Object item = arrList.get(arrList.size()-1);
	        if(history_of_maxes.get(history_of_maxes.size()-1)==arrList.get(arrList.size()-1)){
	    		history_of_maxes.remove(history_of_maxes.size()-1);
	    	}
	        arrList.remove(arrList.size()-1);
	        return item;
	    }
	    
	    @Override
	    public int size(){
	        
	        return arrList.size();
	    }
	    
	    @Override
	    public boolean isEmpty(){
	        
	        return arrList.isEmpty();
	    }
	    
	    
	    @Override
	    public Object max(){
	        if(arrList.isEmpty()){
	            return new RunTimeException("Stack is empty");
	        }
	        /*
	        else if(arrList.size()==1){
	            return arrList.get(0);
	        }
	        */
	        /*
	        maxItem=arrList.get(0);
	        for (int i=1;i<arrList.size()-1;i++){
	            if(arrList.get(i)>maxItem){
	                maxItem=arrList.get(i);
	            }
	            
	        }
	        */
	        return maxItem;
	    }

	public static void main(String[] args) {

		Stack stack = (Stack) new StackClass();

	}
}
	public interface Stack {

    /**
     * Adds the given item to the top of the stack.
     */
    void push(Object item);

    /**
     * Removes the top item from the stack and returns it.
     */
    Object pop();

    /**
     * Returns the number of items currently in the stack.
     */
    int size();

    /**
     * Returns whether the stack is empty or not.
     */
    boolean isEmpty();

    /**
     * Returns the max item .
     */
    Object max();
}

