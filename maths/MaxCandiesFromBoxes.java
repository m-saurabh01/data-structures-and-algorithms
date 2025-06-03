package Maths;

import java.util.ArrayDeque;
import java.util.Queue;

/*
			1298. Maximum Candies You Can Get from Boxes
*/

public class MaxCandiesFromBoxes {

	public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
		int ans = 0;
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] reachedClosedBoxes = new boolean[status.length];

		pushBoxesIfPossible(initialBoxes, status, q, reachedClosedBoxes);

		while (!q.isEmpty()) {
			final int currBox = q.poll();

			ans += candies[currBox];

			for (final int key : keys[currBox]) {
				if (status[key] == 0 && reachedClosedBoxes[key])
					q.offer(key);
				status[key] = 1;
			}

			pushBoxesIfPossible(containedBoxes[currBox], status, q, reachedClosedBoxes);
		}

		return ans;
	}

	private void pushBoxesIfPossible(int[] boxes, int[] status, Queue<Integer> q, boolean[] reachedClosedBoxes) {
		for (final int box : boxes)
			if (status[box] == 1)
				q.offer(box);
			else
				reachedClosedBoxes[box] = true;
	}

}
