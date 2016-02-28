package com.prep.geekforgeek;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.prep.geekforgeek.ArrQst;

public class ArrQstTest {
	ArrQst tesclass = new ArrQst();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void testsubsequence() {
		tesclass.subsequence();
	}
	@Test
	public void testcountIncreasingSubArrays() {
		//int arr[] = {12,15,16,10,11};
		int arr[] = {12,15,16,17,18};
		tesclass.countIncreasingSubArrays(arr);
	}
	
}
