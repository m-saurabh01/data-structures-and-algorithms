package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
			2200. Find All K-Distant Indices in an Array
*/

public class FindKDistantIndicesInArray {
	
	public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int i=0,x=0,n=nums.length;

        List<Integer> res=new ArrayList<>();

        while(i<n){
            while(i<n && nums[i]!=key)i++;

            if(i<n){
            int min=Math.max(x,i-k);
            int max=Math.min(i+k,n-1);

            for(int a=min;a<=max;a++){
                res.add(a);
            }

            x=max+1;
            }
            i++;
        }

        return res;

    }

}
