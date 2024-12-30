package DynamicProgramming;

import java.util.Arrays;

/*
 * 					Leetcode 2466. Count Ways To Build Good Strings
 * 
Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then at each step perform either of the following:

Append the character '0' zero times.
Append the character '1' one times.
This can be performed any number of times.

A good string is a string constructed by the above process having a length between low and high (inclusive).

Return the number of different good strings that can be constructed satisfying these properties. Since the answer can be large, return it modulo 109 + 7.

Example 1:

Input: low = 3, high = 3, zero = 1, one = 1
Output: 8
Explanation: 
One possible valid good string is "011". 
It can be constructed as follows: "" -> "0" -> "01" -> "011". 
All binary strings from "000" to "111" are good strings in this example.

Example 2:

Input: low = 2, high = 3, zero = 1, one = 2
Output: 5
Explanation: The good strings are "00", "11", "000", "110", and "011".
*/ 
public class CountWaysToBuildGoodString {
	
	int mod=(int)(1e9+7);
    int l=0,h=0,z=0,o=0;

    int solve(int len,int[] dp){

        if(len>h)return 0;

        if(dp[len]!=-1)return dp[len];
        int add=0;
        if(len>=l)add=1;

        int add_one=solve(len+o,dp);
        int add_zero=solve(len+z,dp);


        return dp[len]=(add+add_one+add_zero)%mod;

    }

    public int countGoodStrings(int low, int high, int zero, int one) {

        int[] dp=new int[100001];
        Arrays.fill(dp,-1);

        l=low;h=high;z=zero;o=one;

        return solve(0,dp);
        
    }

}
