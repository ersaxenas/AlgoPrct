package com.prep.cci.stackandqueue;


public class Stack {
	private StackNode first;
	private int size =0;
	private int maxSize=-1;
	
	public Stack() {}
    public Stack(int maxSize) {
		this.maxSize = maxSize;
	}
	
	
	public void push(final Object item) {
		if(maxSize != -1 && size >= maxSize) {
			System.out.println("Stack is full. System can't insert item '"+item+"'.");
			throw new StackFullException();
		}
		StackNode oldfirst = first;
		first = new StackNode();
		first.setItem(item);
		first.setNext(oldfirst);
		size++;
	}

	public Object pop() {
		if (first == null) {
			return null;
		}
		Object item = first.getItem();
		StackNode next = first.getNext();
		first.setNext(null); 
		first = next;
		size--;
		return item;
	}
	
	public Object popBottom() {
		if (first == null) {
			return null;
		}
		StackNode last = null;
		StackNode node = first;
		while(node.getNext() != null) {
			if(node.getNext().getNext() != null) {
				node = node.getNext();	
			}
			else {
				break;
			}
		}
		if(first == node && node.getNext() == null) {
			last = first;
			this.first = null;
		}
		else {
			last = node.getNext();
			node.setNext(null);
		}
		size--;
		return last;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int getSize() {
		return size;
	}
	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		StackNode node = first;
		stb.append("[T]");
		while(node != null) {
			stb.append(node.getItem().toString()).append("->");
			node = node.getNext();
		}
		stb.append("[B]");
		return stb.toString();
	}
	
}
