package com.prep.cci.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeQst {

	/**
	 * How to check if tree is balanced. Hint : MaxDepth - MinDepth <=1
	 */
	public static class BalanceTreeCheck {

		public boolean checkIfBalancedTree(TreeNode root) {
			return (getMaxDepth(root) - getMinDepth(root)) <= 1;
		}

		private int getMaxDepth(TreeNode node) {
			if (node == null) {
				return 0;
			}
			int result = 0, leftSTDepth = 0, rightSTDept = 0;
			/* Iterate left node */
			leftSTDepth = getMaxDepth(node.getLeftNode());
			/* Iterate right node */
			rightSTDept = getMaxDepth(node.getRightNode());
			result = 1 + Math.max(leftSTDepth, rightSTDept);
			return result;
		}

		private int getMinDepth(TreeNode node) {
			if (node == null) {
				return 0;
			}
			int result = 0, leftSTDepth = 0, rightSTDept = 0;
			/* Iterate left node */
			leftSTDepth = getMaxDepth(node.getLeftNode());
			/* Iterate right node */
			rightSTDept = getMaxDepth(node.getRightNode());
			result = 1 + Math.min(leftSTDepth, rightSTDept);
			return result;
		}
	}

	/**
	 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height. We will try to create a binary tree such that for each node, the
	 * number of nodes in the left subtree and the right subtree are equal, if possible. Algorithm: 1. Insert into the tree the middle element of the array. 2. Insert (into the
	 * left subtree) the left subarray elements 3. Insert (into the right subtree) the right subarray elements 4. Recurse
	 */
	public static class BTFromArray {

		private TreeNode createBT(Integer arr[], int start, int end) {
			if (end < start) {
				return null;
			}
			int mid = start + ((end - start) / 2);
			TreeNode<Integer, String> node = new TreeNode<Integer, String>();
			node.setKey(arr[mid]);
			node.setVal("" + arr[mid]);
			node.setLeftNode(createBT(arr, start, mid - 1));
			node.setRightNode(createBT(arr, mid + 1, end));
			return node;
		}

		public TreeNode createBT(Integer arr[]) {
			TreeNode node = createBT(arr, 0, arr.length - 1);
			return node;
		}
	}

	/**
	 * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth (eg, if you have a tree with depth D, you’ll have D linked lists).
	 * 
	 */
	public static class BTNodesFetch {
       public ArrayList<LinkedList<TreeNode>> createNodeList(TreeNode root) {
    	   /*List will hold list of nodes at each level*/
           ArrayList<LinkedList<TreeNode>> nodeList = new ArrayList<LinkedList<TreeNode>>();
    	   /*List will have all the nodes for a level. It will be initialzed at each level*/
           LinkedList<TreeNode> lst = new LinkedList<TreeNode>();
           LinkedList<TreeNode> plist = null;
    	   int level =0;
    	   lst.add(root);
    	   nodeList.add(level, lst);
    	   level++;
    	   while(!lst.isEmpty()) { /*List of node to be iterated for child is not empty*/
    		     plist = lst;
    		     lst = new LinkedList<TreeNode>();
    		     for(int cnt=0;cnt<plist.size(); cnt++) {
    		    	 TreeNode node = plist.get(cnt);
    		    	 TreeNode child = node.getLeftNode();
    		    	 if(child != null) {
    		    		 lst.add(child);
    		    	 }
    		    	 child = node.getRightNode();
    		    	 if(child != null) {
    		    		 lst.add(child);
    		    	 }
    		     }
    		     if(!lst.isEmpty()) { /*if list is not empty add to to level node list and increment level*/
    		    	 nodeList.add(level, lst);
    		    	 level++;
    		     }
    	   }
    	   return nodeList;
       }
	}
	/**
	 * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth (eg, if you have a tree with depth D, you’ll have D linked lists).
	 * 
	 */
	
	public static class BTSuccessorNode {

		
		public TreeNode findLeftMostChild(TreeNode node) {
    	   return null;
       }
	}

}
