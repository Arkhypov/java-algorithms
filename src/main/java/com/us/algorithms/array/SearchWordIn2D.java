package com.us.algorithms.array;

public class SearchWordIn2D {

	public static void searchGrid(char[][] grid, String word) {

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == word.charAt(0)) {
                    for (int dir = 0; dir < 4; dir++) {
                        if (searchGridUtil(grid, word, 1, dir, i, j, i, j)) break;
                    }
                }
            }
        }
    }


    private static boolean searchGridUtil(char[][] grid, String word, int pos, int dir, int i, int j, int iPos, int jPos) {
        if (pos == word.length()) {
            System.out.printf("pattern found at %d, %d\n", iPos, jPos);
            return true;
        }
        int m = grid.length, n = grid[0].length;
        int x, y;
        if (dir == 0) {
            x = i - 1;
            y = j - 1;
        } else if (dir == 1) {
            x = i - 1;
            y = j;
        } else if (dir == 2) {
            x = i - 1;
            y = j + 1;
        } else if (dir == 3) {
            x = i;
            y = j + 1;
        } else if (dir == 4) {
            x = i + 1;
            y = j + 1;
        } else if (dir == 5) {
            x = i + 1;
            y = j;
        } else if (dir == 6) {
            x = i + 1;
            y = j - 1;
        } else {
            x = i;
            y = j - 1;
        }

        if (x < 0 || x == m || y < 0 || y == n || grid[x][y] != word.charAt(pos)) return false;
        return searchGridUtil(grid, word, pos + 1, dir, x, y, iPos, jPos);
    }

    public static void main(String[] args) {
        char[][] grid = {
        		new char[]{'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S'},
                new char[]{'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K'},
                new char[]{'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E'}
        		};
        searchGrid(grid, "GEEKS");
        System.out.println();
        searchGrid(grid, "EEE");
    }

}
