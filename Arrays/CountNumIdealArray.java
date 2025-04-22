package Arrays;

import java.util.Arrays;

public class CountNumIdealArray {
	
	private int[][] memoization;
    private int[][] combinationMatrix;
    private int numElements;
    private int maxValue;
    private static final int MOD = (int) 1e9 + 7;

    public int idealArrays(int n, int maxValue) {
        this.numElements = n;
        this.maxValue = maxValue;

        this.memoization = new int[maxValue + 1][16];
        for (int[] row : memoization) {
            Arrays.fill(row, -1);
        }

  
        combinationMatrix = new int[n][16];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i && j < 16; ++j) {
                combinationMatrix[i][j] = (j == 0 ? 1 : (combinationMatrix[i - 1][j] + combinationMatrix[i - 1][j - 1]) % MOD);
            }
        }

        int answer = 0;

        
        for (int i = 1; i <= maxValue; ++i) {
            answer = (answer + dfs(i, 1)) % MOD;
        }

        return answer;
    }

    private int dfs(int startValue, int length) {
        
        if (memoization[startValue][length] != -1) {
            return memoization[startValue][length];
        }

        int count = combinationMatrix[numElements - 1][length - 1];

       
        if (length < numElements) {
            for (int k = 2; startValue * k <= maxValue; ++k) {
                count = (count + dfs(startValue * k, length + 1)) % MOD;
            }
        }

        
        memoization[startValue][length] = count;
        return count;
    }

}
