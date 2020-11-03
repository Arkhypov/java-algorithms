package com.us.algorithms.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import com.us.algorithms.bst.BinaryTree.TreeNode;


public class VerticalTraversalBST {

/***	
 * Algorithm

   
 1) Create a helper class Point which will have x, y, coordinate along with node value.
 2) Run dfs traversal on tree starting from root node with co-ordinates 0, 0. Left call with x - 1, y - 1 and right call x + 1, y - 1 keep all point into reference list.
 3) Sort all the point using Collections.sort method with custom comparator, first compare x co-ordinate then y then value itself.
 4) Now create a treeMap where key is x co-odrinate and value is list of all nodes having same x value.
 5) Just create a List<List> from treeMap.

 * */
      public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) 
            return new ArrayList();
        
        List<Point> list = new ArrayList();
        vtUtil(root, 0, 0, list);
        
        // Sort points based on x then y then value
		// here x is compared in increasing order, y in decreasing order, and value in increasing order
        Collections.sort(list, (p1, p2) -> p1.x == p2.x ? p1.y == p2.y ? p1.val- p2.val : p2.y - p1.y : p1.x - p2.x);
        
		// Build treeMap with key as x value of node
        Map<Integer, List<Integer>> map = new TreeMap();
        for(Point p : list) {
            List<Integer> line = map.getOrDefault(p.x, new ArrayList());
            line.add(p.val);
            map.put(p.x, line);
        }
        
		// Construct result List<List<Integer>>
        List<List<Integer>> result = new ArrayList();
        for(List<Integer> l : map.values())
            result.add(l);
        
        return result;
    }

    private void vtUtil(TreeNode root, int x, int y, List<Point> list) {
        if (root == null) 
            return; 
        list.add(new Point(x, y, root.data));
        vtUtil(root.left, x - 1, y - 1, list);
        vtUtil(root.right, x + 1, y - 1, list);
    }

}

class Point {
    int x;
    int y;
    int val;
    public Point(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
