package Arrays;

import java.util.Arrays;

/*
		2140. Solving Questions With Brainpower
*/
public class SolvingQuestionWithBrainpower {
	
	long[] dp;
    long solve(int[][] quest,int a){

        if(a>=quest.length)return 0;

        if(dp[a]!=-1)return dp[a];

        long sl=quest[a][0]+solve(quest,a+quest[a][1]+1);
        long nsl=solve(quest,a+1);

        return dp[a]=Math.max(sl,nsl);

    }
    public long mostPoints(int[][] quest) {
        dp=new long[100001];
        Arrays.fill(dp,-1);
        return solve(quest,0);
    }

}
