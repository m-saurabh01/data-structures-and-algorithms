package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 					Leetcode Hard 1462. Course Schedule IV
 * 
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course ai first if you want to take course bi.

For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
Prerequisites can also be indirect. If course a is a prerequisite of course b, and course b is a prerequisite of course c, then course a is a prerequisite of course c.

You are also given an array queries where queries[j] = [uj, vj]. For the jth query, you should answer whether course uj is a prerequisite of course vj or not.

Return a boolean array answer, where answer[j] is the answer to the jth query.

 

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
Output: [false,true]
Explanation: The pair [1, 0] indicates that you have to take course 1 before you can take course 0.
Course 0 is not a prerequisite of course 1, but the opposite is true.
*/

public class CourseSchedule4 {

	
	boolean dfs(Map<Integer,List<Integer>> mp,boolean vis[],int u,int v){

        vis[u]=true;

        if(u==v)return true;

        if(mp.get(u)==null)return false;
        

        boolean res=false;
        List<Integer> ls=mp.get(u);
       
        for(int l:ls){

            if(!vis[l]){
                res=res||dfs(mp,vis,l,v);
            }
        }

        return res;
    }
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] qu) {
        
        Map<Integer,List<Integer>> mp=new HashMap<>();

        for(int a[]:pre){
            int u=a[0];
            int v=a[1];

            if(mp.get(u)==null){
                mp.put(u,new ArrayList<>());
            }
            List<Integer> ls=mp.get(u);
            ls.add(v);
            mp.put(u,ls);
        }

       
        List<Boolean> res=new ArrayList<>();

        for(int i=0;i<qu.length;i++){
            int u=qu[i][0];
            int v=qu[i][1];

            boolean vis[]=new boolean[n];

            res.add(dfs(mp,vis,u,v));
            
        }




        
        return res;

    }
}
