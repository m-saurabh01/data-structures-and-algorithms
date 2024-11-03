package String;

/*		Leetcode 796 Rotate String Easy
 * 
 * 
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
 */
public class RotateString {
	
	
	public boolean rotateString(String s, String goal) {

        if(s.length()==goal.length() &&(s+s).contains(goal))return true;

        return false;
        
    }

}
