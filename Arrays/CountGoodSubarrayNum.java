package Arrays;

import java.util.HashMap;
import java.util.Map;


/*
 * 
 * 			2537. Count the Number of Good Subarrays
 * 
*/
public class CountGoodSubarrayNum {
	
	public long countGood(int[] nums, int k) {
	       
        Map<Integer, Integer> frequencyCounter = new HashMap<>();
        long totalCount = 0; 
        long currentSize = 0; 
        int startIndex = 0; 

        
        for (int num : nums) {
      
            currentSize += frequencyCounter.getOrDefault(num, 0);
           
            frequencyCounter.merge(num, 1, Integer::sum);

            
            while (currentSize - frequencyCounter.get(nums[startIndex]) + 1 >= k) {
                
                currentSize -= frequencyCounter.merge(nums[startIndex], -1, Integer::sum);
                
                startIndex++;
            }
          
            
            if (currentSize >= k) {
                
                totalCount += startIndex + 1;
            }
        }

       
        return totalCount;
    }

}
