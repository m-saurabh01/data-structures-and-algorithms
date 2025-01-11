package String;

import java.util.Arrays;

/*
 * 		Leetcode 1400. Construct K Palindrome Strings Medium
 * 
 * 
Given a string s and an integer k, return true if you can use all the characters in s to construct k palindrome strings or false otherwise.

		 

Example 1:

Input: s = "annabelle", k = 2
Output: true
Explanation: You can construct two palindromes using all characters in s.
Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"
*/

 public class ConstructKPalString {
	
	
	public boolean canConstruct(String s, int k) {
	    
	    if (s.length() < k)
	      return false;

	    int[] count = new int[26];

	    for (final char c : s.toCharArray())
	      count[c - 'a'] ^= 1;

	    return Arrays.stream(count).filter(c -> c % 2 == 1).count() <= k;
	  }

}
