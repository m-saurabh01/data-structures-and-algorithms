package String;

/*
 * 					Leetcode Medium 2381. Shifting Letters II
 * 
You are given a string s of lowercase English letters and a 2D integer array shifts where shifts[i] = [starti, endi, directioni]. For every i, shift the characters in s from the index starti to the index endi (inclusive) forward if directioni = 1, or shift the characters backward if directioni = 0.

Shifting a character forward means replacing it with the next letter in the alphabet (wrapping around so that 'z' becomes 'a'). Similarly, shifting a character backward means replacing it with the previous letter in the alphabet (wrapping around so that 'a' becomes 'z').

Return the final string after all such shifts to s are applied.

 

Example 1:

Input: s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]
Output: "ace"
Explanation: Firstly, shift the characters from index 0 to index 1 backward. Now s = "zac".
Secondly, shift the characters from index 1 to index 2 forward. Now s = "zbd".
Finally, shift the characters from index 0 to index 2 forward. Now s = "ace".

*/
public class ShiftingLetter2 {
	
	public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int[] diff=new int[n];

        for(int[] qu:shifts){
            int st=qu[0];
            int ed=qu[1];
            int sh=qu[2]==1?1:-1;

            diff[st]+=sh;
            if(ed+1<n)diff[ed+1]+=(-1)*sh;
        }

        for(int i=1;i<n;i++){
            diff[i]+=diff[i-1];
        }
        
        
        String res="";

        for(int i=0;i<n;i++){
            int add=diff[i]%26;
            int chr=s.charAt(i)-'a';

            if(add<0){
                add+=26;
            }
                
            
            
            res+=(char)((add+chr)%26+'a');
        }

        return res;

    }

}
