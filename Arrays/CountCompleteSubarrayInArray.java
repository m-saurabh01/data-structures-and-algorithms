package Arrays;

import java.util.HashMap;
import java.util.Map;


/*
 * 					2799. Count Complete Subarrays in an Array Medium
*/

public class CountCompleteSubarrayInArray {

	    public int countCompleteSubarrays(int[] nums) {
	        Map<Integer, Integer> frequencyMap = new HashMap<>();
	      
	        for (int num : nums) {
	            frequencyMap.put(num, 1);
	        }
	      
	        int uniqueCount = frequencyMap.size();
	        int answer = 0;
	        int arrayLength = nums.length;
	      
	        frequencyMap.clear();
	      
	        for (int left = 0, right = 0; right < arrayLength; ++right) {
	            frequencyMap.merge(nums[right], 1, Integer::sum);
	            while (frequencyMap.size() == uniqueCount) {
	                answer += arrayLength - right;
	                if (frequencyMap.merge(nums[left], -1, Integer::sum) == 0) {
	                    frequencyMap.remove(nums[left]);
	                }
	                ++left;
	            }
	        }
	      
	        return answer;
	    }
	

}
