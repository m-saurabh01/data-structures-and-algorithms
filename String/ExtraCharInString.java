package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*				Leetcode 2707. Extra Characters in a String Medium
 * 
 * 
You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.

Return the minimum number of extra characters left over if you break up s optimally.

 

Example 1:

Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
Output: 1
Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. There is only 1 unused character (at index 4), so we return 1.

Example 2:

Input: s = "sayhelloworld", dictionary = ["hello","world"]
Output: 3
Explanation: We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. The characters at indices 0, 1, 2 are not used in any substring and thus are considered as extra characters. Hence, we return 3.
 

Constraints:

1 <= s.length <= 50
1 <= dictionary.length <= 50
1 <= dictionary[i].length <= 50
*/
public class ExtraCharInString {
	
	static int n;
    static Set<String> set;

    int solve(int idx,String s,int n,int[] dp){


        if(idx>=n)return 0;

        if(dp[idx]!=-1){
        return dp[idx];
        }
        String curS="";
        int mine=n;
        for(int i=idx;i<n;i++){
            curS+=s.charAt(i);

            int cure=(!set.contains(curS))?curS.length():0;
            int nexte=solve(i+1,s,n,dp);

            int tot=cure+nexte;

            mine=Math.min(mine,tot);

        }

        return dp[idx]=mine;
    }


    public int minExtraChar(String s, String[] dictionary) {

        int n=s.length();
        set=new HashSet<>();
        int []dp=new int [s.length() +1];
        Arrays. fill (dp,-1);
        
        for(String words:dictionary){
            set.add(words);
        }

        return solve(0,s,n,dp);
        
    }

}
