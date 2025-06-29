package Arrays;

import java.util.Arrays;

/*
		1498. Number of Subsequences That Satisfy the Given Sum Condition
*/
public class NumSubseqSatisfyGivenCondition {

	int M = (int) (1e9 + 7);

	public int numSubseq(int[] nums, int target) {

		Arrays.sort(nums);

		int[] pow = new int[nums.length];
		pow[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			pow[i] = (pow[i - 1] * 2) % M;
		}

		int i = 0, j = nums.length - 1, res = 0;

		while (i <= j) {
			if (nums[i] + nums[j] <= target) {
				res = (res % M + pow[j - i]) % M;
				i++;
			} else {
				j--;
			}

		}

		return res;
	}

}
