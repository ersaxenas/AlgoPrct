package com.prep.cci.arrayandstrings;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringUniqueCharsTest {
	
	StringUniqueChars testClass = new StringUniqueChars();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindDuplicatesChars1() {
		assertTrue("Unique chars check", testClass.findDuplicatesChars1("length"));
		assertFalse("Duplicate char check", testClass.findDuplicatesChars1("seen"));
	}

	@Test
	public void testFindDuplicatesChars2() {
		assertTrue("Unique chars check", testClass.findDuplicatesChars2("length"));
		assertFalse("Duplicate char check", testClass.findDuplicatesChars2("seen"));
	}

	@Test
	public void testRemoveDuplicateChars() {
		String str;
		str = testClass.removeDuplicateChars1("Duplicatecharcheck");
		assertTrue("Unique chars check", testClass.findDuplicatesChars2(str));
		str = testClass.removeDuplicateChars1("abcd");
		assertTrue("Unique chars check", testClass.findDuplicatesChars2(str));
		str = testClass.removeDuplicateChars1("aaaa");
		assertTrue("Unique chars check", testClass.findDuplicatesChars2(str));
		str = testClass.removeDuplicateChars1("aaaabbb");
		assertTrue("Unique chars check", testClass.findDuplicatesChars2(str));
	}
	
	@Test
	public void testRemoveDuplicateChars2() {
		String str;
		str = testClass.removeDuplicateChars2("Duplicatecharcheck");
		assertTrue("Unique chars check", testClass.findDuplicatesChars2(str));
		str = testClass.removeDuplicateChars2("abcd");
		assertTrue("Unique chars check", testClass.findDuplicatesChars2(str));
		str = testClass.removeDuplicateChars2("aaaa");
		assertTrue("Unique chars check", testClass.findDuplicatesChars2(str));
		str = testClass.removeDuplicateChars2("aaaabbb");
		assertTrue("Unique chars check", testClass.findDuplicatesChars2(str));
	}

}
