package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
			1857. Largest Color Value in a Directed Graph
*/
public class LargestColorValueInDirectedGraph {
	
	 public int largestPathValue(String colors, int[][] edges) {
		    final int n = colors.length();
		    int ans = 0;
		    int processed = 0;
		    List<Integer>[] graph = new List[n];
		    int[] inDegrees = new int[n];
		    int[][] count = new int[n][26];

		    for (int i = 0; i < n; ++i)
		      graph[i] = new ArrayList<>();

		  
		    for (int[] edge : edges) {
		      final int u = edge[0];
		      final int v = edge[1];
		      graph[u].add(v);
		      ++inDegrees[v];
		    }

		  
		    Queue<Integer> q = IntStream.range(0, n)
		                           .filter(i -> inDegrees[i] == 0)
		                           .boxed()
		                           .collect(Collectors.toCollection(ArrayDeque::new));

		    while (!q.isEmpty()) {
		      final int out = q.poll();
		      ++processed;
		      ans = Math.max(ans, ++count[out][colors.charAt(out) - 'a']);
		      for (final int in : graph[out]) {
		        for (int i = 0; i < 26; ++i)
		          count[in][i] = Math.max(count[in][i], count[out][i]);
		        if (--inDegrees[in] == 0)
		          q.offer(in);
		      }
		    }

		    return processed == n ? ans : -1;
		  }

}
