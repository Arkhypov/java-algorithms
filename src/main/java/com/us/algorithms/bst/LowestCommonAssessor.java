package com.us.algorithms.bst;

import java.util.List;

import com.us.algorithms.bst.BinarySearchTree.TreeNode;

public class LowestCommonAssessor {

	public static void main(String[] args) {
	    // construct the binary tree given in question
		BinarySearchTree bt = BinarySearchTree.create();
	    int n1 = 10, n2 = 14; 
	    TreeNode t = findLCA(bt.root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data); 
   
        n1 = 14; 
        n2 = 8; 
        t = findLCA(bt.root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data); 
   
        n1 = 10; 
        n2 = 22; 
        t = findLCA(bt.root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data); 

	}
    /* Function to find LCA of n1 and n2. The function assumes that both 
    n1 and n2 are present in BST */
	public static TreeNode findLCA(TreeNode node, int n1, int n2){
		if (node == null) return null;
		// If both n1 and n2 are smaller than root, then LCA lies in left 
		if(node.data>n1 && node.data>n2) return findLCA(node.left, n1, n2);
		
		// If both n1 and n2 are greater than root, then LCA lies in right
		if(node.data < n1 && node.data < n2) return findLCA(node.right, n1, n2);
		return node;
	}
}
	

class BinarySearchTree {
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
	  public static BinarySearchTree create() {
		BinarySearchTree tree = new BinarySearchTree();
	    TreeNode root = new TreeNode(20);
	    tree.root = root;
	    tree.root.left = new TreeNode(8);
	    tree.root.left.left = new TreeNode(4);
	    tree.root.left.right = new TreeNode(12);
	    tree.root.left.right.left = new TreeNode(10);
	    tree.root.left.right.right = new TreeNode(14);

	    tree.root.right = new TreeNode(22);

	    return tree;
	  }
	}
