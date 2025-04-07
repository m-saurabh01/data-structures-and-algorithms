package Arrays;



/*
			416. Partition Equal Subset Sum Medium
*/
public class PartitionEqualSubsetSum {
	
	Boolean[][] dp;
    boolean find(int i,int r,int[] nums){
        if(i>=nums.length) return false;
        if(r==0)return true;

        if(dp[i][r]!=null)return dp[i][r];

        boolean bool1=false;
        boolean bool2=false;

        if(r>=nums[i])
        bool1=find(i+1,r-nums[i],nums);
        bool2=find(i+1,r,nums);

        return dp[i][r]=bool1||bool2;
    }
    public boolean canPartition(int[] nums) {

        int sum=0;

       

        for(int n:nums){
            sum+=n;
        }

         

        if(sum%2!=0)return false;

        int r=sum/2;
        dp=new Boolean[201][r+1];

        return find(0,r,nums);
        
    }

}
