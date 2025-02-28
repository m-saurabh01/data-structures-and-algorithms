package String;

/*
 * 				Leetcode Hard 1092. Shortest Common Supersequence 
 * 
Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

 

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
*/
public class ShortestCommonSupersequence {
	
	public String shortestCommonSupersequence(String str1, String str2) {
	    int m = str1.length(), n = str2.length();
	    

	    int[][] dp = new int[m + 1][n + 1];

	    for (int i = 1; i <= m; i++) {
	        for (int j = 1; j <= n; j++) {
	            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
	                dp[i][j] = dp[i - 1][j - 1] + 1;
	            } else {
	                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
	            }
	        }
	    }


	    StringBuilder scs = new StringBuilder();
	    int i = m, j = n;

	    while (i > 0 && j > 0) {
	        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
	            scs.append(str1.charAt(i - 1));  
	            i--; j--;
	        } else if (dp[i - 1][j] > dp[i][j - 1]) {
	            scs.append(str1.charAt(i - 1));  
	            i--;
	        } else {
	            scs.append(str2.charAt(j - 1));  
	            j--;
	        }
	    }

	    while (i > 0) scs.append(str1.charAt(--i));
	    while (j > 0) scs.append(str2.charAt(--j));

	    return scs.reverse().toString(); 
	}

}
