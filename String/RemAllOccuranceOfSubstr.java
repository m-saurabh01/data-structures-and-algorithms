package String;

/*
 * 			Leetcode Medium 1910. Remove All Occurrences of a Substring
 * 
 * 
Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:

Find the leftmost occurrence of the substring part and remove it from s.
Return s after removing all occurrences of part.

A substring is a contiguous sequence of characters in a string.

 

Example 1:

Input: s = "daabcbaabcbc", part = "abc"
Output: "dab"
Explanation: The following operations are done:
- s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
- s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
- s = "dababc", remove "abc" starting at index 3, so s = "dab".
Now s has no occurrences of "abc".
*/

public class RemAllOccuranceOfSubstr {
	
	public String removeOccurrences(String s, String part) {
	    final int n = s.length();
	    final int k = part.length();

	    StringBuilder sb = new StringBuilder(s);
	    int j = 0; 

	    for (int i = 0; i < n; ++i) {
	      sb.setCharAt(j++, s.charAt(i));
	      if (j >= k && sb.substring(j - k, j).toString().equals(part))
	        j -= k;
	    }

	    return sb.substring(0, j).toString();
	  }

}
