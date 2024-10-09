package String;

import java.util.Stack;


/*		Leetcode 921. Minimum Add to Make Parentheses Valid (Medium)
 * 

A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

 

Example 1:

Input: s = "())"
Output: 1

Example 2:

Input: s = "((("
Output: 3

*/
public class MinAddToMakeParamValid {
	
	public int minAddToMakeValid(String s) {
        Stack<Character> stk=new Stack<>();

        for(int i=0;i<s.length();i++){
            if(!stk.isEmpty() && s.charAt(i)==')' && stk.peek()=='(')stk.pop();
            else stk.push(s.charAt(i));
        }

        return stk.size();
    }

}
