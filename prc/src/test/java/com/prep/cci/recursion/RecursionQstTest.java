package com.prep.cci.recursion;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RecursionQstTest {
	RecursionQst testClass = new RecursionQst();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void testGenerateFibonacciNumber1() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGenerateFabonachiNumber2() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testSubsets() {
	      ArrayList<Integer> lst = new ArrayList<Integer>();
	      lst.add(1);
	      lst.add(2);
	      lst.add(3);
	      System.out.println(testClass.subsets(lst)); 
	}

	@Test
	@Ignore
	public void testGetAnagrams() {
      System.out.println(testClass.getAnagrams("abcd")); 
	}
	
	@Test
	@Ignore
	public void testPrintPar() {
      testClass.printPar(2); 
	}
	@Test
	public void testGetDenom() {
      System.out.println(testClass.getDenom(12, 10));
	}

}
