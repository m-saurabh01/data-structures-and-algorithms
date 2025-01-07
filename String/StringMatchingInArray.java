package String;

import java.util.ArrayList;
import java.util.List;

/*
 * 				Leetcode Medium 1408. String Matching in an Array
 * 
 * 
Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.

A substring is a contiguous sequence of characters within a string

 

Example 1:

Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.

*/
public class StringMatchingInArray {
	
	public List<String> stringMatching(String[] words) {
        int n=words.length;
        List<String>  res=new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==i)continue;

                if(words[j].indexOf(words[i])!=-1){
                    res.add(words[i]);
                    break;
                }
            }
        }

        return res;
        
    }

}
