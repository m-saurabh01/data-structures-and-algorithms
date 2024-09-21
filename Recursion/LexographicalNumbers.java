package Recursion;

import java.util.ArrayList;
import java.util.List;

/*					Lexigraphical Number 386 Leetcode Medium
 * 
 * 
Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

 

Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
Example 2:

Input: n = 2
Output: [1,2]
 

Constraints:

1 <= n <= 5 * 104
*/
public class LexographicalNumbers {

	void solve(int sn, int n, List<Integer> res) {
		if (sn > n)
			return;
		res.add(sn);

		for (int i = 0; i <= 9; i++) {
			int cur = sn * 10 + i;
			if (cur > n)
				return;
			solve(cur, n, res);
		}
	}

	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<>();

		for (int i = 1; i <= 9; i++) {
			solve(i, n, res);
		}

		return res;
	}

}
