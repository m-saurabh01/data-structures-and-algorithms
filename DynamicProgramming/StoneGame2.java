package DynamicProgramming;




/*

Alice and Bob continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones. 

Alice and Bob take turns, with Alice starting first.  Initially, M = 1.

On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).

The game continues until all the stones have been taken.


Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.

Input: piles = [2,7,9,4,4]
Output: 10
Explanation:  If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 piles in total. If Alice takes two piles at the beginning, then Bob can take all three piles left. In this case, Alice get 2 + 7 = 9 piles in total. So we return 10 since it's larger.

*/

public class StoneGame2 {
	
	//Declaration array for memoization
	private Integer[][][] dp;
	private int n;


	public int stoneGameII(int[] piles) {
		//Initialization
		dp = new Integer[2][101][101];
		n = piles.length;
		return solve(piles, 1, 0, 1);
	}

	private int solve(int[] piles, int per, int i, int m) {
		
		//Out of bounds return ) for alice
		if (i >= n)return 0;
			

		//DP doing it's work
		if (dp[per][i][m] != null)
			return dp[per][i][m];

		//Initializing res according to the player
		int res = (per == 1) ? -1 : Integer.MAX_VALUE;
		int stones = 0;
		
		for (int x = 1; x <= Math.min(2 * m, n - i); x++) {
			stones += piles[i + x - 1];
			
			
			if (per == 1) {//Alice's turn 
				res = Math.max(res, stones + solve(piles, 0, i + x, Math.max(m, x)));
			} else {//Bob's turn
				res = Math.min(res, solve(piles, 1, i + x, Math.max(m, x)));
			}
		}

		return dp[per][i][m] = res;
	}
	
	
	
	public static void main(String[] args) {
		int piles[]= {2,7,9,4,4};
		
		StoneGame2 game2=new StoneGame2();
		
		System.out.println(game2.stoneGameII(piles));
	}

}
