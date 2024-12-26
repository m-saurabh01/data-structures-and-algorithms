package Arrays;

import java.util.Arrays;


/*
 * 				Leetcode Medium 449. Target Sum
 * 
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
*/

public class TargetSum {
	
	public int findTargetSumWays(int[] nums, int target) {
	    final int sum = Arrays.stream(nums).sum();
	    if (sum < Math.abs(target) || (sum + target) % 2 == 1)
	      return 0;
	    return knapsack(nums, (sum + target) / 2);
	  }

	  private int knapsack(int[] nums, int target) {
	    final int n = nums.length;
	  
	    int[][] dp = new int[n + 1][target + 1];
	    dp[0][0] = 1;

	    for (int i = 1; i <= n; ++i) {
	      final int num = nums[i - 1];
	      for (int j = 0; j <= target; ++j)
	        if (j < num)
	          dp[i][j] = dp[i - 1][j];
	        else
	          dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
	    }

	    return dp[n][target];
	  }

}
