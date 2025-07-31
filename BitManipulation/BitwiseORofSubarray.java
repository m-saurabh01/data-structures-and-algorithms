package BitManipulation;

import java.util.HashSet;
import java.util.Set;

/*
			898. Bitwise ORs of Subarrays
*/
public class BitwiseORofSubarray {
	
	public int subarrayBitwiseORs(int[] arr) {

        Set<Integer> prev=new HashSet<>();
        
        Set<Integer> res=new HashSet<>();

        for(int i=0;i<arr.length;i++){
            Set<Integer> curr=new HashSet<>();

            for(int c:prev){
                curr.add(c|arr[i]);
                res.add(c|arr[i]);
            }

            curr.add(arr[i]);
            res.add(arr[i]);

            prev=curr;
        }

        return res.size();
    }

}
