package Arrays;

/*
 * 		Leetcode Medium 1524. Number of Sub-arrays With Odd Sum
 * 
 * 
Given an array of integers arr, return the number of subarrays with an odd sum.

Since the answer can be very large, return it modulo 109 + 7.

 

Example 1:

Input: arr = [1,3,5]
Output: 4
Explanation: All subarrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
All sub-arrays sum are [1,4,9,3,8,5].
Odd sums are [1,9,3,5] so the answer is 4.
*/

public class NumSubArrWithOddSum {
	
	public int numOfSubarrays(int[] arr) {
	       
        final int MOD = 1000000007;
      
    
        int[] count = {1, 0};
      
        
        int answer = 0;
      
        int sum = 0;
      
     
        for (int num : arr) {
         
            sum += num;
     
            answer = (answer + count[1 - (sum & 1)]) % MOD;
          
            
            ++count[sum & 1];
        }
      
        
        return answer;
    }

}
