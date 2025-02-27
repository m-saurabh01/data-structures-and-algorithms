package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 		Leetcode Medium 873. Length of Longest Fibonacci Subsequence
 * 
 * 
A sequence x1, x2, ..., xn is Fibonacci-like if:

n >= 3
xi + xi+1 == xi+2 for all i + 2 <= n
Given a strictly increasing array arr of positive integers forming a sequence, return the length of the longest Fibonacci-like subsequence of arr. If one does not exist, return 0.

A subsequence is derived from another sequence arr by deleting any number of elements (including none) from arr, without changing the order of the remaining elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].

 

Example 1:

Input: arr = [1,2,3,4,5,6,7,8]
Output: 5
Explanation: The longest subsequence that is fibonacci-like: [1,2,3,5,8].
*/
public class LengthofLongestFibonacciSubsequence {
	
	public int lenLongestFibSubseq(int[] arr) {
	    final int n = arr.length;
	    int ans = 0;
	    int[][] dp = new int[n][n];
	    Arrays.stream(dp).forEach(A -> Arrays.fill(A, 2));
	    Map<Integer, Integer> numToIndex = new HashMap<>();

	    for (int i = 0; i < n; ++i)
	      numToIndex.put(arr[i], i);

	    for (int j = 0; j < n; ++j)
	      for (int k = j + 1; k < n; ++k) {
	        final int ai = arr[k] - arr[j];
	        if (ai < arr[j] && numToIndex.containsKey(ai)) {
	          final int i = numToIndex.get(ai);
	          dp[j][k] = dp[i][j] + 1;
	          ans = Math.max(ans, dp[j][k]);
	        }
	      }

	    return ans;
	  }

}
