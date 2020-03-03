package com.us.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;

public class MaxQueue<X> {
	
	LinkedList<X> queue = null; 
	int maxEl=Integer.MIN_VALUE;
	ArrayList maxL = new ArrayList<X>();
	
	MaxQueue() {
		queue=new LinkedList<X>();
	}
	
	public void push(X el){
		if((int)el>maxEl){
			maxEl= (int)el;
			maxL.add(el);
		}
		queue.push(el);
	}
	
	public Integer peek(){
		Integer el = (int)queue.getLast();
		if((int)el==maxEl){
			maxL.remove(el);
			if(!maxL.isEmpty()){
				maxEl = (int) maxL.get(maxL.size()-1);
			}
		}
		return (Integer) queue.removeLast();
	}
	
	public int size(){
		return queue.size();
	}
	
	public boolean contains(Integer element){
		return queue.contains(element);
	}
	
	public Integer get(X pos){
		return (int)queue.get((int) pos);
	}
	
	public Integer getMax(){
		return new Integer(maxEl);
	}
}
