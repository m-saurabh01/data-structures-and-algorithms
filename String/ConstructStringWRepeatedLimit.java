package String;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 			Leetcode Medium 2182. Construct String With Repeat Limit
 * 
You are given a string s and an integer repeatLimit. Construct a new string repeatLimitedString using the characters of s such that no letter appears more than repeatLimit times in a row. You do not have to use all characters from s.

Return the lexicographically largest repeatLimitedString possible.

A string a is lexicographically larger than a string b if in the first position where a and b differ, string a has a letter that appears later in the alphabet than the corresponding letter in b. If the first min(a.length, b.length) characters do not differ, then the longer string is the lexicographically larger one.

 

Example 1:

Input: s = "cczazcc", repeatLimit = 3
Output: "zzcccac"
Explanation: We use all of the characters from s to construct the repeatLimitedString "zzcccac".
The letter 'a' appears at most 1 time in a row.
The letter 'c' appears at most 3 times in a row.
The letter 'z' appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return "zzcccac".
Note that the string "zzcccca" is lexicographically larger but the letter 'c' appears more than 3 times in a row, so it is not a valid repeatLimitedString.
*/

public class ConstructStringWRepeatedLimit {
	
public String repeatLimitedString(String s, int rm) {
        
        int[] ch=new int[26];

        for(char c:s.toCharArray()){
            ch[c-'a']++;
        }

        String res="";

        Queue<Character> que=new PriorityQueue<>(Collections.reverseOrder());


        for(int i=0;i<=25;i++){
            if(ch[i]!=0){
                que.add((char)('a'+i));
            }
        }

        

        while(!que.isEmpty()){
            
            char c=que.poll();
            int freq=Math.min(ch[c-'a'],rm);

            res+=(""+c).repeat(freq);
            ch[c-'a']-=freq;

            if(ch[c-'a']>0){
                if(que.isEmpty())break;
                char x=que.poll();
                res+=x;
                ch[x-'a']--;

                if(ch[x-'a']>0)que.add(x);
                que.add(c);

            }

            
        }


        return res;
    }

}
