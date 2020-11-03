package com.us.algorithms.array;

public class SearchWordIn2D {

/*
 * Given a 2D board and a word, find if the word exists in the grid.
   The word can be constructed from letters of sequentially adjacent cells, 
   where "adjacent" cells are horizontally or vertically neighboring. 
   The same letter cell may not be used more than once.
   
   Solutions: DFS
 * 	
 */
	
	public static boolean exist(char[][] board, String word) {
	    for(int i = 0; i < board.length; i++)
	        for(int j = 0; j < board[0].length; j++){
	            if(exist(board, i, j, word, 0))
	                return true;
	        }
	    return false;
	}
	private static boolean exist(char[][] board, int i, int j, String word, int ind){
	    if(ind == word.length()) return true;
	    if(i > board.length-1 || i <0 || j<0 || j >board[0].length-1 || board[i][j]!=word.charAt(ind))
	        return false;
	    board[i][j]='*'; //marking asterisk, so does not walk same char 
	    boolean result =    exist(board, i-1, j, word, ind+1) ||
	                        exist(board, i, j-1, word, ind+1) ||
	                        exist(board, i, j+1, word, ind+1) ||
	                        exist(board, i+1, j, word, ind+1);
	    board[i][j] = word.charAt(ind);
	    return result;
	}

    public static void main(String[] args) {
        char[][] grid = {
        		new char[]{'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S'},
                new char[]{'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K'},
                new char[]{'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E'}
        		};
        System.out.println(exist(grid, "GEEKS"));
        System.out.println();
        System.out.println(exist(grid, "EEE"));
    }

}
