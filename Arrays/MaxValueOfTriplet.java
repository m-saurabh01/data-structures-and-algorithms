package Arrays;

public class MaxValueOfTriplet {
	

	/*
	 * 2873. Maximum Value of an Ordered Triplet I
	 */	
public long maximumTripletValue(int[] nums) {
        
        int n=nums.length;
        int[] lmax=new int[n];
        int[] rmax=new int[n];
        lmax[0]=0;
        rmax[n-1]=0;

        for(int i=1;i<n;i++){
            lmax[i]=Math.max(lmax[i-1],nums[i-1]);
        }

        for(int i=n-2;i>=0;i--){
            rmax[i]=Math.max(rmax[i+1],nums[i+1]);
        }

        long res=0;

        for(int i=1;i<n-1;i++){
            res=Math.max(res,((long)(lmax[i]-nums[i])*rmax[i]));
        }

        return res;
        


    }

}
