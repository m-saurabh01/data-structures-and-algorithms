package Arrays;

import java.util.Arrays;

/*
 * 
 * 			3375. Minimum Operations to Make Array Values Equal to K
 * 
 * 
*/
public class MinOpsToMakeArrayEqualsK {
	
	public int minOperations(int[] nums, int k) {

        int min=Arrays.stream(nums).min().getAsInt();
        
        if(min<k)return -1;

        Arrays.sort(nums);
        int n=nums.length,res=0;
        if(nums[0]==nums[n-1] && k==nums[0])return 0;
        if(nums[0]==nums[n-1])return 1;

        int i=0;

        while(i<n){

            if(nums[i]>k)res++;
            
            while(i+1<n && nums[i]==nums[i+1])i++;

            i++;
        }
 
        return res;
    }

}
