package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;


/*				Leetcode 962 Max width Rank (Medium)
 * 
 * 
A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.

Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.

 

Example 1:

Input: nums = [6,0,8,2,1,5]
Output: 4
Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5] = 5.
Example 2:

Input: nums = [9,8,1,0,1,9,4,0,4,1]
Output: 7
Explanation: The maximum width ramp is achieved at (i, j) = (2, 9): nums[2] = 1 and nums[9] = 1.
*/ 
public class MaxWidthRamp {
	
	public int maxWidthRamp(int[] nums) {
	    int ans = 0;
	    Deque<Integer> stack = new ArrayDeque<>();

	    for (int i = 0; i < nums.length; ++i)
	      if (stack.isEmpty() || nums[i] < nums[stack.peek()])
	        stack.push(i);

	    for (int i = nums.length - 1; i > ans; --i)
	      while (!stack.isEmpty() && nums[i] >= nums[stack.peek()])
	        ans = Math.max(ans, i - stack.pop());

	    return ans;
	  }

}
