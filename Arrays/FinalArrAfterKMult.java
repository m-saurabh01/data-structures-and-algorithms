package Arrays;

/*
 * 		Leetcode Easy 3264. Final Array State After K Multiplication Operations I
 * 
 * 
You are given an integer array nums, an integer k, and an integer multiplier.

You need to perform k operations on nums. In each operation:

Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that appears first.
Replace the selected minimum value x with x * multiplier.
Return an integer array denoting the final state of nums after performing all k operations.
*/

public class FinalArrAfterKMult {
	
	public int[] getFinalState(int[] nums, int k, int mu) {

        while(k>0){
            int j=0;

            for(int i=1;i<nums.length;i++){
                if(nums[i]<nums[j])j=i;
            }

            nums[j]=nums[j]*mu;
            k--;
        }

        return nums;
        
    }

}
