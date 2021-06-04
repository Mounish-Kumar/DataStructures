package dev.mounish.sortingalgorithms;

public class SelectionSort {
	
	public void sort(final int[] array) {
		for(int i = 0; i < array.length; i++) {
			int minIndex = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[minIndex] > array[j]) minIndex = j;
			}
			swap(array, i, minIndex);
		}
		
	}
	
	private void swap(final int[] array, final int index1, final int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

}
