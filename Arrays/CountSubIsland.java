package Arrays;


/*
 * 					Count Sub Islands Leetcode 1905 Medium
 
You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.

An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.

Return the number of islands in grid2 that are considered sub-islands.

Input: grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
Output: 3
Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are three sub-islands.

Input: grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
Output: 2 
Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are two sub-islands.

*/

public class CountSubIsland {

	public static int countSubIslands(int[][] grid1, int[][] grid2) {

		int m = grid1.length;
		int n = grid1[0].length;
		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid2[i][j] == 1 && count(grid1, grid2, i, j))
					res++;
			}
		}

		return res;
	}

	public static void main(String[] args) {

		int[][] grid1 = { { 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 },
				{ 1, 1, 0, 1, 1 } };
		int[][] grid2 = { { 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1 }, { 0, 1, 0, 0, 0 }, { 1, 0, 1, 1, 0 },
				{ 0, 1, 0, 1, 0 } };
		
		//Outputs number of sub islands
		System.out.println(countSubIslands(grid1, grid2));

	}

	
	//Done using DFS
	static boolean count(int[][] grid1, int[][] grid2, int i, int j) {
		if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length)
			return true;

		if (grid2[i][j] != 1)
			return true;

		grid2[i][j] = -1;

		boolean res = grid1[i][j] == 1;

		res = res & count(grid1, grid2, i, j + 1);
		res = res & count(grid1, grid2, i, j - 1);
		res = res & count(grid1, grid2, i + 1, j);
		res = res & count(grid1, grid2, i - 1, j);

		return res;
	}

}
