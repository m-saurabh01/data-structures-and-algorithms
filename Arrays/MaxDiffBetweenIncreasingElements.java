package Arrays;

import java.util.PriorityQueue;
import java.util.Queue;

/*
			2016. Maximum Difference Between Increasing Elements
*/

public class MaxDiffBetweenIncreasingElements {
	
	public int maximumDifference(int[] nums) {


        Queue<Integer> que=new PriorityQueue<>();
        int diff=-1;
        que.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(que.peek()<nums[i]){
                diff=Math.max(diff,nums[i]-que.peek());
            }
            que.add(nums[i]);
        }        

        return diff;
    }

}
