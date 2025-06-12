package Arrays;

/*
		3423. Maximum Difference Between Adjacent Elements in a Circular Array
*/
public class MaxDiffBtwAdjacentElementInCircularArray {
	
	public int maxAdjacentDistance(int[] nums) {
        int n=nums.length;
        int mx=Math.abs(nums[0]-nums[n-1]);

        for(int i=0;i<n-1;i++){
            mx=Math.max(mx,Math.abs(nums[i+1]-nums[i]));
        }

        return mx;
    }

}
