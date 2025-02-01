package Arrays;

/*
 * 				Leetcode Easy 3151. Special Array I
 * 
 * 
An array is considered special if every pair of its adjacent elements contains two numbers with different parity.

You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.

 

Example 1:

Input: nums = [1]

Output: true

Explanation:

There is only one element. So the answer is true.
*/public class SpecialArray1 {
	
	public boolean isArraySpecial(int[] nums) {

        if(nums.length==0||nums==null)return true;

        boolean odd=nums[0]%2!=0;

        for(int i=1;i<nums.length;i++){
            
            if(nums[i]%2!=0 == odd){
                return false;
            }

            odd=!odd;
        }
        
        return true;
    }

}
