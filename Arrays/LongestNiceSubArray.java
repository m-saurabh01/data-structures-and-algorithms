package Arrays;

/*
 * 			Leetcode Medium 2401. Longest Nice Subarray
 * 
 * 
You are given an array nums consisting of positive integers.

We call a subarray of nums nice if the bitwise AND of every pair of elements that are in different positions in the subarray is equal to 0.

Return the length of the longest nice subarray.

A subarray is a contiguous part of an array.

Note that subarrays of length 1 are always considered nice.

 

Example 1:

Input: nums = [1,3,8,48,10]
Output: 3
Explanation: The longest nice subarray is [3,8,48]. This subarray satisfies the conditions:
- 3 AND 8 = 0.
- 3 AND 48 = 0.
- 8 AND 48 = 0.
It can be proven that no longer nice subarray can be obtained, so we return 3.
*/
public class LongestNiceSubArray {
	
	public int longestNiceSubarray(int[] nums) {
	    int ans = 0;
	    int used = 0;

	    for (int l = 0, r = 0; r < nums.length; ++r) {
	      while ((used & nums[r]) > 0)
	        used ^= nums[l++];
	      used |= nums[r];
	      ans = Math.max(ans, r - l + 1);
	    }

	    return ans;
	  }

}
