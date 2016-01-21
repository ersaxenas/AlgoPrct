package com.prep.cci.arrayandstrings;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringReplaceTest {
	
	StringReplace testClass = new StringReplace();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReplace() {
		String str = testClass.replace("test test test", ' ', "%420");
		assertTrue("Replacement failed", str.equals("test%420test%420test"));
	}

}
