package DynamicProgramming;



/*
  
  							Strange Printer - Leetcode 664 Hard
   
There is a strange printer with the following two special properties:
The printer can only print a sequence of the same character each time.
At each turn, the printer can print new characters starting from and ending at any place and will cover the original existing characters.
Given a string s, return the minimum number of turns the printer needed to print it.

 

Example 1:
Input: s = "aaabbb"
Output: 2
Explanation: Print "aaa" first and then print "bbb".

Example 2:
Input: s = "aba"
Output: 2
Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.

*/
public class StrangePrinter {
	
	
	private static int n;
	private static Integer[][] dp;
	
	
	public static int strangePrinter(String s) {
		n=s.length();
		dp=new Integer[n+1][n+1];
		
		return solve(0,n-1,s);
			
	}


	private static int solve(int l, int r, String s) {
		
		//left right end are equal can print in 1 step
		if(l==r)return 1;
		//String is exhausted return 0
		if(l>r)return 0;
		
		//Memoization logic
		if(dp[l][r]!=null)return dp[l][r];
		
		
		//Move the i pointer till adjacent element are equal
		int i=l+1;
		while(i<=r && s.charAt(i)==s.charAt(l))i++;
		
		//If i==r+1 means string can be covered with 1 step print
		if(i==r+1)return 1;
		//Else 1 step to print till i pointer and rest with recursion
		int basic=1+solve(i,r,s);
		
		//Solving with different approach in case we print all char and then change in middle
		int greedy=Integer.MAX_VALUE;
		
		for(int j=i;j<=r;j++) {
			
			
			if(s.charAt(j)==s.charAt(l)) {
				//ans consist of l to j-1 and adding j to r
				int ans=solve(l, j-1, s)+solve(j,r,s);
				greedy=Math.min(greedy, ans);
			}
		}
		
		// Return the minimum of both approaches
		return dp[l][r]=Math.min(basic, greedy);
	}

}
