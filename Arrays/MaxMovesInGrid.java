package Arrays;

/*		Leetcode 2684. Maximum Number of Moves in a Grid Medium
 * 
 * 
You are given a 0-indexed m x n matrix grid consisting of positive integers.

You can start at any cell in the first column of the matrix, and traverse the grid in the following way:

From a cell (row, col), you can move to any of the cells: (row - 1, col + 1), (row, col + 1) and (row + 1, col + 1) such that the value of the cell you move to, should be strictly bigger than the value of the current cell.
Return the maximum number of moves that you can perform.
Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
Output: 3
Explanation: We can start at the cell (0, 0) and make the following moves:
- (0, 0) -> (0, 1).
- (0, 1) -> (1, 2).
- (1, 2) -> (2, 3).
It can be shown that it is the maximum number of moves that can be made.

Input: grid = [[3,2,4],[2,1,9],[1,1,7]]
Output: 0
Explanation: Starting from any cell in the first column we cannot perform any moves.

*/
public class MaxMovesInGrid {
	
	public int maxMoves(int[][] grid) {
	    final int m = grid.length;
	    final int n = grid[0].length;
	    int ans = 0;
	    
	    int[][] dp = new int[m][n];

	    for (int j = n - 2; j >= 0; --j)
	      for (int i = 0; i < m; ++i) {
	        if (grid[i][j + 1] > grid[i][j])
	          dp[i][j] = 1 + dp[i][j + 1];
	        if (i > 0 && grid[i - 1][j + 1] > grid[i][j])
	          dp[i][j] = Math.max(dp[i][j], 1 + dp[i - 1][j + 1]);
	        if (i + 1 < m && grid[i + 1][j + 1] > grid[i][j])
	          dp[i][j] = Math.max(dp[i][j], 1 + dp[i + 1][j + 1]);
	      }

	    for (int i = 0; i < m; ++i)
	      ans = Math.max(ans, dp[i][0]);

	    return ans;
	  }

}
