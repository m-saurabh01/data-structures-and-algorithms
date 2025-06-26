package String;

/*
		2311. Longest Binary Subsequence Less Than or Equal to K
*/
public class LongestBinarySubsequenceLessThanK {
	
	
	public int longestSubsequence(String s, int k) {
	    int oneCount = 0;
	    int num = 0;
	    int pow = 1;
	    for (int i = s.length() - 1; i >= 0 && num + pow <= k; --i) {
	      if (s.charAt(i) == '1') {
	        ++oneCount;
	        num += pow;
	      }
	      pow *= 2;
	    }

	    return (int) s.chars().filter(c -> c == '0').count() + oneCount;
	  }

}
