package Recursion;

import java.util.ArrayList;
import java.util.List;


/*					Different Ways to Add Parentheses Leetcode 241 (Medium)
 * 
 * 
Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.

The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.

 

Example 1:

Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0 
(2-(1-1)) = 2


Example 2:

Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10

*/
public class DifferentWaysForParanthesis {
	
	public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }

    List<Integer> solve(String str){
        List<Integer> res=new ArrayList<>();

        for(int i=0;i<str.length();i++){
            char sym=str.charAt(i);

            if(sym=='+'||sym=='*'||sym=='-'){

                List<Integer> left=solve(str.substring(0,i));
                List<Integer> right=solve(str.substring(i+1));

                for(int x:left){
                    for(int y:right){
                        if(sym=='+')res.add(x+y);
                        if(sym=='-')res.add(x-y);
                        if(sym=='*')res.add(x*y);
                    }
                }

            }
        }

        if(res.size()==0)res.add(Integer.valueOf(str));

        return res;
    }

}
