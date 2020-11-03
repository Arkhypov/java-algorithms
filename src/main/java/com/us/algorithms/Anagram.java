package com.us.algorithms;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
	 public static void main(String[] args) {
		 //System.out.print(isAnogram("I am Lord Voldemort", "Tom Marvolo Riddle"));
		 System.out.print(isAnogram("cat", "act"));
	 }

	 public static boolean isAnogram(String str1, String str2){
		    str1=str1.toLowerCase().replace(" ","");
		    str2=str2.toLowerCase().replace(" ","");
		    if(str1.length()!=str2.length()){
		        return false;
		    }
		    char[] charArr1 = str1.toCharArray();
		    char[] charArr2 = str2.toCharArray();
		    Map<Character,Integer> charMap = new HashMap<Character,Integer>();
		    Integer k = new Integer(4);
		    
		    for(int i=0;i<charArr1.length;i++){
		    	int value=charMap.getOrDefault(charArr1[i], 0);
		    	charMap.put(charArr1[i], ++value);
		    }
		    for(int i=0;i<charArr2.length;i++){
		    	int value=charMap.getOrDefault(charArr2[i], 0);
		    	if(value==0) return false;
		    	if(value==1) charMap.remove(charArr2[i]);
		    	charMap.replace(charArr2[i], --value);
		    }
		    if(charMap.isEmpty()){
		    	return true;
		    }
		    return false;
	 }
}