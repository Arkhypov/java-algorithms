package com.us.algorithms;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.management.RuntimeErrorException;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;



public class tasksTest {

	@Test
	public void test() {
		//int[] B = {1,2,5,7,2,3,5};
		//int[] test={1,2,3,4,4,5,6,7,9,10,11,12};
		System.out.println(isSubstring("waterbottle", "elttob"));
		System.out.println(isSubstring("waterbottle", "elttobee"));
		System.out.println("=======================");
		System.out.println(parseString("Some31203-12:{#()@() text"));
		System.out.println("=======================");
		System.out.println(findPositions("b"));
		System.out.println("=======================");
		//function #1
		//System.out.println(parseString("work #@#$ bike bannana fun, perl, ##!()**ruby, function"));
		//function #2 - return unique values
		//System.out.println(parseUniqueValues("perl,python,ruby,java,go,erlang,perl,python,java,java"));
		//System.out.println(findWrongElements(test));
		//System.out.println(Solution.solution(5, B));
		//function #6 - return unique values
		//String s = "Prrrmogrrammming";
		//findDublicatedValues(s);
		//System.out.println(findPositions("ab"));
		//System.out.println(findStringOcurance(s,'m'));
		//System.out.println(Arrays.toString(removeDublicate(Arrays.asList("xyz", "abc", "xyz", "abc", "xyz")).toArray()));
		
		System.out.println(countDuplicatess(new int[]{1,3,1,3,3,6,3,2}));
		System.out.println("=======================");
		System.out.println(Arrays.toString(checkBraces(new String[] {"[]{}()","[({})]","{}[()]","][{}((","][}}(("})));
		
		//s= new String ("056");
		//int value = Integer.valueOf(s);
		
		//System.out.println(value);
		
	}
	
	//function #1 first implementation
	public String returnWord(String input){
		List <String> restrictedPatterns = (List<String>) Arrays.asList("#","@","$","!","(",")","*","^");
		for(String i:restrictedPatterns){
				input = input.replace(i, "");
		}
		return input;
	}
	
	//function #1 second implementation
	public static String parseString(String input){
		ArrayList<String> inputList=new ArrayList<String>();
		
		int index =0;
		while (index<input.length()){
			inputList.add(input.substring(index, Math.min(input.length(), index + 1)));
			index+=1;
		}
				
			for (String i:inputList){
				
				if(!i.matches("[a-zA-Z ]")){
					input = input.replace(i, "");
					
			}
			}
			
		return input;
	}	
	
	//function #2 - return unique values
	public ArrayList<String> parseUniqueValues(String input){
		
		ArrayList result = new ArrayList<String>();
		String[] inputList = input.split(",");
		Map<String, Integer> items = new HashMap<String, Integer>(); 
		for (int i = 0; i<inputList.length; i++){
			if (!items.containsKey(inputList[i])){
			items.put(inputList[i], 1);
			} else {
				
				int oldvalue=(int) items.get(inputList[i]);
				
				items.replace(inputList[i], items.get(inputList[i]), oldvalue+1);
			}
		}
		for (String key:items.keySet()){
			result.add(key+":"+items.get(key)); 
			
		}
		System.out.println(result.size());
		return result;
		
	}
	
	
	
	/* 
	 * function #3 - write class to test api end points:
	 *  api/users - [{"user_id":1, "user_name":"Luis"},{"user_id":2, "user_name":"mike"}]
	 * 	api/users/1 - [{"user_id":1, "user_name":"Luis"},{"user_id":2, "user_name":"mike"}]
	 */
	
	// function #4 - write function to get max value in array
	
	public int getMax(List <Integer> arr){
		int result= arr.get(0);
		for (int i=0; i<arr.size();i++){
			if (arr.get(i)>result){
				result=arr.get(i);
			}
		}
		
		return result;
		
	}
	
	//function #5 to output wrong elements in array in the way described below:
	/**
	[1,2,3,4,4,5,6,7,9,10,11,12]
			 * 4,8 - output, duplicates and wrong index
	*/
	 public static List findWrongElements(int[] someList){
		    List <Integer> result = new <Integer> ArrayList();
		    for (int i=1; i<someList.length; i++){
		         if(someList[i]!=someList[i-1]+1){
		            result.add(i);
		          }
		    }
			return result;
		    }
	 
