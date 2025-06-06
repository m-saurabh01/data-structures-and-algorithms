package String;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


/*
 * 			Leetcode Medium 1980. Find Unique Binary String
 * 
Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.

		 

Example 1:

Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.
*
*/

public class FindUniqueBinaryString {
	
	public String findDifferentBinaryString(String[] nums) {
	    final int bitSize = nums[0].length();
	    final int maxNum = 1 << bitSize;
	    Set<Integer> numsSet = Arrays.stream(nums)
	                               .mapToInt(num -> Integer.parseInt(num, 2))
	                               .boxed()
	                               .collect(Collectors.toSet());

	    for (int num = 0; num < maxNum; ++num)
	      if (!numsSet.contains(num))
	        return String.format("%" + bitSize + "s", Integer.toBinaryString(num)).replace(' ', '0');

	    throw new IllegalArgumentException();
	  }

}
