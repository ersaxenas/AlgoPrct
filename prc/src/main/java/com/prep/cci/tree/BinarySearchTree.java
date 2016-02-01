package com.prep.cci.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree<K extends Comparable<K>, V> {
	
	private TreeNode root;
	
	public TreeNode getRoot() {
		return root;
	}
	
	/**
	 * Function puts key, value pair in the Tree.
	 * It replaces existing value if key is already present else it adds the key. 
	 * @param key
	 * @param val
	 */
	public void put(K key, V val) {
		System.out.println("Inserting :("+key+","+val+")" );
		root = put(root, key, val,null);
	}
	/**
	 * Function recursive lively adds a key and value to the tree.
	 * It also updates the size of the nodes visited.
	 * @param root
	 * @param key
	 * @param val
	 * @return root of the tree.
	 */
	private TreeNode put(TreeNode root,K key, V val, TreeNode parent) {
		TreeNode x = root;
        if(x == null) {
        	TreeNode node = new TreeNode(key,val);
        	node.count = 1;
        	node.parent = parent;
        	return node;
        }
		int cmp = key.compareTo((K) x.getKey());
		if(cmp < 0) {
			x.setLeftNode(put(x.getLeftNode(), key, val, x));
		}
		else if (cmp > 0) {
			x.setRightNode(put(x.getRightNode(), key, val,x));
		}
		else {
			x.setVal(val);
		}
		x.setCount(1+size(x.getLeftNode())+size(x.getRightNode()));
		return x;
	}
	
	/**
	 * Function searches in the tree for the key and returns the value if key is found
	 * in the tree.
	 * @param key
	 * @return Value of the key or null.
	 */
	public V getValue(K key) {
		TreeNode x = root;
		while(x != null) {
		   int cmp = key.compareTo((K) x.getKey());
		   if(cmp < 0) {
			x = x.getLeftNode();   
		   }
		   else if(cmp > 0) {
		    x = x.getRightNode();
		   }
		   else {
			   return (V) x.getVal();
		   }
		}
		return null;
	}
	
	/**
	 * Function searches in the tree for the key and returns the TreeNode if key is found
	 * in the tree.
	 * @param key
	 * @return TreeNode  or null.
	 */
	public TreeNode getNode(K key) {
		TreeNode x = root;
		while(x != null) {
		   int cmp = key.compareTo((K) x.getKey());
		   if(cmp < 0) {
			x = x.getLeftNode();   
		   }
		   else if(cmp > 0) {
		    x = x.getRightNode();
		   }
		   else {
			   return x;
		   }
		}
		return null;
	}
	
	/**
	 * Function checks if key is present in the tree or not.
	 * If key is found then it returns true else false.
	 * @param key
	 * @return True/False.
	 */
	public boolean contains(K key){
		return (getValue(key) != null);
	}
	/**
	 * Function deletes a key from the tree.
	 * @param key
	 */
	public void delete(K key) {
		root = delete(root, key);
	}
	/**
	 * Function iterates through the three and deletes the key.
	 * It also recalculates the size of the nodes visited. 
	 * @param x
	 * @param key
	 * @return
	 */
	private TreeNode delete(TreeNode x, K key) {
		if(x == null) {
			return null;
		}
		int cmp = key.compareTo((K) x.key);
		if(cmp<0) {
			x.leftNode  = delete(x.leftNode, key);
		}
		else if(cmp>0) {
			x.rightNode = delete(x.rightNode, key);
		}
		else {
			if(x.leftNode == null){
				return x.rightNode;
			}
			if(x.rightNode == null) {
				return x.leftNode;
			}
			
			TreeNode t = x;
			x = min(t.rightNode);
			x.rightNode = delMin(t.rightNode);
			x.leftNode = t.leftNode;
			x.count = 1 + size(x.leftNode) + size(x.rightNode);
		}
		return x;
	}
	/**
	 * Function deletes minimum key from the tree.
	 */
	public void delMin() {
		root = delMin(root);
	}
	/**
	 * Function deletes minimum key fro the tree and returns the new root.
	 * @param x
	 * @return
	 */
	private TreeNode delMin(TreeNode x) {
		if(x.leftNode == null) {
			return x.rightNode;
		}
		x.leftNode = delMin(x.leftNode);
		x.count = 1 + size(x.leftNode) + size(x.rightNode);
		return x;
	}
	/**
	 * Function finds and returns the minimum key from the tree.
	 * @return
	 */
	public V getMin() {
		return (V) min(root).getVal();
	}
	/**
	 * Function recursively finds minimum key from the tree.
	 * @param x
	 * @return
	 */
	private TreeNode min(TreeNode x) {
		if(x.leftNode == null) {
			return x;
		}
		return min(x.leftNode);
	}
	/**
	 * Function deletes maximum key from the tree.
	 */
	public void delMax() {
		root = delMax(root);
	}
	/**
	 * Function recursively finds maximum key from the tree and deletes it.
	 * @param x
	 * @return
	 */
	private TreeNode delMax(TreeNode x) {
		if(x.rightNode == null) {
			return x.leftNode;
		}
		x.rightNode = delMax(x.rightNode);
		x.count = 1 + size(x.leftNode) + size(x.rightNode);
		return x;
	}
	
	/**
	 * Function iterates through the tree, pull all the keys in a queue and returns the queue as iterator. 
	 * @return
	 */
	public Iterable<K> iterator() {
		Queue<K> queue = new ArrayDeque<K>();
		inorder(root, queue);
		return queue;
	}
	/**
	 * Function first iterates the left and then iterates the right nodes of the tree and keeps adding nodes to queue.
	 * 
	 * @param x
	 * @param queue
	 */
	private void inorder(TreeNode x, Queue<K> queue) {
		if(x == null) {
			return;
		}
		inorder(x.leftNode,queue);
		queue.add((K) x.key);
		inorder(x.rightNode, queue);
	}
	
	public V floor(K key) {
		TreeNode x = floor(root, key);
		if(x==null) {
			return null;
		}
		return (V) x.getVal();
	}
	
	private TreeNode floor(TreeNode root, K key) {
		TreeNode x = root;
		if(x==null) {return null;}
		int cmp = key.compareTo((K) x.getKey());
		if(cmp == 0) {
			return x;
		}
		else if(cmp < 0) {
		     return floor(x.getLeftNode(), key);
		}
		
		TreeNode t = floor(x.getRightNode(),key);
		if(t != null) {
			return t;
		}
		else {
			return x;
		}
	}
	/**
	 * Function returns current size of the tree.
	 * @return
	 */
	public int size() {
		return size(root);
	}
	/**
	 * Function finds the current size of the tree.
	 * @param x
	 * @return
	 */
	private int size(TreeNode x) {
		if(x == null) {
			return 0;
		}
		return x.getCount();
	}
	/**
	 * function finds the rank of a key in tree.
	 * @param key
	 * @return
	 */
	public int rank(K key) {
		return rank(key, root);
	}
	/**
	 * function finds rank of a give key from the node.
	 * @param key
	 * @param x
	 * @return
	 */
   private int rank(K key, TreeNode x) {
		if(x == null) return 0;
		int cmp = key.compareTo((K) x.getKey());
		if(cmp<0) {
			return rank(key, x.getLeftNode());
		}
		else if(cmp>0) {
			return (1 + size(x.getLeftNode()) + rank(key, x.getRightNode())); 
		}
		else {
			return size(x.leftNode);
		}
	}

   /**
    * Function finds the number of keys within range key1 to key2.
    * @param key1
    * @param key2
    * @return
    */
   public int size(K key1, K key2) {
	   assert(key1 != null);
	   assert(key2 != null);
	   assert(key2.compareTo(key1) > 0);
	   int sz = 0;
	   if(contains(key2)) {
		   sz = rank(key2) - rank(key1) + 1;
	   }
	   else {
		   sz = rank(key2) - rank(key1);
	   }
	   return sz;
   }
   /**
    * Function finds keys in the given range.
    * @param key1
    * @param key2
    * @return
    */
   public Iterable<K> findKeyInRange(K key1, K key2) {
	   Queue<K> queue = new ArrayDeque<K>();
	   findKeyInRange(key1, key2, queue, root);	   
	   return queue;
   }
   /**
    * Function finds keys within provided range startig from the give node.
    * @param key1
    * @param key2
    * @param queue
    * @param x
    */
   private void findKeyInRange(K key1, K key2, Queue<K> queue, TreeNode x) {
	   if(x==null) {return;};
	   int cmp1 = key1.compareTo((K) x.key);
	   if(cmp1 <= 0) {
		   findKeyInRange(key1, key2, queue, x.leftNode);
	   }
	   int cmp2 = key2.compareTo((K) x.key);
	   if(cmp2 >= 0) {
		   findKeyInRange(key1, key2, queue, x.rightNode);
	   }
	 
	   if((cmp1 <= 0) && (cmp2 >= 0)) {
		   queue.add((K) x.key);
	   }
	   
   }
}
