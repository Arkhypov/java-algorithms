package com.us.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class EncodeTheMessage {

	public static void main(String[] args) {
		//System.out.println(decode(encode("false")));
		String[][] logs1 = new String[][] {
	        { "58523", "user_1", "resource_1" },
	        { "62314", "user_2", "resource_2" },
	        { "54001", "user_1", "resource_3" },
	        { "200", "user_6", "resource_5" },
	        { "215", "user_6", "resource_4" },
	        { "54060", "user_2", "resource_3" },
	        { "53760", "user_3", "resource_3" },
	        { "58522", "user_22", "resource_1" },
	        { "53651", "user_5", "resource_3" },
	        { "2", "user_6", "resource_1" },
	        { "100", "user_6", "resource_6" },
	        { "400", "user_7", "resource_2" },
	        { "100", "user_8", "resource_6" },
	        {"54359", "user_1", "resource_3"},
	    };
		Map<String, TreeSet<Integer>> map =getUserTimestamp(logs1);
	    
	    for(String key: map.keySet()){
	      System.out.println(key +": ");
	      map.get(key).forEach(System.out::print);
	    }
	}
	
	private static String encode(String text) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            b.append(c += c + i);
        }
        return b.reverse().toString();
    }
	
	private static String decode(String encodedMessage) {
        //reversing
        StringBuilder b = new StringBuilder(encodedMessage);
        String text = b.reverse().toString();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<text.length(); i++ ){
            char c = text.charAt(i);
            c -= i;
            c /= 2;
            result.append(c);
        }
        return result.toString();
    }
	private static Map<String, ArrayList<Integer>> getUserTimestamp(String[][] logs){
	    Map<String, TreeSet<Integer>> map = new HashMap<String, TreeSet<Integer>>();
      Map<String, ArrayList<Integer>> result = new HashMap<String, ArrayList<Integer>>();
	    for(int i=0; i< logs.length; i++){
	    	TreeSet<Integer> times=map.getOrDefault(logs[i][1], new TreeSet<Integer>());
	      //if(times.size()<2){
	      times.add(Integer.valueOf(logs[i][0]));
	      //}else{
	        if(times.size()>2){
	          Iterator<Integer> it =	times.iterator();
	          it.next();//first value
	          times.remove(it.next());
	        }
	        map.put(logs[i][1], times);
	      }
      for(String key: map.keySet()){
        ArrayList<Integer> t= new ArrayList<Integer>();
        t.addAll(map.get(key));
        if(t.size()==1){
          t.add(t.get(0));
        }
        result.put(key,t);
    }
	    return result;
	}
	    
	  }
	
}
