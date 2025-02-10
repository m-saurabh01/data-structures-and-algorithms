package String;

/*
 * 						Leetcode Easy 3174. Clear Digits
 * 
 * 
You are given a string s.

Your task is to remove all digits by doing this operation repeatedly:

Delete the first digit and the closest non-digit character to its left.
Return the resulting string after removing all digits.

 

Example 1:

Input: s = "abc"

Output: "abc"

Explanation:

There is no digit in the string.
*/

public class ClearDigits {
	
	public String clearDigits(String s) {
	    StringBuilder sb = new StringBuilder();

	    for (final char c : s.toCharArray())
	      if (Character.isDigit(c))
	        sb.setLength(sb.length() - 1);
	      else
	        sb.append(c);

	    return sb.toString();
	  }

}
