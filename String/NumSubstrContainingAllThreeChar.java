package String;

/*
 * 			Leetcode Medium 1358. Number of Substrings Containing All Three Characters
 * 
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

*/

public class NumSubstrContainingAllThreeChar {
	
	public int numberOfSubstrings(String s) {
	    int ans = 0;
	    int[] count = new int[3];

	    int l = 0;
	    for (final char c : s.toCharArray()) {
	      ++count[c - 'a'];
	      while (count[0] > 0 && count[1] > 0 && count[2] > 0)
	        --count[s.charAt(l++) - 'a'];
	 
	      ans += l;
	    }

	    return ans;
	  }

}
