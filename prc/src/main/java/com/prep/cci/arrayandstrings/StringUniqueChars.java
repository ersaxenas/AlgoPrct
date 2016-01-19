package com.prep.cci.arrayandstrings;

import java.util.Arrays;

/**
 * Implement an algo to determine if all the chars in the string are unique. What if cannot use additional data structure.
 * 1. take an array of boolean arr[] and initialize it with false now take ascii of char set arr['char'] = true; if chars repeats then arr['char'] will already be true.
 * 2. Sort the string and then compare each char with the next to find duplicates.
 * 3. take every char of the string and try to find if it exists in the rest of the string. This may take quadratic time O(n^2)
 * Remove duplicates from a string.
 * 
 */
public class StringUniqueChars {
	/**
	 * Function find duplicates using boolean array.
	 * Complexity O(n^2)
	 * @param str
	 * @return True - if unique / false - if duplicate
	 */
	public boolean findDuplicatesChars1(String str) {
	   boolean arr[] = new boolean[256];
	   Arrays.fill(arr, false);
	   for(int cnt=0;cnt<str.length();cnt++) {
		   char ch = str.charAt(cnt);
		   if(!arr[ch]) {
			   arr[ch] = true;
		   }
		   else {
			   System.out.println("Duplicate char found:"+ch);
			   return false;
		   }
	   }
	   System.out.println("String '"+str+"' contains unique chars");
	   return true;
	}
	/**
	 * Function find duplicates. It first sorts and then compares each char with the next char.
	 * Complexity O(n) - Linear time but take additional space.
	 * @param str
	 * @return True - if unique / false - if duplicate
	 */
	public boolean findDuplicatesChars2(String str) {
		char arr[] = str.toCharArray();
		Arrays.sort(arr);
		for(int i=0;i<arr.length-2;i++) {
			if(arr[i] == arr[i+1]) {
				 System.out.println("Duplicate char found:"+arr[i]);
				return false;
			}
		}
		System.out.println("String '"+str+"' contains unique chars");
		return true;
	}
	
	/**
	 * Function removes duplicate chars from a string
	 * @param str
	 * @return String containing unique chars.
	 */
	public String removeDuplicateChars1(String str) {
		assert (str != null):"Null input";
		assert (str.length() < 2):"Input string is too short";
		char []arr = str.toCharArray();
		int tail =1, j=0;
		for(int i=1; i<arr.length; i++) {
			for(j=0; j<tail; j++) {
				if(arr[i] == arr[j]){
					break;
				}
			}
			if(tail == j) {
				arr[tail] = arr[i];
				tail++;
			}
		}
		return new String(Arrays.copyOf(arr, tail));
	}
	/**
	 * Function removes duplicate chars from string. It uses addition space to remove track duplicates.
	 * @param str
	 * @return String containing unique chars.
	 */
	public String removeDuplicateChars2(String str) {
		assert (str != null):"Null input";
		assert (str.length() < 2):"Input string is too short";
		char []arr = str.toCharArray();
		int tail =0;
		boolean chars[] = new boolean[256];
		Arrays.fill(chars, false);
		for(int i=0; i<arr.length; i++) {
			if(!chars[arr[i]]) {
				chars[arr[i]] = true;
				arr[tail] = arr[i];
				tail++;
			}
		}
		return new String(Arrays.copyOf(arr, tail));
	}
	

}
