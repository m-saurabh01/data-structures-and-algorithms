package Graph;

import java.util.Arrays;

/*
 * 					Leetcode Hard 3108. Minimum Cost Walk in Weighted Graph
 * 
 * 
 * 
There is an undirected weighted graph with n vertices labeled from 0 to n - 1.

You are given the integer n and an array edges, where edges[i] = [ui, vi, wi] indicates that there is an edge between vertices ui and vi with a weight of wi.

A walk on a graph is a sequence of vertices and edges. The walk starts and ends with a vertex, and each edge connects the vertex that comes before it and the vertex that comes after it. It's important to note that a walk may visit the same edge or vertex more than once.

The cost of a walk starting at node u and ending at node v is defined as the bitwise AND of the weights of the edges traversed during the walk. In other words, if the sequence of edge weights encountered during the walk is w0, w1, w2, ..., wk, then the cost is calculated as w0 & w1 & w2 & ... & wk, where & denotes the bitwise AND operator.

You are also given a 2D array query, where query[i] = [si, ti]. For each query, you need to find the minimum cost of the walk starting at vertex si and ending at vertex ti. If there exists no such walk, the answer is -1.

Return the array answer, where answer[i] denotes the minimum cost of a walk for query i.

 

Example 1:

Input: n = 5, edges = [[0,1,7],[1,3,7],[1,2,1]], query = [[0,3],[3,4]]

Output: [1,-1]


*/

public class MinCostWalkInWeightedGraph {
	
	public int[] minimumCost(int n, int[][] edges, int[][] query) {
	    int[] ans = new int[query.length];
	    UnionFind uf = new UnionFind(n);

	    for (int[] edge : edges) {
	      final int u = edge[0];
	      final int v = edge[1];
	      final int w = edge[2];
	      uf.unionByRank(u, v, w);
	    }

	    for (int i = 0; i < query.length; ++i) {
	      final int u = query[i][0];
	      final int v = query[i][1];
	      ans[i] = uf.getMinCost(u, v);
	    }

	    return ans;
	  }

}

class UnionFind {
	  public UnionFind(int n) {
	    id = new int[n];
	    rank = new int[n];
	    weight = new int[n];
	    for (int i = 0; i < n; ++i)
	      id[i] = i;
	    
	    Arrays.fill(weight, (1 << 17) - 1);
	  }

	  public void unionByRank(int u, int v, int w) {
	    final int i = find(u);
	    final int j = find(v);
	    final int newWeight = weight[i] & weight[j] & w;
	    weight[i] = newWeight;
	    weight[j] = newWeight;
	    if (i == j)
	      return;
	    if (rank[i] < rank[j]) {
	      id[i] = j;
	    } else if (rank[i] > rank[j]) {
	      id[j] = i;
	    } else {
	      id[i] = j;
	      ++rank[j];
	    }
	  }

	  public int getMinCost(int u, int v) {
	    if (u == v)
	      return 0;
	    final int i = find(u);
	    final int j = find(v);
	    return i == j ? weight[i] : -1;
	  }

	  private int[] id;
	  private int[] rank;
	  private int[] weight;

	  private int find(int u) {
	    return id[u] == u ? u : (id[u] = find(id[u]));
	  }
	}
