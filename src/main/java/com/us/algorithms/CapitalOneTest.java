package com.us.algorithms;

public class CapitalOneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
float calculateTaxes(income, brackets)
where "brackets" is a list of pairs, e.g.
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
  
  