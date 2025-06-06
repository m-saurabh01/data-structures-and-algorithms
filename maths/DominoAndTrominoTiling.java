package Maths;

/*
			790. Domino and Tromino Tiling
*/

public class DominoAndTrominoTiling {
	
	public int numTilings(int n) {
	    final int MOD = 1_000_000_007;
	    long[] dp = new long[1001];
	    dp[1] = 1;
	    dp[2] = 2;
	    dp[3] = 5;

	    for (int i = 4; i <= n; ++i)
	      dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;

	    return (int) dp[n];
	  }

}
