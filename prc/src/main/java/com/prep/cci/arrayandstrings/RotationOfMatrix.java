package com.prep.cci.arrayandstrings;
/**
 *  Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 *  a). Take another matrix of same size and move 1 to n rows to n to 1 column.
 *  b). To rotate in place rotate by layer. First move four corners and then next element to each corner and so on.
 *  
 */
public class RotationOfMatrix {
    /**
     * Function rotates 2 dimensional array by 90 degree. It assumes array is NxN matrix.
     * @param arr
     * @param size
     */
	public void rotate(Object[][] arr, int size) {
	 	int N = size;
	 	for(int i=0;i<N/2;i++) { /*loop 1 for each layer*/
	 		for(int j=i; j<(N-i-1); j++) { /*Loop 2 */
	 			Object x = arr[i][j];
	 			arr[i][j] = arr[(N-1-j)][i];
	 			arr[(N-1-j)][i] = arr[(N-1-i)][(N-1-j)];
	 			arr[(N-1-i)][(N-1-j)] = arr[j][(N-1-i)];
	 			arr[j][(N-1-i)] = x;
	 		}
	 	}
	}
	/**
	 * Function prints NxN matrix on console.
	 * @param arr
	 */
	public void printMatrix(Object[][] arr, int size) {
		System.out.println("\n");
		 for(int i=0; i<size; i++) {
	    	  for(int j=0; j<size; j++) {
	    		  System.out.print(" "+arr[i][j].toString()+" ");    		  
	    	  }
	    	  System.out.println("\n");
	      }
	}

}
