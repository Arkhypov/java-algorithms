package com.us.algorithms;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HackerRankTest extends Test {
	
	   public static String str="Test";
	   public static void main(String[] args) {
		   
		   
		   System.out.println(decode(encode("Test")));
		   //Collection cl = (Collection) new Object();
	    }
	   private static String encode(String text) { 
		   StringBuilder b = new StringBuilder(); 
		   for (int i = 0; i < text.length(); i++) { 
			   char c = text.charAt(i);
			   //System.out.println(c);
			   //System.out.println(c+c+i);
			   b.append(c += c + i);
			   
			   //
		   }
		   //System.out.println(b.toString());
		   return b.reverse().toString(); 
	   }
	   
	   static String decode(String encodedMessage) {
		   
		   StringBuilder b = new StringBuilder(encodedMessage);
		   String s=b.reverse().toString();
		   StringBuilder result = new StringBuilder();
		   for(int i = 0; i < s.length(); i++){
			   char c = s.charAt(i);
			   c+=c-i;
			   
			  result.append(c);
			  System.out.println(c);
		   }
		   return result.toString();

	    }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   public String maxElement(String input){
		   
		           // Read only region end
		   
		           // Write code here...
		   
		           input=input.replaceAll("\\s","");
		   
		           if(input.length()==0){
		   
		                   return "";
		   
		           }
		           char maxOccuredchar='0';
		           int maxTimes=0;
		           char[] chars = input.toCharArray();
		   
		           Map<Character,Integer> charsMap = new HashMap<Character,Integer>();
		           for(int i=0;i<chars.length;i++){

		               if(charsMap.containsKey(chars[i])){		   
		                   int curentOcur=charsMap.get(chars[i]);
		                   charsMap.replace(chars[i],curentOcur,curentOcur+1);
		               } else{
		   
		                   charsMap.put(chars[i],1);
		   
		               }
		   
		           }
		   
		           for(Character Key: charsMap.keySet()){
		   
		               if(charsMap.get(Key)>maxTimes){
		   
		                   maxTimes=charsMap.get(Key);
		                   maxOccuredchar=Key;
		               }
		   
		           }
		   
		           return  String.valueOf(maxOccuredchar);
		 
		           //throw new UnsupportedOperationException("maxElement(String input1)");
		 
		       }
	   
	   static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
		   
		   Arrays.sort(scores);
		   int[] result=new int[lowerLimits.length];
		   for (int i=0; i<lowerLimits.length;i++){
			   int counter=0;
			   int min=lowerLimits[i];
			   int max=upperLimits[i];
			   
			   for(int j=0;j<scores.length;j++){
				   if(scores[j]>max){
					   break;
				   }				   
				   if(scores[j]>=min){
					   counter++;
				   }
				   
			   }
			   
			   
			   result[i]=counter;
		   }
		   
		   
		   return result;
	    }

	   
	   public void printTop2(int[] arr){
			
		   //int[] result = new int[2];
		   int max1=arr[1];
		   int max2=arr[0];
		 	
		   if(arr[0]>arr[1]){
		   max1=arr[0];
		   max2=arr[1];
		   }
		   for (int i=0;i<arr.length;i++){
		   			if(arr[i]>max1){
		         	max2=max1;
		         	max1=arr[i];
		         }else if(arr[i]<max1 && arr[i]>max2){
		         max2=arr[i];
		         }
		   }
		   System.out.println(max1 + max2); //or Arrays.asString();

		 }
	   
	   public void divideStrings(String a, String b){
		  
		   double A=0;
		   double B=0;
		   try{
		   A = Double.valueOf(a);
		   B = Double.valueOf(b);
		   }catch(Exception e){
			   return;
		   }
		   if(B==0){
			   
			   return;
		   }
		  double result= A/B;
		  //if(a instanceOf String.class != null) in
		   
	   }
	   
	   
	   

}

class Dad
{
    protected static String me = "dad";

    public void printMe()
    {
        System.out.println(me);
    }
}

class Son extends Dad{
    protected static String me = "son";
}
class sm{
	public void doIt()
	{
	    new Son().printMe();
	}
	
}

class Test{
	
	public static String str="Woalya";
}


