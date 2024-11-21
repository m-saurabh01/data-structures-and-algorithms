package Arrays;

/*			Leetcode Medium 2257. Count Unguarded Cells in the Grid
 * 
 * 
You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.

A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.

Return the number of unoccupied cells that are not guarded.
*
*/

public class CountUnguardedCells {
	
	class Solution {
		  public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
		    int ans = 0;
		    char[][] grid = new char[m][n];
		    char[][] left = new char[m][n];
		    char[][] right = new char[m][n];
		    char[][] up = new char[m][n];
		    char[][] down = new char[m][n];

		    for (int[] guard : guards)
		      grid[guard[0]][guard[1]] = 'G';

		    for (int[] wall : walls)
		      grid[wall[0]][wall[1]] = 'W';

		    for (int i = 0; i < m; ++i) {
		      char lastCell = 0;
		      for (int j = 0; j < n; ++j)
		        if (grid[i][j] == 'G' || grid[i][j] == 'W')
		          lastCell = grid[i][j];
		        else
		          left[i][j] = lastCell;
		      lastCell = 0;
		      for (int j = n - 1; j >= 0; --j)
		        if (grid[i][j] == 'G' || grid[i][j] == 'W')
		          lastCell = grid[i][j];
		        else
		          right[i][j] = lastCell;
		    }

		    for (int j = 0; j < n; ++j) {
		      char lastCell = 0;
		      for (int i = 0; i < m; ++i)
		        if (grid[i][j] == 'G' || grid[i][j] == 'W')
		          lastCell = grid[i][j];
		        else
		          up[i][j] = lastCell;
		      lastCell = 0;
		      for (int i = m - 1; i >= 0; --i)
		        if (grid[i][j] == 'G' || grid[i][j] == 'W')
		          lastCell = grid[i][j];
		        else
		          down[i][j] = lastCell;
		    }

		    for (int i = 0; i < m; ++i)
		      for (int j = 0; j < n; ++j)
		        if (grid[i][j] == 0 && left[i][j] != 'G' && right[i][j] != 'G' && up[i][j] != 'G' &&
		            down[i][j] != 'G')
		          ++ans;

		    return ans;
		  }
		}

}
