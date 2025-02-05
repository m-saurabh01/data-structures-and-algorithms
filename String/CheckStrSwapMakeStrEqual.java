package String;

/*
 * 				Leetcode Easy 1790. Check if One String Swap Can Make Strings Equal
 * 
You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.

Example 1:

Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".
*/
public class CheckStrSwapMakeStrEqual {
	

	public boolean areAlmostEqual(String s1, String s2) {

        int idx=-1;
        

        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i) && idx==-1 && i==s1.length()-1){
                return false;
            }
            else if(s1.charAt(i)!=s2.charAt(i) && idx==-1){
                idx=i;
                
            } 
            else if(s1.charAt(i)!=s2.charAt(i) && idx==-2){
                return false;
            }
            else if(s1.charAt(i)!=s2.charAt(i) && idx!=-1){

                if(s1.charAt(idx)!=s2.charAt(i) || s1.charAt(i)!=s2.charAt(idx))return false;

                idx=-2;
            }
        }

            if(idx==-2 || idx==-1)return true;

        return false;

      
        
        
    }

}
