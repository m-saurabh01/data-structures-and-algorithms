package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * 		Leetcode Medium 2364. Count Number of Bad Pairs
 * 
 * 
You are given a 0-indexed integer array nums. A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].

Return the total number of bad pairs in nums.

 

Example 1:

Input: nums = [4,1,3,3]
Output: 5
Explanation: The pair (0, 1) is a bad pair since 1 - 0 != 1 - 4.
The pair (0, 2) is a bad pair since 2 - 0 != 3 - 4, 2 != -1.
The pair (0, 3) is a bad pair since 3 - 0 != 3 - 4, 3 != -1.
The pair (1, 2) is a bad pair since 2 - 1 != 3 - 1, 1 != 2.
The pair (2, 3) is a bad pair since 3 - 2 != 3 - 3, 1 != 0.
There are a total of 5 bad pairs, so we return 5.

*/

public class CountNoOfBadPairs {
	
	public long countBadPairs(int[] nums) {
	    long ans = 0;
	    Map<Integer, Long> count = new HashMap<>(); 

	    for (int i = 0; i < nums.length; ++i) {
	     
	      ans += i - count.getOrDefault(nums[i] - i, 0L);
	      count.merge(nums[i] - i, 1L, Long::sum);
	    }

	    return ans;
	  }


}
