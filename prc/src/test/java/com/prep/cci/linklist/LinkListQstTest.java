package com.prep.cci.linklist;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.prep.datastructure.LinkedList;

public class LinkListQstTest {
    LinkListQst testClass = new LinkListQst();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void testRemoveDuplicates() {
       LinkedList lst = new LinkedList();
       lst.add(new Integer(1));
       lst.add(new Integer(2));
       lst.add(new Integer(3));
       lst.add(new Integer(1));
       lst.add(new Integer(2));
       lst.add(new Integer(3));
       lst.add(new Integer(4));
       lst.add(new Integer(1));
       lst.add(new Integer(5));
       lst.add(new Integer(6));
       lst.add(new Integer(8));
       lst.add(new Integer(3));
       lst.add(new Integer(2));
       lst.add(new Integer(7));
       lst.add(new Integer(3));
       lst.add(new Integer(5));
       lst.printList();
       testClass.removeDuplicates(lst);
       lst.printList();
	}
	
	@Test
	@Ignore
	public void testRemoveNthElementFromLast() {
       LinkedList lst = new LinkedList();
       lst.add(new Integer(9));
       lst.add(new Integer(8));
       lst.add(new Integer(7));
       lst.add(new Integer(6));
       lst.add(new Integer(5));
       lst.add(new Integer(4));
       lst.add(new Integer(3));
       lst.add(new Integer(2));
       lst.add(new Integer(1));
       lst.printList();
       testClass.removeNthElementFromLast(lst, 4);
       lst.printList();
	}
	
	@Test
	public void testremoveNthElementFromLast2() {
       LinkedList lst = new LinkedList();
       lst.add(new Integer(9));
       lst.add(new Integer(8));
       lst.add(new Integer(7));
       lst.add(new Integer(6));
       lst.add(new Integer(5));
       lst.add(new Integer(4));
       lst.add(new Integer(3));
       lst.add(new Integer(2));
       lst.add(new Integer(1));
       lst.printList();
       testClass.removeNthElementFromLast2(lst, 7);
       lst.printList();
	}

}
