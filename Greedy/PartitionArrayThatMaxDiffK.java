package Greedy;

import java.util.Arrays;

/*
		2294. Partition Array Such That Maximum Difference Is K
*/
public class PartitionArrayThatMaxDiffK {
	
	
	public int partitionArray(int[] nums, int k) {

        Arrays.sort(nums);

        int res=1,i=0,n=nums.length;

        while(i<n){
            int j=i;
            while(i<n && nums[i]-nums[j]<=k)i++;

            if(i==n)continue;
            else res++;

            
        }

        return res;
      
    }

}
