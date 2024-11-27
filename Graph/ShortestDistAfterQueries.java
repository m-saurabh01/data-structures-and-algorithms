package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 				Leetcode Medium 3243. Shortest Distance After Road Addition Queries I
 * 
You are given an integer n and a 2D integer array queries.

There are n cities numbered from 0 to n - 1. Initially, there is a unidirectional road from city i to city i + 1 for all 0 <= i < n - 1.

queries[i] = [ui, vi] represents the addition of a new unidirectional road from city ui to city vi. After each query, you need to find the length of the shortest path from city 0 to city n - 1.

Return an array answer where for each i in the range [0, queries.length - 1], answer[i] is the length of the shortest path from city 0 to city n - 1 after processing the first i + 1 queries.
 
*/
public class ShortestDistAfterQueries {
	
	public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
	    int[] ans = new int[queries.length];
	    int[] dist = new int[n];
	    List<Integer>[] graph = new List[n];

	    for (int i = 0; i < n; ++i) {
	      dist[i] = i;
	      graph[i] = new ArrayList<>();
	    }

	    for (int i = 0; i < n - 1; ++i)
	      graph[i].add(i + 1);

	    for (int i = 0; i < queries.length; ++i) {
	      final int u = queries[i][0];
	      final int v = queries[i][1];
	      graph[u].add(v);
	      if (dist[u] + 1 < dist[v]) {
	        dist[v] = dist[u] + 1;
	        bfs(graph, v, dist);
	      }
	      ans[i] = dist[n - 1];
	    }

	    return ans;
	  }
	  private void bfs(List<Integer>[] graph, int start, int[] dist) {
	    Queue<Integer> q = new LinkedList<>(Arrays.asList(start));
	    while (!q.isEmpty()) {
	      final int u = q.poll();
	      for (final int v : graph[u]) {
	        if (dist[u] + 1 < dist[v]) {
	          dist[v] = dist[u] + 1;
	          q.offer(v);
	        }
	      }
	    }
	  }

}
