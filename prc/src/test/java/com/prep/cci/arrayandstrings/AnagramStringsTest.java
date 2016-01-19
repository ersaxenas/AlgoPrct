package com.prep.cci.arrayandstrings;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnagramStringsTest {
	
	AnagramStrings testClass = new AnagramStrings();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckIfAnagram1() {
		assertTrue("Anagram test failed", testClass.checkIfAnagram1("fiber", "brief"));
		assertFalse("Anagram test failed", testClass.checkIfAnagram1("forth", "freak"));
	}

	@Test
	public void testCheckIfAnagram2() {
		assertTrue("Anagram test failed", testClass.checkIfAnagram1("fiber", "brief"));
		assertFalse("Anagram test failed", testClass.checkIfAnagram1("forth", "freak"));
	}

}
