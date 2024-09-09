package Arrays;

import java.util.ArrayList;
import java.util.List;

/*					Spiral Matrix Lettcode Medium 54
 * 
 * 
Given an m x n matrix, return all elements of the matrix in spiral order.
		Example 1: 
		Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
		Output: [1,2,3,6,9,8,7,4,5]
		Example 2:
		Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
		Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/
public class SpiralMatrix {
	
	public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> lst=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;

        int left=0;
        int right=n-1;
        int top=0;
        int down=m-1;

        int dir=0;

        while(top<=down && left<=right){

            if(dir==0){

                for(int i=left;i<=right;i++){
                    lst.add(matrix[top][i]);
                }
                top++;dir++;
            }

            else if(dir==1){

                for(int i=top;i<=down;i++){
                    lst.add(matrix[i][right]);
                }
                right--;
                dir++;
            }

            else if(dir==2){

                for(int i=right;i>=left;i--){
                    lst.add(matrix[down][i]);
                }
                down--;
                dir++;
            }

           else if(dir==3){

                for(int i=down;i>=top;i--){
                    lst.add(matrix[i][left]);
                }
                left++;
                dir++;
            }

            

            if(dir==4)dir=0;


        }

      return lst;
    }

}
