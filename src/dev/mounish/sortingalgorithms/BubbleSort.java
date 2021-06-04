package dev.mounish.sortingalgorithms;

public class BubbleSort {
	
	public void sort(final int[] array) {
		boolean isSorted;
		for(int i = 0; i < array.length; i++) {
			isSorted = true;
			for(int j = 1; j < array.length - i; j++) {
				if(array[j - 1] > array[j]) {
					swap(array, j - 1, j);
					isSorted = false;
				}	
			}
			if(isSorted) return;
		}
	}
	
	private void swap(final int[] array, final int index1, final int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

}
