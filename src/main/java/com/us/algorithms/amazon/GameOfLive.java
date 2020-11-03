package com.us.algorithms.amazon;

public class GameOfLive {
/**
 * According to the Wikipedia's article: 
 *  	"The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
   Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
   Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules 
   
   *Any live cell with fewer than two live neighbors dies, as if caused by under-population.
   *Any live cell with two or three live neighbors lives on to the next generation.
   *Any live cell with more than three live neighbors dies, as if by over-population..
   *Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
   
   Write a function to compute the next state (after one update) of the board given its current state. 
   The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
   Input: 
		[
		  [0,1,0],
		  [0,0,1],
		  [1,1,1],
		  [0,0,0]
		]
   Output: 
		[
		  [0,0,0],
		  [1,0,1],
		  [0,1,1],
		  [0,1,0]
		]
 * 
 */
	 private int die = 2; //we are using die and live, because we use existing matrix
	 private int live = 3;
	 public void gameOfLife(int[][] board) {
  
		 	// we only flip the 1 to die and 0 to live
	        // so when we find a die around, it must be a previous 1
	        // then we can count the 1s without being affected
	        int rows = board.length;
	        int cols = board[0].length;
	        for (int i=0;i<rows;i++){
	            for (int j=0;j<cols;j++){
	                int around = countLive(i,j,board);
	                if (board[i][j] == 0 && around == 3) //rule number 4
	                    board[i][j] = live;
	                else if (board[i][j] == 1){
	                    if (around == 2 || around ==3)	//rule number 2
	                        continue;
	                    if (around < 2 || around > 3)	//rule number 1 and 3
	                        board[i][j] = die;
	                }
	            }
	        }
	        
	          for (int i=0;i<rows;i++){
	            for (int j=0;j<cols;j++){
	                 if (board[i][j] == die)
	                     board[i][j] = 0;
	                 if (board[i][j] == live)
	                     board[i][j] = 1;
	                }
	            }
	        
	    }
	    
	private int countLive(int i, int j,int[][] board){
	   int count = 0;
	   int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
	        
	   for (int[] dir:dirs){
	       int x = i+dir[0];
	       int y = j+dir[1];
	            
	       if (x>=0 && y>=0 && x < board.length && y<board[0].length ){
	                
	       if (board[x][y] == 1 || board[x][y] == die)
	           count ++;
	       }
	   }
	        
	   return count;     
	}
	public static void main(String[] args) {
		
	}

}
