package com.prep.cci.linklist;

import java.util.Stack;

import com.prep.datastructure.LinkedList;
import com.prep.datastructure.LinkedList.Node;

public class LinkListQst {
	/**
	 * Remove duplicates from an unsorted linked list (temporary buffer is not allowed).
	 */
	public void removeDuplicates(LinkedList lst) {
		assert (lst != null) : "List is empty";
		assert (lst.getSize() <= 2) : "List is too small";
		/* start at 2 element */
		LinkedList.Node offset = lst.getFirst().getNext();
		while (offset != null) {
			/* check of duplicate and remove if any */
			LinkedList.Node node = lst.getFirst();
			int index = 1;
			while (node != null) {
				if (node == offset) {
					break;
				} else if (node.getItem().equals(offset.getItem())) {
					lst.remove(index);
					break;
				}
				index++;
				node = node.getNext();
			}
			/* move to next element */
			offset = offset.getNext();
		}
	}

	/**
	 * Function removes Nth element from the list. Using recursion.
	 */
	public void removeNthElementFromLast(LinkedList lst, int index) {
		assert (lst != null) : "List is empty";
		assert (lst.getSize() < index) : "List is too small";
		if (index == lst.getSize()) {
			lst.remove(1);
		}
		this.removeElement(lst.getFirst(), index);
	}

	private int removeElement(LinkedList.Node x, int index) {
		int cnt = 0;
		if (x == null) {
			return 1;
		}
		cnt = removeElement(x.getNext(), index);
		if (cnt == index + 1) { /* previous element */
			LinkedList.Node tmp = x.getNext();
			x.setNext(tmp.getNext());
			tmp.setNext(null);
		}
		cnt++;
		return cnt;
	}

	/**
	 * Function removes Nth element from the list - without recursion.
	 */
	public void removeNthElementFromLast2(LinkedList lst, int index) {
		assert (lst != null) : "List is empty";
		assert (lst.getSize() <= index) : "List is too small";
		LinkedList.Node p1 = lst.getFirst();
		LinkedList.Node p2 = lst.getFirst();
		for (int i = 0; i <= index && p2 != null; i++) {
			p2 = p2.getNext();
		}
		while (p2 != null) {
			p2 = p2.getNext();
			p1 = p1.getNext();
		}
		if (index == lst.getSize()) {
			lst.remove(1);
		} else {
			LinkedList.Node tmp = p1.getNext();
			p1.setNext(tmp.getNext());
			tmp.setNext(null);
		}

	}

	/**
	 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1’s digit is at the head of
	 * the list. Write a function that adds the two numbers and returns the sum as a linked list. 
	 * EXAMPLE Input: (3 -> 1 -> 5), (5 -> 9 -> 2) Output: 8 -> 0 -> 8
	 */
	public void sumNumber(LinkedList lst1, LinkedList lst2) {
      LinkedList.Node res = sumNum(lst1.getFirst(), lst2.getFirst(), 0);
      LinkedList lst = new LinkedList();
      lst.setFirst(res);
      lst.printList();
	}
	
	private Node sumNum(LinkedList.Node x1, LinkedList.Node x2, int carry) {
		Node resultLst = new LinkedList.Node(null, null);
		Node next1=null, next2=null;
		int val = 0;
		if(x1 != null) {
			val = val + (Integer)x1.getItem();
			next1 = x1.getNext();
		}
		if(x2 != null) {
			val = val + (Integer)x2.getItem();
			next2 = x2.getNext();
		}
		if(carry != 0) {
			val = val + carry;
		}
		int dig = val % 10;
		int nxtCarry = 0;
		if(val > 10) {
			nxtCarry = 1;
		}
		resultLst.setItem(dig);
		if(next1 != null || next2 != null || nxtCarry != 0) {
			LinkedList.Node nextNode = sumNum(next1,next2, nxtCarry);
			resultLst.setNext(nextNode);
		}
		return resultLst;
	}

}
