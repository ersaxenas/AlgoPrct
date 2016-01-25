package com.prep.cci.stackandqueue;

public class StackNode {

	private Object item;
	private StackNode next;
	private StackNode prev;
	private Integer prevSlot;
	private Integer nextSlot;
	private Integer minElem;
	public Object getItem() {
		return item;
	}
	public void setItem(Object item) {
		this.item = item;
	}
	public StackNode getNext() {
		return next;
	}
	public void setNext(StackNode next) {
		this.next = next;
	}
	public StackNode getPrev() {
		return prev;
	}
	public void setPrev(StackNode prev) {
		this.prev = prev;
	}
	public Integer getPrevSlot() {
		return prevSlot;
	}
	public void setPrevSlot(Integer prevSlot) {
		this.prevSlot = prevSlot;
	}
	public Integer getNextSlot() {
		return nextSlot;
	}
	public void setNextSlot(Integer nextSlot) {
		this.nextSlot = nextSlot;
	}
	public Integer getMinElem() {
		return minElem;
	}
	public void setMinElem(Integer minElem) {
		this.minElem = minElem;
	}
	@Override
	public String toString() {
		return item.toString();
	}
	
}
