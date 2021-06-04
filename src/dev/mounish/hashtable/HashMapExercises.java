package dev.mounish.hashtable;

import java.util.HashMap;

public class HashMapExercises {
	
	public static void main(String[] args) {
		HashMapExercises obj = new HashMapExercises();
		System.out.println(obj.getPairsInArrayWithSum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9}, 10));
	}
	
	private HashMap getFrequencyOfItemsInArray(final int[] array) {
		HashMap<Integer, Integer> map = new HashMap();
		for(int item : array) {
			int count = map.containsKey(item) ? map.get(item) + 1 : 1;
			map.put(item, count);
		}
		return map;
	}
	
	private HashMap getPairsInArrayWithSum(final int[] array, final int sum) {
		HashMap<Integer, Integer> result = new HashMap();
		HashMap<Integer, Integer> map = new HashMap();
		for(int item : array) {
			if(map.containsKey(sum - item)) {
				result.put(item, sum - item);
			}
			map.put(item, null);
		}
		return result;
	}

}
