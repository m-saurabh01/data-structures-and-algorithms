package Maths;

/*
			3024. Type of Triangle
*/

public class TriangleType {
	
	public String triangleType(int[] nums) {

        int a=nums[0],b=nums[1],c=nums[2];

        if(a==b && b==c)return "equilateral";
        if((a==b || a==c ||b==c)&&(a+b>c &&a+c>b &&b+c>a))return "isosceles";

        if(a+b>c &&a+c>b &&b+c>a)return "scalene";

        return "none";

        
    }

}
