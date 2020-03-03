package com.us.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortPrimeOrdersAmazon {

/*	Input
	The input to the function/method consists of two arguments: 
	numOrders, an integer representing the number of orders. 
	orderList, a list of strings representing all of the orders.

	Output
	Return a list of strings representing the correctly prioritized orders.

	Note
	The order identifier consists of only lower case English character and numbers.

	Examples
	Input:
	numOrders = 6
	orderList =
	[zld 93 12]
	[fp kindle book]
	[10a echo show]
	[17g 12 25 6]
	[ab1 kindle book]
	[125 echo dot second generation]

	Output:
	[125 echo dot second generation]
	[10a echo show]
	[ab1 kindle book]
	[fp kindle book]
	[zld 93 12]
	[17g 12 25 6]

	Explanation:
	There are four Prime orders (lines with words) in this order list. Because “echo” comes before “kindle”, those lines should come first, with “dot” coming before “show”. Because two lines have the metadata “kindle book”, their tie should be broken by the identifier, where “ab1” comes before “fp”. Finally, the non-Prime numeric orders should come last, in the original order, they were in the input.*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(prioritizedOrders(6, new ArrayList<String>(){{
			add("zld 93 12");
			add("fp kindle book");
			add("10a echo show");
			add("17g 12 25 6");
			add("ab1 kindle book");
			add("125 echo dot second generation");
			}}));
		}

	
	/*public String reverse(String inputStr) throws InvalidInputStringException {

	    if(inputStr==null || inputStr.length()<2){
	        throw new InvalidInputStringException ("Input string is not correct");
	    }
	    
	    StringBuffer strB= new StringBuffer(inputStr);
	    
	    return strB.reverse().toString();

	}*/
	
	public static List<String> prioritizedOrders(int numOrders, List<String> orderList) 
	{
		List<String> sortedOrders = new ArrayList<String>();
		List<String> notPrimeOrders = new ArrayList<String>();
		for(String order : orderList){
			String[] orderCred = order.split(" ");
			//here I am assuming that prime orders should not contain numeric integers delimeted by space
			if(orderCred[1].matches("[0-9]+")){
				notPrimeOrders.add(order);
			}else{
				sortedOrders.add(order);
			}
		}
		sortedOrders.sort(new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				String tempStr1=str1.substring(str1.indexOf(" ")+1, str1.length());
				String tempStr2=str2.substring(str2.indexOf(" ")+1, str2.length());
				if(tempStr1.equals(tempStr2)){
					return str1.compareTo(str2);
				}
				//System.out.println(str1);
				//System.out.println(str2);
				return tempStr1.compareTo(tempStr2);
			}
		});
		sortedOrders.addAll(notPrimeOrders);
		return sortedOrders;
		// WRITE YOUR CODE HERE
	}

}

