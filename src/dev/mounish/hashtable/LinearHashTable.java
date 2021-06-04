package dev.mounish.hashtable;

import java.util.Arrays;

public class LinearHashTable {
	
	public class Entry {
		
		private int key;
		
		private String value;
		
		public Entry(final int key, final String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	Entry[] array = null;
	
	int count = 0;
	
	public LinearHashTable(final int length) {
		array = new Entry[length];
	}
	
	public void put(final int key, final String value) {
		if(isFull())
			throw new StackOverflowError();
			
		int index = 0, i= 0;
		do {
			index = hash(key, i);
			i++;
		} while(array[index] != null);
		
		Entry entry = new Entry(key, value);
		array[index] = entry;
		count++;
	}
	
	public void remove(final int key) {
		if(isEmpty())
			throw new IllegalStateException();
		
		int index = indexOf(key);
		if(index != -1) {
			array[index] = null;
			count--;
		}
	}
	
	public boolean containsKey(final int key) {
		return indexOf(key) != -1;
	}
	
	public String get(final int key) {
		int index = indexOf(key);
		return index != -1 ? array[index].value : null;
	}
	
	public boolean isFull() {
		return array.length >= count;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	private int indexOf(final int key) {
		int index = 0, i= 0;
		int startIndex = index = hash(key, i);
		do {
			index = hash(key, i);
			
			if(array[index].key == key)
				return index;
			
			i++;
		} while(index != startIndex);
		
		return -1;
	}
	
	private int hash(final Integer key, final int i) {
		return (key.hashCode() + i) % array.length;
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}

}
