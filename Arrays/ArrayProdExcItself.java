package Arrays;

/*				Product of Array except itself Leetcode 238 Medium
 * 
 * 
 * 
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 
*/


public class ArrayProdExcItself {
	
	public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] prSum=new int[n];
        int[] srSum=new int[n];
        int[] res=new int[n];
        prSum[0]=nums[0];
        srSum[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            prSum[i]=prSum[i-1]*nums[i];
            srSum[n-i-1]=srSum[n-i]*nums[n-i-1];
        }

        for(int i=0;i<n;i++){
            res[i]=((i-1<0?1:prSum[i-1]))*(i+1>=n?1:srSum[i+1]);
        }
        
        return res;
    }

}
