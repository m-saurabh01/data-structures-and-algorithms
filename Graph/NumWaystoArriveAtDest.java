package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.apache.commons.lang3.tuple.Pair;

/*
 * 			Leetcode Medium 1976. Number of Ways to Arrive at Destination
 * 
 * 
You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.
*/
public class NumWaystoArriveAtDest {
	
	public int countPaths(int n, int[][] roads) {
	    List<Pair<Integer, Integer>>[] graph = new List[n];

	    for (int i = 0; i < n; i++)
	      graph[i] = new ArrayList<>();

	    for (int[] road : roads) {
	      final int u = road[0];
	      final int v = road[1];
	      final int w = road[2];
	      graph[u].add(Pair.of(v,w));
	      graph[v].add(Pair.of(u, w));
	    }

	    return dijkstra(graph, 0, n - 1);
	  }

	  private int dijkstra(List<Pair<Integer, Integer>>[] graph, int src, int dst) {
	    final int MOD = 1_000_000_007;
	    long[] ways = new long[graph.length];
	    Arrays.fill(ways, 0);
	    long[] dist = new long[graph.length];
	    Arrays.fill(dist, Long.MAX_VALUE);

	    ways[src] = 1;
	    dist[src] = 0;
	    Queue<Pair<Long, Integer>> minHeap = new PriorityQueue<>(Comparator.comparing(Pair::getKey)) {
	      { offer(Pair.of(dist[src], src)); }
	    };

	    while (!minHeap.isEmpty()) {
	      final long d = minHeap.peek().getKey();
	      final int u = minHeap.poll().getValue();
	      if (d > dist[u])
	        continue;
	      for (Pair<Integer, Integer> pair : graph[u]) {
	        final int v = pair.getKey();
	        final int w = pair.getValue();
	        if (d + w < dist[v]) {
	          dist[v] = d + w;
	          ways[v] = ways[u];
	          minHeap.offer(Pair.of(dist[v], v));
	        } else if (d + w == dist[v]) {
	          ways[v] += ways[u];
	          ways[v] %= MOD;
	        }
	      }
	    }

	    return (int) ways[dst];
	  }

}
