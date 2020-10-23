package com.us.algorithms.amazon;

public class SearchDestination2DAmazon {

/*	Amazon Fresh is a grocery delivery services that offers consumers the option of purchasing their groceries online and having them delivered on schedule.  
 * The Amazon Fresh team is planning a route for a delivery truck to deliver customer orders in the city of Techlandia.  The planner will create a delivery area for each order to effectively plan the route. The area is abstracted as a grid. Not all locations are accessible by road. The truck only needs to make a single delivery.

	Write an algorithm to determine the minimum distance required for the truck to deliver the order.

	Assumptions:

	Some places in the delivery area cannot be accessed by the driver, as there are no roads into those locations.
	The delivery area can be represented as a two-dimensional grid of integers, where each integer represents one cell.
	The truck must start from the top-left corner of the area, which is always accessible, and can move one cell up, down, left, or right at a time.
	The truck must navigate around the areas without roads and cannot leave the area.
	The accessible areas are represented as 1, areas with without roads are represented by 0 and the order destination is represented by 9.
	Input
	The input to the function/method consists of three arguments:
	numRows, an integer representing the number of rows;
	numColumns, an integer representing the number of columns;
	area, representing the two-dimensional grid of integers.

	Output
	Return an integer representing the total distance traversed to deliver the order else return -1.

	Constraints
	1 ≤ numRows, numColumns ≤ 1000

	Example
	Input:
	numRows = 3
	numColumns = 3
	area =
	[[1, 0, 0],
	[1, 0, 0],
	[1, 9, 1]]

	Output:
	3

	Explanation:
	Starting from the top-left corner, the truck traversed the cells (0,0) -> (1,0) -> (2,0) -> (2,1). 
	The truck traversed the total distance 3 to deliver the order.
	So, the output is 3.*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(minimumDistance(int numRows, int numColumns, List<List<Integer>> area));
		int[][] area = new int[][] {
			{1, 0, 0},
			{1, 0, 0},
			{1, 9, 1}		
					};
		int[][] area2 = new int[][] {
			{ 1, 1, 1, 1 }, 
			{ 0, 1, 1, 1 }, 
			{ 0, 1, 0, 1 }, 
			{ 1, 1, 9, 1 }, 
			{ 0, 0, 1, 1 } 
		};
		System.out.println(findDistance(area));
		System.out.println(findDistance(area2));
	}
	
	/*int minimumDistance(char[][] area)
    {
		int n=area.length; 
		int m=area[0].length;
		int count=0;
		
        for(;i<area.size();){
        	if(area.get(i).get(j)==9){
        		return count;
        	}
        	if(area.get(i+1).get(j)==9){
        		return count++;
        	}
        	if(area.get(i).get(j+1)==9){
        		return count++;
        	}
        	if(area.get(i+1).get(j)==1){
        		i++;
        		count++;
        		continue;
        	}else if(area.get(i).get(j+1)==1){
        		j++;
        		count++;
        		continue;
        	}
        }
        return count;
		// WRITE YOUR CODE HERE
    }*/
	static int finalDistance;
	static int findDistance(int[][] area)
    {
		int numRows=area.length; 
		int numColumns=area[0].length;
		//int count=0;
		finalDistance = 0;

        // 2D array with the same size to track the visited cell.
        boolean [][] visited = new boolean [numRows][numColumns];

        // initial distance moved.
        int distance = 0;
                   
        // till the helper method returns true.
        if (helper(numRows, numColumns, area, visited, 0, 0, distance))
        {
            return finalDistance;
        }
        else
        {
            // no path found.
            return 0;
        }
    }

    /// <summary>
    /// Helper method to find the distance from origin to the destination cell
    /// </summary>
    /// <param name="numRows">total number of rows</param>
    /// <param name="numColumns">total number of columns</param>
    /// <param name="area">total area matrix</param>
    /// <param name="visited">metrix to track the visited cells.</param>
    /// <param name="currentRow">current row number</param>
    /// <param name="currentColumn">current column number</param>
    /// <param name="distance">distance covered till now.</param>
    /// <returns>true if the destination is found</returns>
    static boolean helper(int numRows, int numColumns, int[][] area, boolean[][] visited, int currentRow, int currentColumn, int distance)
    {
        // edge cases when the searching index goes beyond the limit in rows and columns.
        if (currentRow < 0 || currentColumn < 0 || currentRow >= numRows || currentColumn >= numColumns)
        {
            return false;
        }

        // check if this cell is already visited
        if (visited[currentRow][currentColumn])
        {
            return false;
        }

        // check if the value at cell is 0 i.e. no further path
        if (area[currentRow][currentColumn] == 0)
        {
            return false;
        }

        // if the value is 9 i.e. the destination.
        // Found the destination, return true 
        if (area[currentRow][currentColumn] == 9)
        {
            return true;
        }

        // This means, current cell is not visited yet and it has the value 1 i.e. path
        // this is 1 step forward toward the destination.

        // increase the distance by 1.
        distance++;

        // mark current cell as visited so that we dont come on the same cell again.
        visited[currentRow][currentColumn] = true;

        // Go for "Breadth Firth Search" in all four direction. 
        if (helper(numRows, numColumns, area, visited, currentRow++, currentColumn, distance) ||
           helper(numRows, numColumns, area, visited, currentRow--, currentColumn, distance) ||
           helper(numRows, numColumns, area, visited, currentRow, currentColumn++, distance) ||
           helper(numRows, numColumns, area, visited, currentRow, currentColumn--, distance)
            )
        {
            // Set the final distance to travel if it is not set yet.
            if (finalDistance == 0)
            {
                finalDistance = distance;
            }

            return true;
        }
        else {
            return false;
        }
    }
}
