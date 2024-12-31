package DynamicProgramming;

import java.util.Arrays;


/*
 * 			Leetcode Medium 983. Minimum Cost For Tickets
 * 

You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.

Train tickets are sold in three different ways:

a 1-day pass is sold for costs[0] dollars,
a 7-day pass is sold for costs[1] dollars, and
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.

For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
Return the minimum number of dollars you need to travel every day in the given list of days.

 

Example 1:

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total, you spent $11 and covered all the days of your travel.
*/
public class MinCostOfTicket {
	
	int solve(int i,int[] d,int[] c,int[] dp){
        if(i>=d.length)return 0;

        if(dp[i]!=-1)return dp[i];

        int c1=c[0]+solve(i+1,d,c,dp);

        int max=d[i]+7;
        int j=i;

        while(j<d.length && d[j]<max)j++;
        int c2=c[1]+solve(j,d,c,dp);

        max=d[i]+30;
        j=i;
        while(j<d.length && d[j]<max)j++;
        int c3=c[2]+solve(j,d,c,dp);

        return dp[i]=Math.min(c1,Math.min(c2,c3));

    }
    public int mincostTickets(int[] d, int[] c) {

        int[] dp=new int[367];
        Arrays.fill(dp,-1);

        return solve(0,d,c,dp);
        
        
    }

}
