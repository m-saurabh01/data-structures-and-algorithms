package Graph;

import java.util.HashSet;
import java.util.Set;

/*
 * 			Leetcode Medium 2685. Count the Number of Complete Components
 * 
You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.

Return the number of complete connected components of the graph.

A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

A connected component is said to be complete if there exists an edge between every pair of its vertices.
*/
class UnionFind {
	  public UnionFind(int n) {
	    id = new int[n];
	    rank = new int[n];
	    nodeCount = new int[n];
	    edgeCount = new int[n];
	    for (int i = 0; i < n; ++i) {
	      id[i] = i;
	      nodeCount[i] = 1;
	    }
	  }

	  public void unionByRank(int u, int v) {
	    final int i = find(u);
	    final int j = find(v);
	    ++edgeCount[i];
	    if (i == j)
	      return;
	    if (rank[i] < rank[j]) {
	      id[i] = j;
	      edgeCount[j] += edgeCount[i];
	      nodeCount[j] += nodeCount[i];
	    } else if (rank[i] > rank[j]) {
	      id[j] = i;
	      edgeCount[i] += edgeCount[j];
	      nodeCount[i] += nodeCount[j];
	    } else {
	      id[i] = j;
	      edgeCount[j] += edgeCount[i];
	      nodeCount[j] += nodeCount[i];
	      ++rank[j];
	    }
	  }

	  public int find(int u) {
	    return id[u] == u ? u : (id[u] = find(id[u]));
	  }

	  public boolean isComplete(int u) {
	    return nodeCount[u] * (nodeCount[u] - 1) / 2 == edgeCount[u];
	  }

	  private int[] id;
	  private int[] rank;
	  private int[] nodeCount;
	  private int[] edgeCount;
	}

public class CountNumOfCompleteComponent {
	
	public int countCompleteComponents(int n, int[][] edges) {
	    int ans = 0;
	    UnionFind uf = new UnionFind(n);
	    Set<Integer> parents = new HashSet<>();

	    for (int[] edge : edges) {
	      final int u = edge[0];
	      final int v = edge[1];
	      uf.unionByRank(u, v);
	    }

	    for (int i = 0; i < n; ++i) {
	      final int parent = uf.find(i);
	      if (parents.add(parent) && uf.isComplete(parent))
	        ++ans;
	    }

	    return ans;
	  }
	

}
