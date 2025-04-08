package Set;

import java.util.HashSet;
import java.util.Set;


/*
 * 
 * 
 * 			3396. Minimum Number of Operations to Make Elements in Array Distinct (Easy)
 * 
 * 
*/
public class MinOpsTomakeArrayDistinct {
	
	public int minimumOperations(int[] nums) {

        Set<Integer> set=new HashSet<>();

        int n=nums.length;
        

        for(int i=n-1;i>=0;i--){
            if(set.contains(nums[i])){
                return (int)Math.ceil((i+1)/(double)3);
            }else{
                set.add(nums[i]);
            }
        }
        
        return 0;
    }

}
