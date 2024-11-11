package Arrays;

/*		
 * 			Leetcode 2601. Prime Subtraction Operation Medium
 * 
You are given a 0-indexed integer array nums of length n.

You can perform the following operation as many times as you want:

Pick an index i that you haven’t picked before, and pick a prime p strictly less than nums[i], then subtract p from nums[i].
Return true if you can make nums a strictly increasing array using the above operation and false otherwise.

A strictly increasing array is an array whose each element is strictly greater than its preceding element.

 

Example 1:

Input: nums = [4,9,6,10]
Output: true
Explanation: In the first operation: Pick i = 0 and p = 3, and then subtract 3 from nums[0], so that nums becomes [1,9,6,10].
In the second operation: i = 1, p = 7, subtract 7 from nums[1], so nums becomes equal to [1,2,6,10].
After the second operation, nums is sorted in strictly increasing order, so the answer is true.

Example 2:

Input: nums = [6,8,11,12]
Output: true
Explanation: Initially nums is sorted in strictly increasing order, so we don't need to make any operations.

Example 3:

Input: nums = [5,8,3]
Output: false
Explanation: It can be proven that there is no way to perform operations to make nums sorted in strictly increasing order, so the answer is false.
*/

public class PrimeSubtractionOperation {
	
	public boolean primeSubOperation(int[] nums) {
        int n=nums.length;

        int[] siv=new int[1001];
        for(int i=2;i<1001;i++)siv[i]=1;
        for(int i=2;i*i<=1000;i++){
            if(siv[i]==1){
                for(int j=i*i;j<=1000;j+=i)siv[j]=0;
            }
        }

        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1])continue;

            for(int p=2;p<nums[i];p++){
                if(siv[p]!=1)continue;

                if(nums[i]-p<nums[i+1]){
                    nums[i]-=p;
                    break;
                }
            }

            if(nums[i]>=nums[i+1])return false;
        }


        
        return true;
    }

}
