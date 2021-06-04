package dev.mounish.searchingalgorithms;

public class SearchingAlgorithms {
	
	public int linearSearch(final int[] array, final int target) {
		for(int i = 0; i < array.length; i++)
			if(target == array[i]) return i;
		
		return -1;
	}
	
	public int binarySearch(final int[] array, final int target) {
		return binarySearch(array, target, 0, array.length - 1);
	}
	private int binarySearch(final int[] array, final int target, final int start, final int end) {
		if(start > end)
			return -1;
		
		final int middle = (start + end) / 2;
		
		if(target > array[middle])
			return binarySearch(array, target, middle + 1, end);
		else if(target < array[middle])
			return binarySearch(array, target, start, middle - 1);
		else
			return middle;
	}
	
	public int binarySearchByIteration(final int[] array, final int target) {
		int start = 0;
		int end = array.length - 1;
		
		while(start <= end) {
			final int middle = (start + end) / 2;
			
			if(target > array[middle])
				start = middle + 1;
			else if(target < array[middle])
				end = middle - 1;
			else
				return middle;
		}
		
		return -1;
	}
	
	public int ternarySearch(final int[] array, final int target) {
		return binarySearch(array, target, 0, array.length - 1);
	}
	private int ternarySearch(final int[] array, final int target, final int start, final int end) {
		if(start > end)
			return -1;
		
		final int partitionSize = (start - end) / 3;
		final int middle1 = start + partitionSize;
		final int middle2 = end - partitionSize;
		
		if(target < array[middle1])
			return binarySearch(array, target, start, middle1 - 1);
		
		if(target == array[middle1])
			return middle1;
		
		if(target > array[middle1] && target < array[middle2])
			return binarySearch(array, target, middle1 + 1, middle2 - 1);
		
		if(target == array[middle2])
			return middle2;
		
		if(target > array[middle2])
			return binarySearch(array, target, middle2 + 1, end);
		
		return -1;
	}
	
	public int jumpSearch(final int[] array, final int target) {
		int blockSize = (int) Math.sqrt(array.length);
		int first = 0;
		int last = blockSize - 1;
		
		while(first < array.length) {
			if(target == array[last])
				return last;
			
			if(target < array[last]) {
				for(int i = first; i <= last && i < array.length; i++) {
					if(target == array[i])
						return i;
				}
				return -1;
			}
			
			first = first + blockSize;
			last = last + blockSize;
		}
		
		return -1;
	}
	
	public int exponentialSearch(final int[] array, final int target) {
		int bound = 1;
		
		while(bound < array.length && target > array[bound])
			bound = bound * 2;
		
		final int start = bound / 2;
		final int end = Math.min(bound, array.length - 1);
		
		return binarySearch(array, target, start, end);
	}

}
