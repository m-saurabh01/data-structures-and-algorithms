package String;

/*
 * 			Leetcode Medium 2116. Check if a Parentheses String Can Be Valid
 * 
 * 
A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:

It is ().
It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
It can be written as (A), where A is a valid parentheses string.
You are given a parentheses string s and a string locked, both of length n. locked is a binary string consisting only of '0's and '1's. For each index i of locked,

If locked[i] is '1', you cannot change s[i].
But if locked[i] is '0', you can change s[i] to either '(' or ')'.
Return true if you can make s a valid parentheses string. Otherwise, return false.
*/

public class CheckValidParanthesis {
	
	 public boolean canBeValid(String s, String locked) {
		    if (s.length() % 2 == 1)
		      return false;

		    return check(s, locked, true) && check(new StringBuilder(s).reverse().toString(),
		                                           new StringBuilder(locked).reverse().toString(), false);
		  }

		  private boolean check(final String s, final String locked, boolean isForward) {
		    int changeable = 0;
		    int l = 0;
		    int r = 0;

		    for (int i = 0; i < s.length(); ++i) {
		      final char c = s.charAt(i);
		      final char lock = locked.charAt(i);
		      if (lock == '0')
		        ++changeable;
		      else if (c == '(')
		        ++l;
		      else 
		        ++r;
		      if (isForward && changeable + l - r < 0)
		        return false;
		      if (!isForward && changeable + r - l < 0)
		        return false;
		    }

		    return true;
		  }

}
