package dev.mounish.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpression {
	
	private static final List<Character> openBrackets = Arrays.asList('(', '{', '[', '<');
	
	private static final List<Character> closeBrackets = Arrays.asList(')', '}', ']', '>');
	
	public static void main(String[] args) {
		BalancedExpression be = new BalancedExpression();
		System.out.println(be.isBalanced("(a + b))"));
	}
	
	public boolean isBalanced(final String input) {
		Stack<Character> stack = new Stack();
		for(char ch : input.toCharArray()) {
			if(isOpenBracket(ch)) {
				stack.push(ch);
			}
			
			if(isCloseBracket(ch)) {
				if(stack.empty()) return false;
				
				char lastOpenBracket = (char) stack.pop();
				if(!isBracketsMatch(lastOpenBracket, ch)) return false;
			}
		}
		return stack.empty();
	}
	
	private boolean isOpenBracket(final char ch) {
		return openBrackets.contains(ch);
	}
	
	private boolean isCloseBracket(final char ch) {
		return closeBrackets.contains(ch);
	}
	
	private boolean isBracketsMatch(final char open, final char close) {
		return openBrackets.indexOf(open) == closeBrackets.indexOf(close);
	}

}
