package Arrays;

import java.util.Arrays;
import java.util.List;

/*				Minimum Time Difference Leetcode Medium 539

Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
		 

Example 1:

Input: timePoints = ["23:59","00:00"]
Output: 1

Example 2:

Input: timePoints = ["00:00","23:59","00:00"]
Output: 0
 

Constraints:

2 <= timePoints.length <= 2 * 104
timePoints[i] is in the format "HH:MM".

*/

public class MinimumTimeDifference {
	
	public int findMinDifference(List<String> timePoints) {
        int n=timePoints.size();
        int[] buck=new int[n];

        for(int i=0;i<n;i++){
            String time=timePoints.get(i);
            String hr=time.substring(0,2);
            String mn=time.substring(3);

            buck[i]=Integer.parseInt(hr)*60+Integer.parseInt(mn);
        }

        Arrays.sort(buck);
        int res=1728;
        for(int i=1;i<n;i++){
            res=Math.min(res,buck[i]-buck[i-1]);
        }
        
        return Math.min(res,1440-buck[n-1]+buck[0]);
    }

}
