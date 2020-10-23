package com.us.algorithms.bst;

import com.us.algorithms.bst.BinarySearchTree.TreeNode;

public class AddSumBST {
	
	public static void main(String[] args) {
		BinarySearchTree tree = BinarySearchTree.create();
		tree.inOrder(tree.root);
		System.out.println();
		addSum(tree.root, 0);
		tree.inOrder(tree.root);
	}
	
	public static int addSum(TreeNode node,int sum){
		if(node == null) {
			return sum;
		}
		if(node.right!=null) {
			sum = addSum(node.right, sum);
		}
		node.data+=sum;
		return addSum(node.left, node.data);
	}
}
