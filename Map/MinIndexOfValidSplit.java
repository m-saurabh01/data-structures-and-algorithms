package Map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
				Leetcode Medium 2780. Minimum Index of a Valid Split
*/

public class MinIndexOfValidSplit {
	
	public int minimumIndex(List<Integer> nums) {

        Map<Integer,Integer> map1=new HashMap<>();
        Map<Integer,Integer> map2=new HashMap<>();

        for(Integer n:nums){
            map2.put(n,map2.getOrDefault(n,0)+1);
        }

        

        for(int i=0;i<nums.size();i++){
            map1.put(nums.get(i),map1.getOrDefault(nums.get(i),0)+1);
            int n1=-1,n2=-1;
            n1=i+1;
            
            if(map2.get(nums.get(i))>0){
                map2.put(nums.get(i),map2.get(nums.get(i))-1);
            }else{
                map2.remove(nums.get(i));
            }

            n2=nums.size()-i-1;

            if(map1.get(nums.get(i))>n1/2 && map2.get(nums.get(i))>n2/2){
                return i;
            }
       
        }

        return -1;
    }

}
