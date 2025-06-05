package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
		1061. Lexicographically Smallest Equivalent String
*/
public class LexSmallestStringEquivalent {
	
public String smallestEquivalentString(String s1, String s2, String baseStr) {
        
        Map<Character,List<Character>> mp=new HashMap<>();

        for(int i=0;i<s1.length();i++){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);

            if(mp.containsKey(ch1)){
                mp.get(ch1).add(ch2);
            }else{
                List<Character> ls=new ArrayList<>();
                ls.add(ch2);
                mp.put(ch1,ls);
            }

            if(mp.containsKey(ch2)){
                mp.get(ch2).add(ch1);
            }else{
                List<Character> ls=new ArrayList<>();
                ls.add(ch1);
                mp.put(ch2,ls);
            }

        }


        String res="";
        for(char c:baseStr.toCharArray()){

            res+=dfs(c,new int[26],mp);
        }

        return res;
    }

    char dfs(char c,int[] vis,Map<Character,List<Character>> mp){
        vis[c-'a']=1;
        char min=c;
        if(!mp.containsKey(c))return c;
        for(char ch:mp.get(c)){
            if(vis[ch-'a']==0){
            char nc=dfs(ch,vis,mp);
            min=min<nc?min:nc;
            }
        }

        return min;
    }

}
