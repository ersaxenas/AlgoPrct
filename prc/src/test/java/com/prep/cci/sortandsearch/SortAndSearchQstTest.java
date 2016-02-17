package com.prep.cci.sortandsearch;

import static org.junit.Assert.fail;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.prep.sortandsearch.SortAndSearchQst;

public class SortAndSearchQstTest {
	SortAndSearchQst testClass = new SortAndSearchQst();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void testMergeTwoArrays() {
		int arr1[] = {5,6,7,8,9,0,0,0,0};
		int arr2[] = {1,2,3,4};
		testClass.mergeTwoArrays(arr1, arr2, 4);
		System.out.println("Test completed.");
	}
	
	@Test
	@Ignore
	public void testanagramNextToEachOther() {
		String arr1[] = {"god", "dog", "abc", "cab", "man"};
		System.out.println(Arrays.asList(arr1));
		testClass.anagramNextToEachOther(arr1);
		System.out.println(Arrays.asList(arr1));
		System.out.println("Test completed.");
	}
	
	@Test
	@Ignore
	public void testfindElementInRotatedArray() {
		int arr1[] = {7,8,9,1,2,3,4,5,6};
		int elem = 1;
		Assert.assertEquals(elem, arr1[testClass.findElementInRotatedArray(arr1, elem)]);
		System.out.println("Test completed.");
	}
	
	@Test
	@Ignore
	public void testsearchString() {
		String arr1[] = {"aaa", "", "", "aab", "aac","","","","","","","aad","","","aae","","","aaf","","","","aag","",""};
		System.out.println(testClass.searchString(arr1, "aac"));
		System.out.println("Test completed.");
	}
	@Test
	public void testfindElemSortedMatrix() {
		int arr1[][] = { 
				{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
              };
		testClass.findElemSortedMatrix(arr1, 4,27);
		System.out.println("Test completed.");
	}
}
