package Arrays;

/*
 * 					Leetcode Medium 2762. Continuous Subarrays
 * 
You are given a 0-indexed integer array nums. A subarray of nums is called continuous if:

Let i, i + 1, ..., j be the indices in the subarray. Then, for each pair of indices i <= i1, i2 <= j, 0 <= |nums[i1] - nums[i2]| <= 2.
Return the total number of continuous subarrays.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [5,4,2,4]
Output: 8
Explanation: 
Continuous subarray of size 1: [5], [4], [2], [4].
Continuous subarray of size 2: [5,4], [4,2], [2,4].
Continuous subarray of size 3: [4,2,4].
Thereare no subarrys of size 4.
Total continuous subarrays = 4 + 3 + 1 = 8.
It can be shown that there are no more continuous subarrays.
 

Example 2:

Input: nums = [1,2,3]
Output: 6
Explanation: 
Continuous subarray of size 1: [1], [2], [3].
Continuous subarray of size 2: [1,2], [2,3].
Continuous subarray of size 3: [1,2,3].
Total continuous subarrays = 3 + 2 + 1 = 6.

*/
public class ContinuousSubArrays {
	
	public long continuousSubarrays(int[] nums) {
	    long ans = 1; 
	    int left = nums[0] - 2;
	    int right = nums[0] + 2;
	    int l = 0;

	    
	    for (int r = 1; r < nums.length; r++) {
	      if (left <= nums[r] && nums[r] <= right) {
	        left = Math.max(left, nums[r] - 2);
	        right = Math.min(right, nums[r] + 2);
	      } else {
	        
	        left = nums[r] - 2;
	        right = nums[r] + 2;
	        l = r;
	        
	        while (nums[r] - 2 <= nums[l] && nums[l] <= nums[r] + 2) {
	          left = Math.max(left, nums[l] - 2);
	          right = Math.min(right, nums[l] + 2);
	          --l;
	        }
	        ++l;
	      }
	   
	      ans += r - l + 1;
	    }

	    return ans;
	  }

}
