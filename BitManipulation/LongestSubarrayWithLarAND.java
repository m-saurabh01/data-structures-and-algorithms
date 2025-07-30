package BitManipulation;

/*
		2419. Longest Subarray With Maximum Bitwise AND
*/
public class LongestSubarrayWithLarAND {
	
	public int longestSubarray(int[] nums) {
        int max=0;
        int str=0;
        int res=0;

        for(int n:nums){

            if(n>max){
                max=n;
                str=0;
                res=0;
            }

            if(n==max)str++;
            else{
                str=0;
            }

            res=Math.max(res,str);
        }
        
        return res;
    }

}
