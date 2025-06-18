package Greedy;

import java.util.Arrays;

/*
		2966. Divide Array Into Arrays With Max Difference
*/
public class DivideArrayIntoMaxDifference {
	
	
	public int[][] divideArray(int[] nums, int k) {

        Arrays.sort(nums);
        int n=nums.length;
        int[][] res=new int[n/3][3];

        int a=0;
        for(int i=0;i<n;i+=3){
            if(nums[i+2]-nums[i]>k)return new int[][]{};

            res[a++]=new int[]{nums[i],nums[i+1],nums[i+2]};
        }


        return res;
        
    }

}
