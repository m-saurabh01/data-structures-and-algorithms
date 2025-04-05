package BitManipulation;

/*
1863. Sum of All Subset XOR Totals Easy
*/

public class SumOfAllSubsetXOR {
	
	public int subsetXORSum(int[] nums) {
	    return dfs(nums, 0, 0);
	  }

	  private int dfs(int[] nums, int i, int xors) {
	    if (i == nums.length)
	      return xors;

	    final int x = dfs(nums, i + 1, xors);
	    final int y = dfs(nums, i + 1, nums[i] ^ xors);
	    return x + y;
	  }

}
