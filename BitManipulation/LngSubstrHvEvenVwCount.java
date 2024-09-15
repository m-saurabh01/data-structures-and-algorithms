package BitManipulation;

import java.util.HashMap;
import java.util.Map;

/*
 * 					Find the Longest Substring Containing Vowels in Even Counts LC1371 Medium
 * 
Given the string s, return the size of the longest substring containing each vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.

		 

Example 1:

Input: s = "eleetminicoworoep"
Output: 13
Explanation: The longest substring is "leetminicowor" which contains two each of the vowels: e, i and o and zero of the vowels: a and u.
Example 2:

Input: s = "leetcodeisgreat"
Output: 5
Explanation: The longest substring is "leetc" which contains two e's.
Example 3:

Input: s = "bcbcbc"
Output: 6
Explanation: In this case, the given string "bcbcbc" is the longest because all vowels: a, e, i, o and u appear zero times.
*/
public class LngSubstrHvEvenVwCount {
	
	
	public int findTheLongestSubstring(String s) {

        Map<Integer,Integer> map=new HashMap<>();
        int res=0;
        int mask=0;
        map.put(mask,-1);

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                mask=mask^(1<<0);
            }else if(s.charAt(i)=='e'){
                mask=(mask^(1<<1));
            }else if(s.charAt(i)=='i'){
                mask=(mask^(1<<2));
            }else if(s.charAt(i)=='o'){
                mask=(mask^(1<<3));
            }else if(s.charAt(i)=='u'){
                mask=(mask^(1<<4));
            }

            if(map.containsKey(mask))res=Math.max(res,i-map.get(mask));
            else map.put(mask,i);
        }
        
        return res;
    }

}
