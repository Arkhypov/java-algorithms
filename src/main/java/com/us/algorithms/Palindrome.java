package com.us.algorithms;

import org.testng.Assert;

public class Palindrome {

	public static void main(String[] args) {

		/*
		 *  Polidromes are below:
		 *  redivider
		 *	noon
		 *	civic
		 *	radar
		 *	level
		 *	rotor
		 *	kayak
		 *	reviver
		 *	racecar
		 *	redder
		 *	madam
		 *	refer
		 */
		
		Assert.assertTrue(istPalindrom("reviver"));
	}
	public static boolean istPalindrom(String str){
		char[] word = str.replaceAll("\\s+","").toCharArray();
	    int i1 = 0;
	    int i2 = word.length - 1;
	    while (i2 > i1) {
	        if (word[i1] != word[i2]) {
	            return false;
	        }
	        ++i1;
	        --i2;
	    }
	    return true;
	}

}

class MyClass {
	  
    public synchronized void log1(String msg1, String msg2){
       System.out.println(msg1);
       System.out.println(msg2);
    }

  
    public void log2(String msg1, String msg2){
    	
    	System.out.println(msg1);
       synchronized(this){
    	  System.out.println(msg1);
          System.out.println(msg2);
       }
    }
  }
