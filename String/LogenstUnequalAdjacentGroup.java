package String;

import java.util.ArrayList;
import java.util.List;

/*
			2900. Longest Unequal Adjacent Groups Subsequence I
*/
public class LogenstUnequalAdjacentGroup {
	
	 public List<String> getLongestSubsequence( String[] words, int[] groups) {
	        
	        List<String> result = new ArrayList<>();
	        int n=words.length;

	        for (int i = 0; i < n; ++i) {
	            
	            if (i == 0 || groups[i] != groups[i - 1]) {
	                result.add(words[i]);
	            }
	        }
	        
	        return result;
	    }

}
