package dev.mounish.sortingalgorithms;

public class InsertionSort {
	
	public void sort(final int[] array) {
		for(int i = 1; i < array.length; i++) {
			int current = array[i];
			
			int j = i - 1;
			for(; j >= 0 && array[j] > current; j--) {
				array[j + 1] = array[j];
			}
			
			array[j + 1] = current;
		}
	}

}
