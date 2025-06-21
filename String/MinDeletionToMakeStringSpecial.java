package String;

import java.util.Arrays;

/*
		3085. Minimum Deletions to Make String K-Special
*/
public class MinDeletionToMakeStringSpecial {

	public int minimumDeletions(String word, int k) {

		int[] chr = new int[26];
		int res = (int) (1e9 + 7);

		for (char c : word.toCharArray()) {
			chr[c - 'a']++;
		}

		Arrays.sort(chr);
		int cumSum = 0;

		for (int i = 0; i < 26; i++) {
			int del = cumSum;

			for (int j = 25; j > i; j--) {

				if (chr[j] == 0 || chr[j] - chr[i] <= k)
					continue;

				del += chr[j] - chr[i] - k;
			}

			res = Math.min(res, del);
			cumSum += chr[i];

		}

		return res;

	}

}
