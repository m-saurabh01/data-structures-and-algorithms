package Arrays;

public class DivideArrayInEqualPairs {
	
	
	/*
	 * 			Leetcode Easy 2206. Divide Array Into Equal Pairs
	 * 
	 * 
	 * You are given an integer array nums consisting of 2 * n integers.
	 * 
	 * You need to divide nums into n pairs such that:
	 * 
	 * Each element belongs to exactly one pair. The elements present in a pair are
	 * equal. Return true if nums can be divided into n pairs, otherwise return
	 * false.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [3,2,3,2,2,2] Output: true Explanation: There are 6 elements in
	 * nums, so they should be divided into 6 / 2 = 3 pairs. If nums is divided into
	 * the pairs (2, 2), (3, 3), and (2, 2), it will satisfy all the conditions.
	 */	
public boolean divideArray(int[] nums) {
        
        int n=nums.length;

        if(n%2!=0)return false;
        
        int arr[]=new int[501];

        for(int i=0;i<n;i++){
            arr[nums[i]]++;
        }

        int x=0;
        for(int i=0;i<=500;i++){
            if(arr[i]==2)x++;

            if(arr[i]>2 && arr[i]%2==0)x+=arr[i]/2;
        }

       



        return x==n/2;
        
    }

}
