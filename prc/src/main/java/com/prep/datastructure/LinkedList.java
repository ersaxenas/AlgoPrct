package com.prep.datastructure;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class LinkedList {

	private Node first = null;
	private Node last = null;
	private int size = 0;

	/**
	 * Function adds an element at the end of the listl
	 * 
	 * @param elem
	 */
	public void add(Object elem) {
		if (first == null) {
			Node node = new Node(elem, null);
			first = node;
			last = node;
			size++;
		} else {
			Node node = new Node(elem, null);
			last.next = node;
			last = node;
			size++;
		}
	}

	/**
	 * Removes an element from the list
	 * 
	 * @param elem
	 * @return True / False
	 */
	public boolean remove(Object elem) {
		boolean result = false;
		if (!isEmpty()) {
			Node node = first;
			Node prev = null;
			while (node != null) {
				if (node.item.equals(elem)) {
					if (prev != null) {
						prev.next = node.next;
						node.next = null;
						result = true;
						size--;
					} else {
						/* first element */
						first = node.next;
						node.next = null;
						result = true;
						size--;
					}
				}
				prev = node;
				node = node.next;
			}
		}
		return result;
	}

	/**
	 * Return true if queue is empty else false
	 * 
	 * @return true / false;
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns true if list not empty else false
	 * 
	 * @return true / false
	 */
	public boolean isNotEmpty() {
		return first != null;
	}

	/**
	 * Function adds elements of the list to queue and returns its iterator.
	 * 
	 * @return Iterator
	 */
	public Iterator iterator() {
		Queue queue = new ArrayDeque();
		if (isNotEmpty()) {
			Node node = first;
			while (node != null) {
				queue.add(node.item);
				node = node.next;
			}
		}
		return queue.iterator();
	}

	/**
	 * Function prints the content of the list.
	 */
	public void printList() {
		if (isNotEmpty()) {
			StringBuilder str = new StringBuilder();
			Node node = first;
			while (node != null) {
				str.append(node.item.toString()).append("->");
				node = node.next;
			}
			System.out.println(str.toString());
		} else {
			System.out.println("List is empty");
		}
	}

	/**
	 * Function gets an element at given index.
	 * 
	 * @param index
	 * @return
	 */
	public Object getElement(int index) {
		if (isEmpty()) {
			return null;
		}
		Object elem = null;
		if (index > 0 && index <= size) {
			Node node = first;
			int curr = 1;
			while (node != null) {
				if (curr == index) {
					elem = node.item;
					break;
				}
				curr++;
				node = node.next;
			}
		}
		return elem;
	}

	/**
	 * Function removes element at given index.
	 * @param index
	 * @return
	 */
	public boolean remove(int index) {
		boolean result = true;
		int cnt = 1;
		if (isNotEmpty()) {
			Node node = first;
			Node prev = null;
			while (node != null) {
				if (cnt == index ) {
					if (prev != null) {
						prev.next = node.next;
						node.next = null;
						result = true;
						size--;
					} else {
						/* first element */
						first = node.next;
						node.next = null;
						result = true;
						size--;
					}
				}
				prev = node;
				node = node.next;
				cnt++;
			}
		}
		return result;
	}

	public int getSize() {
		return size;
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public Node getLast() {
		return last;
	}

	public void setLast(Node last) {
		this.last = last;
	}

	public class Node {
		private Object item;
		private Node next;

		public Node(final Object item, final Node node) {
			this.item = item;
			this.next = node;
		}

		public Object getItem() {
			return item;
		}

		public void setItem(Object item) {
			this.item = item;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
}
