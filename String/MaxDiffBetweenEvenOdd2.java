package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Arrays.Pair;

/*
		3445. Maximum Difference Between Even and Odd Frequency II
*/
public class MaxDiffBetweenEvenOdd2 {
	
	public int maxDifference(String s, int k) {
	    int ans = Integer.MIN_VALUE;

	    for (Pair<Character, Character> pair : getPermutations()) {
	      final char a = pair.getKey();
	      final char b = pair.getValue();

	      int[][] minDiff = new int[2][2];
	      Arrays.stream(minDiff).forEach(A -> Arrays.fill(A, Integer.MAX_VALUE / 2));
	      List<Integer> prefixA = new ArrayList<>(List.of(0));
	      List<Integer> prefixB = new ArrayList<>(List.of(0));
	      for (int l = 0, r = 0; r < s.length(); ++r) {
	        prefixA.add(prefixA.get(prefixA.size() - 1) + (s.charAt(r) == a ? 1 : 0));
	        prefixB.add(prefixB.get(prefixB.size() - 1) + (s.charAt(r) == b ? 1 : 0));
	        while (r - l + 1 >= k &&                                  
	               prefixA.get(l) < prefixA.get(prefixA.size() - 1) && 
	               prefixB.get(l) < prefixB.get(prefixB.size() - 1)) { 
	          minDiff[prefixA.get(l) % 2][prefixB.get(l) % 2] = Math.min(
	              minDiff[prefixA.get(l) % 2][prefixB.get(l) % 2], prefixA.get(l) - prefixB.get(l));
	          ++l;
	        }
	        ans = Math.max(ans, (prefixA.get(prefixA.size() - 1) - prefixB.get(prefixB.size() - 1)) -
	                                minDiff[1 - prefixA.get(prefixA.size() - 1) % 2]
	                                       [prefixB.get(prefixB.size() - 1) % 2]);
	      }
	    }

	    return ans;
	  }

	  private List<Pair<Character, Character>> getPermutations() {
	    List<Pair<Character, Character>> permutations = new ArrayList<>();
	    for (final char a : "01234".toCharArray())
	      for (final char b : "01234".toCharArray())
	        if (a != b)
	          permutations.add(new Pair<>(a, b));
	    return permutations;
	  }

}
