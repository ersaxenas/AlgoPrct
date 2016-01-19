package com.prep.cci.arrayandstrings;

import java.util.Arrays;

public class AnagramStrings {

	/**
	 * Function checks if two strings are anagrams. Function sorts and then compares two strings.
	 * 
	 * @param str1
	 * @param str2
	 * @return True /False
	 */
	public boolean checkIfAnagram1(String str1, String str2) {
		assert (str1 == null) : "Input is null";
		assert (str2 == null) : "Input is null";
		assert (str1.length() != str2.length()) : "Strings must be of same length to be anagram.";

		char arr1[] = str1.toCharArray();
		char arr2[] = str2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		String a = new String(arr1);
		String b = new String(arr2);
		return a.equals(b);
	}

	/**
	 * Function checks if two strings are anagrams.
	 * @param str1
	 * @param str2
	 * @return True /False
	 */
	public boolean checkIfAnagram2(String str1, String str2) {
		assert (str1 == null) : "Input is null";
		assert (str2 == null) : "Input is null";
		assert (str1.length() != str2.length()) : "Strings must be of same length to be anagram.";
		/*
		 * Two string will have same no. of unique chars. If we counts no. of unique chars then if anagram then count for each char will be even.
		 */
		int chars[] = new int[256];
		int uniqueChar = 0;
		Arrays.fill(chars, 0);
		for (char ch : str1.toCharArray()) {
			chars[ch]++;
			if (chars[ch] == 0) {
				uniqueChar++;
			}
		}
		int i=0;
		for (char ch : str2.toCharArray()) {
			if (chars[ch] == 0) {
				return false;
			}
			chars[ch]--;
			if (chars[ch] == 0) {
				uniqueChar--;
				if(uniqueChar == 0) {
					return (i == (str2.length() -1));
				}
			}
			i++;
		}
     return false;
	}

}
