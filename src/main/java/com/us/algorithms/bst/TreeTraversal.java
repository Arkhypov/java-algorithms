package com.us.algorithms.bst;

import static org.junit.Assert.*;

public class TreeTraversal {

	public static void main(String[] args) throws Exception {

	    // construct the binary tree given in question
	    BinaryTree bt = BinaryTree.create();

	    // traversing binary tree using InOrder traversal using recursion
	    System.out
	        .println("printing nodes of binary tree on InOrder using recursion");
	    bt.inOrder(bt.root);
	    
	    System.out
        .println("\nprinting nodes of binary tree on PreOrder using recursion");
	    bt.preOrder(bt.root);
	    
	    System.out
	    .println("\nprinting nodes of binary tree on PostOrder using recursion");
	    bt.postOrder(bt.root);
	  }

	}

/*	class BinaryTreee {
	  static class TreeNode {
	    String data;
	    TreeNode left, right;

	    TreeNode(String value) {
	      this.data = value;
	      left = right = null;
	    }

	  }

	  // root of binary tree
	  TreeNode root;

	  *//**
	   * traverse the binary tree on InOrder traversal algorithm
	   *//*
	  public void inOrder(TreeNode root) {
		  if (root == null) {
		      return;
		    }

		    inOrder(root.left);
		    System.out.printf("%s ", root.data);
		    inOrder(root.right);
	  }
	  
	  *//**
	   * traverse the binary tree on preOrder traversal algorithm
	   *//*
	  public void preOrder(TreeNode root) {
		  if (root == null) {
		      return;
		    }
		  
		  	System.out.printf("%s ", root.data);
		    inOrder(root.left);
		    inOrder(root.right);
	  }
	  
	  *//**
	   * traverse the binary tree on preOrder traversal algorithm
	   *//*
	  public void postOrder(TreeNode root) {
		  if (root == null) {
		      return;
		    }
		    inOrder(root.left);
		    inOrder(root.right);
		    System.out.printf("%s ", root.data);
	  }

	  *//**
	   * Java method to create binary tree with test data
	   * 
	   * @return a sample binary tree for testing
	   *//*
	  public static BinaryTreee create() {
	    BinaryTree tree = new BinaryTreee();
	    TreeNode root = new TreeNode("40");
	    tree.root = root;
	    tree.root.left = new TreeNode("20");
	    tree.root.left.left = new TreeNode("10");
	    tree.root.left.left.left = new TreeNode("5");

	    tree.root.left.right = new TreeNode("30");
	    tree.root.right = new TreeNode("50");
	    tree.root.right.right = new TreeNode("60");
	    tree.root.left.right.left = new TreeNode("67");
	    tree.root.left.right.right = new TreeNode("78");

	    return tree;
	  }

	}*/
