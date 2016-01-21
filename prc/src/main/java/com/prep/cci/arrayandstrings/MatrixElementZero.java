package com.prep.cci.arrayandstrings;

import java.util.HashSet;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
 */
public class MatrixElementZero {
	/**
	 * Function finds matrix elements as zero and then sets rows and columns as zero.
	 * 
	 * @param arr
	 */
	public void setZeros(Integer[][] arr) {
		assert (arr == null) : "Input array is null";
		HashSet<Integer> rows = new HashSet<Integer>();
		HashSet<Integer> cols = new HashSet<Integer>();
		outer: for (int i = 0; i < arr.length; i++) {
			inner: for (int j = 0; j < arr[i].length; j++) {
				/*if (rows.contains(i)) {
					continue outer;
				} else if (cols.contains(j)) {
					continue inner;
				}*/
				if (arr[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				/*if (rows.contains(i)) {
					arr[i][j] = 0;
				} 
				else {
					continue;
				}*/
				if (rows.contains(i)) {
					arr[i][j] = 0;
				} else if (cols.contains(j)) {
					arr[i][j] = 0;
				}
				/*if (cols.contains(j)) {
					arr[i][j] = 0;
				}*/
			}
		}

	}

}
