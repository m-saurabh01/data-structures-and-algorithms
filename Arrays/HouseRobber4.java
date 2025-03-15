package Arrays;

import java.util.Arrays;

/*
 * 			Leetcode Medium 2560. House Robber IV
 * 
 * 
There are several consecutive houses along a street, each of which has some money inside. There is also a robber, who wants to steal money from the homes, but he refuses to steal from adjacent homes.

The capability of the robber is the maximum amount of money he steals from one house of all the houses he robbed.

You are given an integer array nums representing how much money is stashed in each house. More formally, the ith house from the left has nums[i] dollars.

You are also given an integer k, representing the minimum number of houses the robber will steal from. It is always possible to steal at least k houses.

Return the minimum capability of the robber out of all the possible ways to steal at least k houses.

 

Example 1:

Input: nums = [2,3,5,9], k = 2
Output: 5
Explanation: 
There are three ways to rob at least 2 houses:
- Rob the houses at indices 0 and 2. Capability is max(nums[0], nums[2]) = 5.
- Rob the houses at indices 0 and 3. Capability is max(nums[0], nums[3]) = 9.
- Rob the houses at indices 1 and 3. Capability is max(nums[1], nums[3]) = 9.
Therefore, we return min(5, 9, 9) = 5.
*/
public class HouseRobber4 {
	
	
	public int minCapability(int[] nums, int k) {
	    int l = Arrays.stream(nums).min().getAsInt();
	    int r = Arrays.stream(nums).max().getAsInt();

	    while (l < r) {
	      final int m = (l + r) / 2;
	      if (numStolenHouses(nums, m) >= k)
	        r = m;
	      else
	        l = m + 1;
	    }

	    return l;
	  }

	  private int numStolenHouses(int[] nums, int capacity) {
	    int stolenHouses = 0;
	    for (int i = 0; i < nums.length; ++i)
	      if (nums[i] <= capacity) {
	        ++stolenHouses;
	        ++i;
	      }
	    return stolenHouses;
	  }

}
