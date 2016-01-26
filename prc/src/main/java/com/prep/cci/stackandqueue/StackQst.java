package com.prep.cci.stackandqueue;

import java.util.ArrayList;

public class StackQst {
	/**
	 * Describe how you could use a single array to implement three stacks Divide the array in three equal parts and allow the individual stack to grow in that limited space.
	 */
	public static class StackArrayDevideImpl {
		StackNode stack[] = null;
		int stackSize = 0;
		int stackTop[] = null;

		public StackArrayDevideImpl(int arraySize, int parts) {
			stack = new StackNode[arraySize];
			stackTop = new int[parts];
			stackSize = arraySize / parts;
			for (int cnt = 0; cnt < parts; cnt++) {
				stackTop[cnt] = cnt * stackSize;
			}
		}

		public void push(Object item, int stackNo) {
			int top = stackTop[stackNo];
			int nTop = top + 1;
			if (nTop < (stackNo + 1) * stackSize) {
				StackNode node = new StackNode();
				node.setItem(item);
				stack[nTop] = node;
				stackTop[stackNo] = nTop;
			} else {
				System.out.println("Can't insert item " + item + ", Stack '" + stackNo + "' is full.");
			}
		}

		public StackNode pop(int stackNo) {
			int top = stackTop[stackNo];
			StackNode node = stack[top];
			stack[top] = null;
			int nTop = top - 1;
			if (nTop > (stackNo) * stackSize) {
				stackTop[stackNo] = nTop;
			}
			return node;
		}

		public StackNode peek(int stackNo) {
			int top = stackTop[stackNo];
			return stack[top];
		}

	}

	/**
	 * Describe how you could use a single array to implement three stacks and keep track of min element. We sequentially allocate space to the stacks and we link new blocks to the
	 * previous block This means any new element in a stack keeps a pointer to the previous top element of that particular stack. It is space efficient implementation.
	 */
	public static class StackArrayDevideImplSE {
		StackNode stack[] = null;
		Integer stackTop[] = null;
		ArrayList<Integer> emptySlot = null;

		public StackArrayDevideImplSE(int arraySize, int parts) {
			stack = new StackNode[arraySize];
			stackTop = new Integer[parts];
			emptySlot = new ArrayList<Integer>(arraySize);
			for (int cnt = 0; cnt < arraySize; cnt++) {
				emptySlot.add(cnt);
			}
		}

		public void push(Object item, int stackNo) {
			if (emptySlot.isEmpty()) {
				System.out.println("Stack is full. System can't add element '" + item + "'.");
				return;
			}
			StackNode node = new StackNode();
			node.setItem(item);
			Integer top = stackTop[stackNo];
			if (top == null) { /* first element. */
				Integer slot = emptySlot.get(0); /* Get an empty slot */
				stack[slot] = node; /* place node in the slot */
				stackTop[stackNo] = slot; /* set the new top for stack */
				node.setMinElem(slot);
			} else {
				Integer slot = emptySlot.get(0); /* Get an empty slot */
				stack[slot] = node;/* place node in the slot */
				node.setPrevSlot(top); /* set current top to new nodes previous slot */
				stackTop[stackNo] = slot; /* set the new top for stack */
				if (((Integer) stack[stack[top].getMinElem()].getItem()) > (Integer) item) {
					node.setMinElem(slot);
				} else {
					node.setMinElem(stack[top].getMinElem());
				}
			}
			emptySlot.remove(0);
		}

		public StackNode pop(int stackNo) {
			Integer top = stackTop[stackNo];
			if (top == null) {
				System.out.println("Stack is empty.");
				return null;
			}
			StackNode node = stack[top]; /* pull node at the top */
			stack[top] = null; /* empty the slot */
			stackTop[stackNo] = node.getPrevSlot(); /* move top to previous node */
			emptySlot.add(top);/* reclaim free slot */
			System.out.println("Removed element:" + node.getItem());
			return node;
		}

		public StackNode peek(int stackNo) {
			int top = stackTop[stackNo];
			return stack[top];
		}

		public StackNode getMin(int stackNo) {
			int top = stackTop[stackNo];
			return stack[stack[top].getMinElem()];
		}

	}

