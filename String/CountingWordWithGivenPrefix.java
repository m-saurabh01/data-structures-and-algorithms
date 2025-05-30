package String;

/*
 * 		Leetcode Easy 2185. Counting Words With a Given Prefix
 * 
You are given an array of strings words and a string pref.

Return the number of strings in words that contain pref as a prefix.

A prefix of a string s is any leading contiguous substring of s.

 

Example 1:

Input: words = ["pay","attention","practice","attend"], pref = "at"
Output: 2
Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend"
*/

public class CountingWordWithGivenPrefix {
	
	public int prefixCount(String[] words, String pref) {
        int res=0;

        for(String w:words){
            if(w.indexOf(pref)==0)res++;
        }

        return res;
    }

}
