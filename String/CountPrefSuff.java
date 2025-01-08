package String;

import java.util.HashMap;
import java.util.Map;

/*
 * 			Leetcode Medium 3042. Count Prefix and Suffix Pairs I
 * 
You are given a 0-indexed string array words.

Let's define a boolean function isPrefixAndSuffix that takes two strings, str1 and str2:

isPrefixAndSuffix(str1, str2) returns true if str1 is both a 
prefix
 and a 
suffix
 of str2, and false otherwise.
For example, isPrefixAndSuffix("aba", "ababa") is true because "aba" is a prefix of "ababa" and also a suffix, but isPrefixAndSuffix("abc", "abcd") is false.

Return an integer denoting the number of index pairs (i, j) such that i < j, and isPrefixAndSuffix(words[i], words[j]) is true.

 

Example 1:

Input: words = ["a","aba","ababa","aa"]
Output: 4
Explanation: In this example, the counted index pairs are:
i = 0 and j = 1 because isPrefixAndSuffix("a", "aba") is true.
i = 0 and j = 2 because isPrefixAndSuffix("a", "ababa") is true.
i = 0 and j = 3 because isPrefixAndSuffix("a", "aa") is true.
i = 1 and j = 2 because isPrefixAndSuffix("aba", "ababa") is true.
Therefore, the answer is 4.
*/
public class CountPrefSuff {
	
	class TrieNode {
		  Map<Integer, TrieNode> children = new HashMap<>();
		  int count = 0;
		}

		class Trie {
		  public int insert(final String word) {
		    final int n = word.length();
		    int count = 0;
		    TrieNode node = root;
		    for (int i = 0; i < n; ++i) {
		      final char prefix = word.charAt(i);
		      final char suffix = word.charAt(n - 1 - i);
		      final int key = (prefix - 'a') * 26 + (suffix - 'a');
		      node.children.putIfAbsent(key, new TrieNode());
		      node = node.children.get(key);
		      count += node.count;
		    }
		    ++node.count;
		    return count;
		  }

		  private TrieNode root = new TrieNode();
		}

		class Solution {
		  public int countPrefixSuffixPairs(String[] words) {
		    int ans = 0;
		    Trie trie = new Trie();

		    for (final String word : words)
		      ans += trie.insert(word);

		    return ans;
		  }
		}

}
