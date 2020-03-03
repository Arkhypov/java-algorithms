package com.us.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Anagram {
	 public static void main(String[] args) {
		 //System.out.print(isAnogram("I am Lord Voldemort", "Tom Marvolo Riddle"));
		 System.out.print(isAnogram("c0t", "act"));
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
		    
		    for(int i=0;i<charArr1.length;i++){
		    	if(charMap.containsKey(charArr1[i])){
		    		int value=charMap.get(charArr1[i]);
		    		charMap.replace(charArr1[i], value,value+1);
		    		continue;
		    	}
		    	charMap.put(charArr1[i], 1);
		    }
		    for(int i=0;i<charArr2.length;i++){
		    	if(charMap.containsKey(charArr2[i])){
		    		int value=charMap.get(charArr2[i]);
		    		if(value==1){
		    			charMap.remove(charArr2[i]);
		    		}
		    		charMap.replace(charArr2[i], value,value-1);
		    	}else{
		    		return false;
		    	}
		    }
		    if(charMap.isEmpty()){
		    	return true;
		    }
		    return false;
	 }
}