package dev.mounish.queue;

import java.util.Arrays;

public class ArrayQueue {
	
	private int[] array = null;
	
	private int start = 0, end = 0, count = 0;
	
	public ArrayQueue(final int length) {
		array = new int[length];
	}
	
	public void enqueue(final int item) {
		if(isFull())
			throw new StackOverflowError();
		
		array[end] = item;
		end = (end + 1) % array.length;
		count++;
	}
	
	public int dequeue() {
		int firstItem = peek();
		start = (start + 1) % array.length;
		count--;
		return firstItem;
	}
	
	public int peek() {
		if(isEmpty())
			throw new IllegalStateException();
		
		return array[start];
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public boolean isFull() {
		return count == array.length;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(array);
	}

}
