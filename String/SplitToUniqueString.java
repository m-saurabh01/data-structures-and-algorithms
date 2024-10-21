package String;

import java.util.HashSet;
import java.util.Set;

/*				Leetcode Medium 1593. Split a String Into the Max Number of Unique Substrings

Given a string s, return the maximum number of unique substrings that the given string can be split into.

You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: s = "ababccc"
Output: 5
Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc']. Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.
Example 2:

Input: s = "aba"
Output: 2
Explanation: One way to split maximally is ['a', 'ba'].
Example 3:

Input: s = "aa"
Output: 1
Explanation: It is impossible to split the string any further.
*/
public class SplitToUniqueString {
	
	public int maxUniqueSplit(String s) {

        Set<String> set=new HashSet<>();

        return solve(set,s,0,"");
        
    }


    int solve(Set<String> set,String s,int i,String ins){

        if(i>=s.length())return set.size();

        ins+=s.charAt(i);

        int tk=Integer.MIN_VALUE,ntk=Integer.MIN_VALUE;

        if(!set.contains(ins)){
            set.add(ins);
            tk=solve(set,s,i+1,"");
            set.remove(ins);
            ntk=solve(set,s,i+1,ins);
        }
        else{
            return solve(set,s,i+1,ins);
        }

        return Math.max(tk,ntk);
    }

}
