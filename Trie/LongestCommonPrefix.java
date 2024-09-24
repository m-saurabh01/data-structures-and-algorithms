package Trie;


public class LongestCommonPrefix {
	
	
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int res=0;
        Trie root=new Trie();

        for(int a:arr1){
            String str=String.valueOf(a);
            Trie temp=root;
            for(char c:str.toCharArray()){
                if(temp.trie[c-'0']!=null)temp=temp.trie[c-'0'];
                else {
                	temp.trie[c-'0']=new Trie();
                	temp=temp.trie[c-'0'];
                }
            }
        }

        for(int a:arr2){
            String str=String.valueOf(a);
            Trie temp=root;
            int max=0,i=0;

            while(i<str.length() && temp.trie[str.charAt(i)-'0']!=null){
                temp=temp.trie[str.charAt(i)-'0'];
                i++;
                max++;
            }
            res=Math.max(res,max);
        }

        return res;
    }
    
    
}

class Trie{
    Trie[] trie;

    public Trie(){
        this.trie=new Trie[10];
    }
}