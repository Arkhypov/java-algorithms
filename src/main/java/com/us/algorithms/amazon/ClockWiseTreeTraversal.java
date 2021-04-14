package com.us.algorithms.amazon;

import com.us.algorithms.bst.Tree;
import com.us.algorithms.bst.go;
import com.us.algorithms.bst.left;
import com.us.algorithms.bst.node;
import com.us.algorithms.bst.of;

public class ClockWiseTreeTraversal {
	/*Compilation successful.

	Example test:    (4, (5, (4, (5, None, None), None), None), (6, (1, None, None), (6, None, None))) 
	WRONG ANSWER  (got 4 expected 3) */
	/*
	Problem: Write code to perform a boundary traversal of a binary tree. 
	In the example below, the result would be: [20, 8, 4, 10, 14, 25, 22]. 

	Note that we go counter-clockwise to traverse the boundary.

	    ____20
	   /      \
	  8___     22
	 /    \     \
	4     _12    25
	     /   \
	    10    14

	*/

//	1. go by left side of tree, print value
//	if node on the left is null 
//
//	public void printClockwiseTree(Tree node){
//	    if(node==null){
//	        return;
//	    }
//	    printLeftNodes(node);
//	    printLeafs(node);
//	    printRightNodes(node);
//	}
//
//	public void printRightNodes(Tree node){
//	    if(node==null){
//	        return;
//	    }
//	    if(node.right!=null){
//	        printRightNodes(node.right);
//	        System.out.println(node.data);
//	    }
//	    
//	}
//
//	public void printLeftNodes(Tree node){
//	    if(node==null){
//	        return;
//	    }
//	    if(node.left!=null){
//	        System.out.println(node.data)
//	        printLeftNodes(node.left)
//	    }
//	}
//	public void printLeafs(Tree node){
//	    if(node==null){
//	        return;
//	    }
//	    printLeafs(node.left);
//	    if(node.left==null && node.righ==null){
//	        System.out.println(node.data);
//	    }
//	    printLeafs(node.right);
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
