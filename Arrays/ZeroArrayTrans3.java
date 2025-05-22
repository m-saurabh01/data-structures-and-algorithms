package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
			3362. Zero Array Transformation III
*/

public class ZeroArrayTrans3 {

	public int maxRemoval(int[] nums, int[][] queries) {
	    int queryIndex = 0;
	    Queue<Integer> available = new PriorityQueue<>(Collections.reverseOrder()); 
	    Queue<Integer> running = new PriorityQueue<>();                       

	    Arrays.sort(queries, Comparator.comparingInt((int[] query) -> query[0]));

	    for (int i = 0; i < nums.length; ++i) {
	      while (queryIndex < queries.length && queries[queryIndex][0] <= i)
	        available.offer(queries[queryIndex++][1]);
	      while (!running.isEmpty() && running.peek() < i)
	        running.poll();
	      while (nums[i] > running.size()) {
	        if (available.isEmpty() || available.peek() < i)
	          return -1;
	        running.offer(available.poll());
	      }
	    }

	    return available.size();
	  }
}
