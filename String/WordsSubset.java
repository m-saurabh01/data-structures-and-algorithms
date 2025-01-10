package String;

import java.util.ArrayList;
import java.util.List;

/*
 * 			Leetcode Medium 916. Word Subsets
 * 
You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

 

Example 1:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]
*/
public class WordsSubset {
	
	public List<String> wordSubsets(String[] A, String[] B) {
	    List<String> ans = new ArrayList<>();
	    int[] countB = new int[26];

	    for (final String b : B) {
	      int[] temp = counter(b);
	      for (int i = 0; i < 26; ++i)
	        countB[i] = Math.max(countB[i], temp[i]);
	    }

	    for (final String a : A)
	      if (isUniversal(counter(a), countB))
	        ans.add(a);

	    return ans;
	  }

	  private int[] counter(final String s) {
	    int[] count = new int[26];
	    for (char c : s.toCharArray())
	      ++count[c - 'a'];
	    return count;
	  }

	  private boolean isUniversal(int[] countA, int[] countB) {
	    for (int i = 0; i < 26; ++i)
	      if (countA[i] < countB[i])
	        return false;
	    return true;
	  }

}
