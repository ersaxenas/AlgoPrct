package com.prep.util;
/**
 * Class defines helper function. 
 *  
 */
public class CollectionUtils {
	/**
	 * Function prints NxN matrix on console.
	 * @param two dimensional array of integer
	 */
	public static void printMatrix(Object[][] arr) {
		System.out.println("\n");
		 for(int i=0; i<arr.length; i++) {
	    	  for(int j=0; j<arr[i].length; j++) {
	    		  System.out.print(" "+arr[i][j].toString()+" ");    		  
	    	  }
	    	  System.out.println("\n");
	      }
	}
}
