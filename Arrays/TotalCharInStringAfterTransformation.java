package Arrays;

import java.util.Arrays;

/*
			3335. Total Characters in String After Transformations I
*/
public class TotalCharInStringAfterTransformation {
	
	public int lengthAfterTransformations(String s, int t) {
	    final int MOD = 1_000_000_007;
	    int[] count = new int[26];

	    for (final char c : s.toCharArray())
	      ++count[c - 'a'];

	    while (t-- > 0) {
	      int[] newCount = new int[26];
	      
	      for (int i = 0; i < 25; i++)
	        newCount[i + 1] = count[i];
	     
	      newCount[0] = count[25];
	      newCount[1] = (newCount[1] + count[25]) % MOD;
	      count = newCount;
	    }

	    return Arrays.stream(count).reduce(0, (a, b) -> (a + b) % MOD);
	  }

}
