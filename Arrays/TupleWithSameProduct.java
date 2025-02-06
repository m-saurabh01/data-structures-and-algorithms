package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * 			Leetcode Medium 1726. Tuple with Same Product
 * 
Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that
a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.



Example 1:

Input: nums = [2,3,4,6]
Output: 8
Explanation: There are 8 valid tuples:
(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
*/
public class TupleWithSameProduct {
	
	public int tupleSameProduct(int[] nums) {
	    int ans = 0;
	    Map<Integer, Integer> count = new HashMap<>();

	    for (int i = 0; i < nums.length; ++i)
	      for (int j = 0; j < i; ++j) {
	        final int prod = nums[i] * nums[j];
	        ans += count.getOrDefault(prod, 0) * 8;
	        count.merge(prod, 1, Integer::sum);
	      }

	    return ans;
	  }

}
