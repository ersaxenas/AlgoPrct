package com.prep.cci.stackandqueue;

public class QueueQst {
	
	/**
	 * queue implementation using two stacks. 
	 *
	 */
	public static class QueueByStacks {
		Stack s1 = new Stack();
		Stack s2 = new Stack();
		
		public void push(Object item) {
			s1.push(item);
		}
		
		public int getSize() {
			return s1.getSize() + s2.getSize();
		}
		
		public Object pop() {
			if(s2.isEmpty()) {
				while(!s1.isEmpty()) {
					s2.push(s1.pop());
				}
			} 
			return s2.pop();
		}
		
		public Object peek() {
			if(s2.isEmpty()) {
				while(!s1.isEmpty()) {
					s2.push(s1.pop());
				}
			} 
			return s2.peek();
		}
		
	}
	

}
