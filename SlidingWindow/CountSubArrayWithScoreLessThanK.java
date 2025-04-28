package SlidingWindow;

/*
			2302. Count Subarrays With Score Less Than K
*/

public class CountSubArrayWithScoreLessThanK {
	
	public long countSubarrays(int[] nums, long k) {
        int n=nums.length;

        int i=0,j=0;
        long sum=0,res=0;

        while(j<n){
            sum+=nums[j];

            while(i<=j && (j-i+1)*sum>=k){
                sum-=nums[i];
                i++;
            }

            res+=j-i+1;
            j++;
        }

        return res;
    }

}
