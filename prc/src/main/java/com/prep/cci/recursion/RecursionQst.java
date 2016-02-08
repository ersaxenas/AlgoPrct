package com.prep.cci.recursion;

import java.awt.Color;
import java.util.ArrayList;

public class RecursionQst {
	/**
	 * Function generates Fibonacci recursively.
	 * 
	 * @param n
	 * @return
	 */
	public int generateFibonacciNumber1(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n < 0) {
			return -1;
		}
		return generateFibonacciNumber1(n - 1) + generateFibonacciNumber1(n - 2);
	}

	/**
	 * Function generates Fibonacci iteratively.
	 * 
	 * @param n
	 * @return
	 */
	public int generateFabonachiNumber2(int n) {
		if (n < 0) {
			return -1;
		}
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int a = 1, b = 1, c = 0;

		for (int i = 3; i <= n; i++) {
			c = a + b;
			b = c;
			a = b;
		}
		return b;
	}

	/**
	 * Function generates subsets of integers.
	 * 
	 * @param set
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> set) {
		assert (set == null) : "Set is null";

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		for (Integer elem : set) {
			ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();

			/* copy existing sets from result to tmp */
			for (ArrayList<Integer> lst : result) {
				ArrayList<Integer> nLst = new ArrayList<Integer>(lst);
				nLst.add(elem);
				tmp.add(nLst);
			}
			/* Add elem to tmp list */
			ArrayList<Integer> lst = new ArrayList<Integer>();
			lst.add(elem);
			tmp.add(lst);
			result.addAll(tmp);
		}
		return result;
	}

	/**
	 * Function generates subsets of integers.
	 * 
	 * @param set
	 * @param index
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> emptyLst = new ArrayList<Integer>();
			allsubsets.add(emptyLst); /* empty list will help form subgroup of single element */
		} else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> tmpSubSet = new ArrayList<ArrayList<Integer>>();
			for (ArrayList subgrp : allsubsets) { /* for each existing subgroups create add item and create new subgrp */
				ArrayList<Integer> lst = new ArrayList<Integer>(); /* new sub group */
				lst.addAll(subgrp); /* add all existing elements to group */
				lst.add(item); /* add new element to subgroup */
				tmpSubSet.add(lst); /* add group to subgroup list and move to next subgroup; */
			}/* element added to all existing sub group in tmpSubSet */
			allsubsets.addAll(tmpSubSet); /* Merge with original subgroup list. */
		}
		return allsubsets;
	}

	/**
	 * Function generates anagrams of string.
	 * 
	 * @param s
	 * @return
	 */
	public ArrayList<String> getAnagrams(String s) {
		ArrayList<String> permutations = new ArrayList<String>();
		if (s == null) {
			return null;
		} else if (s.length() == 0) {
			permutations.add("");
			return permutations;
		}
		char ch = s.charAt(0);
		String rem = s.substring(1);
		ArrayList<String> wordList = getAnagrams(rem);
		for (String word : wordList) {
			/* add ch at each possible position in word starting from 0 to word length */
			for (int indx = 0; indx <= word.length(); indx++) {
				permutations.add(insertCharAt(word, ch, indx));
			}
		}
		return permutations;
	}

	private String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}

	/**
	 * Function prints out all left right parentheses combinations/
	 * 
	 * @param left
	 * @param right
	 * @param str
	 * @param count
	 */
	private void paranthesesCombinations(int left, int right, char[] str, int count) {
		if (left < 0 || right < left)
			return; // invalid state
		if (left == 0 && right == 0) {
			System.out.println(str); // found one, so print it
			System.out.println("Stack->left:" + left + ", right:" + right);
		} else {
			if (left > 0) { // try a left paren, if there are some available
				str[count] = '(';
				paranthesesCombinations(left - 1, right, str, count + 1);
			}
			if (right > 0) { // try a right paren, if there’s a matching left
				str[count] = ')';
				paranthesesCombinations(left, right - 1, str, count + 1);
			}
			System.out.println("Stack->left:" + left + ", right:" + right);
		}
	}

	public void printPar(int count) {
		char[] str = new char[count * 2];
		paranthesesCombinations(count, count, str, 0);
	}

	/**
	 * Implement the “paint fill” function that one might see on many image editing pro- grams That is, given a screen (represented by a 2-dimensional array of Colors), a point,
	 * and a new color, fill in the surrounding area until you hit a border of that color
	 * 
	 * @param arr
	 * @param x
	 * @param y
	 * @param originalColor
	 * @param newColor
	 */
	public void fillImage(Color arr[][], int x, int y, Color originalColor, Color newColor) {
		if (x < 0 || x > arr[0].length || y < 0 || y > arr.length) {
			return;
		}
		if (arr[x][y] == originalColor) {
			arr[x][y] = newColor;
			fillImage(arr, x + 1, y, originalColor, newColor);
			fillImage(arr, x, y + 1, originalColor, newColor);
			fillImage(arr, x - 1, y, originalColor, newColor);
			fillImage(arr, x, y - 1, originalColor, newColor);
		}
	}

}
