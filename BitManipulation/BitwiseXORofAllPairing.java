package BitManipulation;

import java.util.HashMap;
import java.util.Map;

/*
 * 		Leetcode Medium 2425. Bitwise XOR of All Pairings
 * 
You are given two 0-indexed arrays, nums1 and nums2, consisting of non-negative integers. There exists another array, nums3, which contains the bitwise XOR of all pairings of integers between nums1 and nums2 (every integer in nums1 is paired with every integer in nums2 exactly once).

Return the bitwise XOR of all integers in nums3.

 

Example 1:

Input: nums1 = [2,1,3], nums2 = [10,2,5,0]
Output: 13
Explanation:
A possible nums3 array is [8,0,7,2,11,3,4,1,9,1,6,3].
The bitwise XOR of all these numbers is 13, so we return 13.
*/
public class BitwiseXORofAllPairing {
	
	public int xorAllNums(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        int m=nums1.length;
        int n=nums2.length;

        for(int x:nums1){
            map.put(x,map.getOrDefault(x,0)+n);
        }

        for(int x:nums2){
            map.put(x,(map.getOrDefault(x,0)+m));
        }

        int res=0;

        for(int k:map.keySet()){
            if(map.get(k)%2!=0){
                if(res==0)res=k;
                else res^=k;
            }
        }

        return res;
    }

}
