package Arrays;

/*
 * 		Leetcode Medium 48. Rotate Image
 * 
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
*/

public class RotateImage {
	
	public void rotate(int[][] mat) {

        int m=mat.length;
        int n=m;

        for(int i=0;i<m;i++){
            for(int j=i;j<n;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<m/2;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[i][m-1-j];
                mat[i][m-1-j]=temp;
            }
        }

       
        
    }

}
