package com.us.algorithms.bst;

import java.util.ArrayList;

import com.us.algorithms.bst.BinaryTree.TreeNode;

public class FindMaxNodeBST {

	public static void main(String[] args) {
		
	}
	
	public static int findMaxNodeVal(TreeNode t){
				    /* loop down to find the rightmost leaf */
			TreeNode current = t; 
			if (current == null) return Integer.MIN_VALUE; 
			
			int cVal = current.data; 
		    int lMax = findMaxNodeVal(current.left); 
		    int rMax = findMaxNodeVal(current.right); 
		    
		    if (lMax > cVal) 
		    	cVal = lMax; 
		    if (rMax > cVal) 
		    	cVal = rMax; 
		    return cVal; 
	}
}
class BinaryTree {
	  static class TreeNode {
	    int data;
	    TreeNode left, right;

	    TreeNode(int value) {
	      this.data = value;
	      left = right = null;
	    }

	  }

	  // root of binary tree
	  TreeNode root;

	  /**
	   * traverse the binary tree on InOrder traversal algorithm
	   */
	  public void inOrder(TreeNode root) {
		  if (root == null) {
		      return;
		    }

		    inOrder(root.left);
		    System.out.printf("%s ", root.data);
		    inOrder(root.right);
	  }
	  
	  /**
	   * traverse the binary tree on preOrder traversal algorithm
	   */
	  public void preOrder(TreeNode root) {
		  if (root == null) {
		      return;
		    }
		  
		  	System.out.printf("%s ", root.data);
		    inOrder(root.left);
		    inOrder(root.right);
	  }
	  
	  /**
	   * traverse the binary tree on preOrder traversal algorithm
	   */
	  public void postOrder(TreeNode root) {
		  if (root == null) {
		      return;
		    }
		  
		  	
		    inOrder(root.left);
		    inOrder(root.right);
		    System.out.printf("%s ", root.data);
	  }

	  /**
	   * Java method to create binary tree with test data
	   * 
	   * @return a sample binary tree for testing
	   */
	  public static BinaryTree create() {
	    BinaryTree tree = new BinaryTree();
	    TreeNode root = new TreeNode(40);
	    tree.root = root;
	    tree.root.left = new TreeNode(20);
	    tree.root.left.left = new TreeNode(10);
	    tree.root.left.left.left = new TreeNode(5);

	    tree.root.left.right = new TreeNode(30);
	    tree.root.right = new TreeNode(50);
	    tree.root.right.right = new TreeNode(60);
	    tree.root.left.right.left = new TreeNode(67);
	    tree.root.left.right.right = new TreeNode(78);

	    return tree;
	  }

	}

