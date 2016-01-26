package com.prep.cci.stackandqueue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prep.cci.stackandqueue.QueueQst.QueueByStacks;

public class QueueQstTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		QueueByStacks queue = new QueueByStacks();
	  for(int cnt=0; cnt<20;cnt++) {
		  queue.push(cnt);
		  if(cnt == 9) {
			  for(int i =0; i<3; i++) {
				  System.out.println(queue.peek());
				  System.out.println(queue.pop());
			  }
		  }
	  }
	  for(int i =0; i<15; i++) {
		  System.out.println(queue.pop());
	  }
	  
	}

}
