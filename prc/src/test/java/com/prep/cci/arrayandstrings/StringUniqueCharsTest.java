package com.prep.cci.arrayandstrings;

import junit.framework.TestCase;

public class StringUniqueCharsTest extends TestCase {
	StringUniqueChars testClass = new StringUniqueChars();

	public StringUniqueCharsTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testFindDuplicatesChars1() {
		assertTrue("Unique chars check", testClass.findDuplicatesChars1("length"));
		assertFalse("Duplicate char check", testClass.findDuplicatesChars1("seen"));
	}

	public void testFindDuplicatesChars2() {
		assertTrue("Unique chars check", testClass.findDuplicatesChars2("length"));
		assertFalse("Duplicate char check", testClass.findDuplicatesChars2("seen"));
	}

}
