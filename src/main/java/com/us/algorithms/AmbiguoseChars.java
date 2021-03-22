package com.us.algorithms;
import java.util.HashMap;
import java.util.Map;

public class AmbiguoseChars {

	/*

	true:  "aabc" "xxyz" (left to right is true: a->x, b->y, c->z, and right to left is true: x->a, y->b, z->c, therefore true)
	false: "abc" "xxx" (left to right is fine, right to left is ambiguous (x -> a?b?c?), therefore false)

	"aba" "xyz" (false)

	"abca" "xxyz" (false)
	"aabc" "xxyz" (true)
	"abca" "xyzx" (true)
 	"abab" "xyyx" (false)
	"xxx" "abc"   (false)
	"abc" "xxx"   (false)
	*/
	public static void main(String[] args) {
	        System.out.println("false: " + isAmbiguose("abca", "xxyz"));
	        System.out.println("true:  " + isAmbiguose("aabc", "xxyz"));
	        System.out.println("true:  " + isAmbiguose("abca", "xyzx"));
	        
	        System.out.println("false: " + isAmbiguose("abab", "xyyx"));
	        System.out.println("false: " + isAmbiguose("xxx", "abc"));
	        System.out.println("false: " + isAmbiguose("abc", "xxx"));
	        
	}	     
	public static boolean isAmbiguose(String s1, String s2){
	        Map<Character, Character> map= new HashMap<Character, Character>();
	        
	        for(int i=0; i< s1.length(); i++){
	        if(!map.containsKey(s2.charAt(i))){
	            if(map.containsValue(s1.charAt(i))){
	                return false;
	            }
	            map.put(s2.charAt(i), s1.charAt(i));
	            continue;
	        }
	        char c=map.get(s2.charAt(i));
	        if(c!=s1.charAt(i)) return false;
	        }
	        return true;
	    }
}
