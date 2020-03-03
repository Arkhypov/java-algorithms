package com.us.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.google.common.collect.ImmutableCollection;

public class AmexTestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("test");
	}
	
	private void showArr(int[] arr){
		for(int e:arr) {
			System.out.println(e);
		}
		Runnable r = () ->{
			System.out.print("blabla");
		};
		r.run();
		CompletableFuture cf =CompletableFuture.completedFuture("value").handle((a,b)->{return a.length();});
		try {
			System.out.println(cf.get());
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Map m = new HashMap();
		Set<?> s = m.entrySet();
		List myList = new ArrayList<>();
		myList.addAll(s);
		
	}
	
}

	class Solution {
	  private final static String sentence= "I am a Person with my first name as Jonathan";
	  public static void main(String[] args) {
	    //System.out.println(getOccurance('z'));
	    int[] tmp =getTheMostOccuredNum(new int[]{10, 10, 40, 10, 22, 19, 7, 1, 99, 46, 31, 40, 19, 6, 18});
	    System.out.println(tmp[0] +"," +tmp[1] );
	    ArrayList<String> strings = new ArrayList<String>();
	    strings.add("Hello, World!");
	    strings.add("Welcome to CoderPad.");
	    //strings.add("This pad is running Java " + Runtime.version().feature());
	  
	    for (String string : strings) {
	      System.out.println(string);
	    }
	  }
	  
	  private static int getOccurance(char input){
	    
	    int count =0;
	    for(int i=0; i<sentence.length(); i++){
	      if(sentence.charAt(i)==input){
	        count++;
	      }
	    }
	  return count;
	  }
	  
	  private static int[] getTheMostOccuredNum(int[] input){
	    Map<Integer, Integer> map = new HashMap<Integer,Integer>();
	    
	    for(int a: input){
	      if(map.containsKey(a)){
	        int count = map.get(a);
	        map.put(a, count+1);
	      }else{
	        map.put(a,1);
	      }
	    }
	    int maxKey =Integer.MIN_VALUE;
	    int max = Integer.MIN_VALUE;
	    //System.out.println(map.size());
	    for(int key : map.keySet()){
	      if(map.get(key)>=max){
	        max=map.get(key);
	        maxKey =key;
	      }
	    }
	    return new int[] {maxKey, max };
	    
	  }
	}
