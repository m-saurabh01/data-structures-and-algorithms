package Arrays;

class MostPowerFulInteger {
    private String sequence;    
    private String threshold;  
    private Long[] memo;        
    private int digitLimit;     

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        this.sequence = s;
        this.digitLimit = limit;
        threshold = String.valueOf(start - 1);
        memo = new Long[20];
        long countStart = dfs(0, true);
        threshold = String.valueOf(finish);
        memo = new Long[20];  
        long countFinish = dfs(0, true);
        return countFinish - countStart;
    }

    private long dfs(int pos, boolean isLimit) {
        if (threshold.length() < sequence.length()) {
            return 0;
        }
        if (threshold.length() - pos == sequence.length()) {
            return isLimit ? (sequence.compareTo(threshold.substring(pos)) <= 0 ? 1 : 0) : 1;
        }
        int upperBound = isLimit ? threshold.charAt(pos) - '0' : 9;
        upperBound = Math.min(upperBound, digitLimit); 
        long count = 0;
        for (int i = 0; i <= upperBound; ++i) {
            count += dfs(pos + 1, isLimit && i == (threshold.charAt(pos) - '0'));
        }
        if (!isLimit) {
            memo[pos] = count;
        }
        return count; 
    }
}