package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 * 			Leetcode Medium 1765. Map of Highest Peak
 * 
You are given an integer matrix isWater of size m x n that represents a map of land and water cells.

If isWater[i][j] == 0, cell (i, j) is a land cell.
If isWater[i][j] == 1, cell (i, j) is a water cell.
You must assign each cell a height in a way that follows these rules:

The height of each cell must be non-negative.
If the cell is a water cell, its height must be 0.
Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
Find an assignment of heights such that the maximum height in the matrix is maximized.

Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.

 

Example 1:

Input: isWater = [[0,1],[0,0]]
Output: [[1,0],[2,1]]
Explanation: The image shows the assigned heights of each cell.
The blue cell is the water cell, and the green cells are the land cells.
*/

public class MapOfHighestPeak {
	
	int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};

    public int[][] highestPeak(int[][] wat) {
        int m=wat.length;
        int n=wat[0].length;

        Queue<List<Integer>> que=new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(wat[i][j]==0){
                    wat[i][j]=-1;
                }else{
                    wat[i][j]=0;
                    que.add(Arrays.asList(i,j));
                }
            }
        }


        while(!que.isEmpty()){
            List<Integer> ls=que.remove();

            int i=ls.get(0);
            int j=ls.get(1);

            for(int[] a:dir){
                int i_=i+a[0];
                int j_=j+a[1];

                if(i_>=0 && j_>=0 && i_<m && j_<n && wat[i_][j_]==-1){
                    wat[i_][j_]=wat[i][j]+1;
                    que.add(Arrays.asList(i_,j_));
                }
            }

        }

        return wat;
        
    }

}
