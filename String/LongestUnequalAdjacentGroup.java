package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
			2901. Longest Unequal Adjacent Groups Subsequence II
*/
public class LongestUnequalAdjacentGroup {
	
	public List<String> getWordsInLongestSubsequence( String[] words, int[] groups) {
	    List<String> ans = new ArrayList<>();
	    int n=words.length;
	    int[] dp = new int[n];
	    Arrays.fill(dp, 1);

	    int[] prev = new int[n];
	    Arrays.fill(prev, -1);

	    for (int i = 1; i < n; ++i)
	      for (int j = 0; j < i; ++j) {
	        if (groups[i] == groups[j])
	          continue;
	        if (words[i].length() != words[j].length())
	          continue;
	        if (hammingDist(words[i], words[j]) != 1)
	          continue;
	        if (dp[i] < dp[j] + 1) {
	          dp[i] = dp[j] + 1;
	          prev[i] = j;
	        }
	      }

	   
	    int index = getMaxIndex(dp);
	    while (index != -1) {
	      ans.add(words[index]);
	      index = prev[index];
	    }

	    Collections.reverse(ans);
	    return ans;
	  }

	  private int hammingDist(final String s1, final String s2) {
	    int dist = 0;
	    for (int i = 0; i < s1.length(); ++i)
	      if (s1.charAt(i) != s2.charAt(i))
	        ++dist;
	    return dist;
	  }

	  private int getMaxIndex(int[] dp) {
	    int maxIndex = 0;
	    for (int i = 0; i < dp.length; ++i)
	      if (dp[i] > dp[maxIndex])
	        maxIndex = i;
	    return maxIndex;
	  }

}
