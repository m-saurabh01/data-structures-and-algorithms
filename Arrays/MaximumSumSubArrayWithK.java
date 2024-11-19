package Arrays;

import java.util.HashSet;
import java.util.Set;

/*
 * 					Leetcode Medium 2461. Maximum Sum of Distinct Subarrays With Length K
 * 
You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
Example 2:

Input: nums = [4,4,4], k = 3
Output: 0
Explanation: The subarrays of nums with length 3 are:
- [4,4,4] which does not meet the requirements because the element 4 is repeated.
We return 0 because no subarrays meet the conditions.
 */
public class MaximumSumSubArrayWithK {
	
	public long maximumSubarraySum(int[] nums, int k) {

        int i=0,j=0,n=nums.length;
        long sum=0,res=0;
        Set<Integer> hs=new HashSet<>();

        while(i<=n-k && j<n){

            while(j<n && j-i+1<=k){
                
                if(!hs.contains(nums[j])){
                    sum+=nums[j];
                    hs.add(nums[j]);
                    j++;
                }else{
                    while(hs.contains(nums[j])){
                        sum-=nums[i];
                        hs.remove(nums[i]);
                        i++;
                    }
                }
            }

            if(hs.size()==k){
                res=Math.max(res,sum);
                hs.remove(nums[i]);
                sum-=nums[i];
            }
            i++;

        }
        
        return res;
    }

}
