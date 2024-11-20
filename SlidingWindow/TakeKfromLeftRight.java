package SlidingWindow;

/*
 * 				Leetcode Medium 2516. Take K of Each Character From Left and Right
 * 
You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k. Each minute, you may take either the leftmost character of s, or the rightmost character of s.

Return the minimum number of minutes needed for you to take at least k of each character, or return -1 if it is not possible to take k of each character.

 

Example 1:

Input: s = "aabaaaacaabc", k = 2
Output: 8
Explanation: 
Take three characters from the left of s. You now have two 'a' characters, and one 'b' character.
Take five characters from the right of s. You now have four 'a' characters, two 'b' characters, and two 'c' characters.
A total of 3 + 5 = 8 minutes is needed.
It can be proven that 8 is the minimum number of minutes needed.
Example 2:

Input: s = "a", k = 1
Output: -1
Explanation: It is not possible to take one 'b' or 'c' so return -1.

*/

public class TakeKfromLeftRight {
	
	public int takeCharacters(String s, int k) {
        int n=s.length();

        int a=0,b=0,c=0;

        for(char ch:s.toCharArray()){
            if(ch=='a')a++;
            else if(ch=='b')b++;
            else c++;
        }

        if(c<k || a<k ||b<k)return -1;

        int i=0,j=0,res=0;

        while(j<n){

            if(s.charAt(j)=='a'){
                a--;
            }
            else if(s.charAt(j)=='b'){
                b--;
            }
            else if(s.charAt(j)=='c'){
                c--;
            }


            while(i<=j && (a<k||b<k||c<k)){
                if(s.charAt(i)=='a'){
                    a++;
                }
                else if(s.charAt(i)=='b'){
                    b++;
                }
                else{
                    c++;
                }
                i++;
            }
            
            res=Math.max(res,j-i+1);

            j++;

        }

        return n-res;
        
    }

}
