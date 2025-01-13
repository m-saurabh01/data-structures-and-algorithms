package String;

import java.util.HashMap;
import java.util.Map;

/*
 * 		Leetcode Medium 3223. Minimum Length of String After Operations
 * 
You are given a string s.

You can perform the following process on s any number of times:

Choose an index i in the string such that there is at least one character to the left of index i that is equal to s[i], and at least one character to the right that is also equal to s[i].
Delete the closest character to the left of index i that is equal to s[i].
Delete the closest character to the right of index i that is equal to s[i].
Return the minimum length of the final string s that you can achieve.

 

Example 1:

Input: s = "abaacbcbb"

Output: 5

Explanation:
We do the following operations:

Choose index 2, then remove the characters at indices 0 and 3. The resulting string is s = "bacbcbb".
Choose index 3, then remove the characters at indices 0 and 5. The resulting string is s = "acbcb".
*/

public class MinLenStrAfterOperation {
	
	public int minimumLength(String s) {

        Map<String,Integer> mp=new HashMap<>();

        for(char ch:s.toCharArray()){
            mp.put(""+ch,mp.getOrDefault(""+ch,0)+1);
        }
     
        int len=0;
        for(String key:mp.keySet()){
            if(mp.get(key)<3){
                len+=mp.get(key);
            }else{
                int x=mp.get(key);
                
                while(x>=3){
                    int y=x%3;
                    x=x/3+y;
                }
                len+=x;
            }
        }
        
        return len;
    }

}
