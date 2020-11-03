package com.us.algorithms.amazon;

public class Skier {

/**
 * Skier going down a mountain.
 * Write a program where you have a 2D array of MxN, starting at (0,0) and needs to return true 
 * if they can reach the bottom right-most index (M, N). Return false if they can not.
 * Skier can only traverse through portions of the array marked 0. If there is a 1 then the skier can not traverse that index.
 * The skier can only go down or right.
 * 
 * Follow-up
 * What if the skier can go left as well.
 * 
 */
    
    private static boolean canReachBottom(int[][] m) {
        return canReach(0, 0, m);
    }
    //DFS solution
    private static boolean canReach(int i, int j, int[][] m) {
        if(i < 0 || i >= m.length || j < 0 || j >= m[0].length || m[i][j] == 1) {
            return false;
        }
        System.out.println(i + "," + j);
        if(i == m.length-1 && j == m[0].length-1) {
            return true;
        }
        m[i][j] = 1;
        return canReach(i+1, j, m) || canReach(i, j+1, m) || canReach(i, j-1, m);
    }
    
    static String assertStatement(boolean expected, boolean actual) {
      return expected != actual ? "FAILED" : "PASSED";  
    }
    
    public static void main(String[] args) {
        int[][] m = {{0, 0, 0, 1, 1},
                     {1, 1, 0, 1, 1},
                     {1, 0, 0, 1, 0},
                     {1, 0, 1, 0, 0},
                     {0, 0, 0, 0, 0}};
        
        System.out.println(assertStatement(true, canReachBottom(m)));
    }

}
