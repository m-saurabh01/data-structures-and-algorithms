package Arrays;

/*
 * 			Leetcode Medium 769. Max Chunks To Make Sorted
 * 
You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].

We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.

Return the largest number of chunks we can make to sort the array.

 

Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
*/

public class MaxChunkToMakeSorted {
	
	 public int maxChunksToSorted(int[] arr) {
		    int ans = 0;
		    int mx = Integer.MIN_VALUE;

		    for (int i = 0; i < arr.length; ++i) {
		      mx = Math.max(mx, arr[i]);
		      if (mx == i)
		        ++ans;
		    }

		    return ans;
		  }

}
