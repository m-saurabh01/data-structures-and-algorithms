package Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/* 					Leetcode 1942. The Number of the Smallest Unoccupied Chair (Medium)
 * 
 * 
There is a party where n friends numbered from 0 to n - 1 are attending. There is an infinite number of chairs in this party that are numbered from 0 to infinity. When a friend arrives at the party, they sit on the unoccupied chair with the smallest number.

For example, if chairs 0, 1, and 5 are occupied when a friend comes, they will sit on chair number 2.
When a friend leaves the party, their chair becomes unoccupied at the moment they leave. If another friend arrives at that same moment, they can sit in that chair.

You are given a 0-indexed 2D integer array times where times[i] = [arrivali, leavingi], indicating the arrival and leaving times of the ith friend respectively, and an integer targetFriend. All arrival times are distinct.

Return the chair number that the friend numbered targetFriend will sit on.

 

Example 1:

Input: times = [[1,4],[2,3],[4,6]], targetFriend = 1
Output: 1
Explanation: 
- Friend 0 arrives at time 1 and sits on chair 0.
- Friend 1 arrives at time 2 and sits on chair 1.
- Friend 1 leaves at time 3 and chair 1 becomes empty.
- Friend 0 leaves at time 4 and chair 0 becomes empty.
- Friend 2 arrives at time 4 and sits on chair 0.
Since friend 1 sat on chair 1, we return 1.
Example 2:

Input: times = [[3,10],[1,5],[2,6]], targetFriend = 0
Output: 2
Explanation: 
- Friend 1 arrives at time 1 and sits on chair 0.
- Friend 2 arrives at time 2 and sits on chair 1.
- Friend 0 arrives at time 3 and sits on chair 2.
- Friend 1 leaves at time 5 and chair 0 becomes empty.
- Friend 2 leaves at time 6 and chair 1 becomes empty.
- Friend 0 leaves at time 10 and chair 2 becomes empty.
Since friend 0 sat on chair 2, we return 2.
 */
public class SmallestUnoccupiedChair {
	
	class Pair{
		Integer key;
		Integer value;
		public Pair() {
			
		}
		public Pair(Integer key,Integer value) {
			this.key=key;
			this.value=value;
		}
		public Integer getKey() {
			return key;
		}
		public void setKey(Integer key) {
			this.key = key;
		}
		public Integer getValue() {
			return value;
		}
		public void setValue(Integer value) {
			this.value = value;
		}
		
		
	}
	
	
	class Solution {
		  public int smallestChair(int[][] times, int targetFriend) {
		    int nextUnsatChair = 0;
		    PriorityQueue<Integer> emptyChairs = new PriorityQueue<>();
		    PriorityQueue<Pair> occupied =
		        new PriorityQueue<>(Comparator.comparing(Pair::getKey));

		    for (int i = 0; i < times.length; ++i) {
		      int[] time = times[i];
		      time = Arrays.copyOf(time, time.length + 1);
		      time[time.length - 1] = i;
		      times[i] = time;
		    }

		    Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

		    for (int[] time : times) {
		      final int arrival = time[0];
		      final int leaving = time[1];
		      final int i = time[2];
		      while (!occupied.isEmpty() && occupied.peek().getKey() <= arrival)
		        emptyChairs.add(occupied.poll().getValue());
		      if (i == targetFriend)
		        return emptyChairs.isEmpty() ? nextUnsatChair : emptyChairs.peek();
		      if (emptyChairs.isEmpty())
		        occupied.add(new Pair(leaving, nextUnsatChair++));
		      else
		        occupied.add(new Pair(leaving, emptyChairs.poll()));
		    }

		    throw new IllegalArgumentException();
		  }
		}

}
