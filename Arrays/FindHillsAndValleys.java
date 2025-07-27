package Arrays;

/*
			2210. Count Hills and Valleys in an Array
*/

public class FindHillsAndValleys {
	
	public int countHillValley(int[] nums) {
	    int ans = 0;
	    int left = nums[0];

	    for (int i = 1; i + 1 < nums.length; ++i)
	      if (left < nums[i] && nums[i] > nums[i + 1] || 
	          left > nums[i] && nums[i] < nums[i + 1]) { 
	        ++ans;
	        left = nums[i];
	      }

	    return ans;
	  }

}
