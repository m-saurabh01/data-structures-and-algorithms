package Arrays;

/*
 * 		Leetcode Medium 2698. Find the Punishment Number of an Integer
 * 
 * 
Given a positive integer n, return the punishment number of n.

The punishment number of n is defined as the sum of the squares of all integers i such that:

1 <= i <= n
The decimal representation of i * i can be partitioned into contiguous substrings such that the sum of the integer values of these substrings equals i.
 

Example 1:

Input: n = 10
Output: 182
Explanation: There are exactly 3 integers i in the range [1, 10] that satisfy the conditions in the statement:
- 1 since 1 * 1 = 1
- 9 since 9 * 9 = 81 and 81 can be partitioned into 8 and 1 with a sum equal to 8 + 1 == 9.
- 10 since 10 * 10 = 100 and 100 can be partitioned into 10 and 0 with a sum equal to 10 + 0 == 10.
Hence, the punishment number of 10 is 1 + 81 + 100 = 182
*/
public class PunishmentNumber {

	public int punishmentNumber(int n) {
		int ans = 0;
		for (int i = 1; i <= n; ++i)
			if (isPossible(0, 0, String.valueOf(i * i), 0, i))
				ans += i * i;

		return ans;
	}

	private boolean isPossible(int accumulate, int running, String numChars, int s, int target) {
		if (s == numChars.length())
			return target == accumulate + running;
		final int d = numChars.charAt(s) - '0';
		return isPossible(accumulate, running * 10 + d, numChars, s + 1, target)
				|| isPossible(accumulate + running, d, numChars, s + 1, target);
	}

}
