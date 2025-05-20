package Arrays;

public class ZeroArrayTransformation {
	
	/*
	 *		 3355. Zero Array Transformation I
	 */	
	
public boolean isZeroArray(int[] nums, int[][] qu) {
        
        int n=nums.length;
        int diff[]=new int[n];
        int res[]=new int[n];


        for(int q[]:qu){
            diff[q[0]]+=1;
            if(q[1]+1<n){
                diff[q[1]+1]-=1;
            }
        }

        int cm=0;

        for(int i=0;i<n;i++){
            res[i]=cm+diff[i];
            cm=res[i];
        }

        for(int i=0;i<n;i++){
            if(res[i]<nums[i])return false;
        }


        return true;
    }

}
