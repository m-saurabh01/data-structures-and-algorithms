package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;


/*
		118. Pascal's Triangle
*/
public class PascalsTriangle {
	
	public List<List<Integer>> generate(int num) {

        List<List<Integer>> res=new ArrayList<>();

        for(int i=1;i<=num;i++){

            List<Integer> ls=new ArrayList<>();

            for(int j=0;j<i;j++){

                if(j==0||j==i-1)ls.add(1);
                else{
                int x=res.get(i-2).get(j)+res.get(i-2).get(j-1);
                ls.add(x);
                }
            }

            res.add(ls);
        }

        return res;
        
    }

}
