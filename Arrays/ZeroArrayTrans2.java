package Arrays;

/*
 * 
 * 		Leetcode Medium 3356. Zero Array Transformation II
 * 
 * 
You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri, vali].

Each queries[i] represents the following action on nums:

Decrement the value at each index in the range [li, ri] in nums by at most vali.
The amount by which each value is decremented can be chosen independently for each index.
A Zero Array is an array with all its elements equal to 0.

Return the minimum possible non-negative value of k, such that after processing the first k queries in sequence, nums becomes a Zero Array. If no such k exists, return -1.

 

Example 1:

Input: nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]

Output: 2

Explanation:

For i = 0 (l = 0, r = 2, val = 1):
Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
The array will become [1, 0, 1].
For i = 1 (l = 0, r = 2, val = 1):
Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
The array will become [0, 0, 0], which is a Zero Array. Therefore, the minimum value of k is 2.
*/

public class ZeroArrayTrans2 {
	
	public int minZeroArray(int[] nums, int[][] queries) {
	    int[] line = new int[nums.length + 1];
	    int decrement = 0;
	    int k = 0;

	    for (int i = 0; i < nums.length; ++i) {
	      while (decrement + line[i] < nums[i]) {
	        if (k == queries.length)
	          return -1;
	        final int l = queries[k][0];
	        final int r = queries[k][1];
	        final int val = queries[k][2];
	        ++k;
	        if (r < i)
	          continue;
	        line[Math.max(l, i)] += val;
	        line[r + 1] -= val;
	      }
	      decrement += line[i];
	    }

	    return k;
	  }

}
