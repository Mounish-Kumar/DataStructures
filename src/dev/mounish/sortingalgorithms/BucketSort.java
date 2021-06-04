package dev.mounish.sortingalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
	
	public void sort(final int[] array, final int numberOfBuckets) {
		int i = 0;
		for(List<Integer> bucket : createBuckets(array, numberOfBuckets)) {
			Collections.sort(bucket);
			
			for(Integer item : bucket)
				array[i] = item;
		}
	}
	
	private List<List<Integer>> createBuckets(final int[] array, final int numberOfBuckets) {
		List<List<Integer>> buckets = new ArrayList();
		
		for(int i = 0; i < numberOfBuckets; i++)
			buckets.add(new ArrayList<Integer>());
		
		for(int item : array)
			buckets.get(item / numberOfBuckets).add(item);
		
		return buckets;
	}

}
