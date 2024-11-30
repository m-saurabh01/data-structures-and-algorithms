package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 
 * 					Leetcode Hard 2097. Valid Arrangement of Pairs

You are given a 0-indexed 2D integer array pairs where pairs[i] = [starti, endi]. An arrangement of pairs is valid if for every index i where 1 <= i < pairs.length, we have endi-1 == starti.

Return any valid arrangement of pairs.

Note: The inputs will be generated such that there exists a valid arrangement of pairs.

 

Example 1:

Input: pairs = [[5,1],[4,5],[11,9],[9,4]]
Output: [[11,9],[9,4],[4,5],[5,1]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 9 == 9 = start1 
end1 = 4 == 4 = start2
end2 = 5 == 5 = start3
Example 2:

Input: pairs = [[1,3],[3,2],[2,1]]
Output: [[1,3],[3,2],[2,1]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 3 == 3 = start1
end1 = 2 == 2 = start2
The arrangements [[2,1],[1,3],[3,2]] and [[3,2],[2,1],[1,3]] are also valid.
Example 3:

Input: pairs = [[1,2],[1,3],[2,1]]
Output: [[1,2],[2,1],[1,3]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 2 == 2 = start1
end1 = 1 == 1 = start2

*/
public class ValidArrangementOfPairs {
	
	public int[][] validArrangement(int[][] pairs) {
	    List<int[]> ans = new ArrayList<>();
	    Map<Integer, Deque<Integer>> graph = new HashMap<>();
	    Map<Integer, Integer> outDegree = new HashMap<>();
	    Map<Integer, Integer> inDegrees = new HashMap<>();

	    for (int[] pair : pairs) {
	      final int start = pair[0];
	      final int end = pair[1];
	      graph.putIfAbsent(start, new ArrayDeque<>());
	      graph.get(start).push(end);
	      outDegree.merge(start, 1, Integer::sum);
	      inDegrees.merge(end, 1, Integer::sum);
	    }

	    final int startNode = getStartNode(graph, outDegree, inDegrees, pairs);
	    euler(graph, startNode, ans);
	    Collections.reverse(ans);
	    return ans.stream().toArray(int[][] ::new);
	  }

	  private int getStartNode(Map<Integer, Deque<Integer>> graph, Map<Integer, Integer> outDegree,
	                           Map<Integer, Integer> inDegrees, int[][] pairs) {
	    for (final int u : graph.keySet())
	      if (outDegree.getOrDefault(u, 0) - inDegrees.getOrDefault(u, 0) == 1)
	        return u;
	    return pairs[0][0]; 
	  }

	  private void euler(Map<Integer, Deque<Integer>> graph, int u, List<int[]> ans) {
	    Deque<Integer> stack = graph.get(u);
	    while (stack != null && !stack.isEmpty()) {
	      final int v = stack.pop();
	      euler(graph, v, ans);
	      ans.add(new int[] {u, v});
	    }
	  }

}
