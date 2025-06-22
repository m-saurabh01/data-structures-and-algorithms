package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * 				Leetcode Hard 2127. Maximum Employees to Be Invited to a Meeting
 * 
A company is organizing a meeting and has a list of n employees, waiting to be invited. They have arranged for a large circular table, capable of seating any number of employees.

The employees are numbered from 0 to n - 1. Each employee has a favorite person and they will attend the meeting only if they can sit next to their favorite person at the table. The favorite person of an employee is not themself.

Given a 0-indexed integer array favorite, where favorite[i] denotes the favorite person of the ith employee, return the maximum number of employees that can be invited to the meeting.
*/

@SuppressWarnings("unchecked")
public class MaxEmpInvMeeting {
	
	enum State { kInit, kVisiting, kVisited }
	
	public int maximumInvitations(int[] favorite) {
	    final int n = favorite.length;
	    int sumComponentsLength = 0; 
	    List<Integer>[] graph = new List[n];
	    int[] inDegrees = new int[n];
	    int[] maxChainLength = new int[n];
	    Arrays.fill(maxChainLength, 1);

	    for (int i = 0; i < n; ++i)
	      graph[i] = new ArrayList<>();

	    // Build the graph.
	    for (int i = 0; i < n; ++i) {
	      graph[i].add(favorite[i]);
	      ++inDegrees[favorite[i]];
	    }

	    // Perform topological sorting.
	    Queue<Integer> q = IntStream.range(0, n)
	                           .filter(i -> inDegrees[i] == 0)
	                           .boxed()
	                           .collect(Collectors.toCollection(ArrayDeque::new));

	    while (!q.isEmpty()) {
	      final int u = q.poll();
	      for (final int v : graph[u]) {
	        if (--inDegrees[v] == 0)
	          q.offer(v);
	        maxChainLength[v] = Math.max(maxChainLength[v], 1 + maxChainLength[u]);
	      }
	    }

	    for (int i = 0; i < n; ++i)
	      if (favorite[favorite[i]] == i)
	        // i <-> favorite[i] (the cycle's length = 2)
	        sumComponentsLength += maxChainLength[i] + maxChainLength[favorite[i]];

	    int[] parent = new int[n];
	    Arrays.fill(parent, -1);
	    boolean[] seen = new boolean[n];
	    State[] states = new State[n];

	    for (int i = 0; i < n; ++i)
	      if (!seen[i])
	        findCycle(graph, i, parent, seen, states);

	    return Math.max(sumComponentsLength / 2, maxCycleLength);
	  }

	  private int maxCycleLength = 0; // the cycle : a -> b -> c -> a

	  private void findCycle(List<Integer>[] graph, int u, int[] parent, boolean[] seen,
	                         State[] states) {
	    seen[u] = true;
	    states[u] = State.kVisiting;

	    for (final int v : graph[u]) {
	      if (!seen[v]) {
	        parent[v] = u;
	        findCycle(graph, v, parent, seen, states);
	      } else if (states[v] == State.kVisiting) {
	       
	        int curr = u;
	        int cycleLength = 1;
	        while (curr != v) {
	          curr = parent[curr];
	          ++cycleLength;
	        }
	        maxCycleLength = Math.max(maxCycleLength, cycleLength);
	      }
	    }

	    states[u] = State.kVisited;
	  }

}
