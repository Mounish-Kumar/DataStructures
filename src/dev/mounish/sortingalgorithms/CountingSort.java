package dev.mounish.sortingalgorithms;

public class CountingSort {
	
	public void sort(final int[] array, final int max) {
		int[] counts = new int[max + 1];
		for(int item : array)
			counts[item]++;
		
		int j = 0;
		for(int i = 0; i < counts.length; i++) {
			while(counts[i] > 0) {
				array[j] = i;
				j++;
				counts[i]--;
			}
		}
	}

}
