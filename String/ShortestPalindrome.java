package String;

/*
 * 			Shortest Palindrome Leetcode hard 214
 * 
 * 
You are given a string s. You can convert s to a 
palindrome
 by adding characters in front of it.

Return the shortest palindrome you can find by performing this transformation.

 

Example 1:

Input: s = "aacecaaa"
Output: "aaacecaaa"
Example 2:

Input: s = "abcd"
Output: "dcbabcd"
*/
public class ShortestPalindrome {
	
	
	public String shortestPalindrome(String s) {
	    final String t = new StringBuilder(s).reverse().toString();

	    for (int i = 0; i < t.length(); ++i)
	      if (s.startsWith(t.substring(i)))
	        return t.substring(0, i) + s;

	    return t + s;
	  }

}