	//function #6 look up in String for Sting pattern and output found positions as array:
	/**
		*	"abcfabretyab" - our String
		* 	"ab" - string-pattern we are looking for
	*/
	public List findPositions(String pattern){
		
		String string="abcfabretyab";
		List <Integer> result = new <Integer> ArrayList();
		
		int index =0;
		while (index<string.length()){
			
			if (string.indexOf(pattern, index)!=-1){
				
				result.add(string.indexOf(pattern, index));
				
				if (index!=0){
					index=string.indexOf(pattern, index);
					System.out.println("Now index: "+index);
				}
				
			} else{
				
				System.out.println(index);
				System.out.println(string.indexOf(pattern, index));
			}
			index++;
		
		}
			    
		return result;
	}
	
	//method #7 look up in String for duplicated values,  print them and their count
	/*
	 *  "Programming"
	 *  r: 2
	 *  g: 2
	 *  m: 2
	 */
	
	public void findDublicatedValues(String s){
		
		HashMap<Character, Integer> dublicates = new HashMap<Character, Integer>();
		for (int i=0; i<s.length(); i++){
			 
			if(dublicates.containsKey(s.charAt(i))){
				
				continue;
				
			}
			for (int j=i+1; j<s.length(); j++){
					
				if (s.charAt(i)==s.charAt(j)){
						
					if(!dublicates.containsKey(s.charAt(j))){
						
						dublicates.put(s.charAt(j), 2);
					
					} else {
						
						dublicates.put(s.charAt(j), dublicates.get(s.charAt(j))+1);
						
					}
				
				}
	
			}
		}

			for (Character item : dublicates.keySet()){
				
				System.out.println(item + ": "+dublicates.get(item));
				
			}
			
		
	}
	
	//method #8 find Occurrence in the String and output count of this occurrence
		/*
		 *  "Java"
		 *  output: 2
		 */
	public Integer findStringOcurance (String str, char ch){
		
		int count = 0;
		for (int i=0; i<str.length(); i++){
		
			if (str.charAt(i)==ch){
				
				count++;
			}
		
		}
		return count;
	}
	
	public static int countDuplicates(int[] numbers) {
		
		int count =0;
		Map<String, Integer> nums = new HashMap<String, Integer>();
		for (int i=0; i<numbers.length; i++){
            String key =String.valueOf(numbers[i]);
            if(nums.containsKey(key)){
                
                int value=nums.get(key);
                nums.replace(key, value+1);
            }else{
            	nums.put(key, 1);	
            }
		}
        for (String key: nums.keySet()){
                
                if (nums.get(key)>1){
                    count++;
                    continue;
                }
                
            }
            return count;
	
	
	}
	//method #9 remove duplicates from given list
			/*
			 *  "xyz", "abc", "xyz", "abc", "xyz"
			 *  "xyz", "abc"
			 */
	public static ArrayList<String> removeDublicate (List<String> data){
			
			ArrayList <String> result= new ArrayList<String>();
			data.stream().forEach(e -> System.out.println(e));
			//System.out.println(data.stream().sorted(s->"a"));
			
			for (String str:data){
				
				if (!result.contains(str)){
					result.add(str);
				}
			}
			
			
			
			return result;
	}
	
