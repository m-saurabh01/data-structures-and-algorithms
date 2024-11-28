package Graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;


/*
 * 				Leetcode 2290. Minimum Obstacle Removal to Reach Corner
 * 
You are given a 0-indexed 2D integer array grid of size m x n. Each cell has one of two values:

0 represents an empty cell,
1 represents an obstacle that may be removed.
You can move up, down, left, or right from and to an empty cell.

Return the minimum number of obstacles to remove so you can move from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1).
*/

public class MinObstRemoveToReachCorner {
	
	public int minimumObstacles(int[][] grid) {
	    final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	    final int m = grid.length;
	    final int n = grid[0].length;
	    Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])) {
	      { offer(new int[] {grid[0][0], 0, 0}); } // (d, i, j)
	    };
	    int[][] dist = new int[m][n];
	    Arrays.stream(dist).forEach(A -> Arrays.fill(A, Integer.MAX_VALUE));
	    dist[0][0] = grid[0][0];

	    while (!minHeap.isEmpty()) {
	      final int d = minHeap.peek()[0];
	      final int i = minHeap.peek()[1];
	      final int j = minHeap.poll()[2];
	      if (i == m - 1 && j == n - 1)
	        return d;
	      for (int[] dir : dirs) {
	        final int x = i + dir[0];
	        final int y = j + dir[1];
	        if (x < 0 || x == m || y < 0 || y == n)
	          continue;
	        final int newDist = d + grid[i][j];
	        if (newDist < dist[x][y]) {
	          dist[x][y] = newDist;
	          minHeap.offer(new int[] {newDist, x, y});
	        }
	      }
	    }

	    return dist[m - 1][n - 1];
	  }

}
