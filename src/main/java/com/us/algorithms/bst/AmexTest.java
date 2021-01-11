package com.us.algorithms.bst;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class AmexTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//solution("ABCHello");
		
	}
	
	static String solution(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toLowerCase().toCharArray()) {
        	System.out.println(ch - 'a');
            occurrences[ch - 'a']++;
        }
        
        char best_char = 'a';
        int  best_res  = 0;

        for (int i = 1; i < 26; i++) {
            if (occurrences[i] >= best_res) {
                best_char = (char)((int)'a' + i);
                best_res  = occurrences[i];
            }
        }

        return Character.toString(best_char);
    }
	
	void getMax(Tree T, Hashtable<Integer, Tree> h)
	{
	     if(T!= null) 
	     {
		if(!h.containsKey(T.x))
		{
		     h.put(T.x, T);
	        }
		getMax(T.right, h);
		getMax(T.left, h);
	     }
	}
	

	private int getMaxNumNodes(Tree root, Set<Integer> uniq){
		if(root == null){
			return uniq.size();
		}
		int l = 0;
		int r  = 0;
		if(uniq.add(root.x)){
			l = getMaxNumNodes(root.left, uniq);
			r = getMaxNumNodes(root.right, uniq);
			uniq.remove(uniq.size()-1);
		}
		else{
			l = getMaxNumNodes(root.left, uniq);
			r = getMaxNumNodes(root.right, uniq);
		}
		return Math.max(l, r);//(l >= r) ? l : r;
}
	
	public int solution(Tree T) {
        // write your code in Java SE 8
		//Set<Integer> uniq = new HashSet<Integer>();
		//return getMaxNumNodes(T,uniq);
		Hashtable<Integer, Tree> h = new Hashtable<Integer, Tree>();
	     getMax(T, h);
	     return h.size();
    }
	
}
class Tree {
	
	public int x;
	public Tree left;
	public Tree right;
	int i=Integer.MIN_VALUE;
	public Tree(int j) {
		this.x=j;
	}
}
	
	





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

1. go by left side of tree, print value
if node on the left is null 

public void printClockwiseTree(Tree node){
    if(node==null){
        return;
    }
    printLeftNodes(node);
    printLeafs(node);
    printRightNodes(node);
}

public void printRightNodes(Tree node){
    if(node==null){
        return;
    }
    if(node.right!=null){
        printRightNodes(node.right);
        System.out.println(node.data);
    }
    
}

public void printLeftNodes(Tree node){
    if(node==null){
        return;
    }
    if(node.left!=null){
        System.out.println(node.data)
        printLeftNodes(node.left)
    }
}
public void printLeafs(Tree node){
    if(node==null){
        return;
    }
    printLeafs(node.left);
    if(node.left==null && node.righ==null){
        System.out.println(node.data);
    }
    printLeafs(node.right);
}

