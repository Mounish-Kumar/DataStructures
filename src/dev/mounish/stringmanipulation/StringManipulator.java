package dev.mounish.stringmanipulation;

import java.util.HashSet;
import java.util.Set;

public class StringManipulator {
	
	public static int findNumberOfVowels(final String value) {
		int count = 0;
		if(value != null) {
			char[] characters = value.toLowerCase().toCharArray();
			String vowels = "aeiou";
			for(Character ch : characters)
				if(vowels.indexOf(ch) != -1) count++;
		}
		return count;
	}
	
	public static String reverseString(final String value) {
		StringBuilder reversed = new StringBuilder();
		if(value != null) {
			for(int i = value.length() - 1; i >= 0; i--)
				reversed.append(value.charAt(i));
		}
		return reversed.toString();
	}
	
	public static String reverseWords(final String sentence) {
		StringBuilder reversed = new StringBuilder();
		if(sentence != null) {
			String[] words = sentence.split(" ");
			for(int i = words.length - 1; i >= 0; i--)
				reversed.append(words[i]).append(" ");
		}
		return reversed.toString().trim();
	}
	
	public static boolean checkIfRotation(final String value1, final String value2) {
		return (value1 != null && value2 != null
				&& value1.length() == value2.length()
				&& value1.concat(value1).contains(value2));
	}
	
	public static String removeDuplicates(final String value) {
		StringBuilder unique = new StringBuilder();
		Set<Character> set = new HashSet();
		if(value != null) {
			for(Character ch : value.toCharArray()) {
				if(!set.contains(ch)) {
					set.add(ch);
					unique.append(ch);
				}
			}	
		}
		return unique.toString();
	}
	
	public static char getMostRepeatedChar(final String value) {
		char result = ' ';
		if(value != null) {
			final int ASCII_SIZE = 256;
			int[] frequencies = new int[ASCII_SIZE];
			for(Character ch : value.toCharArray())
				frequencies[ch]++;
			
			int max = 0;
			for(int i = 0; i < frequencies.length; i++) {
				if(frequencies[i] > max) {
					max = frequencies[i];
					result = (char) i;
				}
			}
		}
		return result;
	}
	
	public static String capitalizeWords(final String sentence) {
		String result = "";
		if(sentence != null) {
			String[] words = sentence.trim().replaceAll(" +", " ").split(" ");
			for(int i = 0; i < words.length; i++)
				words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
			result = String.join(" ", words);
		}
		return result;
	}
	
	// Same string with letters mixed up
	public static boolean checkAnagram(final String value1, final String value2) {
		if(value1 == null || value2 == null || value1.length() != value2.length())
			return false;
		
		int[] frequencies = new int[26];
		
		for(char ch : value1.toLowerCase().toCharArray())
			frequencies[ch - 'a']++;
		
		for(char ch : value2.toLowerCase().toCharArray())
			frequencies[ch - 'a']--;
		
		for(int count : frequencies)
			if(count != 0)
				return false;
		
		return true;
	}
	
	
	// String and its reverse should be the same
	public static boolean checkPalindrome(final String value) {
		if(value == null)
			return false;

		for(int l = 0, r = value.length() - 1; l <= r; l++, r--)
			if(value.toLowerCase().charAt(l) != value.toLowerCase().charAt(r))
				return false;
		
		return true;
	}

}
