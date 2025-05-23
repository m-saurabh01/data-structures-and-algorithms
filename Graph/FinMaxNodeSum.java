package Graph;

/*
		3068. Find the Maximum Sum of Node Values (Hard)
*/

public class FinMaxNodeSum {
	
	public long maximumValueSum(int[] nums, int k, int[][] edges) {
	    long maxSum = 0;
	    int changedCount = 0;
	    int minChangeDiff = Integer.MAX_VALUE;

	    for (final int num : nums) {
	      maxSum += Math.max(num, num ^ k);
	      changedCount += ((num ^ k) > num) ? 1 : 0;
	      minChangeDiff = Math.min(minChangeDiff, Math.abs(num - (num ^ k)));
	    }

	    if (changedCount % 2 == 0)
	      return maxSum;
	    return maxSum - minChangeDiff;
	  }

}
