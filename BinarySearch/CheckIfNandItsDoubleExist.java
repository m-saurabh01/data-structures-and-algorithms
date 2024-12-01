package BinarySearch;

import java.util.Arrays;

/*			Leetcode Easy 1346 Check if N and its double exist
			
Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
 

Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
Example 2:

Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.
*/
public class CheckIfNandItsDoubleExist {
	
	public boolean checkIfExist(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            double d=arr[i]/2.0;

            if(d%1==0){
                int x=Arrays.binarySearch(arr,(int)d);
                if(x>=0 && x!=i)return true;
            }
        }

        return false;
        
    }

}
