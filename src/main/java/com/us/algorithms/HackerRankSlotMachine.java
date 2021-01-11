package com.us.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackerRankSlotMachine {

	public static void main(String[] args) {
		System.out.println(slotWheels(Arrays.asList("712","246","365","312")));
	}
	
	public static int slotWheels(List<String> history) {
		int result=0;
		List<String> list = new ArrayList<String>();
		for(String s:history){
			char [] nums=s.toCharArray();
			Arrays.sort(nums);
			list.add(String.valueOf(nums));
		}
		int max=Integer.MIN_VALUE;
		while(!list.isEmpty()){
			for(int i=0; i< list.size(); i++){
				String value=list.get(i);
				int current=value.charAt(value.length()-1)-'0';
				if(current>max) max=current;
				if(value.length()==1){
					list.remove(i);
					}else{
						list.set(i,value.substring(0, value.length()-1));
				}
				if(i==list.size()-1 && value.length()!=1){ result+=max; max=Integer.MIN_VALUE;}
			}
		}
		return result+max;
	}
}
