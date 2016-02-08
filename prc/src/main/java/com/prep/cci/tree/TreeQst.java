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
			/* List will hold list of nodes at each level */
			ArrayList<LinkedList<TreeNode>> nodeList = new ArrayList<LinkedList<TreeNode>>();
			/* List will have all the nodes for a level. It will be initialzed at each level */
			LinkedList<TreeNode> lst = new LinkedList<TreeNode>();
			LinkedList<TreeNode> plist = null;
			int level = 0;
			lst.add(root);
			nodeList.add(level, lst);
			level++;
			while (!lst.isEmpty()) { /* List of node to be iterated for child is not empty */
				plist = lst;
				lst = new LinkedList<TreeNode>();
				for (int cnt = 0; cnt < plist.size(); cnt++) {
					TreeNode node = plist.get(cnt);
					TreeNode child = node.getLeftNode();
					if (child != null) {
						lst.add(child);
					}
					child = node.getRightNode();
					if (child != null) {
						lst.add(child);
					}
				}
				if (!lst.isEmpty()) { /* if list is not empty add to to level node list and increment level */
					nodeList.add(level, lst);
					level++;
				}
			}
			return nodeList;
		}
	}

	/**
	 * Write an algorithm to find the ‘next’ node (e.g., in-order successor) of a given node in a binary search tree where each node has a link to its parent.
	 * 
	 */

	public static class BTSuccessorNode {

		public TreeNode findSuccessorNode(TreeNode node) {
			assert (node == null) : "Node is null";
			TreeNode successor = null;
			TreeNode parent = null;
			if (node.getParent() == null) {
				if (node.getRightNode() == null) {
					return null; /* root and no node is greater then root */
				} else {
					return findLeftMostChild(node.getRightNode());
				}
			} else {
				/* go to right */
				if (node.getRightNode() != null) {
					return findLeftMostChild(node.getRightNode());
				}
				/* go to parent and check left child */
				parent = node.getParent();
				successor = node;
				while (successor.getParent() != null) {
					if (successor == parent.getLeftNode()) {
						break;
					}
					successor = parent;
					parent = successor.getParent();
				}
			}
			return parent;
		}

		public TreeNode findLeftMostChild(TreeNode node) {
			if (node == null) {
				return null;
			}
			while (node.getLeftNode() != null) {
				node = node.getLeftNode();
			}
			return node;
		}
	}
	
	public class CommonParent {
		
		/*approach 1*/
		public TreeNode findCommonParent1(TreeNode root, TreeNode a, TreeNode b) {
			assert(a==b):"Nodes are same";
			/*if both the node exists in the left of the root.*/
			if(findNode(root.getLeftNode(), a) && findNode(root.getLeftNode(),b)) {
				return findCommonParent1(root.getLeftNode(), a, b);
			}
			/*if both the node exists in the right of the root.*/
			if(findNode(root.getRightNode(), a) && findNode(root.getRightNode(),b)) {
				return findCommonParent1(root.getRightNode(), a, b);
			}
			return root;
		}
		/*check if node is child of the give node*/
		private boolean findNode(TreeNode root, TreeNode a) {
			if(root == null) {
				return false;
			}
			if(root == a) {
				return true;
			}
			return findNode(root.getLeftNode(),a) || findNode(root.getRightNode(), a); 
		}
		
		
		
	}
	
	

	/**
	 * two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1
	 * 
	 */
	public static class BTSubtreeCheck {
		public boolean checkSubTree(TreeNode t1, TreeNode t2) {
			assert (t1 == null || t2 == null) : "One of the tree is empty";
			return subTree(t1, t2);
		}

		private boolean subTree(TreeNode t1, TreeNode t2) {
			if (t1.getKey() == t2.getKey()) { /* key matches here - so this is where tree match would start */
				return matchTree(t1, t2);
			}
			/* find where t2 is present in the t1 */
			return (subTree(t1.getLeftNode(), t2) || subTree(t1.getRightNode(), t2));
		}

		private boolean matchTree(TreeNode t1, TreeNode t2) {
			if (t1 == null && t2 == null) {
				return true; /* No more nodes to visit in the subtree */
			}
			if (t1 == null || t2 == null) {
				return false; /* one of the node is null so trees are not of the same length */
			}
			if (t1.getKey() != t2.getKey()) {
				return false; /* Data doesn't match */
			}
			/* check if children are same */
			return matchTree(t1.getLeftNode(), t2.getLeftNode()) && matchTree(t1.getRightNode(), t2.getRightNode());
		}
	}

	/**
	 * You are given a binary tree in which each node contains a value. Design an algorithm to print all paths which sum up to that value. Note that it can be any path in the tree
	 * - it does not have to start at the root.
	 * 
	 */
	public static class BTSumUpToValue {

		public void findNodesWithSum(TreeNode node, int sum, ArrayList<Integer> buffer, int level) {
			if (node == null) {
				return;
			}
			int bsum = sum;
			buffer.add((Integer) node.getKey());
			for (int i = level; i > -1; i--) {
				bsum = bsum - buffer.get(i);
				if (bsum == 0) {/* sum found */
					printList(buffer, i, level);
				}
			}
			ArrayList<Integer> bufferLeft = (ArrayList<Integer>) buffer.clone();
			ArrayList<Integer> bufferRight = (ArrayList<Integer>) buffer.clone();
			findNodesWithSum(node.getLeftNode(), sum, bufferLeft, level + 1);
			findNodesWithSum(node.getRightNode(), sum, bufferRight, level + 1);
		}

		private void printList(ArrayList<Integer> buffer, int start, int end) {
			System.out.print("\n");
			for (int cnt = start; cnt <= end; start++) {
				System.out.print(buffer.get(start) + "->");
			}
		}

	}
	
	public class CommonParent {
		
		/*approach 1*/
		public TreeNode findCommonParent1(TreeNode root, TreeNode a, TreeNode b) {
			assert(a==b):"Nodes are same";
			/*if both the node exists in the left of the root.*/
			if(findNode(root.getLeftNode(), a) && findNode(root.getLeftNode(),b)) {
				return findCommonParent1(root.getLeftNode(), a, b);
			}
			/*if both the node exists in the right of the root.*/
			if(findNode(root.getRightNode(), a) && findNode(root.getRightNode(),b)) {
				return findCommonParent1(root.getRightNode(), a, b);
			}
			return root;
		}
		/*check if node is child of the give node*/
		private boolean findNode(TreeNode root, TreeNode a) {
			if(root == null) {
				return false;
			}
			if(root == a) {
				return true;
			}
			return findNode(root.getLeftNode(),a) || findNode(root.getRightNode(), a); 
		}
		
		
		
	}
	
	

}
