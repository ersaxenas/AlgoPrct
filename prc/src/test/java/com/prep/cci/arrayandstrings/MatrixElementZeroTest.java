package com.prep.cci.arrayandstrings;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prep.util.CollectionUtils;

public class MatrixElementZeroTest {
	MatrixElementZero testClass = new MatrixElementZero();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetZeros() {
		Integer arr[][] = new Integer[5][5];
		Random ran = new Random();
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = ran.nextInt(20);
			}
		}
		CollectionUtils.printMatrix(arr);
		long start = System.currentTimeMillis();
		testClass.setZeros(arr);
		long end = System.currentTimeMillis();
		CollectionUtils.printMatrix(arr);
		System.out.println("Execution time:" + (end-start));
	}

}
