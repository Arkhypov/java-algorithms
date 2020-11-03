package com.us.algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javafx.util.Pair;

public class CustomSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(movesss(Arrays.asList(13,10,21,20)));
	}
	
	public static int moves(List<Integer> arr) {
	   int n = arr.size();
	   // Initialize result 
       int result = 0; 
	   ArrayList <Pair <Integer, Integer> > arrpos = 
	                  new ArrayList <Pair <Integer, Integer> > (); 
	   for (int i = 0; i < n; i++) 
	             arrpos.add(new Pair <Integer, Integer> (arr.get(i), i)); 
	   
	   arrpos.sort(new Comparator<Pair<Integer, Integer>>() 
	        { 
	            @Override
	            public int compare(Pair<Integer, Integer> o1, 
	                               Pair<Integer, Integer> o2) 
	            { 
	                if (o1.getKey() % 2==0 && o2.getKey() % 2==0) 
	                    return 0; 
	                if (o1.getKey() % 2==0  || o1.getKey() % 2==0) 
	                    return -1; 
	                else
	                    return 1; 
	            } 
	        }); 
	  
	        Boolean[] vis = new Boolean[n]; 
	        Arrays.fill(vis, false); 
	  
	        for (int i = 0; i < n; i++) 
	        { 
	       
	            if (vis[i] || arrpos.get(i).getValue() == i) 
	                continue; 
	  
	            int cycle_size = 0; 
	            int j = i; 
	            while (!vis[j]) 
	            { 
	                vis[j] = true;
	                j = arrpos.get(j).getValue(); 
	                cycle_size++; 
	            } 
	            if(cycle_size > 0) 
	            { 
	            	result += (cycle_size - 1); 
	            } 
	        } 
	  
	        // Return result 
	        return result; 
	    }
	public static int movess(List<Integer> arr){
		int count = 0;
		for(int i = 0; i<arr.size(); i++){
			
			if(arr.get(i) %2 != 0 && arr.get(i+1) %2 == 0){
				count++;
			}
		}
		return count;
	}
	
	public static int movesss(List<Integer> list){
		int[] arr=list.stream().mapToInt(i->i).toArray();
		int result = 0;
		int totalLength = arr.length;
		for (int i = 0; i < totalLength / 2; i++) {
			if (arr[i] % 2 != 0) {
				for (int j = totalLength / 2; j < totalLength; j++) {
					if (arr[j] % 2 == 0) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						result++;
						break;
					} else {
						continue;
					}
				}
			} else {
				continue;
			}
		}
		return result;
	}

}
