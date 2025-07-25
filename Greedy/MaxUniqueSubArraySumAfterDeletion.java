package Greedy;

import java.util.HashSet;
import java.util.Set;

/*
		3487. Maximum Unique Subarray Sum After Deletion
*/

public class MaxUniqueSubArraySumAfterDeletion {
	
	public int maxSum(int[] nums) {

        Set<Integer> set=new HashSet<>();
        int sum=0,x=Integer.MIN_VALUE;

        for(int n:nums){
            if(set.contains(n)||n<=0){
                if(n<=0){
                    x=Math.max(n,x);
                }
            }else{
                set.add(n);
                sum+=n;
            }
        }
        
        return sum>0?sum:x;
    }

}
