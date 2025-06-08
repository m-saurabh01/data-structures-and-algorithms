package String;

import java.util.ArrayList;
import java.util.List;


/*
			386. Lexicographical Numbers
*/
public class LexographicalNumbers {
	
	void solve(int sn,int n,List<Integer> res){
        if(sn>n)return;
        res.add(sn);

        for(int i=0;i<=9;i++){
            int cur=sn*10+i;
            if(cur>n)return;
            solve(cur,n,res);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res=new ArrayList<>();

        for(int i=1;i<=9;i++){
            solve(i,n,res);
        }
        
        return res;
    }

}
