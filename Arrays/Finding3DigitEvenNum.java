package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
				2094. Finding 3-Digit Even Numbers
*/
public class Finding3DigitEvenNum {
	
	public int[] findEvenNumbers(int[] digits) {
	    List<Integer> ans = new ArrayList<>();
	    int[] count = new int[10];

	    for (final int digit : digits)
	      ++count[digit];

	    for (int a = 1; a <= 9; ++a)
	      for (int b = 0; b <= 9; ++b)
	        for (int c = 0; c <= 8; c += 2)
	          if (count[a] > 0 && count[b] > (b == a ? 1 : 0) &&
	              count[c] > (c == a ? 1 : 0) + (c == b ? 1 : 0))
	            ans.add(a * 100 + b * 10 + c);

	    return ans.stream().mapToInt(Integer::intValue).toArray();
	  }

}