	//method #9 method to count duplicates in array
	/*
	 *  
	 *  "xyz", "abc"
	 */
	public static int countDuplicatess(int[] numbers) {
	    
	    int countDub=0;
	    Set foundNum= new HashSet<Integer>();
	    
	    for (int i=0; i<numbers.length;i++){
	       
	    	
	    	if(foundNum.contains(numbers[i])){
	    		
	    		continue;
	    
	    	}
	    	
	       for (int j=i+1; j<numbers.length;j++){
	           
	           if (numbers[i]==numbers[j]){
	               
	               countDub+=1;
	               foundNum.add(numbers[i]);
	               break;
	           }
	           
	       }    
	    }
	    
	    return countDub;

	}
	
static int countDuplicatesss(int[] numbers) {
        
		if(numbers.length==0||numbers.length>1000){
			throw new RuntimeException("Array is too long");
    	}
        int count=0;
        Set<Integer> dublicates = new HashSet<Integer>();
        
           for (int i=0; i<numbers.length; i++){
               
        	   
        	   if(numbers[i]<1||numbers[i]>1000){
                   throw new RuntimeException("Number is too long");
        	   }
               if(dublicates.contains(numbers[i])){
                   
                   continue;
               }
               for (int j=i+1; j<numbers.length; j++){
                   
                   
                   if (numbers[i]==numbers[j]){
                       count++;
                       dublicates.add(numbers[i]);
                       continue;
                   }
                   
               }
               
               
           }
        return count;

    }
	//method #10 Method to find biggest occurrence of character in String 
			/*	
			 *  i/p: "Hello! How are you? How is everything?" (case not sensitive)
			 *  o/p: (h, 3)
			 */
		public static String findCharOccurance(String input) {
	    
		    
		    input=input.replaceAll("\\s","").toLowerCase();
		    System.out.println(input);
		    if (input.length()==0){
		    	
		    	throw new RuntimeException("Input string probably empty or with spaces");
		    }
		    char[] chararray=input.toCharArray();
		    Map<Integer, Character> chars= new HashMap<Integer, Character>();
		    
		    for (int i=0; i<chararray.length;i++){
		       
		    	int occurance=1;
		    	
		    	if(chars.containsValue(chararray[i])){
		    		
		    		continue;
		    
		    	}
		    	
		       for (int j=i+1; j<chararray.length;j++){
		           
		           if (chararray[i]==chararray[j]){
		               
		        	   occurance++;
		               
		           }
		           if (j==chararray.length-1){
		        	   
		        	   chars.put(occurance, chararray[j]);
		        		   
		           }   
		       }
		       
		    }
		    
		    int maxKey=1;
		    for (int Key:chars.keySet()){
		    	
		    	if(Key>maxKey){
		    		maxKey=Key;
		    	}
		    	System.out.println(chars.get(Key)+","+Key);
		    }
		    if (maxKey==1){
		    	
		    	System.out.println("There is no same characters in given string");
		    	return new String("");
		    }
		     
			return new String(chars.get(maxKey)+","+maxKey);
	}
	
	//method #11 multiply elements in array and put result on position of element
	/*	
	 *  i/p: [2,4,3,5]
	 *  o/p: [60,30,40,24]
	 *  60 = 4 * 3 * 5
	 */
	
			public int[] changeArray(int[] input){
			    int[] result=new int[input.length];
			    for (int i=0;i<input.length;i++){
			        
			        int tmp=0;
			        for (int j=0;j<input.length;j++){
			            if (j==i){
			                continue;
			            }
			            tmp*=input[j];
			            
			        }
			        result[i]=tmp;
			    }
			        
			    return result;
			       
			}
		//method #12 multiply elements in array and put result on position of element
			/*	
			 *  i/p: [2,4,3,5]
			 *  o/p: [60,30,40,24]
			 *  60 = 4 * 3 * 5
			 */
		public static int find2ndMaxNumber(int[]input){
			    
				int max;
				int result;
			    if(input.length==0){
			        return 0; 
			    }else if(input.length==1){
			        return input[1];
			    } 
			    if(input[input.length-1]>input[input.length-2]){
			    	max=input[input.length-1];
				    result=input[input.length-2];
			    } else {
			    	max=input[input.length-2];
				    result=input[input.length-1];
			    }
			    
			    for (int i=0; i<input.length; i++){
			         if(input[i]>max){
			             result=max;
			             max=input[i];
			             
			         }
			    }
			    System.gc();
			    return result;

		}	
		//method #14 check braces in String array
		/*	
		 *  i/p: {"[]{}()","[({})]","{}[()]","][{}((","][}}(("})
		 *  o/p: [Yes, Yes, Yes, No, No]
		 */
		public static String[] checkBraces(String[] values) {

		        String[] result = new String[values.length];
		        
		        for (int i=0;i<values.length;i++){
		        	
		        	System.out.println(values[i]);
		        	if(values[i].matches(".*\\{.*\\}.*") && values[i].matches(".*\\[.*\\].*") 
		        			&& values[i].matches(".*\\(.*\\).*")){
		        		
		        		result[i]= new String("Yes");
		        		
		        	} else{
		        		
		        		result[i]=new String("No");
		        	
		        	}
		        }
				return result;
		}
		
