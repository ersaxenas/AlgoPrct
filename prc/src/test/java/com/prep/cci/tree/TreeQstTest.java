package com.prep.cci.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.prep.cci.tree.TreeQst.BTFromArray;
import com.prep.cci.tree.TreeQst.BTNodesFetch;
import com.prep.cci.tree.TreeQst.BalanceTreeCheck;

public class TreeQstTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void testBalanceTreeCheck() {
		BalanceTreeCheck testClass = new BalanceTreeCheck();
		BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
		tree.put(10, "10");
		tree.put(5, "5");
		tree.put(15, "15");
		tree.put(3, "3");
		tree.put(4, "4");
		tree.put(12, "12");
		tree.put(20, "20");
		if(testClass.checkIfBalancedTree(tree.getRoot()))
		{
			System.out.println("Tree is balanced");
		}
		else {
			System.out.println("Tree is not balanced");
		}
		
		tree.put(30, "30");
		tree.put(40, "40");
		tree.put(50, "50");
		if(testClass.checkIfBalancedTree(tree.getRoot()))
		{
			System.out.println("Tree is balanced");
		}
		else {
			System.out.println("Tree is not balanced");
		}
	}
	
	@Test
	@Ignore
	public void testBTFromArray() {
		BTFromArray testClass = new BTFromArray();
		Integer arr[] = {2,5,7,9,10,12,14,16,17,18,19,20,23,25};
		testClass.createBT(arr);
		System.out.println("Test finished.");
	}
	
	@Test
	public void testBTNodesFetch() {
		BTNodesFetch testClass = new BTNodesFetch();
		BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
		tree.put(10, "10");
		tree.put(5, "5");
		tree.put(15, "15");
		tree.put(3, "3");
		tree.put(4, "4");
		tree.put(12, "12");
		tree.put(20, "20");
		tree.put(30, "30");
		tree.put(40, "40");
		tree.put(50, "50");
		testClass.createNodeList(tree.getRoot());
		System.out.println("Test finished.");
	}

}
