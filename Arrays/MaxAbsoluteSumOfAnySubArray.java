package Arrays;

/*
 * 			Leetcode Medium 1749. Maximum Absolute Sum of Any Subarray
 * 
You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).

Return the maximum absolute sum of any (possibly empty) subarray of nums.

Note that abs(x) is defined as follows:

If x is a negative integer, then abs(x) = -x.
If x is a non-negative integer, then abs(x) = x.
 

Example 1:

Input: nums = [1,-3,2,3,-4]
Output: 5
Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.
*/

public class MaxAbsoluteSumOfAnySubArray {
	
	public int maxAbsoluteSum(int[] nums) {

        int max=nums[0];
        int min=nums[0];
        int n=nums.length;
        int cur=nums[0];

        for(int i=1;i<n;i++){
            cur=Math.max(nums[i],cur+nums[i]);
            max=Math.max(max,cur);
        }

        cur=nums[0];
        for(int i=1;i<n;i++){
            cur=Math.min(nums[i],cur+nums[i]);
            min=Math.min(min,cur);
        }


        return Math.max(Math.abs(max),Math.abs(min));
        
    }

}
