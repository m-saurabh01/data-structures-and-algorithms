package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/*
 * 				Leetcode Hard 2493. Divide Nodes Into the Maximum Number of Groups
 * 
You are given a positive integer n representing the number of nodes in an undirected graph. The nodes are labeled from 1 to n.

You are also given a 2D integer array edges, where edges[i] = [ai, bi] indicates that there is a bidirectional edge between nodes ai and bi. Notice that the given graph may be disconnected.

Divide the nodes of the graph into m groups (1-indexed) such that:

Each node in the graph belongs to exactly one group.
For every pair of nodes in the graph that are connected by an edge [ai, bi], if ai belongs to the group with index x, and bi belongs to the group with index y, then |y - x| = 1.
Return the maximum number of groups (i.e., maximum m) into which you can divide the nodes. Return -1 if it is impossible to group the nodes with the given conditions.
*/
 
public class DivideNodeMaxGroups {
	
	private List<Integer>[] graph; 
    private List<Integer> componentNodes = new ArrayList<>(); 
    private boolean[] visited; 
    private int totalNodes; 

    
    public int magnificentSets(int n, int[][] edges) {
        totalNodes = n;
        graph = new List[n + 1];
        Arrays.setAll(graph, k -> new ArrayList<>()); 
        for (int[] edge : edges) { 
            int nodeA = edge[0], nodeB = edge[1];
            graph[nodeA].add(nodeB);
            graph[nodeB].add(nodeA);
        }

        visited = new boolean[n + 1];
        int totalMagnificentSets = 0;
        for (int i = 1; i <= n; ++i) {
            if (!visited[i]) {
                dfs(i); 
                int largestDepth = -1;
                
                for (int node : componentNodes) {
                    largestDepth = Math.max(largestDepth, bfs(node));
                }
                if (largestDepth == -1) {
                    return -1; 
                }
                totalMagnificentSets += largestDepth; 
                componentNodes.clear(); 
            }
        }
        return totalMagnificentSets; 
    }

    private int bfs(int startNode) {
        int[] depth = new int[totalNodes + 1];
        Arrays.fill(depth, Integer.MAX_VALUE); 
        depth[startNode] = 1; 
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(startNode); 

        int maxDepth = 1; 
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : graph[currentNode]) {
                if (depth[neighbor] == Integer.MAX_VALUE) {
                    depth[neighbor] = depth[currentNode] + 1; 
                    maxDepth = depth[neighbor]; 
                    queue.offer(neighbor); 
                }
            }
        }

       
        for (int node : componentNodes) {
            if (depth[node] == Integer.MAX_VALUE) {
                depth[node] = ++maxDepth;
            }
        }

        
        for (int node : componentNodes) {
            for (int neighbor : graph[node]) {
                if (Math.abs(depth[node] - depth[neighbor]) != 1) {
                    return -1; 
                }
            }
        }

        return maxDepth; 
    }

   
    private void dfs(int currentNode) {
        componentNodes.add(currentNode); 
        visited[currentNode] = true; 
        for (int neighbor : graph[currentNode]) {
            if (!visited[neighbor]) {
                dfs(neighbor); 
            }
        }
    }

}
