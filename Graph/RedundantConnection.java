package Graph;

/*
 * 				Leetcode Medium 684. Redundant Connection
 * 
In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
*/

public class RedundantConnection {
	
	class UnionFind {
		  public UnionFind(int n) {
		    id = new int[n];
		    rank = new int[n];
		    for (int i = 0; i < n; ++i)
		      id[i] = i;
		  }

		  public boolean unionByRank(int u, int v) {
		    final int i = find(u);
		    final int j = find(v);
		    if (i == j)
		      return false;
		    if (rank[i] < rank[j]) {
		      id[i] = j;
		    } else if (rank[i] > rank[j]) {
		      id[j] = i;
		    } else {
		      id[i] = j;
		      ++rank[j];
		    }
		    return true;
		  }

		  private int[] id;
		  private int[] rank;

		  private int find(int u) {
		    return id[u] == u ? u : (id[u] = find(id[u]));
		  }
		}

		class Solution {
		  public int[] findRedundantConnection(int[][] edges) {
		    UnionFind uf = new UnionFind(edges.length + 1);

		    for (int[] edge : edges) {
		      final int u = edge[0];
		      final int v = edge[1];
		      if (!uf.unionByRank(u, v))
		        return edge;
		    }

		    throw new IllegalArgumentException();
		  }
		}

}
