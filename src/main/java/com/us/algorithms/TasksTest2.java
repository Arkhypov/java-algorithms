package com.us.algorithms;



import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class TasksTest2 {
	
	Map<String, Integer> globMap = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		//outPutCharOcur("Hello");
		System.out.println(reverseString("Hello World"));
		System.out.println(findFirst("rerverse"));
        
	}
	
	public static char findFirst(String input)
	  {
	    // TODO: Implement solution
	    char result = 0;
	    char[] ch = input.toCharArray();
	    Set<Character> chWeHave = new HashSet<Character>();
	
	    for (int i=0;i<ch.length;i++){
	    	System.out.println("i="+i);
	    	if(!chWeHave.contains(ch[i])){
		        chWeHave.add(ch[i]);
		        for (int j=i+1;j<ch.length;j++){
		        	System.out.println("j="+j);
		    		
		        	if(ch[i]==ch[j]){
		            	result=0;
		              break;            
		            } else if(result==0){
		            	result=ch[i];
		            }
		            if(ch[i]!=ch[j] && j==ch.length-1){
		            	System.out.println("Hello");
		            	return result;
		            }
		         }
	    	}
	     }
	 
	    //solution #2
/*	    
	    Map<Character, Integer> map = new HashMap<Character, Integer>();
	    for(int i=0;i<ch.length-1;i++){
	    	
	    	if(map.containsKey(ch[i])){
	    		map.replace(ch[i], map.get(ch[i]), map.get(ch[i])+1);
	    	}else{
	    		map.put(ch[i], 1);
	    	}
	    }
	    for (Character k : map.keySet()){
	    	if(map.get(k)==1){
	    		return k;
	    	}
	    }
*/	    
	    return result;
	  }
	
	public static void outPutCharOcur(String input){
		
		Map <Character, Integer> map =new HashMap <Character, Integer>();
		//int ocur=0;
		char[] chars = input.toCharArray();
		for (int i=0; i<chars.length; i++){
			
			if(!map.containsKey(chars[i])){
				
				map.put(chars[i], 1);
			} else{
				
				int ocur = map.get(chars[i]);
				map.replace(chars[i], ocur+1);
			}
	
		}
		for (Character key: map.keySet()){
			
			System.out.println(key+" : "+map.get(key));
		}
		
		
	}
	
	public static String reverseString(String input){
		
		String result="";
		char[] chars = input.toCharArray();
		
		for (int i=input.length()-1;i>=0;i--){
			 
			result+=chars[i];
			
		}
		
		
		return result;
		
		
		
		
	}

	public void appendMap (String line, HashMap<String, Integer> map){
		
		String[] words= line.split(" ");
		
		StringBuffer b= new StringBuffer("");
		for (int i=0; i< words.length; i++){
			if (map.containsKey(words[i])){
				
				int value = map.get(words[i]);
				map.replace(words[i], value+1);
				
			}else{
				
				map.put(words[i], 1);
				
			}
		}
		//for (String key:)
		//return (HashMap<String, Integer>) globMap; 
		
	}
	
	
	
static int reductionArray(int[] num) {
		   
		   Arrays.sort(num);
		   int cost = 0;
		   LinkedList<Integer> ll = new LinkedList<Integer>();
		   for (int i : num)
		   {
			   ll.add(i);
		   }
		   
		   for(int i=0; i<ll.size()-1; ) {
			   int el=ll.get(i)+ll.get(i+1);
			   ll.set(i+1, el);
			   cost=cost+el;
			   ll.remove(i);
			   Collections.sort(ll);
		   }
		return cost;
		   
		      /*  
	        Arrays.sort(num);
			   int cost = 0;
			   for(int i=0; i<num.length-1; i++) {
				   num[i+1] = num[i] + num[i+1];
				   cost = cost + num[i+1];
			   }
			return cost;
	*/

	}
}


