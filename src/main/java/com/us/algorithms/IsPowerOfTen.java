package com.us.algorithms;

public class IsPowerOfTen {

	public static void main(String args[])
	  {
	  doTestsPass();
	  }

	  /**
	   * bool isPowerOf10(int x)
	   * Returns true if x is a power-of-10. Otherwise returns false.
	   */
	  public static boolean isPowerOf10(int x)
	  {
	    
	    if(x%10==0){
	      
	      int value =new Integer((int) Math.floor(x/10));
	      
	      while(value%10==0){
	        value =new Integer((int) Math.floor(value/10));
	      
	      }
	      if(value==1){
	        return true;
	      }
	      
	      return false;
	    }
	  return false;
	  }


	  /**
	   * bool doTestsPass()
	   * Runs various tests. Returns true if tests pass. Otherwise,
	   * returns false.
	   */
	  public static boolean doTestsPass()
	  {
	  // todo: implement more tests, please
	  // feel free to make testing more elegant
	  int[] isPowerList = {10,1000, 10000};
	  int[] isNotPowerList = {3, 50,130,1300};

	  for(int i : isPowerList)
	  {
	    if(!isPowerOf10(i))
	    {
	    System.out.println("Test failed for: " + i);
	    return false;
	    }
	  }

	  for(int i : isNotPowerList)
	  {
	    if(isPowerOf10(i))
	    {
	    System.out.println("Test failed for: " + i);
	    return false;
	    }
	  }

	  System.out.println("All tested passed");
	  return true;
	  };


	  /**
	   * Execution entry point.
	   */
	  


}
