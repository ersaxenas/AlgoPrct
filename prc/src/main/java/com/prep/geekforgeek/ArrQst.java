package com.prep.geekforgeek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ArrQst {

	/**
	 * Subsequence and Programs to Generate them : A subbarray is a contiguous part of array. An array that is inside another array. For example, consider the array [1, 2, 3, 4],
	 * There are 10 non-empty sub-arrays. The subbarays are (1), (2), (3), (4), (1,2), (2,3), (3,4), (1,2,3), (2,3,4) and (1,2,3,4). In general, for an array/string of size n,
	 * there are n*(n+1)/2 non-empty subarrays/subsrings. A subsequence is a sequence that can be derived from another sequence by zero or more elements, without changing the order
	 * of the remaining elements. For the same example, there are 15 sub-sequences. They are (1), (2), (3), (4), (1,2), (1,3),(1,4), (2,3), (2,4), (3,4), (1,2,3), (1,2,4), (1,3,4),
	 * (2,3,4), (1,2,3,4). More generally, we can say that for a sequence of size n, we can have (2n-1) non-empty sub-sequences in total.
	 */
	public void subsequence() {
		char arr[] = { 'a', 'b', 'c' };
		int cnt = 0;
		ArrayList<String> mainLst = new ArrayList<String>();
		while (cnt < arr.length) {
			char ch = arr[cnt++];
			ArrayList<String> lst = new ArrayList<String>();
			for (String sb : mainLst) {
				lst.add(sb + ch);
			}
			lst.add("" + ch);
			mainLst.addAll(lst);
		}
		System.out.println(mainLst);
	}

	/**
	 * Count Strictly Increasing Subarrays: An Efficient Solution can count subarrays in O(n) time. The idea is based on fact that a sorted sunarray of length ‘len’ adds
	 * len*(len-1)/2 to result. For example, {10, 20, 30, 40} adds 6 to the result.
	 * 
	 */
	public void countIncreasingSubArrays(int arr[]) {
		int cnt = 0;
		int len = 1;
		for (int i = 0; i <= arr.length - 1; i++) {
			if ((i + 1 <= arr.length - 1) && (arr[i + 1] >= arr[i])) { /* increasing so continue .. */
				len++;
				continue;
			} else {/* calculate count for increasing sequence */
				cnt = cnt + ((len * (len - 1)) / 2);
				len = 1;
			}
		}
		if (len > 1) {
			cnt = cnt + (len * ((len - 1) / 2));
		}
		System.out.println("Count:" + cnt);
	}

	/**
	 * Given a pattern containing only I’s and D’s. I for increasing and D for decreasing. Devise an algorithm to print the minimum number following that pattern. Digits from 1-9
	 * and digits can’t repeat.
	 * Examples:
	 * Input: D Output: 21 
	 * Input: I Output: 12 
	 * Input: DD Output: 321 
	 * Input: II Output: 123 
	 * Input: DIDI Output: 21435 
	 * Input: IIDDD Output: 126543 
	 * Input: DDIDDIID Output: 321654798
	 */              
	public void genSeq1(String strSeq){
		char arr[] = strSeq.toCharArray();
		StringBuilder resultSeq = new StringBuilder();
		int max = 1;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(max);
		for (int cnt = 0; cnt < arr.length; cnt++) {
			max++;
			if(arr[cnt] == 'I') {
				while(!stack.isEmpty()) {
					resultSeq.append(stack.pop());
				}
				stack.push(max);
			}
			else {
				stack.push(max);
			}
		}
		while(!stack.isEmpty()) {
			resultSeq.append(stack.pop());
		}
		System.out.println(resultSeq);
	}

	/**
	 * We are given two sorted array. We need to merge these two arrays such that the initial numbers (after complete sorting) are in the first array and the remaining numbers are
	 * in the second array. Extra space allowed in O(1).
	 * 
	 * Example:
	 * 
	 * Input: ar1[] = {1, 5, 9, 10, 15, 20}; ar2[] = {2, 3, 8, 13}; Output: ar1[] = {1, 2, 3, 5, 8, 9} ar2[] = {10, 13, 15, 20}
	 */
	public void mergeSortedArrays(Integer arr1[], Integer arr2[]){
		int l1,l2;
		for(int i=arr2.length-1; i>=0; i--) {
			l2 = arr2[i];
			l1 = arr1[arr1.length-1];
			if(l1 > l2) {
				arr1[arr1.length-1] = l2;
				arr2[i] = l1;
				sortLastElement(arr1);
			}
		}
		System.out.println(Arrays.asList(arr1).toString());
		System.out.println(Arrays.asList(arr2).toString());
	}
	private void sortLastElement(Integer arr[]) {
		int last = arr[arr.length-1];
		for(int i=arr.length-1; i>=0; i--) {
			if(arr[i]>last) {
				arr[arr.length-1] = arr[i];
				arr[i] = last;
				break;
			}
		}
	}

	/**
	 * Given two binary arrays arr1[] and arr2[] of same size n. Find length of the longest common span (i, j) where j >= i such that arr1[i] + arr1[i+1] + .. + arr1[j] = arr2[i] +
	 * arr2[i+1] + + arr2[j].
	 * 
	 * Expected time complexity is Θ(n).
	 * 
	 * Examples:
	 * 
	 * Input: arr1[] = {0, 1, 0, 0, 0, 0}; arr2[] = {1, 0, 1, 0, 0, 1}; Output: 4 The longest span with same sum is from index 1 to 4.
	 * 
	 * Input: arr1[] = {0, 1, 0, 1, 1, 1, 1}; arr2[] = {1, 1, 1, 1, 1, 0, 1}; Output: 6 The longest span with same sum is from index 1 to 6.
	 * 
	 * Input: arr1[] = {0, 0, 0}; arr2[] = {1, 1, 1}; Output: 0
	 * 
	 * Input: arr1[] = {0, 0, 1, 0}; arr2[] = {1, 1, 1, 1}; Output: 1
	 */
	public void longestSum(Integer arr1[], Integer arr2[]) {
		int maxLen = 0,start=0,end=0;
		for(int i=0; i<arr1.length; i++) {
			int sum1=0, sum2=0;
			for(int j=i;j<arr2.length;j++) {
				sum1 = sum1+arr1[j];
				sum2 = sum2+arr2[j];
				if((sum1==sum2)&&((j-i+1)>maxLen)) {
					maxLen = (j-i+1);
					start=i;
					end=j;
				}
			}
		}
		System.out.println("Start:"+start+", end:"+end+", max length"+maxLen);
	}
	
}
