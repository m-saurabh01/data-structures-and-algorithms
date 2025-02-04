package Arrays;

/*
 * 						Leetcode Easy 1800. Maximum Ascending Subarray Sum
 * 
Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.

A subarray is defined as a contiguous sequence of numbers in an array.

A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi  < numsi+1. Note that a subarray of size 1 is ascending.

 

Example 1:

Input: nums = [10,20,30,5,10,50]
Output: 65
Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.
*/

public class MaxAscSubarraySum {
	
	public int maxAscendingSum(int[] nums) {

        int i=0,res=0,n=nums.length;

        
        while(i<n){

            while(i<n-1 && nums[i]==nums[i+1])i++;

            if(i<n-1 && nums[i]>nums[i+1]){
                int sum=nums[i];
                res=Math.max(res,sum);
                i++;
            }else{
                int sum=nums[i];

                while(i<n-1 && nums[i]<nums[i+1]){
                    sum+=nums[i+1];
                    i++;
                }

                res=Math.max(res,sum);
                i++;
            }

        }

        return res;
        
    }

}
