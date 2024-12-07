package BinarySearch;

import java.util.Arrays;

/*
 * 			Leetcode Medium 1760. Minimum Limit of Balls in a Bag
 * 
You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an integer maxOperations.

You can perform the following operation at most maxOperations times:

Take any bag of balls and divide it into two new bags with a positive number of balls.
For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.
Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.

Return the minimum possible penalty after performing the operations.

 

Example 1:

Input: nums = [9], maxOperations = 2
Output: 3
Explanation: 
- Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3].
- Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3].
The bag with the most number of balls has 3 balls, so your penalty is 3 and you should return 3.
*/
public class MinLimitOfBallInBag {
	
	public int minimumSize(int[] nums, int max) {
        int r=Arrays.stream(nums).max().getAsInt();
        int l=1,res=Integer.MAX_VALUE;

        while(l<=r){
            int mid=(r+l)/2;

            if(possible(nums,mid,max)){
                res=Math.min(res,mid);
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        
        return res;
    }

    boolean possible(int[] nums,int m,int mops){
        int totOps=0;

        for(int n:nums){
            int ops=n/m;

            if(n%m==0)ops--;

            totOps+=ops;
        }

        if(totOps>mops)return false;
        
        return true;
    }

}
