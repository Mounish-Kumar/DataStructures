package dev.mounish.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {
	
	private class Node {
		private int value;
		private Node next;
		
		public Node(final int value) {
			this.value = value;
		}
	}
	
	private Node first;
	private Node last;
	private int size;
	
	public void addFirst(final int item) {
		Node node = new Node(item);
		if(isEmpty())
			first = last = node;
		else {
			node.next = first;
			first = node;
		}
		
		size++;
	}
	
	public void addLast(final int item) {
		Node node = new Node(item);
		if(isEmpty())
			first = last = node;
		else {
			last.next = node;
			last = node;
		}
		
		size++;
	}
	
	public int indexOf(final int item) {
		int index = 0;
		Node node = first;
		while(node != null) {
			if(node.value == item) return index;
			node = node.next;
			index++;
		}
		return -1;
	}
	
	public boolean contains(final int item) {
		return indexOf(item) != -1;
	}
	
	public void removeFirst() {
		if(isEmpty())
			throw new NoSuchElementException();
		
		if(first == last)
			first = last = null;
		else {
			Node second = first.next;
			first.next = null;
			first = second;
		}
		
		size--;
	}
	
	public void removeLast() {
		if(isEmpty())
			throw new NoSuchElementException();
		
		if(first == last)
			first = last = null;
		else {
			Node lastPrevious = previousNode(last);
			last = lastPrevious;
			last.next = null;
		}
		
		size--;
	}
	
	public int size() {
		return size;
	}
	
	public int[] toArray() {
		int[] array = new int[size];
		
		int index = 0;
		Node node = first;
		while(node != null) {
			array[index] = node.value;
			node = node.next;
			index++;
		}
		return array;
	}
	
	public LinkedList reverse() {
		if(isEmpty())
			return this;
		
		Node previous = first;
		Node current = first.next;
		while(current != null) {
			Node next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		last = first;
		last.next = null;
		first = previous;
		return this;
	}
	
	public int getNthFromEnd(final int n) {
		if(isEmpty())
			throw new IllegalStateException();
			
		int index = 0;
		Node node = first;
		while(node != null) {
			if(index == (size - n)) return node.value;
			node = node.next;
			index++;
		}
		throw new IllegalArgumentException();
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void printMiddle() {
		if(isEmpty())
			throw new IllegalStateException();
		
		Node x = first, y = first;
		while(y != last && y.next != last) {
			x = x.next;
			y = y.next.next;
		}
		
		if(y ==  last)
			System.out.println(x.value);
		else
			System.out.println(x.value + ", " + x.next.value);
	}
	
	public boolean hasLoop() {
		if(isEmpty())
			throw new IllegalStateException();
		
		Node x = first, y = first;
		while(y != null && y.next != null) {
			x = x.next;
			y = y.next.next;
			
			if(x == y) return true;
		}
		return false;
	}
	
	private Node previousNode(final Node item) {
		Node node = first;
		while(node != null) {
			if(node.next == item) return node; 
			node = node.next;
		}
		return null;
	}
	
	public void print() {
		System.out.print("[");
		Node node = first;
		while(node != null) {
			System.out.print(node.value);
			node = node.next;
			if(node != null) System.out.print(", ");
		}
		System.out.print("]");
		System.out.println();
	}

}
