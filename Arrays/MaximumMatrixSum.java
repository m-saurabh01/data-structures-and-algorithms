package Arrays;

/*
 * 				Leetcode 1975. Maximum Matrix Sum
 * 
You are given an n x n integer matrix. You can do the following operation any number of times:

Choose any two adjacent elements of matrix and multiply each of them by -1.
Two elements are considered adjacent if and only if they share a border.

Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.
*/

public class MaximumMatrixSum {
	
	public long maxMatrixSum(int[][] matrix) {
	    long absSum = 0;
	    int minAbs = Integer.MAX_VALUE;
	    int oddNeg = 0;

	    for (int[] row : matrix)
	      for (final int num : row) {
	        absSum += Math.abs(num);
	        minAbs = Math.min(minAbs, Math.abs(num));
	        if (num < 0)
	          oddNeg ^= 1;
	      }

	    return absSum - oddNeg * minAbs * 2;
	  }

}
