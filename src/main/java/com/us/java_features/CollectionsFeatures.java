package com.us.java_features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class CollectionsFeatures {

	
	public static void printEl(Collection<String> collection){
		
		Iterator it=collection.iterator();
		while(it.hasNext()){
			System.out.println(it.toString());
		}
		
	}
	
	public static void main(String[] args){
		
		
		Set<String> strSet = new HashSet<String>(){{
			add("Apple");
			add("Palm");
			add("Grape");
			add("Orange");
		}};
		//could not use this loop
		for(String s: strSet){
			System.out.println(s);
		}
		
		List<String> strList = new ArrayList<String>(){{
			add("Christmas");
			add("Plum");
			add("Limon");
			add("Peach");
			add("Cherry");
		}};
		
		List<String> strLinkedList = new LinkedList<String>(){{
			add("Charm");
			add("Pretty");
			add("Smile");
			add("Smell");
			add("Look");
		}};
		
		LinkedList<String> testLinkedList = new LinkedList<String>(){{
			add("Charm");
			add("Pretty");
			add("Smile");
			add("Smell");
			add("Look");
		}};
		
		testLinkedList.addFirst("test");      //magic of LinkedList
		testLinkedList.addLast("test");
		testLinkedList.removeFirst();
		testLinkedList.removeLast();
		testLinkedList.peekFirst(); 		//return first element from LinkedList but do not remove element
		testLinkedList.pop(); 				//first element returns and remove it from LinkedList
		testLinkedList.peekLast(); 			//return last element from LinkedList but do not remove element
		testLinkedList.offer("someElement");//inserts element at the tail and return true
		testLinkedList.element();			//retrives, but does not removes head element
		
		
		printEl(strLinkedList);
		printEl(strList);
		printEl(strSet);
		
	}
	
	public void mapFeatures(){
		
		Map<String,String> testHashM = new HashMap<String,String>(){{
			put("k1","test");
			put("k2","apple");
			put("k3","bananna");
			put("k4","margarita");
			put("k5","cream");
		}};
		testHashM.containsValue("cream"); //true
		
	}
	
	
}
class PrioriityQuee{
	
	public static void main(String[] args){
		
		List<Integer> ints = Arrays.asList(25,24,3,18,15,10,9,7,8);
		PriorityQueue<Integer> priorityQ = new PriorityQueue<Integer>(ints);
		priorityQ.stream().forEach(e->System.out.print("|"+e+"|"));
		
		System.out.println();
		PriorityQueue<Integer> priorityQ2 = new PriorityQueue<Integer>(ints.size(),Collections.reverseOrder());
		priorityQ2.addAll(ints);
		priorityQ2.stream().forEach(e->System.out.print("|"+e+"|"));
	}
}