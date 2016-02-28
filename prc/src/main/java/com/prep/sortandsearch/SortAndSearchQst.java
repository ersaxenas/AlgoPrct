package com.prep.sortandsearch;

import java.util.Arrays;
import java.util.Comparator;

public class SortAndSearchQst {

	/**
	 * You are given two sorted arrays, A and B, and A has a large enough bufer at the end to hold B Write a method to merge B into A in sorted order.
	 * 
	 * @param arr1
	 * @param arr2
	 */
	public void mergeTwoArrays(int arr1[], int arr2[], int lastElem) {
		assert (arr1 == null || arr2 == null) : "Array is null";
		assert (arr1.length == arr2.length) : "arrays are of equal size";
		int x = arr1.length - 1;
		int y = lastElem; /* index of last element of array1 */
		int z = arr2.length - 1; /* index of last element of array1 */
		while (x >= 0) {
			if (y == -1 && z >= 0) {
				arr1[x--] = arr2[z--];
			} else if (z == -1 && y >= 0) {
				arr1[x--] = arr1[y--];
			} else if (arr1[y] > arr2[z]) {
				arr1[x--] = arr1[y--];
			} else {
				arr1[x--] = arr2[z--];
			}
		}
	}

	/**
	 * Write a method to sort an array of strings so that all the anagrams are next to each other
	 * 
	 * @param arr
	 * @return
	 */
	public String[] anagramNextToEachOther(String arr[]) {
		Comparator<String> anacomp = new Comparator<String>() {
			String sort(String str) {
				char arr[] = str.toCharArray();
				Arrays.sort(arr);
				return new String(arr);
			}

			@Override
			public int compare(String o1, String o2) {
				return sort(o1).compareTo(sort(o2));
			}
		};

		Arrays.sort(arr, anacomp);
		return arr;
	}

	/**
	 * Given a sorted array of n integers that has been rotated an unknown number of times, give an O(log n) algorithm that fnds an element in the array 
	 * @param arr
	 * @param key
	 * @return
	 */
	public int findElementInRotatedArray(int arr[], int key) {
		assert (arr == null) : "Array is null";
		int lo = 0;
		int hi = arr.length - 1;
		int mid = 0;
		
		/*
		 * Notes: if a sorted array is rotated and if we divide it in half at-least one half will be fully sorted.
		 */
		while (lo <= hi) { /* low should always be less then high */
			 /* Avoid overflow, same as M=(L+R)/2 */
			mid = lo + ((hi - lo) / 2);
			if(arr[mid] == key) { /*if element found */
				return mid;
			}
			if (arr[lo] <= arr[mid]) { /* first half is sorted */
				if (arr[lo] < key && key < arr[mid]) { /* if key is in sorted first half */
                   /*search in first half, move upper bound to mid -1 */
					hi = mid-1;
				} else {/* if key is in unsorted second half */
					 /*search in second half, move lower bound to mid +1*/
                    lo =  mid +1;
				}
			} else { /* second half is sorted. */
				if (arr[mid] < key && key < arr[hi]) { /* if key is in sorted second half */
					/*search in second half*/
					lo =  mid +1;
				} else {/* if key is in unsorted first half */
					 /*search in first half*/
					hi = mid-1;
				}
			}
		}
		return -1;/*not found*/
	}
	
	public int searchString(String arr[], String str) {
		assert (arr == null) : "Array is null";
		int lo = 0;
		int hi = arr.length - 1;
		int mid = 0;
		
		while(lo <= hi) { /* low should always be less then high */
		/*bring upper bound to a non blank string*/
			while(lo <= hi && arr[hi].equalsIgnoreCase("")) {
				hi--;
			}
			/* Avoid overflow, same as M=(L+R)/2 */
			mid = lo + ((hi - lo) / 2);
			/*bring mid to a non blank string*/
			while(arr[mid].equalsIgnoreCase("")) {
				mid++;
			}
			int cmp = arr[mid].compareTo(str);
			if(cmp<0) {
				/*go to left*/
				lo = mid+1;
			} else if(cmp>0) {
				hi = mid-1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	
	public void findElemSortedMatrix(int arr[][], int N, int elem) {
		int row = 0;
		int col = N-1;
		/*Start diagonally and go down.*/
          while(row < N && col >-1) {
        	  if(arr[row][col] == elem) {
        		  System.out.println("element found at"+row+"x"+col);
        		  return;
        	  }
        	  else if(arr[row][col] > elem) { /*col element is greater then elem so ignore whole column*/
        		  col--;
        	  }
        	  else {/*keep searching in the current row.*/
        		  row++;
        	  }
          }
		System.out.println("Element not found.");
	}
	

}
