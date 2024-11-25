package Arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * 			Leetcode 773 Sliding Puzzle
 * 
 * 
On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0. A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given the puzzle board board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.

*/
public class SlidingPuzzle {
	
	public int slidingPuzzle(int[][] board) {
	    final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	    final int m = 2;
	    final int n = 3;
	    final String goal = "123450";
	    StringBuilder startSb = new StringBuilder();

	    for (int i = 0; i < m; ++i)
	      for (int j = 0; j < n; ++j)
	        startSb.append((char) ('0' + board[i][j]));

	    final String start = startSb.toString();
	    if (start.equals(goal))
	      return 0;

	    Queue<String> q = new ArrayDeque<>(List.of(start));
	    Set<String> seen = new HashSet<>(Arrays.asList(start));

	    for (int step = 1; !q.isEmpty(); ++step)
	      for (int sz = q.size(); sz > 0; --sz) {
	        final String s = q.poll();
	        final int zeroIndex = s.indexOf("0");
	        final int i = zeroIndex / n;
	        final int j = zeroIndex % n;
	        for (int[] dir : dirs) {
	          final int x = i + dir[0];
	          final int y = j + dir[1];
	          if (x < 0 || x == m || y < 0 || y == n)
	            continue;
	          final int swappedIndex = x * n + y;
	          StringBuilder sb = new StringBuilder(s);
	          sb.setCharAt(zeroIndex, s.charAt(swappedIndex));
	          sb.setCharAt(swappedIndex, s.charAt(zeroIndex));
	          final String t = sb.toString();
	          if (t.equals(goal))
	            return step;
	          if (!seen.contains(t)) {
	            q.offer(t);
	            seen.add(t);
	          }
	        }
	      }

	    return -1;
	  }

}
