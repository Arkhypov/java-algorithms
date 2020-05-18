package com.us.algorithms.array;

public class HackerRankStockPicker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxDifference(new int[]{100,101,99,94,80,99,100,101,103,102,81,85,84,95,100,105,75,100,104,70,75,90}));
	}
	static String maxDifference(int [] data){
		 
		 int buyDay=Integer.MIN_VALUE;
		 int sellPrice=0;
		 int sellDay=0;
		 int buyPrice=0;
		 
		 //int buyPrice=0;
		 
		 int profit = data[1] - data[0];
		 int min_element= data[0];
		 
		 for (int i=0; i<data.length; i++){
			 
			 if(data[i]<min_element){
				 min_element=data[i];
				 //buyDay=i+1;
			 }
			 if(data[i] - min_element>profit){
				 profit=data[i] - min_element;
				 buyPrice=min_element;
				 sellDay=i+1;
				 sellPrice=data[i];
			 }
			 
		 }
		 
		 for(int i=0;i<data.length; i++){
			 
			 if(data[i]==buyPrice &&(i+1)<sellDay){
				 buyDay=i+1; 
			 }
			 
		 }
		 
		 return String.valueOf(buyPrice)+" "+String.valueOf(buyDay)+" "+String.valueOf(sellPrice)+" "+
				 String.valueOf(sellDay)+" "+String.valueOf(profit);
	 }
}
