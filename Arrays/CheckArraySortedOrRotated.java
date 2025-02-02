package Arrays;

/*
 * 					Leetcode Easy 1752. Check if Array Is Sorted and Rotated
 * 
Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
*/
public class CheckArraySortedOrRotated {
	
	public boolean check(int[] nums) {
        if(nums.length<2)return true;

        int n=nums.length;
        
        int drop=0,x=-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                drop++;
                x=i;
            }

            if(drop>1)return false;
        }

        for(int i=0;i<x;i++){
            if(nums[n-1]>nums[i])return false;
        }
        

        return true;
    }

}
