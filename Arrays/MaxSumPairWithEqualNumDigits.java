package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 			Leetcode Medium 2342. Max Sum of a Pair With Equal Sum of Digits
 * 
You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.

 

Example 1:

Input: nums = [18,43,36,13,7]
Output: 54
Explanation: The pairs (i, j) that satisfy the conditions are:
- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
So the maximum sum that we can obtain is 54.
*/

@SuppressWarnings("unchecked")
public class MaxSumPairWithEqualNumDigits {
	
	public int maximumSum(int[] nums) {
	    final int kMax = 9 * 9;
	    int ans = -1;
	    List<Integer>[] count = new List[kMax + 1];

	    for (int i = 0; i <= kMax; ++i)
	      count[i] = new ArrayList<>();

	    for (final int num : nums)
	      count[getDigitSum(num)].add(num);

	    for (List<Integer> groupNums : count) {
	      if (groupNums.size() < 2)
	        continue;
	      Collections.sort(groupNums, Collections.reverseOrder());
	      ans = Math.max(ans, groupNums.get(0) + groupNums.get(1));
	    }

	    return ans;
	  }

	  private int getDigitSum(int num) {
	    int digitSum = 0;
	    while (num > 0) {
	      digitSum += num % 10;
	      num /= 10;
	    }
	    return digitSum;
	  }

}
