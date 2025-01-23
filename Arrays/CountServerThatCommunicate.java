package Arrays;

public class CountServerThatCommunicate {
	/*
	 * 		Leetcode Medium 1267. Count Servers that Communicate
	 * 
	 * 
	 * You are given a map of a server center, represented as a m * n integer matrix
	 * grid, where 1 means that on that cell there is a server and 0 means that it
	 * is no server. Two servers are said to communicate if they are on the same row
	 * or on the same column.
	 * 
	 * Return the number of servers that communicate with any other server.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * 
	 * 
	 * Input: grid = [[1,0],[0,1]] Output: 0 Explanation: No servers can communicate
	 * with others.
	 */
public int countServers(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;

        int row[] =new int[m];
        int col[] =new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    row[i]++;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[j][i]==1){
                    col[i]++;
                }
            }
        }

        int res=0;

        

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&(row[i]>1||col[j]>1)){
                    res++;
                }
            }
        }
        

        return res;

    }

}
