package Arrays;


/*
 * 		Leetcode Easy 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
 * 
You are given an array of integers nums. Return the length of the longest 
subarray
 of nums which is either 
strictly increasing
 or 
strictly decreasing
.

 

Example 1:

Input: nums = [1,4,3,3,2]

Output: 2

Explanation:

The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].

The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].

Hence, we return 2.
*/

public class LongestStricIncDec {
	
	public int longestMonotonicSubarray(int[] nums) {

        int i=0,res=1,n=nums.length;

        while(i<n){
            if(i==0){
                i++;
                continue;
            }
            
            while(i<n && nums[i]==nums[i-1])i++;

            int prev=i-1;

            if(i<n && nums[i]<nums[prev]){
                int p=prev;
                while(i<n && nums[i]<nums[prev++])i++;

                res=Math.max(res,i-p);
            }else if(i<n && nums[i]>nums[prev]){
                int p=prev;
                while(i<n && nums[i]>nums[prev++])i++;

                res=Math.max(res,i-p);
            }

            
            
        }

        return res;
        
    }

}
