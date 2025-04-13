package Maths;


/*
 * 				1922. Count Good Numbers
 */
public class CountGoodNum {
	
	int M = (int)(1e9 + 7);

    public int countGoodNumbers(long n) {
        long evenPos = (n + 1) / 2; 
        long oddPos = n / 2;        

        long part1 = findPow(5, evenPos);
        long part2 = findPow(4, oddPos);

        return (int)((part1 * part2) % M);
    }

    int findPow(long a, long b) {
        if (b == 0) return 1;

        long half = findPow(a, b / 2);
        long res = (half * half) % M;

        if (b % 2 != 0) {
            res = (res * a) % M;
        }

        return (int) res;
    }

}
