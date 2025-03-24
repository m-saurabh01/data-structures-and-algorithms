package Arrays;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 			Leetcode Medium 3169. Count Days Without Meetings
 * 
 * 
You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).

Return the count of days when the employee is available for work but no meetings are scheduled.

Note: The meetings may overlap.

 

Example 1:

Input: days = 10, meetings = [[5,7],[1,3],[9,10]]

Output: 2

Explanation:

There is no meeting scheduled on the 4th and 8th days.
*/

public class CountDaysWithoutMeeting {
	
	public int countDays(int days, int[][] meets) {
        Arrays.sort(meets,Comparator.comparingInt(a->a[0]));

        int res=0,end=0;

        for(int[] m:meets){

            if(m[0]>end){
                res+=m[0]-end-1;
            }
            end=Math.max(m[1],end);
        }

        if(end<days){
            res+=days-end;
        }
        

        return res;
    }

}
