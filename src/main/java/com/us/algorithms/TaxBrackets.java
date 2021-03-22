package com.us.algorithms;

import java.util.LinkedHashMap;
import java.util.Map;

public class TaxBrackets {
	/**
	[
	[5000, 0],
	 [10000, 0.1],
	 [20000, 0.2],
	 [10000, 0.3],
	 [null, 0.4],
	]
	This indicates that:
	  ○ The first $5K is untaxed
	  ○ The next $10K is taxed at 10%
	  ○ The next $20K is taxed at 20%
	  ○ The next $10K is taxed at 30%
	  ○ All income above this is taxed at 40%
	So, for an income of $55K, the tax would be $0K + $1K + $4K + $3K + $4K = $12K.
	*/
	Map<Double, Double> itSlabMap = new LinkedHashMap<>();
	itSlabMap.put(10000d, .3d);
	itSlabMap.put(20000d, .2d);
	itSlabMap.put(30000d, .1d);
	itSlabMap.put(9999999d, .1d);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	static double calculateTax2(Map<Double, Double> itSlabMap, double income) {
	        double tax = 0d;

	        for (Map.Entry<Double, Double> entry : itSlabMap.entrySet()) {
	            if (income >= entry.getKey()) {
	                tax += entry.getValue() * entry.getKey();
	                income -= entry.getKey();
	            } 
	            // final residual of tax on highest slab
	            else if (tax != 0) {
	                tax += entry.getValue() * income;
	                break;
	            } 
	            // when income is lesser than first slab
	             else {
	                return tax;
	            }
	        }
	        return tax;
	    }

}
 
  