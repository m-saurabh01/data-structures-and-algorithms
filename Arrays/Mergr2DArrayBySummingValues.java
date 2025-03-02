package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * 			Leetcode Easy 2570. Merge Two 2D Arrays by Summing Values
 * 
 * 
You are given two 2D integer arrays nums1 and nums2.

nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
Each array contains unique ids and is sorted in ascending order by id.

Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:

Only ids that appear in at least one of the two arrays should be included in the resulting array.
Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
Return the resulting array. The returned array must be sorted in ascending order by id.

 

Example 1:

Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
Output: [[1,6],[2,3],[3,2],[4,6]]
Explanation: The resulting array contains the following:
- id = 1, the value of this id is 2 + 4 = 6.
- id = 2, the value of this id is 3.
- id = 3, the value of this id is 2.
- id = 4, the value of this id is 5 + 1 = 6.
*/
public class Mergr2DArrayBySummingValues {
	
	public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
	    final int kMax = 1000;
	    List<int[]> ans = new ArrayList<>();
	    int[] count = new int[kMax + 1];

	    addCount(nums1, count);
	    addCount(nums2, count);

	    for (int i = 1; i <= kMax; ++i)
	      if (count[i] > 0)
	        ans.add(new int[] {i, count[i]});

	    return ans.stream().toArray(int[][] ::new);
	  }

	  private void addCount(int[][] nums, int[] count) {
	    for (int[] idAndVal : nums) {
	      final int id = idAndVal[0];
	      final int val = idAndVal[1];
	      count[id] += val;
	    }
	  }

}
