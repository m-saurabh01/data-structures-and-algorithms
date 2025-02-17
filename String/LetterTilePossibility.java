package String;

/*
 * 			Leetcode Medium 1079. Letter Tile Possibilities
 * 
You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

 

Example 1:

Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
*/

public class LetterTilePossibility {
	
	public int numTilePossibilities(String tiles) {
	    int[] count = new int[26];

	    for (final char t : tiles.toCharArray())
	      ++count[t - 'A'];

	    return dfs(count);
	  }

	  private int dfs(int[] count) {
	    int possibleSequences = 0;

	    for (int i = 0; i < 26; ++i) {
	      if (count[i] == 0)
	        continue;
	      --count[i];
	      possibleSequences += 1 + dfs(count);
	      ++count[i];
	    }

	    return possibleSequences;
	  }

}
