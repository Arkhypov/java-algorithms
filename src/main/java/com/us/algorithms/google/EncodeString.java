package com.us.algorithms.google;

public class EncodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
        System.out.println(EncodeStr("aabbbbbCCCCCCbbb88888888888888zxa6x"));
	}
	public static String EncodeStr(String str){
			
		 StringBuffer result = new StringBuffer();

		 for (int i = 0; i < str.length();) {
			
		 char c = str.charAt(i);
		 int count = 1;
		 
		 for(int j=i+1;j < str.length();){
			 
			 if(str.charAt(j) == c){
				 count++; 
				 j++;
				 continue;
			 }else{
				 break;
			 }
		 }
		 i+=count;
		 if(count>3){
			 result.append(count+"x"+c);
			 count=0;
			
		 }else{
			 while(count>0){
			 result.append(c);
			 count--;
			 }
		 }
		 }
		 return result.toString();
	}
}
	
		
		
		
		
		
		
		
		
		
		/*
		if(str.length()<4){
		return str;
		}
		    char[] strArr=str.toCharArray();
		    int count=0;
		    StringBuilder result = new StringBuilder("");
		    String temp="";
		  
		    for(int i=0;i<strArr.length;i++){
		        	
		    	for(int j=i+1;j<strArr.length;j++){
			        if(strArr[i]==strArr[j]){
			        	temp=temp+strArr[i];
			        	count++;
			            System.out.println(count);
			            continue;
			        }else{
			        	if(count>0 && count<3){
			        		result.append(temp);
			        		i=j;
			        		break;
			        	}
			        	result.append(count+"x"+strArr[i]);
			        	i=j;
			        	break;
			        }
		    	}
		    }
		return result.toString();
*/		

