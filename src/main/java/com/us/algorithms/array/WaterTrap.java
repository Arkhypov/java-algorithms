package com.us.algorithms.array;

public class WaterTrap {

	/* Problem Name is &&& Snowpack &&& PLEASE DO NOT REMOVE THIS LINE. */

	/*
	** Instructions to candidate.
	**  1) Given an array of non-negative integers representing the elevations
	**     from the vertical cross section of a range of hills, determine how
	**     many units of snow could be captured between the hills. 
	**
	**     See the example array and elevation map below.
	**                                 ___
	**             ___                |   |        ___
	**            |   |        ___    |   |___    |   |
	**         ___|   |    ___|   |   |   |   |   |   |
	**     ___|___|___|___|___|___|___|___|___|___|___|___
	**     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
	**                                 ___
	**             ___                |   |        ___
	**            |   | *   *  _*_  * |   |_*_  * |   |
	**         ___|   | *  _*_|   | * |   |   | * |   |
	**     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
	**     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
	**
	**     Solution: In this example 13 units of snow (*) could be captured.
	**  
	**  2) Consider adding some additional tests in doTestsPass().
	**  3) Implement computeSnowpack() correctly.
	*/
	  public static Integer computeSnowpack(Integer[] arr){
		  int maxSeenSoFar = 0;//helper variable to formulate max height to the right array
	      int[] maxSeenRight = new int[arr.length];//array that contains max height seen to the right                                         of tower i
	      int rainWater = 0;//variable to store total units of rain water.
	      
	      //**traversing from Right to Left
	      for (int i = arr.length - 1; i >= 0; i--) {
	             if (arr[i] > maxSeenSoFar) {//if curr height is greater than maxSeenSoFar
	               maxSeenSoFar = arr[i];//then update maxSeenSoFar with curr height
	               maxSeenRight[i] = maxSeenSoFar;//and enter that maxSeenSoFar in maxSeenRight array
	           } else {//otherwise update maxSeenSoFar into maxSeenRight                             array
	               maxSeenRight[i] = maxSeenSoFar;
	           }
	         }
	      
	      int maxSeenLeft = 0;//optimized to have a variable that contains max height of a tower traversing from the left.
	      //**traversing from Left to Right
	      for (int i = 0; i < arr.length; i++) { 
	    	  	  
	    	  	  //0 to take care of case where there is no taller tower to its left & right
	              rainWater += Integer.max((Integer.min(maxSeenLeft, maxSeenRight[i]) - arr[i]), 0);
	             
	              if (arr[i] > maxSeenLeft) {//if curr height > maxSeenLeft
	                  maxSeenLeft = arr[i];//update maxSeenLeft with curr height.
	              }
	              
	          }
		  return rainWater;
	  }

	  /*
	  **  Returns true if the tests pass. Otherwise, returns false;
	  */
	  public static boolean doTestsPass(){
		boolean result = true;
	  	result &= computeSnowpack(new Integer[]{0,1,3,0,1,2,0,4,2,0,3,0}) == 13;
	  
	  	return result;
	  }
	  /*
	   **  Execution entry point.
	   */
	  public static void main(String[] args){
		if(doTestsPass()){
		  System.out.println("All tests pass");
		}else{
		  System.out.println("Tests fail.");
		}
	  }	  
}


