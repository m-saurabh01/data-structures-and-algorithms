package Maths;



/*
		2929. Distribute Candies Among Children II
*/

public class DistributeCandiesAmongChilds2 {
	
	public long distributeCandies(int n, int limit) {

        long ways=0;

        int min=Math.max(0,n-2*limit);
        int max=Math.min(limit,n);


        for(int i=min;i<=max;i++){
            int N=n-i;

            int ch2min=Math.max(0,N-limit);
            int ch2max=Math.min(N,limit);

            ways+=(ch2max-ch2min)+1;
        }

        return ways;
        
    }

}