		static String[] Braces(String[] values) {
	        
	        String[] result = new String[values.length];
	        
	        for (int i=0; i<values.length;i++){
	            
	            if(values[i].matches(".*\\{.*\\}.*") && values[i].matches(".*\\[.*\\].*") && values[i].matches(".*\\(.*\\).*")){
	                
	                result[i]=new String("Yes");
	            } else {
	                
	                result[i]=new String("No");
	            }
	        }
	        return result;
	        

	    }
		
		public static String removeExtraSpaces(String input){
			
			
			StringBuilder result= new StringBuilder("");
			if(input.contains(" ")){
				
				//char chars[] = input.toCharArray();
				for (int i=0; i<input.length();i++){
					if(!(input.charAt(i)==' '&& input.charAt(i+1)==' ')){
						
						result.append(input.charAt(i));
						
					}
				}
				
				return result.toString();
				
				
			}
			return input;
			
		}
		
		//method #15 check braces in String array
		/*
		Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
				Output:  True  //There is a subset (4, 5) with sum 9.
				1 3 6 7 10
				9
				1 2 3 6 7 10
				2 7
				3 6
		*/
		
		public static void givePairToSum(int[] inputArray, int sum) {
		
			if (inputArray.length<2){
				
				throw new RuntimeErrorException(null, "given array should contains 2 or more integers");
				
			}
			Map<Integer, Integer> result = new HashMap<Integer, Integer>(); 
			for (int i=0; i<inputArray.length;i++){
				
				if(result.containsKey(inputArray[i])){
					continue;
				}
				for (int j=i+1;j<inputArray.length;j++){
					
					if(inputArray[i]+inputArray[j]==sum){
						
						result.put(inputArray[i], inputArray[j]);
						continue;
						
					}
				}
				
			}
			
			for (Integer key: result.keySet()){
				
				System.out.println(key+","+result.get(key));
			}
			//return (HashMap<Integer, Integer>) result;
			
			
		}
	
		//method #16 Method to check if IP address is valid 1-255.0-255.0-255.0-255
		/*	
		 *  i/p: 192.168.0.1
		 *  o/p: true
		 *  i/p: 54.2.2
		 *  o/p: false
		 */
		
		public static boolean parseIP(String IP) {
			
			String pattern = "[0-9]|1[0-9][0-9]|2[0-5][0-5]|[1-9][0-9]";
			String[] digits= new String[IP.split("\\.").length];
			digits=IP.split("\\.");
			if (digits.length==4){
				
				for (int i=0;i<4;i++){ 
					if (digits[i].matches(pattern)){
						
						if(i==3){
							return true;
						}
					} else{
						break;
						
					}
				}
				return false;
			} else {
				
				return false;
			}
		
			
		}
		
		//method #17 Method 
		/**
		 * Given two words as Strings, determine if 
		 * there exists a 1:1 mapping of characters from the first to the second word. No two letters
		 * may map to the same letter, but a letter may map to itself.
		 *
		 * Example:
		 *   given "foo", "app"; returns true
		 *     we can map 'f' -> 'a' and 'o' -> 'p'
		 *
		 *   given "foo", "boa"; returns false
		 *     we can map 'f' -> 'b', 'o' -> 'o', we can't map 'o' -> 'a'
		 *
		 *   given "bar", "foo"; returns false
		 *     we can't map both 'a' and 'r' to 'o'
		 *
		 *   given "turtle", "tletur"; returns true
		 *     we can map 't' -> 't', 'u' -> 'l', 'r' -> 'e', 'l' -> 'u', 'e' ->'r'
		 *
		 *   given "ab", "ca"; returns true
		 *     we can map 'a' -> 'c', 'b' -> 'a'
		 *
		 *   given "ofo", "pop"; returns true
		 *     we can map 'o' -> 'p' and 'f' -> 'o'
		 */
		 
