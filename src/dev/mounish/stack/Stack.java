package dev.mounish.stack;

public class Stack {
	
	private int[] array = null;
	
	private int count = 0;
	
	public Stack(final int length) {
		array = new int[length];
	}
	
	public void push(final int item) {
		if(isFull())
			throw new StackOverflowError();

		array[count] = item;
		count++;
	}
	
	public int pop() {
		final int lastItem = peek();
		array[count - 1] = 0;
		count--;
		return lastItem;
	}
	
	public int peek() {
		if(isEmpty())
			throw new IllegalStateException();
		
		return array[count - 1];
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public boolean isFull() {
		return count >= array.length;
	}
	
	public void print() {
		System.out.print("[");
		for(int i = 0; i < count; i++) {
			System.out.print(array[i]);
			if(i < count - 1) System.out.print(", ");
		}
		System.out.print("]");
		System.out.println();
	}

}
