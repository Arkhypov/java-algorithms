package com.us.algorithms.bst;

import com.us.algorithms.bst.BinarySearchTree.TreeNode;

public class TreeDepth {

	public static void main(String[] args) {
		BinarySearchTree tree = BinarySearchTree.create();
		System.out.println(findMaxDepth(tree.root));
	}
	public static int findMaxDepth(TreeNode t){
	    /* loop down to find the rightmost leaf */
		TreeNode current = t; 
		if (current == null) return 0; 
		
		int leftDepth = findMaxDepth(current.left); 
		int rightDepth = findMaxDepth(current.right); 

		if (leftDepth > rightDepth) 
			return (leftDepth+1);
		else return (rightDepth+1); 
	}
	
	/**
		For every node, check if it is a leaf node. If yes, then return 1. 
		If not leaf node then if the left subtree is NULL, then recur for the right subtree. 
		And if the right subtree is NULL, then recur for the left subtree. 
		If both left and right subtrees are not NULL, then take the minimum of two heights.
	*/
	 public int minDepth(TreeNode root) {
	        TreeNode current = root; 
			if (current == null) return 0; 
			
			// Base case : Leaf Node. This accounts for height = 1. 
	        if (current.left == null && current.right == null) 
	            return 1;
	        
			if (root.left == null) 
	            return minDepth(root.right) + 1;
			if (root.right == null) 
	            return minDepth(root.left) + 1;

			return Math.min(minDepth(root.left), 
	                        minDepth(root.right)) + 1;
	    }
}