	/**
	 * Imagine a (literal) stack of plates If the stack gets too high, it might topple There- fore, in real life, we would likely start a new stack when the previous stack exceeds
	 * some threshold Implement a data structure SetOfStacks that mimics this SetOf- Stacks should be composed of several stacks, and should create a new stack once the previous
	 * one exceeds capacity SetOfStacks push() and SetOfStacks pop() should behave identically to a single stack (that is, pop() should return the same values as it would if there
	 * were just a single stack) FOLLOW UP Implement a function popAt(int index) which performs a pop operation on a specifc sub-stack
	 */
	public static class StackOfStack {
		Stack stack = null;
		ArrayList<Stack> stackOfStacks = null;
		Integer top = null;
		int defaultStackSize = 3;

		public StackOfStack() {
			stack = new Stack(defaultStackSize);
			stackOfStacks = new ArrayList<Stack>();
			stackOfStacks.add(stack);
			top = 0;
		}

		public void push(Object item) {
			try {
				stack.push(item);
			} catch (StackFullException exp) {
				addNewStack();
				stack.push(item);
			}
		}

		private void addNewStack() {
			System.out.println("Creating new stack");
			stack = new Stack(defaultStackSize);
			stackOfStacks.add(stack);
			top++;
		}
		
		public Object pop() {
			Object item = null;
			if(top == 0 && stack.isEmpty()) {
				return null;
			}
			else if(top > 0 && stack.isEmpty()){
				stackOfStacks.remove(top);
				top--;
				stack = stackOfStacks.get(top);
			}
			item = stack.pop();
           return item;			
		}
		
		public Object popAt(int index) {
			Object item = null;
			if(index > top) {
				System.out.println("Invalid index.");
				return item;
			}
			else if(index == top) {
				item = stack.pop();
			}
			else {
				item = popAtIndex(index, top);
			}
			return item;
		}
		
		private Object popAtIndex(int index, int top) {
			Stack stc = stackOfStacks.get(index);
			Object tmp = stc.pop();
			Object item = popAtBottom(index+1, top);
			stc.push(item);
			return tmp;
		}

		private Object popAtBottom(int index, int top) {
			Object item = null;
			Stack stc = null;
			if(index < top) {
				item = popAtBottom(index+1, top);
			}
			else if(index == top){
				stc = stackOfStacks.get(index);
				return stc.popBottom();
			}
			stc = stackOfStacks.get(index);
			Object tmp = stc.popBottom();
			stc.push(item);
			return tmp;
		}

	}
    /**
     * Algorithm to solve tower of hanoi	
     *
     */
	public static class TowerOfHanoi {
		Stack stacks[] = new Stack[3];
		int disks = 0;
		
		public TowerOfHanoi(int disks) {
			for(int cnt=0;cnt<stacks.length; cnt++){
				stacks[cnt] = new Stack();
			}
			for(int cnt=5;cnt>0; cnt--) {
				stacks[0].push("disk"+cnt);
			}
			this.disks = disks;  
		}
		
		public void solve() {
         moveDisks(disks, stacks[0], stacks[2], stacks[1]);			
		}
		
		/**
		 * A = SOURCE
		 * B = BUFFER = AUX
		 * C = DESTINATION
		 * @param disks
		 */
		private void moveDisks(int disks, Stack A, Stack C, Stack B) {
			if(disks == 0) {
				/*Move from source to destination*/
				Object disk = A.pop();
				C.push(disk);
			} else {
				moveDisks(disks -1, A, B, C);
				/*Move from source to destination*/
				Object disk = A.pop();
				C.push(disk);
				moveDisks(disks-1, B, C, A);
			}
		}
	}
	
	public static class SortedStack {
		Stack s1 = new Stack();
		Stack s2 = new Stack();
		
		public Object pop() {
			return s1.pop();
		}
		
		public Object peek() {
			return s1.peek();
		}
		
		public void push(Object item) {
			if(s1.isEmpty()) {
				s1.push(item);
			} else {
				while(!s1.isEmpty()) {
					Object top = s1.pop();
					if(((Integer) item) >= ((Integer) top)) {
						s1.push(item);
						break;
					}
					else {
                        s2.push(top);	
                        if(s1.isEmpty()) {
                        	s2.push(item);
                        }
					}
				}
				while(!s2.isEmpty()) {
					s1.push(s2.pop());
				}
				
			}
		}
		
		public Stack sortStack(Stack st) {
			Stack buf = new Stack();
			Integer topOfSt = null;
			Integer topOfBuf = null;
			while(!st.isEmpty()) {
				  topOfSt = (Integer) st.pop();
				  while(!buf.isEmpty() &&(((Integer)buf.peek()) > topOfSt)) {
					  topOfBuf = (Integer) buf.pop();
					  st.push(topOfBuf);
				  }
				  buf.push(topOfSt);
			}
			return buf;
		}
		
		
	}
	

}
