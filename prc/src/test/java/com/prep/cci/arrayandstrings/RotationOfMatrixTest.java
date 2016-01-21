package com.prep.cci.arrayandstrings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RotationOfMatrixTest {
	RotationOfMatrix testClass = new RotationOfMatrix();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRotate() {
		 String arr[][] = new String[5][5];
	      char ch = 'a';
	      for(int i=0; i<5; i++) {
	    	  for(int j=0; j<5; j++) {
	    		  arr[i][j] = ""+ch++;    		  
	    	  }
	      }
	      testClass.printMatrix(arr, 5);
	      testClass.rotate(arr, 5);
	      testClass.printMatrix(arr,5);
	}

}
