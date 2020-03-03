package com.us.algorithms;

public class TopTallTasks {
	
/* 
 * 
An integer X and a non-empty zero-indexed array A consisting of N integers are given. 
We are interested in which elements of A are equal to X and which are different from X. 
The goal is to split array A into two parts, such that the number of elements equal to X in the first part is the same 
as the number of elements different from X in the other part. More formally, we are looking for a number K such that:
0 = K = N, and the number of elements equal to X in A[0..K-1] is the same as the number of elements different from X in A[K..N-1]. 
(For K = 0, A[0..K-1] does not contain any elements. For K = N, A[K..N-1] does not contain any elements.)

For example, given integer X = 5 and array A such that:
  A[0] = 5
  A[1] = 5
  A[2] = 1
  A[3] = 7
  A[4] = 2
  A[5] = 3
  A[6] = 5
Example of array above {5,5,1,7,2,3,5}
  
  K equals 4, because:
1)two of the elements of A[0..3] are equal to X, namely A[0] = A[1] = X, and
2)two of the elements of A[4..6] are different from X, namely A[4] and A[5].

Write a function:
int solution(int X, int A[], int N);
that, given an integer X and a non-empty zero-indexed array A consisting of N integers, returns the value of number K satisfying the above conditions. It can be shown such index K always exists and it is unique.
For example, given integer X and array A as above, the function should return 4, as explained above.

Assume that:
N is an integer within the range 100,000;
X is an integer within the range ..100,000;
each element of array A is an integer within the range 0..100,000.

Complexity:
1) expected worst-case time complexity is O(N);
2) expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).

Elements of input arrays can be modified.



https://github.com/Jarosh/Exercises
 
 * 	
 */
		public int splitArray(int X, int[] A) {
	        
			int occur=0;
			int chunk=0;
			
			for (int i=0;i<A.length;i++){
				
				if(X==A[i]){
					
					occur++;
					chunk++;
				}else{
					
					chunk=0;
				}
			}
			
			if(occur>0 && occur>chunk){
				
				return A.length - occur;
			}else{
				
				return -1;
			}
			
	}
		
		
		
		
		
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
