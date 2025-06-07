package String;

import java.util.ArrayList;
import java.util.List;

/*
		3170. Lexicographically Minimum String After Removing Stars
*/
public class LexographicallyMinStringAfterRemovingStars {
	
	public String clearStars(String s) {
	    StringBuilder sb = new StringBuilder(s);
	    List<Integer>[] buckets = new List[26];

	    for (int i = 0; i < 26; ++i)
	      buckets[i] = new ArrayList<>();

	    for (int i = 0; i < s.length(); ++i)
	      if (s.charAt(i) == '*') {
	        sb.setCharAt(i, ' ');
	        int j = 0;
	        while (buckets[j].isEmpty())
	          ++j;
	        sb.setCharAt(buckets[j].remove(buckets[j].size() - 1), ' ');
	      } else {
	        buckets[s.charAt(i) - 'a'].add(i);
	      }

	    return sb.toString().replaceAll(" ", "");
	  }

}
