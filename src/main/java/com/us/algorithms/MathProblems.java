package com.us.algorithms;

import java.util.HashMap;
import java.util.Map;

public class MathProblems {
	 public static String solution(String S, int K) {
		Map<String, Integer> daysMap = new HashMap<String, Integer>(){{
			put("Mon",1);
			put("Tue",2);
			put("Wed",3);
			put("Thu",4);
			put("Fri",5);
			put("Sat",6);
			put("Sun",7);
		}};
		
		
		int currentDay =daysMap.get(S);
		K+=currentDay;
		if(K>7){
			K=K%7;
			//System.out.println(K);
		}
		//int expectedDay=K+currentDay;
		for(String key: daysMap.keySet()){
			if(daysMap.get(key)==K){
				return key;
			}
		}
		 return "-1";
	        // write your code in Java SE 8
	    }
	/* public static int getCurrentDay(String num){
		 
	 }*/
	 
	 public static void main(String[] args) throws Exception {
		 //System.out.println(solution("Sat",23));
		 System.out.println(solution2(-999));
		}
	 
	 public static int solution2(int N) {
		 if(N==0){
			 return 50;
		 }else if(N>0){
			 return getBiggestValue(N, true);
		 }
		return getBiggestValue(N, false);
	        // write your code in Java SE 8
	    }
	 public static int getBiggestValue(int N, boolean isPositive){
		 String strN=isPositive? String.valueOf(N):String.valueOf(Math.abs(N));
		 int index=0;
		 for(int i=0;i<strN.length();i++){
			 char s =strN.charAt(i);
			 int tmp = Integer.parseInt(String.valueOf(strN.charAt(i)));
			 if(tmp<5 && isPositive){
				 index=i;
				 break;
			 }else if(tmp>5 && !isPositive){
				 index=i;
				 break;
			 }
		 }
		 String tmpS1 = strN.substring(0,index);
		 String tmpS2 = strN.substring(index,strN.length());
		 String resultS = tmpS1+"5"+tmpS2;
		 int result = isPositive ? Integer.parseInt(resultS):Integer.parseInt(resultS)*-1;
		 return result;
	 }
}
