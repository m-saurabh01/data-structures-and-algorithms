package Arrays;

/*
 * 				Leetcode Hard 689. Maximum Sum of 3 Non-Overlapping Subarrays
 * 
Given an integer array nums and an integer k, find three non-overlapping subarrays of length k with maximum sum and return them.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

 

Example 1:

Input: nums = [1,2,1,2,6,7,5,1], k = 2
Output: [0,3,5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
Example 2:

Input: nums = [1,2,1,2,1,2,1,2,1], k = 2
Output: [0,2,4]
*/
public class MaxSum3SumNOverlappingSubarr {

	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		final int n = nums.length - k + 1;

		int[] sums = new int[n];

		int[] l = new int[n];

		int[] r = new int[n];

		int sum = 0;
		for (int i = 0; i < nums.length; ++i) {
			sum += nums[i];
			if (i >= k)
				sum -= nums[i - k];
			if (i >= k - 1)
				sums[i - k + 1] = sum;
		}

		int maxIndex = 0;
		for (int i = 0; i < n; ++i) {
			if (sums[i] > sums[maxIndex])
				maxIndex = i;
			l[i] = maxIndex;
		}

		maxIndex = n - 1;
		for (int i = n - 1; i >= 0; --i) {
			if (sums[i] >= sums[maxIndex])
				maxIndex = i;
			r[i] = maxIndex;
		}

		int[] ans = { -1, -1, -1 };

		for (int i = k; i + k < n; ++i)
			if (ans[0] == -1
					|| sums[ans[0]] + sums[ans[1]] + sums[ans[2]] < sums[l[i - k]] + sums[i] + sums[r[i + k]]) {
				ans[0] = l[i - k];
				ans[1] = i;
				ans[2] = r[i + k];
			}

		return ans;
	}

}
