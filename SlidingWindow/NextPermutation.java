package SlidingWindow;

/*
		31. Next Permutation
*/
public class NextPermutation {
	
	public void nextPermutation(int[] nums) {

        int n=nums.length;

        int gi=-1;

        for(int i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                gi=i-1;
                break;
            }
        }

        if(gi!=-1){
            int si=gi;
            for(int i=n-1;i>=gi+1;i--){
                if(nums[i]>nums[gi]){
                    si=i;
                    break;
                }
            }

            int temp=nums[gi];
            nums[gi]=nums[si];
            nums[si]=temp;
        }
        int st=gi+1;
        int ed=n-1;
        while(st<ed){
            int temp=nums[st];
            nums[st]=nums[ed];
            nums[ed]=temp;
            st++;
            ed--;
        }

   
        
    }

}
