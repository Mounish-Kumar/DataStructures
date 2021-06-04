package dev.mounish.stack;

public class TwoStacks {

	private int[] array = null;
	
	private int count1 = 0;
	
	private int count2 = 0;
	
	public TwoStacks(final int length) {
		array = new int[length];
		count2 = length - 1;
	}
	
	public void push1(final int item) {
		if(isFull())
			throw new StackOverflowError();

		array[count1] = item;
		count1++;
	}
	
	public void push2(final int item) {
		if(isFull())
			throw new StackOverflowError();

		array[count2] = item;
		count2--;
	}
	
	public int pop1() {
		final int lastItem = peek1();
		array[count1 - 1] = 0;
		count1--;
		return lastItem;
	}
	
	public int pop2() {
		final int lastItem = peek2();
		array[count1 + 1] = 0;
		count2++;
		return lastItem;
	}
	
	public int peek1() {
		if(isEmpty1())
			throw new IllegalStateException();
		
		return array[count1 - 1];
	}
	
	public int peek2() {
		if(isEmpty2())
			throw new IllegalStateException();
		
		return array[count2 + 1];
	}
	
	public boolean isEmpty1() {
		return count1 == 0;
	}
	
	public boolean isEmpty2() {
		return count2 == array.length - 1;
	}
	
	public boolean isFull() {
		return count1 > count2;
	}
	
	public void print1() {
		System.out.print("[");
		for(int i = 0; i < count1; i++) {
			System.out.print(array[i]);
			if(i < count1 - 1) System.out.print(", ");
		}
		System.out.print("]");
		System.out.println();
	}
	
	public void print2() {
		System.out.print("[");
		for(int i = array.length - 1; i > count2; i--) {
			System.out.print(array[i]);
			if(i > count2 + 1) System.out.print(", ");
		}
		System.out.print("]");
		System.out.println();
	}
}
