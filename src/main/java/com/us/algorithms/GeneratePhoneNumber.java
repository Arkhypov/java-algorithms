package com.us.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;


public class GeneratePhoneNumber {

	public static void main(String[] args) 
    {     
		//Scanner sc = new Scanner(System.in);
        //String message = sc.nextLine();
        //System.out.println(isBalanced(message));
		checkIterator();
		
		List <String> combinations= getPhoneNumbers("4155230");
		System.out.println(getPhoneNumbers("4155230").size());
		String result = combinations.stream()
			      .map(n -> String.valueOf(n))
			      .collect(Collectors.joining(",", "", ""));
			  
		System.out.println(result);
        //System.out.println(StringUtils.join(getPhoneNumbers("4155230"),","));
    }
	
	public static String isBalanced(String message){
		
		  char[] charArr = message.toCharArray();
	        Stack<Character> stack = new Stack<Character>();
	        
	        boolean isBalanced = true;
	        for (int i=0;i<charArr.length; i++){
	        	
	        	if(charArr[i]=='('){
	        		
	        		if(i>0){
	        			if(charArr[i-1]==':'){
	        				continue;
	        			}	
	        		}	
	        		stack.push(charArr[i]);
	        		continue;
	        		
	        	
	        	}
	        	
	        	if(charArr[i]==')'){
	        		if(i>0){
	        			//special case for (:) messages
	        			if(charArr[i-1]==':'){
	        				if(i>1 && charArr[i-2]=='('){
	        					if(!stack.isEmpty()){
	        		        		stack.pop();
	        		        	}else{
	        		        		isBalanced=false;
	        		            	break;
	        		        	}
	        				}
	        				continue;
	        			}	
	        		}
	        		
	        		if(!stack.isEmpty()){
		        		stack.pop();
		        	}else{
		        		isBalanced=false;
		            	break;
		        	}
	        	}
	        	
	        	
	        	
	        	
	        }
	        if(!stack.isEmpty()){
            	isBalanced=false;
            }
	        
	        if(isBalanced){
	        	return "YES";
	        }
	        return "NO";
		
	}

	public static List<String> getPhoneNumbers(String number){
		
		final HashMap<Character,String> map = new HashMap<Character,String>(){{
	        put('1', "1");
	        put('2',"abc");
	        put('3',"def");
	        put('4',"ghi");
	        put('5',"jkl");
	        put('6',"mno");
	        put('7',"pqrs");
	        put('8',"tuv");
	        put('9',"wxyz");
	        put('0', "0");
	    }} ;
	    
	    List<String> numbers = new ArrayList<String>();
	    List<String> prenumbers = new ArrayList<String>();
	    numbers.add("");
	    
	    for(int i = 0; i < number.length(); i++) {
            String letters = map.get(number.charAt(i));
              
            for(String num: numbers) {
                for(int j = 0; j < letters.length(); j++)
                	prenumbers.add(num + letters.charAt(j));
            }
            numbers = prenumbers;
            prenumbers = new ArrayList<String>();
        }      
	    //Collections.sort(numbers.subList(1, numbers.size()));
	    return numbers;
	}
	
	
	public static void checkIterator(){
		List<String> crunchifyList = new ArrayList<String>();
		 
		// add 4 different values to list
		crunchifyList.add("eBay");
		crunchifyList.add("Paypal");
		crunchifyList.add("Google");
		crunchifyList.add("Yahoo");
		
		Set<String> someset = new HashSet();
		someset.add("Hello");
		someset.add("World");
		Iterator<String> ourIterator = someset.iterator();
		
		Iterator<String> crunchifyIterator = crunchifyList.iterator();
		while (crunchifyIterator.hasNext()) {
			System.out.println(crunchifyIterator.next());
		}
		
	}
	
	public static Set<String> longestWord(String letters, String[] dict) {
	    Set<String> result = new HashSet<String>();
	    Set<String> preResult= new HashSet<String>();
	    //char[]letArr= letters.toCharArray();
	    int max=0;
	    
	    for(int i=0; i<dict.length;i++){
	        String word= dict[i];
	        char c=0;
	        boolean flag=false;
	        char[] wordArr= word.toCharArray();
	        for(int j=0; j<wordArr.length; j++){
	            if(!word.contains(String.valueOf(wordArr[j]))){
	            	if(letters.contains("//?")){
	            		if(flag && c!=wordArr[j]){
	            			break;
	            		}
	            		flag=true;
	            		c=wordArr[j];
	            		continue;
	            	}
	            	break;
	            }
	            if(j==wordArr.length-1){
	              if(word.length()>=max){
	      	        max=word.length();
	      	        preResult.add(word);
	      	      }
	              
	            }
	          }
	    }
	   
	    for(String word: preResult){
	        if(word.length()==max){
	          result.add(word);
	        }
	    }
	    
	    
	    return result;
	  }
	
	
	
}


