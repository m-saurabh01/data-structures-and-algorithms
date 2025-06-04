package String;

/*
		3403. Find the Lexicographically Largest String From the Box I
*/

public class LexographicalLargestStringFromBox1 {
	public String answerString(String word, int numFriends) {

		int n = word.length();
		int x = n - (numFriends - 1), idx = -1;

		if (x <= 0 || n < numFriends)
			return "";
		if (n == 1 || numFriends == 1)
			return word;

		char prev = '1';
		for (int i = 0; i < n; i++) {
			if (word.charAt(i) > prev) {
				prev = word.charAt(i);
				idx = i;
			}
		}

		int i = idx, j = idx + 1;

		while (j < n) {
			while (j < n && word.charAt(i) > word.charAt(j))
				j++;

			if (j < n && word.charAt(j) == word.charAt(i)) {
				int a = i, b = j;

				while (b < n && word.charAt(a) == word.charAt(b)) {
					a++;
					b++;
				}
				if (b < n && word.charAt(a) < word.charAt(b)) {
					i = j;
				} else {
					j++;
				}

			} else if (j < n && word.charAt(j) > word.charAt(i)) {
				i = j;
			} else {
				j++;
			}
		}

		return word.substring(i, Math.min(i + x, n));

	}

}
