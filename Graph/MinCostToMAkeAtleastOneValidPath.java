package Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * 			Leetcode Hard 1368. Minimum Cost to Make at Least One Valid Path in a Grid
 * 
 * 
Given an m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell. The sign of grid[i][j] can be:

1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
Notice that there could be some signs on the cells of the grid that point outside the grid.

You will initially start at the upper left cell (0, 0). A valid path in the grid is a path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path does not have to be the shortest.

You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.

Return the minimum cost to make the grid have at least one valid path.

Example 1:

Input: grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
Output: 3
Explanation: You will start at point (0, 0).
The path to (3, 3) is as follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) change the arrow to down with cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) change the arrow to down with cost = 1 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3) change the arrow to down with cost = 1 --> (3, 3)
The total cost = 3.
*/

public class MinCostToMAkeAtleastOneValidPath {

	int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public int minCost(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int res[][] = new int[m][n];

		Arrays.stream(res).forEach(ar -> Arrays.fill(ar, Integer.MAX_VALUE));
		PriorityQueue<List<Integer>> que = new PriorityQueue<>(Comparator.comparingInt(list -> list.get(0)));

		que.add(Arrays.asList(0, 0, 0));
		res[0][0] = 0;

		while (!que.isEmpty()) {
			List<Integer> ls = que.peek();
			que.remove();

			int cost = ls.get(0);
			int i = ls.get(1);
			int j = ls.get(2);

			for (int a = 0; a <= 3; a++) {
				int i_ = i + dir[a][0];
				int j_ = j + dir[a][1];

				if (i_ >= 0 && j_ >= 0 && i_ < m && j_ < n) {
					int newCost = (grid[i][j] - 1 != a ? 1 : 0) + cost;

					if (res[i_][j_] > newCost) {
						res[i_][j_] = newCost;
						que.add(Arrays.asList(newCost, i_, j_));
					}
				}
			}

		}

		return res[m - 1][n - 1];

	}

}
