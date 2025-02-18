package String;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/*
 * 			Leetcode Medium 2375. Construct Smallest Number From DI String
 * 
You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and 'D' meaning decreasing.

A 0-indexed string num of length n + 1 is created using the following conditions:

num consists of the digits '1' to '9', where each digit is used at most once.
If pattern[i] == 'I', then num[i] < num[i + 1].
If pattern[i] == 'D', then num[i] > num[i + 1].
Return the lexicographically smallest possible string num that meets the conditions.

 

Example 1:

Input: pattern = "IIIDIDDD"
Output: "123549876"
Explanation:
At indices 0, 1, 2, and 4 we must have that num[i] < num[i+1].
At indices 3, 5, 6, and 7 we must have that num[i] > num[i+1].
Some possible values of num are "245639871", "135749862", and "123849765".
It can be proven that "123549876" is the smallest possible num that meets the conditions.
Note that "123414321" is not possible because the digit '1' is used more than once.
*/

public class ConstructNumFromDiString {
	
	public String smallestNumber(String pattern) {
	    StringBuilder sb = new StringBuilder();
	    Deque<Character> stack = new ArrayDeque<>(List.of('1'));

	    for (final char c : pattern.toCharArray()) {
	      char maxSorFar = stack.peek();
	      if (c == 'I')
	        while (!stack.isEmpty()) {
	          maxSorFar = (char) Math.max(maxSorFar, stack.peek());
	          sb.append(stack.pop());
	        }
	      stack.push((char) (maxSorFar + 1));
	    }

	    while (!stack.isEmpty())
	      sb.append(stack.pop());

	    return sb.toString();
	  }

}
