package dev.mounish.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	
	private class Node {
		private int value;
		private Node leftChild;
		private Node rightChild;
		
		public Node(final int value) {
			this.value = value;
		}
	}
	
	private Node root;
	
	public void insert(final int item) {
		Node node = new Node(item);
		
		if(root == null) {
			root = node;
			return;
		}
		
		Node current = root;
		while(current != null) {
			if(item > current.value) {
				if(current.rightChild == null) {
					current.rightChild = node;
					return;
				}
				current = current.rightChild;
			} else {
				if(current.leftChild == null) {
					current.leftChild = node;
					return;
				}
				current = current.leftChild;
			}
		}
	}
	
	public boolean find(final int item) {		
		Node current = root;
		while(current != null) {
			if(item == current.value)
				return true;
 		
			current = item > current.value ? current.rightChild : current.leftChild;
		}
		return false;
	}
	
	// Root, Left, Right
	public void traversePreOrder() {
		traversePreOrder(root);
	}
	private void traversePreOrder(final Node node) {
		if(node == null)
			return;
		
		System.out.println(node.value);
		traversePreOrder(node.leftChild);
		traversePreOrder(node.rightChild);
	}
	
	// Left, Root, Right
	public void traverseInOrder() {
		traverseInOrder(root);
	}
	private void traverseInOrder(final Node node) {
		if(node == null)
			return;
		
		traverseInOrder(node.leftChild);
		System.out.println(node.value);
		traverseInOrder(node.rightChild);
	}
	
	// Left, Right, Root
	public void traversePostnOrder() {
		traversePostOrder(root);
	}
	private void traversePostOrder(final Node node) {
		if(node == null)
			return;
		
		traversePostOrder(node.leftChild);
		traversePostOrder(node.rightChild);
		System.out.println(node.value);
	}
	
	public int height() {
		return height(root);
	}
	private int height(final Node node) {
		if(isLeaf(node))
			return 0;
		
		return 1 + Math.max(height(node.leftChild), height(node.rightChild));
	}
	
	public int min() {
		return min(root);
	}
	private int min(final Node node) {
		if(isLeaf(node))
			return node.value;
		
		var left = min(node.leftChild);
		var right = min(node.rightChild);
		return Math.min(Math.min(left, right), node.value);
	}
	
	private boolean isLeaf(final Node node) {
		return node.leftChild == null && node.rightChild == null;
	}
	
	public boolean equals(final BinaryTree other) {
		if(other == null)
			return false;
		
		return equals(root, other.root);
	}
	private boolean equals(final Node first, final Node second) {
		if(first == null && second == null)
			return true;
			
		if(first != null && second != null)
			return first.value == second.value
					&& equals(first.leftChild, second.leftChild)
					&& equals(first.rightChild, second.rightChild);
		
		return false;
	}
	
	public boolean isBinarySearchTree() {
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private boolean isBinarySearchTree(final Node node, final int min, final int max) {
		if(node == null)
			return true;
		
		if(node.value < min || node.value > max)
			return false;
		
		return isBinarySearchTree(node.leftChild, min, node.value - 1) && isBinarySearchTree(node.rightChild, node.value + 1, max);
	}
	
	public void printNodesAtDistance(final int distance) {
		printNodesAtDistance(root, distance);
	}
	private void printNodesAtDistance(final Node node, final int distance) {
		if(node != null) {
			if(distance == 0)
				System.out.println(node.value);
			
			printNodesAtDistance(node.leftChild, distance - 1);
			printNodesAtDistance(node.rightChild, distance - 1);
		}
	}
	
	public int size() {
		return size(root);
	}
	private int size(final Node node) {
		if(node == null)
			return 0;
		
		if(isLeaf(node))
			return 1;
		
		return 1 + size(node.leftChild) + size(node.rightChild);
	}
	
	public int countLeaves() {
		return countLeaves(root);
	}
	private int countLeaves(final Node node) {
		if(node == null)
			return 0;
		
		if(isLeaf(node))
			return 1;
		
		return countLeaves(node.leftChild) + countLeaves(node.rightChild);
	}
	
	public int max() {
		return max(root);
	}
	private int max(final Node node) {
		if(node.rightChild == null)
			return node.value;
		
		return max(node.rightChild);
	}
	
	public boolean contains(final int item) {
		return contains(root, item);
	}
	private boolean contains(final Node node, final int item) {
		if(node == null)
			return false;
		
		if(item > node.value)
			return contains(node.rightChild, item);
		else if(item < node.value)
			return contains(node.leftChild, item);
		else
			return true;
	}
	
	public boolean areSiblings(final int first, final int second) {
		if(root == null)
			return false;
		
		return areSiblings(root.leftChild, root.rightChild, first, second);
	}
	private boolean areSiblings(final Node left, final Node right, final int first, final int second) {
		if(left == null || right == null)
			return false;
		
		if((left.value == first && right.value == second) || (right.value == first && left.value == second))
			return true;
		
		return areSiblings(left.leftChild, left.rightChild, first, second) || areSiblings(right.leftChild, right.rightChild, first, second);
	}
	
	public List<Integer> getAncestors(final int item) {
		final List<Integer> ancestors = new ArrayList();
		findAncestors(root, item, ancestors);
		return ancestors;
	}
	private boolean findAncestors(final Node node, final int item, final List<Integer> ancestors) {
		if(node == null)
			return false;
		
		if(node.value == item)
			return true;
		
		if(findAncestors(node.leftChild, item, ancestors) || findAncestors(node.rightChild, item, ancestors)) {
			ancestors.add(node.value);
			return true;
		}
		return false;
	}

}
