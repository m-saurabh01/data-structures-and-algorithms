package String;

import java.util.Stack;

/*
				Valid Paranthesis Leetcode 20 (Easy)

	
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

*/

public class ValidParanthesis {

	public static boolean isValid(String s) {

		Stack<Character> stk = new Stack<>();

		for (char c : s.toCharArray()) {
			if (!stk.isEmpty() && ((c == ')' && stk.peek() == '(') || (c == '}' && stk.peek() == '{')
					|| (c == ']' && stk.peek() == '['))) {
				stk.pop();

			} else {
				stk.push(c);
			}

		}
		if (stk.isEmpty())
			return true;
		return false;
	}
	
	
	
	public static void main(String[] args) {
		
		
		String test="([])";
		
		//Outputs true
		System.out.println(isValid(test));
	}

}
