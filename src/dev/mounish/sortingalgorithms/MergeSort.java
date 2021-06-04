package dev.mounish.sortingalgorithms;

public class MergeSort {
	
	public void sort(final int[] array) {
		if(array.length < 2)
			return;
		
		int middle = array.length / 2;
		
		int[] left = new int[middle];
		for(int i = 0; i < middle; i++)
			left[i] = array[i];
		
		int[] right = new int[array.length - middle];
		for(int i = middle; i < array.length; i++)
			right[i - middle] = array[i];
		
		sort(left);
		sort(right);
		
		merge(left, right, array);
	}
	
	private void merge(final int[] left, final int[] right, final int[] result) {
		int i = 0, j = 0, k = 0;
		while(i < left.length && j < right.length) {
			if(left[i] > right[j]) {
				result[k] = right[j];
				j++;
			} else {
				result[k] = left[i];
				i++;
			}
			k++;
		}
		
		while(i < left.length) {
			result[k] = left[i];
			i++;
			k++;
		}
		
		while(j < right.length) {
			result[k] = right[j];
			j++;
			k++;
		}
	}

}
