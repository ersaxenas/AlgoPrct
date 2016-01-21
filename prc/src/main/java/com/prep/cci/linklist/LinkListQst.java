package com.prep.cci.linklist;

import com.prep.datastructure.LinkedList;

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
			while (node != null) {
				if (node == offset) {
					break;
				} else if (node.getItem().equals(offset.getItem())) {
					lst.remove(node.getItem());
					break;
				}
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
		if(index == lst.getSize()) {
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
		for(int i=0; i<=index && p2 != null; i++) {
			p2 = p2.getNext();
		}
		while(p2 != null) {
			p2 = p2.getNext();
			p1 = p1.getNext();
		}
		if(index == lst.getSize()) {
			lst.remove(1);
		}
		else {
			LinkedList.Node tmp = p1.getNext();
			p1.setNext(tmp.getNext());
			tmp.setNext(null);
		}
		
	}
	
	
	

}
