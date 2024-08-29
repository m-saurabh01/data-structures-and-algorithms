package String;

/*
				WildCard Matching Leetcode 44 Hard 

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 

Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.
*/

public class WildCardMatching {
	
	static Boolean[][] dp;
	static boolean solve(String s, String p,int i,int j){

        if(dp[i][j]!=null)return dp[i][j];

        if(i>=s.length() && j>=p.length())return dp[i][j]=true;
        if(j>=p.length() && i<s.length())return dp[i][j]=false;
        if(i>=s.length() && j<p.length()){
            for(int x=j;x<p.length();x++){
                if(p.charAt(x)!='*')return dp[i][j]=false;
            }
            return dp[i][j]=true;
        }
        
        

        if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?'){
            return dp[i][j]=solve(s,p,i+1,j+1);
        }

        if(p.charAt(j)=='*'){
            return dp[i][j]=solve(s,p,i,j+1)||solve(s,p,i+1,j+1)||solve(s,p,i+1,j);
        }

        return dp[i][j]=false;
    }
    public static boolean isMatch(String s, String p) {
         dp=new Boolean[s.length()+1][p.length()+1];
        return solve(s,p,0,0);
    }

}