		 public static boolean MapStrings(String str1, String str2){
		     
		     if(str1.length()!=str2.length()){
		         return false;
		     }
		    char[] charArr1=str1.toCharArray();
		    char[] charArr2=str2.toCharArray();
		    Map<Character,Character> ourMap = new HashMap<Character,Character>();
		    
		    for (int i=0;i<charArr1.length;i++){
		        if(!ourMap.containsKey(charArr1[i])){
		            
		            ourMap.put(charArr1[i],charArr2[i]);
		            
		        }else{
		            if(!(ourMap.get(charArr1[i])==charArr2[i])){
		                return false;
		            }
		            
		        }
		        if(i==charArr1.length-1){
		                
		                Set<Character> values= new HashSet<Character>();
		                for (char Key:ourMap.keySet()){
		                    if(values.contains(ourMap.get(Key))){
		                        return false;
		                    }
		                    values.add(ourMap.get(Key));
		                }
		                return true;
		            } 
		    
		    }
		    return false;
		 }
		 
		
				
	
		public static String[] checkBraces2(String[] values){
			
			String[] result = new String[values.length];
			/* 
			*	Solve task using removal brackets
			*
			/*
			
			/*
        	switch(values[i].charAt(0)){
        	
        	case '(' :
        		if (values[i].charAt(1)==')'||values[i].charAt(1)=='[' || values[i].charAt(1)=='{'){
        			
        			
        		} else 
        			
        		//String [] strArr  = values[i].split("(?!^)");
        		break;
        	case '[' :
        		
        		break;
        		
        	case '{' :
        		
        		
        		break;	
        	default :
        		
        		result[i]="NO";
        	}		
        	*/	
        	
        	
        	//if (strArr[i].startsWith("(") || strArr[i].startsWith("(")){
        			
        			
        			
        		//}
        		
        	
        	//} else {
        		
        	//	result[i]="NO";
        	//}
			
			
        	
      
        
			
			/*
        	switch(values[i].charAt(0)){
        	
        	case '(' :
        		if (values[i].charAt(1)==')'||values[i].charAt(1)=='[' || values[i].charAt(1)=='{'){
        			
        			
        		} else 
        			
        		//String [] strArr  = values[i].split("(?!^)");
        		break;
        	case '[' :
        		
        		break;
        		
        	case '{' :
        		
        		
        		break;	
        	default :
        		
        		result[i]="NO";
        	}		
        	*/	
        	
        	
        	//if (strArr[i].startsWith("(") || strArr[i].startsWith("(")){
        			
        			
        			
        		//}
        		
        	
        	//} else {
        		
        	//	result[i]="NO";
        	//}
        	
        //}
		return result;
	}
		        
		        
			
	
	//method #11 find Occurrence in the String and output count of this occurrence
			/*
			 *  "Java"
			 *  output: 2
			 */
	public int[] findGridSize(int n){
	    int result[] = new int[2]; 
				if (Math.sqrt(n) % 1 == 0){
					
					for (int i=0; i<2;i++){
						
						result[i]=(int) Math.sqrt(n);
						
					}
					
					return result;
				}else {
					
				    int x = (int) Math.floor(Math.sqrt(n));
				    int y=x;
				    for (int j=0; j<x;j++){
				        for (int i=1; i<x;i++)
				        if((x-j)*(y+i)==n || (x-j)*(y+i)==n+1 || (x-j)*(y+i)==n+2){
				            	
				            result[0]=x-j;
				            result[1]=y+i;
		                   return result;
		                    		            
				        }else if ((x-j)*(y+i)>n+2){
				            
		                    break;
				        }
				        
				        
				    }
					
				}
				return null;
	    
	    
	    }
	
	/*
		Lets say I have a string "waterbottle" and I want to check if my second string is substring
		of the first "ttlewa"? -> True
	*/
	public boolean isSubstring(String Initstr, String Substr){
		
	    char[] InitArr=Initstr.toLowerCase().replace(" ", "").toCharArray();
	    char[] SubArr=Substr.toLowerCase().replace(" ", "").toCharArray();
	    
	    for(int i=0; i<SubArr.length;){
	        if (Initstr.contains(String.valueOf(SubArr[i]))){
	        
	            for(int j=i; j<InitArr.length; j++){ 
	            	if(InitArr[j]==SubArr[i]){
	            		SubArr=ArrayUtils.removeElement(SubArr, SubArr[i]);
	            		InitArr=ArrayUtils.removeElement(InitArr, InitArr[j]);
	            		break;
	                }
	            	if(InitArr[j]!=SubArr[i] && j==InitArr.length-1){
	            		return false;
	            	}
	            }
	        
	        } else {
	        	System.out.println("Hello");
	            return false;
	        }
	    }
	    return true;
	}

/*
	Find all the numbers whose length to the adjacent number is 1. you can define you own N = 1000
	Eg: 121 
*/

