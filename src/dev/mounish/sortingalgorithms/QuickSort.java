package dev.mounish.sortingalgorithms;

public class QuickSort {
	
	public void sort(final int[] array) {
		sort(array, 0, array.length - 1);
	}
	
	private void sort(final int[] array, final int start, final int end) {
		if(start >= end)
			return;
		
		int boundary = partition(array, start, end);

		sort(array, start, boundary - 1); // sort left partition
		sort(array, boundary + 1, end); // sort right partition
	}
	
	private int partition(final int[] array, final int start, final int end) {
		int pivot = array[end];
		int boundary = start - 1;
		for(int i = start; i <= end; i++) {
			if(array[i] <= pivot) {
				boundary++;
				swap(array, boundary, i);
			}
		}
		return boundary;
	}
	
	private void swap(final int[] array, final int index1, final int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

}
