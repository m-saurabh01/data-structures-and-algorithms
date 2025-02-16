package String;

/*
 * 			Leetcode Medium 1718. Construct the Lexicographically Largest Valid Sequence
 * 
Given an integer n, find a sequence that satisfies all of the following:

The integer 1 occurs once in the sequence.
Each integer between 2 and n occurs twice in the sequence.
For every integer i between 2 and n, the distance between the two occurrences of i is exactly i.
The distance between two numbers on the sequence, a[i] and a[j], is the absolute difference of their indices, |j - i|.

Return the lexicographically largest sequence. It is guaranteed that under the given constraints, there is always a solution.

A sequence a is lexicographically larger than a sequence b (of the same length) if in the first position where a and b differ, sequence a has a number greater than the corresponding number in b. For example, [0,1,9,0] is lexicographically larger than [0,1,5,6] because the first position they differ is at the third number, and 9 is greater than 5.

 

Example 1:

Input: n = 3
Output: [3,1,2,3,2]
Explanation: [2,3,2,1,3] is also a valid sequence, but [3,1,2,3,2] is the lexicographically largest valid sequence.
*/
public class ConstructLexLargeValidSeq {
	
	 public int[] constructDistancedSequence(int n) {
		    int[] ans = new int[2 * n - 1];
		    dfs(n, 0, 0, ans);
		    return ans;
		  }

		  private boolean dfs(int n, int i, int mask, int[] ans) {
		    if (i == ans.length)
		      return true;
		    if (ans[i] > 0)
		      return dfs(n, i + 1, mask, ans);

		   
		    for (int num = n; num >= 1; --num) {
		      if ((mask >> num & 1) == 1)
		        continue;
		      if (num == 1) {
		        ans[i] = num;
		        if (dfs(n, i + 1, mask | 1 << num, ans))
		          return true;
		        ans[i] = 0;
		      } else { 
		        if (i + num >= ans.length || ans[i + num] > 0)
		          continue;
		        ans[i] = num;
		        ans[i + num] = num;
		        if (dfs(n, i + 1, mask | 1 << num, ans))
		          return true;
		        ans[i + num] = 0;
		        ans[i] = 0;
		      }
		    }

		    return false;
		  }

}
