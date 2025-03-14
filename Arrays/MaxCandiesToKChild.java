package Arrays;

import java.util.Arrays;


/*
 * 			Leetcode Medium 2226. Maximum Candies Allocated to K Children
 * 
 * 
You are given a 0-indexed integer array candies. Each element in the array denotes a pile of candies of size candies[i]. You can divide each pile into any number of sub piles, but you cannot merge two piles together.

You are also given an integer k. You should allocate piles of candies to k children such that each child gets the same number of candies. Each child can be allocated candies from only one pile of candies and some piles of candies may go unused.

Return the maximum number of candies each child can get.

 

Example 1:

Input: candies = [5,8,6], k = 3
Output: 5
Explanation: We can divide candies[1] into 2 piles of size 5 and 3, and candies[2] into 2 piles of size 5 and 1. We now have five piles of candies of sizes 5, 5, 3, 5, and 1. We can allocate the 3 piles of size 5 to 3 children. It can be proven that each child cannot receive more than 5 candies.

*/

public class MaxCandiesToKChild {
	
	public int maximumCandies(int[] candies, long k) {
	    int l = 1;
	    int r = (int) (Arrays.stream(candies).asLongStream().sum() / k);

	    while (l < r) {
	      final int m = (l + r) / 2;
	      if (numChildren(candies, m) < k)
	        r = m;
	      else
	        l = m + 1;
	    }

	    return numChildren(candies, l) >= k ? l : l - 1;
	  }

	  private long numChildren(int[] candies, int m) {
	    return Arrays.stream(candies).asLongStream().reduce(0L, (subtotal, c) -> subtotal + c / m);
	  }

}
