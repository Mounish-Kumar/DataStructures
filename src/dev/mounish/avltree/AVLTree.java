package dev.mounish.avltree;

public class AVLTree {
	
	private class AVLNode {
		private int value;
		private AVLNode leftChild;
		private AVLNode rightChild;
		private int height;
		
		public AVLNode(final int value) {
			this.value = value;
		}
	}
	
	private AVLNode root;
	
	public void insert(final int item) {
		root = insert(root, item);
	}
	private AVLNode insert(final AVLNode current, final int item) {
		if(current == null)
			return new AVLNode(item);
		
		if(item > current.value) {
			current.rightChild = insert(current.rightChild, item);
		} else {
			current.leftChild = insert(current.leftChild, item);
		}
		
		current.height = 1 + Math.max(height(current.rightChild), height(current.leftChild));
		
		balance(current);
		
		return current;
	}
	
	private void balance(final AVLNode current) {
		if(isLeftHeavy(current)) {
			if(balanceFactor(current.leftChild) > 0)
				System.out.println("Left Rotate " + current.leftChild.value);
			System.out.println("Right Rotate " + root.value);
		} else if(isRightHeavy(current)) {
			if(balanceFactor(current.rightChild) > 0)
				System.out.println("Right Rotate " + current.rightChild.value);
			System.out.println("Left Rotate " + root.value);
		}
	}
	
	private boolean isLeftHeavy(final AVLNode node) {
		return balanceFactor(node) > 1;
	}
	
	private boolean isRightHeavy(final AVLNode node) {
		return balanceFactor(node) < -1;
	}
	
	private int balanceFactor(final AVLNode node) {
		return node == null ? 0 : height(node.rightChild) - height(node.leftChild);
	}
	
	public int height(final AVLNode node) {
		return node == null ? -1 : node.height;
	}
	
	private boolean isLeaf(final AVLNode node) {
		return node.leftChild == null && node.rightChild == null;
	}

}
