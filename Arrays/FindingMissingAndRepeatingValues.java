package Arrays;

/*
 * 			Leetcode Medium 2965. Find Missing and Repeated Values
 * 
 * 
You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.

Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.

 

Example 1:

Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].
*/

public class FindingMissingAndRepeatingValues {
	
	public int[] findMissingAndRepeatedValues(int[][] grid) {
	    final int n = grid.length;
	    final int nSquared = n * n;
	    int[] count = new int[nSquared + 1];

	    for (int[] row : grid)
	      for (final int num : row)
	        ++count[num];

	    int repeated = -1;
	    int missing = -1;

	    for (int i = 1; i <= nSquared; ++i) {
	      if (count[i] == 2)
	        repeated = i;
	      if (count[i] == 0)
	        missing = i;
	    }

	    return new int[] {repeated, missing};
	  }

}
