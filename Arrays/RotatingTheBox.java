package Arrays;

/*
 * 				Leetcode 1861 Rotating the Box
 * 
 * 
You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:

A stone '#'
A stationary obstacle '*'
Empty '.'
The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.

It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.

Return an n x m matrix representing the box after the rotation described above.

*/ 
public class RotatingTheBox {
	
	public char[][] rotateTheBox(char[][] box) {
        int m=box.length,n=box[0].length;
        char[][] res=new char[n][m];

        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                if(box[i][j]=='#'||box[i][j]=='*')continue;
                int a=j;
                while(a>=0){
                    
                    if(box[i][a]=='#'){
                        box[i][a]='.';
                        box[i][j]='#';
                        break;
                    }

                    else if(box[i][a]=='*'){
                        j=a;
                        break;
                    }
                    else{
                        a--;
                    }

                }

            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[i][j]=box[m-j-1][i];
            }
        }



        return res;
        
    }

}
