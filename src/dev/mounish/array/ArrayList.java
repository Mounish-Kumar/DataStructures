package dev.mounish.array;


public class ArrayList {
	
	private int[] array = null;
	
	private int count = 0;
	
	public ArrayList() {
		array = new int[5];
	}
	
	public ArrayList(final int length) {
		array = new int[length];
	}
	
	public void insert(final int item) {
		resizeArrayOnFull();
		array[count] = item;
		count++;
	}
	
	public void insertAt(final int item, final int index) {
		if(isValidIndex(index)) {
			resizeArrayOnFull();
			for(int i = count - 1; i >= index; i--) {
				array[i + 1] = array[i];
			}
			array[index] = item;
			count++;
		}
	}
	
	public void removeAt(final int index) {
		if(isValidIndex(index)) {
			for(int i = index; i < count - 1; i++) {
				array[i] = array[i + 1];
			}
			count--;
			array[count] = 0;
		}
	}
	
	public int indexOf(final int item) {
		int index = -1;
		for(int i = 0; i < count; i++) {
			if(array[i] == item) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	private void resizeArrayOnFull() {
		if(count >= array.length) {
			int newArraySize = count + (count / 2);
			int[] newArray = new int[newArraySize];
			for(int i = 0; i < count; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}
	}
	
	private boolean isValidIndex(final int index) {
		if(index >= 0 && index < count)
			return true;
		throw new IllegalArgumentException();
	}
	
	public int min() {
		int min = array[0];
		for(int i = 1; i < count; i++) {
			if(array[i] < min) min = array[i];
		}
		return min;
	}
	
	public int max() {
		int max = array[0];
		for(int i = 1; i < count; i++) {
			if(array[i] > max) max = array[i];
		}
		return max;
	}
	
	public ArrayList reverse() {
		ArrayList reverseArray = new ArrayList();
		for(int i = count - 1; i >= 0; i--) {
			reverseArray.insert(array[i]);
		}
		return reverseArray;
	}
	
	public ArrayList intersect(final ArrayList secondArray) {
		ArrayList intersectArray = new ArrayList();
		for(int i = 0; i < count; i++) {
			for(int j = 0; j < secondArray.size(); j++) {
				if(array[i] == secondArray.get(j)) {
					intersectArray.insert(array[i]);
				}
			}
		}
		return intersectArray;
	}
	
	public int size() {
		return count;
	}
	
	public int get(final int index) {
		return array[index];
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
