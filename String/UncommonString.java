package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*					LeetCode 884. Uncommon Words from Two Sentences Easy 
A sentence is a string of single-space separated words where each word consists only of lowercase letters.

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

 

Example 1:

Input: s1 = "this apple is sweet", s2 = "this apple is sour"

Output: ["sweet","sour"]

Explanation:

The word "sweet" appears only in s1, while the word "sour" appears only in s2.

Example 2:

Input: s1 = "apple apple", s2 = "banana"

Output: ["banana"]
*/
public class UncommonString {
	
	
	public String[] uncommonFromSentences(String s1, String s2) {

        Set<String> set=new HashSet<>();
        List<String> res=new ArrayList<>();

        for(String s:s1.split(" ")){
            if(set.contains(s)){
                res.remove(s);
            }else{
                res.add(s);
            }
            set.add(s);
        }

        for(String s:s2.split(" ")){
            if(set.contains(s)){
                res.remove(s);
            }else{
                res.add(s);
            }
            set.add(s);
        }
        
        return res.toArray(String[]::new);
    }

}
