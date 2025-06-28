package Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
			2099. Find Subsequence of Length K With the Largest Sum
*/
public class FindSubSeqLKWithLarSum {
	
	public int[] maxSubsequence(int[] nums, int k) {

        Queue<Pair<Integer,Integer>> que=new PriorityQueue<>(Comparator.comparingInt(a->a.getKey()));

        for(int i=0;i<nums.length;i++){
            que.add(new Pair<>(nums[i],i));

            if(que.size()>k)que.poll();
        }

        int[] res=new int[k];
        int x=0;

        List<Pair<Integer,Integer>> list = new ArrayList<>(que);
        list.sort(Comparator.comparingInt(p -> p.getValue()));

        

        for(Pair<Integer,Integer> n:list){
            res[x++]=n.getKey();
        }


        return res;
        
    }

}
