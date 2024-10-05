package String;




/*				Leetcode 567 Medium (Permutations in String)
 * 
Given two strings s1 and s2, return true if s2 contains a 
permutation
 of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
*/
public class PermutationsInString {
	
	public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();

        int[] freq1=new int[26];
        int[] freq2=new int[26];

        for(char c:s1.toCharArray()){
            freq1[c-'a']++;
        }

        int i=0,j=0;

        while(j<m){
            freq2[s2.charAt(j)-'a']++;

            if(j-i+1>n){
                freq2[s2.charAt(i)-'a']--;
                i++;
            }

            if(equal(freq1,freq2))return true;
            j++;
        }

        return false;
    }

    boolean equal(int[] f1,int[] f2){

        for(int i=0;i<26;i++){
            if(f1[i]!=f2[i])return false;
        }
        return true;
    }

}
