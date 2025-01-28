package Graph;


/*
 * 				Leetcode Medium 2658. Maximum Number of Fish in a Grid
 * 

You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:

A land cell if grid[r][c] = 0, or
A water cell containing grid[r][c] fish, if grid[r][c] > 0.
A fisher can start at any water cell (r, c) and can do the following operations any number of times:

Catch all the fish at cell (r, c), or
Move to any adjacent water cell.
Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no water cell exists.

An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.
*/

public class MaxFishInGrid {
	
	int m,n;
    int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};

    int dfs(int i,int j, int[][] grid){

        if(i<0 ||j<0||i>=m||j>=n||grid[i][j]==0)return 0;

        int count=grid[i][j];
        grid[i][j]=0;
        for(int[] d:dir){
            int i_=i+d[0];
            int j_=j+d[1];

            count+=dfs(i_,j_,grid);
        }

        return count;
    }

    public int findMaxFish(int[][] grid) {
        m=grid.length;
        n=grid[0].length;

        int fish=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    fish=Math.max(fish,dfs(i,j,grid));
                }
            }
        }
        
        return fish;
    }

}
