package Arrays;

import java.util.HashMap;
import java.util.Map;


/*
 * 				Leetcode Medium 3160. Find the Number of Distinct Colors Among the Balls
 * 
You are given an integer limit and a 2D array queries of size n x 2.

There are limit + 1 balls with distinct labels in the range [0, limit]. Initially, all balls are uncolored. For every query in queries that is of the form [x, y], you mark ball x with the color y. After each query, you need to find the number of distinct colors among the balls.

Return an array result of length n, where result[i] denotes the number of distinct colors after ith query.

Note that when answering a query, lack of a color will not be considered as a color.

 

Example 1:

Input: limit = 4, queries = [[1,4],[2,5],[1,3],[3,4]]

Output: [1,2,2,3]
*/

public class FindNumDistinctColorAmongBalls {
	
	
	public int[] queryResults(int limit, int[][] queries) {
	    int[] ans = new int[queries.length];
	    Map<Integer, Integer> ballToColor = new HashMap<>();
	    Map<Integer, Integer> colorCount = new HashMap<>();

	    for (int i = 0; i < queries.length; ++i) {
	      final int ball = queries[i][0];
	      final int color = queries[i][1];
	      if (ballToColor.containsKey(ball)) {
	        final int prevColor = ballToColor.get(ball);
	        if (colorCount.merge(prevColor, -1, Integer::sum) == 0)
	          colorCount.remove(prevColor);
	      }
	      ballToColor.put(ball, color);
	      colorCount.merge(color, 1, Integer::sum);
	      ans[i] = colorCount.size();
	    }

	    return ans;
	  }

}
