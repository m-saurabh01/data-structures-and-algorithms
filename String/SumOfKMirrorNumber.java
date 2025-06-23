package String;

/*
		2081. Sum of k-Mirror Numbers
*/

public class SumOfKMirrorNumber {
	
	private long remaining;
    private long sum = 0;
    public long kMirror(int k, int n) {
        remaining = n;
        for (int d = 1; remaining > 0; d++) {
            char[] s = new char[d];
            dfs(k, d, s, 0, d - 1);
        }
        return sum;
    }
    private void dfs(int k, int d, char[] s, int i, int j) {
        if (remaining == 0) return;
        if (i > j) {
            long val = convertAndValidate(s, k);
            if (val > 0) sum += val;
            return;
        }
        int start = (i == 0) ? 1 : 0;
        for (int x = start; x < k; x++) {
            char digit = (char) ('0' + x);
            s[i] = digit;
            s[j] = digit;
            dfs(k, d, s, i + 1, j - 1);
        }
    }
    private long convertAndValidate(char[] s, int k) {
        long num = 0, base = 1;
        for (int i = s.length - 1; i >= 0; i--) {
            num += (s[i] - '0') * base;
            base *= k;
        }
        if (isPalindrome(Long.toString(num))) {
            remaining--;
            return num;
        }
        return 0;
    }
    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

}
