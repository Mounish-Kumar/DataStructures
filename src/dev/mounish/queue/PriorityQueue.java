package dev.mounish.queue;

public class PriorityQueue {
	
	private int[] array = null;
	
	private int count = 0;
	
	public PriorityQueue(final int length) {
		array = new int[length];
	}
	
	public void insert(final int item) {
		if(isFull())
			throw new StackOverflowError();
		
		int i;
		for(i = count - 1; i >= 0; i--) {
			if(item >= array[i])
				break;
			else
				array[i + 1] = array[i];
		}
		array[i + 1] = item;
		count++;
	}
	
	public int remove() {
		if(isEmpty())
			throw new IllegalStateException();
		
		count--;
		return array[count];
	}
	
	public boolean isFull() {
		return count == array.length;
	}
	
	public boolean isEmpty() {
		return count == 0;
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
