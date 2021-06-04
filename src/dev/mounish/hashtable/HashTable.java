package dev.mounish.hashtable;

import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {
	
	public class Entry {
		
		private int key;
		
		private String value;
		
		public Entry(final int key, final String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	LinkedList<Entry>[] array = null;
	
	public HashTable(final int length) {
		array = new LinkedList[length];
	}
	
	public void put(final int key, final String value) {
		Entry entry = getEntry(key);
		if(entry != null) {
			entry.value = value;
			return;
		}
		
		LinkedList<Entry> linkedList = getLinkedList(key);
		if(linkedList == null) {
			linkedList = new LinkedList();
		}
		entry = new Entry(key, value);
		linkedList.addLast(entry);
		array[hash(key)] = linkedList;
	}
	
	public void remove(final int key) {
		Entry entry = getEntry(key);
		if(entry == null)
			throw new IllegalStateException();
		
		LinkedList<Entry> linkedList = getLinkedList(key);
		linkedList.remove(entry);
	}
	
	public boolean containsKey(final int key) {
		return getEntry(key) != null;
	}
	
	public String get(final int key) {
		Entry entry = getEntry(key);
		return entry != null ? entry.value : null;
	}
	
	private Entry getEntry(final int key) {
		LinkedList<Entry> linkedList = getLinkedList(key);
		if(linkedList != null) {
			for(int i = 0; i < linkedList.size(); i++) {
				Entry entry = linkedList.get(i);
				if(entry.key == key) return entry;
			}
		}
		return null;
	}
	
	private LinkedList<Entry> getLinkedList(final int key) {
		int index = hash(key);
		return array[index];
	}
	
	private int hash(final int key) {
		return key % array.length;	
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}

}
