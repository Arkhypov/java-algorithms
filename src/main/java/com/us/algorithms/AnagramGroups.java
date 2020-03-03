package com.us.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnagramGroups {

	public static void main(String[] args) 
    { 
  
        // Driver program 
        Set<String> set = new HashSet<String>(){{ add("cat");add("dog");add("tac");add("god");add("act");}}; 
        Map<String, List<String>> map = getMapOfAnagrams(set);
        printAnagrams(map); 
    } 
	
	private static HashMap<String, List<String>> getMapOfAnagrams(Set<String> strSet){
        HashMap<String, List<String> > map = new HashMap<>(); 
  
        // loop over all words 
        for (String word : strSet) { 
  
            // convert to char array, sort and 
            // then re-convert to string 
            //String word = arr[i]; 
            char[] letters = word.toCharArray(); 
            Arrays.sort(letters); 
            String newWord = new String(letters); 
  
            // calculate hashcode of string 
            // after sorting 
            if (map.containsKey(newWord)) { 
  
                map.get(newWord).add(word); 
            } 
            else { 
  
                // This is the first time we are 
                // adding a word for a specific 
                // hashcode 
                List<String> words = new ArrayList<>(); 
                words.add(word); 
                map.put(newWord, words); 
            } 
        }
        return map;
    }
	private static void printAnagrams(Map<String, List<String>> map){
	     // print all the values where size is > 1 
        // If you want to print non-anagrams, 
        // just print the values having size = 1 
        for (String s : map.keySet()) { 
            List<String> values = map.get(s); 
            if (values.size() > 1) { 
                System.out.print(values); 
            } 
        }
	}
	
	}
