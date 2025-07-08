package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
		1751. Maximum Number of Events That Can Be Attended II
*/
public class MaxEventAttended2 {
	
	 public int maxValue(int[][] events, int k) {
		    Integer[][] mem = new Integer[events.length][k + 1];
		    Arrays.sort(events, Comparator.comparingInt((int[] event) -> event[0])
		                            .thenComparing((int[] event) -> event[1]));
		    return maxValue(events, 0, k, mem);
		  }

		  private int maxValue(int[][] events, int i, int k, Integer[][] mem) {
		    if (k == 0 || i == events.length)
		      return 0;
		    if (mem[i][k] != null)
		      return mem[i][k];

		    final int j = firstGreaterEqual(events, i + 1, events[i][1] + 1);
		    return mem[i][k] = Math.max(events[i][2] + maxValue(events, j, k - 1, mem),
		                                maxValue(events, i + 1, k, mem));
		  }


		  private int firstGreaterEqual(int[][] events, int l, int target) {
		    int r = events.length;
		    while (l < r) {
		      final int m = (l + r) / 2;
		      if (events[m][0] >= target)
		        r = m;
		      else
		        l = m + 1;
		    }
		    return l;
		  }

}
