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
	 * the list. Write a function that adds the two numbers and returns the sum as a linked list. EXAMPLE Input: (3 -> 1 -> 5), (5 -> 9 -> 2) Output: 8 -> 0 -> 8
	 */
	public void sumNumber(LinkedList lst1, LinkedList lst2) {
		LinkedList.Node res = sumNum(lst1.getFirst(), lst2.getFirst(), 0);
		LinkedList lst = new LinkedList();
		lst.setFirst(res);
		lst.printList();
	}

	private Node sumNum(LinkedList.Node x1, LinkedList.Node x2, int carry) {
		Node resultLst = new LinkedList.Node(null, null);
		Node next1 = null, next2 = null;
		int val = 0;
		if (x1 != null) {
			val = val + (Integer) x1.getItem();
			next1 = x1.getNext();
		}
		if (x2 != null) {
			val = val + (Integer) x2.getItem();
			next2 = x2.getNext();
		}
		if (carry != 0) {
			val = val + carry;
		}
		int dig = val % 10;
		int nxtCarry = 0;
		if (val > 10) {
			nxtCarry = 1;
		}
		resultLst.setItem(dig);
		if (next1 != null || next2 != null || nxtCarry != 0) {
			LinkedList.Node nextNode = sumNum(next1, next2, nxtCarry);
			resultLst.setNext(nextNode);
		}
		return resultLst;
	}

	/**
	 * Given a circular linked list, implement an algorithm which returns node at the begin- ning of the loop DEFINITION Circular linked list: A (corrupt) linked list in which a
	 * node’s next pointer points to an earlier node, so as to make a loop in the linked list EXAMPLE Input: A -> B -> C -> D -> E -> C [the same C as earlier] Output: C
	 * 
	 * If we move two pointers, one with speed 1 and another with speed 2, they will end up meeting if the linked list has a loop Why? Think about two cars driving on a track—the
	 * faster car will always pass the slower one! The tricky part here is finding the start of the loop Imagine, as an analogy, two people racing around a track, one running
	 * twice as fast as the other If they start of at the same place, when will they next meet? They will next meet at the start of the next lap Now, let’s suppose Fast Runner had
	 * a head start of k meters on an n step lap When will they next meet? They will meet k meters before the start of the next lap (Why? Fast Runner would have made k + 2(n - k)
	 * steps, including its head start, and Slow Runner would have made n - k steps Both will be k steps before the start of the loop ) Now, going back to the problem, when Fast
	 * Runner (n2) and Slow Runner (n1) are moving around our circular linked list, n2 will have a head start on the loop when n1 enters Specifically, it will have a head start of
	 * k, where k is the number of nodes before the loop Since n2 has a head start of k nodes, n1 and n2 will meet k nodes before the start of the loop So, we now know the
	 * following: 1 Head is k nodes from LoopStart (by definition) 2 MeetingPoint for n1 and n2 is k nodes from LoopStart (as shown above) Thus, if we move n1 back to Head and keep
	 * n2 at MeetingPoint, and move them both at the same pace, they will meet at LoopStart
	 */
	public Node findStartOfCircularLinkedList(LinkedList lst) {
		Node x1 = lst.getFirst();
		Node x2 = lst.getFirst();
		
		while(x2 != null) {
			x1=x1.getNext();
			x2=x2.getNext().getNext();
			if(x1==x2) {
				break;
			}
		}
		
		if(x2.getNext() == null) {
			return null;
		}
		
		x1=lst.getFirst();
		while(x1!=x2) {
			x1=x1.getNext();
			x2=x2.getNext();
		}
		System.out.println("Start of loop :" + x2.getItem());
		return x2;
	}

}
