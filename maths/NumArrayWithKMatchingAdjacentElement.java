package Maths;

/*
		3405. Count the Number of Arrays with K Matching Adjacent Elements
*/

public class NumArrayWithKMatchingAdjacentElement {

	int M = (int) (1e9 + 7);

	public int countGoodArrays(int n, int m, int k) {

		int[] fact = new int[n + 1];
		int[] invMod = new int[n + 1];

		fact[0] = 1;
		for (int i = 1; i <= n; i++) {
			fact[i] = (int) ((long) fact[i - 1] * i % M);
		}

		for (int i = 0; i <= n; i++) {
			invMod[i] = findPower(fact[i], M - 2);
		}

		int res = nCr(n - 1, k, fact, invMod);
		res = (int) ((long) res * m % M);
		res = (int) ((long) res * findPower(m - 1, n - k - 1) % M);

		return res;
	}

	int nCr(int n, int r, int[] fact, int[] invMod) {
		if (r > n || r < 0)
			return 0;

		long res = fact[n];
		res = res * invMod[r] % M;
		res = res * invMod[n - r] % M;
		return (int) res;
	}

	int findPower(long a, long b) {
		a %= M;
		long res = 1;
		while (b > 0) {
			if ((b & 1) == 1) {
				res = res * a % M;
			}
			a = a * a % M;
			b >>= 1;
		}
		return (int) res;
	}

}
