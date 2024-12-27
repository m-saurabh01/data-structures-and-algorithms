package Arrays;

/*
 * 					Leetcode Medium 1014. Best Sightseeing Pair
 * 
You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.

The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.

 

Example 1:

Input: values = [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
*/

public class BestSightSeeingPair {
	
	public int maxScoreSightseeingPair(int[] val) {
        int n=val.length,max=-101011;
        int[] left=new int[n];
        left[0]=val[0];

        for(int i=1;i<n;i++)left[i]=Math.max(left[i-1],val[i]+i);
        
        for(int i=1;i<n;i++){
            max=Math.max(max,val[i]-i+left[i-1]);
        }


        return max;
    }

}