	public static ArrayList<Integer>findAjustendNum(int maxNum){
			List<Integer> result = new ArrayList<Integer>();
			
			int k = 0;
	        for(int i=10; i<=maxNum; i++){
	        	
	        	if(i>=10 && i<100){
	        		
	        		
	                int firstPoint = Math.floorDiv(i, 10);
	                //System.out.println("My firstPoint is "+ i+ " "+ firstPoint);
	                DecimalFormat df = new DecimalFormat("#.#");
	                df.setRoundingMode(RoundingMode.HALF_EVEN);
	                double divRes = (double)i/10 - firstPoint;
	                divRes = Double.parseDouble(df.format(divRes));
	                int secondPoint = (int) (divRes*10);
	                //System.out.println("My secondPoint is "+ i+ " "+ secondPoint);
	                
	                if(secondPoint-firstPoint==1 || firstPoint-secondPoint==1){
	                	System.out.println("======Found number: "+ i);
	                	result.add(i);
	                	k++;
	                	if(k==2){
	                		i=i+8;
	                		k=0;}
	                }
	            }
	        }
	        System.out.println("total elements in array is: "+result.size());
			return (ArrayList<Integer>) result;

	}
	
	
	
	public static void main(String[] args) {
		
        BufferedReader br = null;
        //List someList = new ArrayList(findAjustendNum(99));
        System.out.println("===================");
        System.out.println(countDuplicates(new int[]{8,1,3,1,4,5,6,3,2}));
        System.out.println("===================");
        
        
        //System.out.println(findWrongElements(new int[]{1,2,3,4,4,5,6,7,9,10,11,12}));
       
        //System.out.println(countDuplicatess(new int[]{12,5,4,3,2,4,4,4,444,4,4,4,4}));
        /*
        System.out.println("T: "+MapStrings("foo", "app"));
        System.out.println("F "+MapStrings("foo", "boa"));
        System.out.println("F: "+MapStrings("bar", "foo"));
        System.out.println("T: "+MapStrings("turtle", "tletur"));
        System.out.println("T: "+MapStrings("ab", "ca"));
        System.out.println("T: "+MapStrings("ofo", "pop"));
        */
        
        System.out.println("hello".substring(2,3));
        //System.out.println(Arrays.toString( Braces(new String[] {"[]{}()","[({})]","{}[()]","][{}((","][}}((","{[}]"})));
        
        //System.out.println(findCharOccurance("Input string probably empty or with spaces"));
        //System.out.println(Arrays.toString(removeDublicate(
        //		   Arrays.asList("xyz", "abc", "xyz", "abc", "xyz", "bac", "cab", "dab", "efa")).toArray())); 
        //givePairToSum(new int[] {0, 2, 5, 6, 0, 10}, 9);
		
        //System.out.println("2nd number in array: "+find2ndMaxNumber(new int[]{2,1}));
        
        try {

            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                System.out.print("Enter IP : ");
                String input = br.readLine();
               input.length();
                if ("q".equals(input)) {
                    System.out.println("Exit!");
                    System.exit(0);
                }
               System.out.println(new Integer((int) Math.floor(3/10)));
                
                	System.out.println("result : " + parseIP(input));
                	System.out.println("-----------\n");
                	
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }       

	
	
	
/*	
	class Solution {
	    public int solution(int[] A) {
	        int result= -1;
	        List<Integer> indexes = new ArrayList<Integer>();
	        int tmpl= 0;
	        int tmpr= 0;
	        
	        if (!((A.length==1)&&(A.length==0))){
	        	//for (int P=0; P<=A.length-1; P++)
	            for (int i=0; i<A.length-1; i++){
	            	for(int j=0; j<i; j++){
	                tmpl=+A[j];
	                tmpr=+A[A.length-1-j];
	                }
	            tmpl=+A[i];
	            
	            if (tmpl==tmpr){
	            	indexes.add(i);
	            }
	            }
	            
	            int rnd = new Random().nextInt(indexes.size());
	            result = indexes.get(rnd);
	            }
	        return result;
	    }
*/
	 
	 
	  public static String reverseStr( String str ){

		  if( str.length() <= 1 )
		   return str;

		  int strLength = str.length() - 1;
		  StringBuilder sb = new StringBuilder( strLength );

		  for( int i = strLength/2; --i >= 0;)
		  {
		    sb.append(str.charAt(i));
		    strLength += i;
		  };

		  return sb.toString();
	  };
	  
	  
	    

	

}
