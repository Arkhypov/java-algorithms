package com.us.algorithms.amazon;

public class NumberOfIslands {

	/*Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
	An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
	You may assume all four edges of the grid are all surrounded by water.
		11110
		11010
		11000
		00000
		
		Output:1
	*/
	public static void main(String[] args) {
		char[][] ocean = { 
                {'1', '1','1','1','0'},
                {'1', '1','0','1','0'},
                {'1', '1','0','0','0'},
                {'0', '0','0','1','0'}
                };
		System.out.print(findNumIslands(ocean));
		
	}
	
	private static int findNumIslands(char[][] grid){
		if(grid.length==0||grid[0].length==0){
			return 0;
		}
		int m= grid.length;
		int n = grid[0].length;
		int count =0;
		
		//double loop matrix until you would meet 1
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j]=='1'){
					
					count++;
					merge(grid,i,j);
				}
			}
		}
		
		return count;
	}
	
	//go around this dot up, down, left, right, by marking it recursively
	public static void merge(char[][]grid, int i, int j){
		
		int m= grid.length;
		int n = grid[0].length;
		
		if(i<0||i>=m||j<0||j>=n||grid[i][j]!='1')
	        return;
		
		grid[i][j]='X';
		
		merge(grid, i-1, j);
	    merge(grid, i+1, j);
	    merge(grid, i, j-1);
	    merge(grid, i, j+1);
	}
	

}
