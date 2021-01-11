package com.us.algorithms.amazon;

public class FriendsCircle {

/**
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature.
 * For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. 
 * And we defined a friend circle is a group of students who are direct or indirect friends.
 * 
   Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, 
   then the ith and jth students are direct friends with each other, otherwise not. 
   And you have to output the total number of friend circles among all the students.
   
Example 1:

Input: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.

Example 2:

Input: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findCircleNum(new int[][]{{1,1,0,0},{1,1,1,0},{0,1,1,0},{0,0,0,1}}));
	}
	
	    public static int findCircleNum(int[][] M) {
	        boolean[] visited = new boolean[M.length]; //visited[i] means if ith person is visited in this algorithm
	        int count = 0;
	        for(int i = 0; i < M.length; i++) {
	            if(!visited[i]) {
	                dfs(M, visited, i);
	                count++;
	            }
	        }
	        return count;
	    }
	    private static void dfs(int[][] M, boolean[] visited, int person) {
	        for(int other = 0; other < M.length; other++) {
	            if(M[person][other] == 1 && !visited[other]) {
	                //We found an unvisited person in the current friend cycle 
	                visited[other] = true;
	                dfs(M, visited, other); //Start DFS on this new found person
	            }
	        }
	    }
	}


