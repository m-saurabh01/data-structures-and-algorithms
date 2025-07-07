package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
		1353. Maximum Number of Events That Can Be Attended
*/
public class MaxEventCanBeAttended {
	
	public int maxEvents(int[][] events) {
	    int ans = 0;
	    int d = 0; 
	    int i = 0;
	    Queue<Integer> minHeap = new PriorityQueue<>();

	    Arrays.sort(events, Comparator.comparingInt(event -> event[0]));

	    while (!minHeap.isEmpty() || i < events.length) {
	      
	      if (minHeap.isEmpty())
	        d = events[i][0];
	      
	      while (i < events.length && events[i][0] == d)
	        minHeap.offer(events[i++][1]);
	    
	      minHeap.poll();
	      ++ans;
	      ++d;
	      
	      while (!minHeap.isEmpty() && minHeap.peek() < d)
	        minHeap.poll();
	    }

	    return ans;
	  }

}
