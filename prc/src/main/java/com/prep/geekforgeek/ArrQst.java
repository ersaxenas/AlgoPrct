package com.prep.geekforgeek;

import java.util.ArrayList;
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
}
