package String;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * 		Leetcode Medium 1415. The k-th Lexicographical String of All Happy Strings of Length n
 * 
A happy string is a string that:

consists only of letters of the set ['a', 'b', 'c'].
s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.

Return the kth string of this list or return an empty string if there are less than k happy strings of length n.

 

Example 1:

Input: n = 1, k = 3
Output: "c"
Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
*/
public class KthLexographicalOfAllHappyString {
	
	public String getHappyString(int n, int k) {
	    Map<Character, String> nextLetters = Map.of('a', "bc", 'b', "ac", 'c', "ab");
	    Queue<String> q = new ArrayDeque<>(List.of("a", "b", "c"));

	    while (q.peek().length() != n) {
	      final String u = q.poll();
	      for (final char nextLetter : nextLetters.get(u.charAt(u.length() - 1)).toCharArray())
	        q.offer(u + nextLetter);
	    }

	    if (q.size() < k)
	      return "";

	    for (int i = 0; i < k - 1; ++i)
	      q.poll();
	    return q.poll();
	  }

}
