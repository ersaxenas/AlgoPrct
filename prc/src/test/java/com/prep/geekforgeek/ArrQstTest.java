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
	@Ignore
	public void testcountIncreasingSubArrays() {
		//int arr[] = {12,15,16,10,11};
		int arr[] = {12,15,16,17,18};
		tesclass.countIncreasingSubArrays(arr);
	}
	@Test
	@Ignore
	public void testgenSeq1() {
		tesclass.genSeq1("IDID");
		tesclass.genSeq1("I");
		tesclass.genSeq1("DD");
		tesclass.genSeq1("II");
		tesclass.genSeq1("DIDI");
		tesclass.genSeq1("IIDDD");
		tesclass.genSeq1("DDIDDIID");
	}
	
	@Test
	@Ignore
	public void testmergeSortedArrays() {
		Integer arr1[] = {2,5,7,45,56};
		Integer arr2[] = {4,8,34,97};
		tesclass.mergeSortedArrays(arr1, arr2);
	}
	
	@Test
	public void testlongestsum() {
		Integer arra1[] = {0, 1, 0, 0, 0, 0};
		Integer arra2[] = {1, 0, 1, 0, 0, 1};
		Integer arrb1[] = {0, 1, 0, 1, 1, 1, 1}; 
		Integer arrb2[] = {1, 1, 1, 1, 1, 0, 1};
		Integer arrc1[] = {0, 0, 0}; 
		Integer arrc2[] = {1, 1, 1}; 
		Integer arrd1[] = {0, 0, 1, 0}; 
		Integer arrd2[] = {1, 1, 1, 1}; 
		tesclass.longestSum(arra1, arra2);
		tesclass.longestSum(arrb1, arrb2);
		tesclass.longestSum(arrc1, arrc2);
		tesclass.longestSum(arrd1, arrd2);
	}
	
}
