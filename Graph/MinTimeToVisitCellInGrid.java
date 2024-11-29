package Graph;

import java.util.PriorityQueue;
import java.util.Queue;

/*
		2577. Minimum Time to Visit a Cell In a Grid

You are given a m x n matrix grid consisting of non-negative integers where grid[row][col] represents the minimum time required to be able to visit the cell (row, col), which means you can visit the cell (row, col) only when the time you visit it is greater than or equal to grid[row][col].

You are standing in the top-left cell of the matrix in the 0th second, and you must move to any adjacent cell in the four directions: up, down, left, and right. Each move you make takes 1 second.

Return the minimum time required in which you can visit the bottom-right cell of the matrix. If you cannot visit the bottom-right cell, then return -1.

*/ 
public class MinTimeToVisitCellInGrid {
	
	public int minimumTime(int[][] grid) {
	    if (grid[0][1] > 1 && grid[1][0] > 1)
	      return -1;

	    final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	    final int m = grid.length;
	    final int n = grid[0].length;
	    Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])) {
	      { offer(new int[] {0, 0, 0}); } // (time, i, j)
	    };
	    boolean[][] seen = new boolean[m][n];
	    seen[0][0] = true;

	    while (!minHeap.isEmpty()) {
	      final int time = minHeap.peek()[0];
	      final int i = minHeap.peek()[1];
	      final int j = minHeap.poll()[2];
	      if (i == m - 1 && j == n - 1)
	        return time;
	      for (int[] dir : dirs) {
	        final int x = i + dir[0];
	        final int y = j + dir[1];
	        if (x < 0 || x == m || y < 0 || y == n)
	          continue;
	        if (seen[x][y])
	          continue;
	        final int extraWait = (grid[x][y] - time) % 2 == 0 ? 1 : 0;
	        final int nextTime = Math.max(time + 1, grid[x][y] + extraWait);
	        minHeap.offer(new int[] {nextTime, x, y});
	        seen[x][y] = true;
	      }
	    }

	    throw new IllegalArgumentException();
	  }

}
